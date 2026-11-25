package com.rai.inbrazil.ui.theme.comentarios

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rai.inbrazil.data.presentation.ComentarioViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

private val VerdeComentario = Color(0xFF2C8950)
private val BrancoComentario = Color(0xFFFFFFFF)
private val PretoComentario = Color(0xFF111111)

@Composable
fun AdicionarComentarioScreen(
    viewModel: ComentarioViewModel,
    estado: String = "Acre",
    onPublicado: () -> Unit = {}
) {

    val context = LocalContext.current

    var nome by remember { mutableStateOf("") }
    var comentario by remember { mutableStateOf("") }
    var fotoUri by remember { mutableStateOf<Uri?>(null) }

    val limiteComentario = 200

    val seletorImagem = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.OpenDocument()
    ) { uri ->

        uri?.let {
            try {
                context.contentResolver.takePersistableUriPermission(
                    it,
                    Intent.FLAG_GRANT_READ_URI_PERMISSION
                )
            } catch (_: SecurityException) {
                // Mantém a URI caso a permissão persistente não esteja disponível.
            }

            fotoUri = it
        }
    }

    val podePublicar = nome.isNotBlank() && comentario.isNotBlank()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(VerdeComentario)
            .statusBarsPadding()
            .navigationBarsPadding()
            .imePadding()
            .verticalScroll(rememberScrollState())
            .padding(
                horizontal = 20.dp,
                vertical = 20.dp
            )
    ) {

        // CABEÇALHO

        Text(
            text = "Conte como foi sua visita",
            color = BrancoComentario,
            fontSize = 17.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Deixe seu\ncomentário",
            color = BrancoComentario,
            fontSize = 34.sp,
            lineHeight = 35.sp,
            fontWeight = FontWeight.Black
        )

        Spacer(modifier = Modifier.height(20.dp))

        // CARTÃO DO FORMULÁRIO

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(28.dp))
                .background(BrancoComentario)
                .padding(20.dp)
        ) {

            // FOTO

            Text(
                text = "Foto",
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold,
                color = PretoComentario
            )

            Spacer(modifier = Modifier.height(10.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(140.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .background(Color(0xFFF5F5F2))
                    .border(
                        width = 2.dp,
                        color = Color(0xFFAAA9A1),
                        shape = RoundedCornerShape(20.dp)
                    )
                    .clickable {
                        seletorImagem.launch(arrayOf("image/*"))
                    },
                contentAlignment = Alignment.Center
            ) {

                if (fotoUri != null) {

                    FotoSelecionada(
                        uri = fotoUri!!,
                        modifier = Modifier.fillMaxSize()
                    )

                } else {

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Text(
                            text = "+",
                            fontSize = 36.sp,
                            color = Color(0xFFFF7043),
                            fontWeight = FontWeight.Bold
                        )

                        Text(
                            text = "Adicionar foto",
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.DarkGray
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // NOME

            Text(
                text = "Seu nome",
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold,
                color = PretoComentario
            )

            Spacer(modifier = Modifier.height(10.dp))

            OutlinedTextField(
                value = nome,
                onValueChange = { nome = it },
                modifier = Modifier.fillMaxWidth(),
                placeholder = {
                    Text("Como quer ser chamado?")
                },
                singleLine = true,
                shape = RoundedCornerShape(30.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = PretoComentario,
                    unfocusedBorderColor = PretoComentario,
                    focusedContainerColor = BrancoComentario,
                    unfocusedContainerColor = BrancoComentario
                )
            )

            Spacer(modifier = Modifier.height(20.dp))

            // COMENTÁRIO

            Text(
                text = "Comentário",
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold,
                color = PretoComentario
            )

            Spacer(modifier = Modifier.height(10.dp))

            OutlinedTextField(
                value = comentario,
                onValueChange = {
                    if (it.length <= limiteComentario) {
                        comentario = it
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(130.dp),
                placeholder = {
                    Text("O que você mais gostou no $estado?")
                },
                shape = RoundedCornerShape(20.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = PretoComentario,
                    unfocusedBorderColor = PretoComentario,
                    focusedContainerColor = BrancoComentario,
                    unfocusedContainerColor = BrancoComentario
                )
            )

            Text(
                text = "${comentario.length}/$limiteComentario",
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(top = 6.dp),
                fontSize = 12.sp,
                color = Color.DarkGray
            )

            Spacer(modifier = Modifier.height(24.dp))

            // BOTÃO PUBLICAR

            Button(
                onClick = {

                    viewModel.inserirComentario(
                        nome = nome.trim(),
                        comentario = comentario.trim(),
                        fotoUri = fotoUri?.toString(),
                        estado = estado
                    )

                    nome = ""
                    comentario = ""
                    fotoUri = null

                    onPublicado()
                },
                enabled = podePublicar,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(52.dp),
                shape = RoundedCornerShape(30.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFB4F02F),
                    contentColor = PretoComentario,
                    disabledContainerColor = Color(0xFFCACAC6),
                    disabledContentColor = Color.Gray
                )
            ) {

                Text(
                    text = "Publicar comentário",
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp
                )
            }
        }

        Spacer(modifier = Modifier.height(12.dp))
    }
}

@Composable
private fun FotoSelecionada(
    uri: Uri,
    modifier: Modifier = Modifier
) {

    val context = LocalContext.current

    val bitmap by produceState<Bitmap?>(
        initialValue = null,
        key1 = uri
    ) {

        value = withContext(Dispatchers.IO) {
            try {
                context.contentResolver.openInputStream(uri)?.use {
                    BitmapFactory.decodeStream(it)
                }
            } catch (_: Exception) {
                null
            }
        }
    }

    if (bitmap != null) {

        Image(
            bitmap = bitmap!!.asImageBitmap(),
            contentDescription = "Foto selecionada",
            modifier = modifier,
            contentScale = ContentScale.Crop
        )

    } else {

        Box(
            modifier = modifier.background(Color.LightGray),
            contentAlignment = Alignment.Center
        ) {
            Text("Carregando imagem...")
        }
    }
}