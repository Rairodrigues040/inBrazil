package com.rai.inbrazil.ui.theme.comentarios

import android.content.Intent
import android.graphics.BitmapFactory
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
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
import com.rai.inbrazil.data.entity.ComentarioEntity
import com.rai.inbrazil.data.presentation.ComentarioViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@Composable
fun EditarComentarioScreen(
    comentarioOriginal: ComentarioEntity,
    viewModel: ComentarioViewModel,
    onSalvo: () -> Unit
) {

    val context = LocalContext.current

    var nome by remember(comentarioOriginal.id) {
        mutableStateOf(comentarioOriginal.nome)
    }

    var comentario by remember(comentarioOriginal.id) {
        mutableStateOf(comentarioOriginal.comentario)
    }

    var fotoUri by remember(comentarioOriginal.id) {
        mutableStateOf(
            comentarioOriginal.fotoUri?.let { Uri.parse(it) }
        )
    }

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
            }

            fotoUri = it
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF2C8950))
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {

        Text(
            text = "Atualize sua experiência",
            color = Color.White,
            fontSize = 17.sp,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "Editar\ncomentário",
            color = Color.White,
            fontSize = 36.sp,
            lineHeight = 36.sp,
            fontWeight = FontWeight.Black
        )

        Spacer(modifier = Modifier.height(20.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(28.dp))
                .background(Color.White)
                .padding(16.dp)
        ) {

            // FOTO

            Text(
                text = "Foto",
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(8.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(160.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .background(Color(0xFFF2F3EE))
                    .clickable {
                        seletorImagem.launch(arrayOf("image/*"))
                    },
                contentAlignment = Alignment.Center
            ) {

                if (fotoUri != null) {

                    FotoEdicao(
                        uri = fotoUri!!,
                        modifier = Modifier.fillMaxSize()
                    )

                } else {

                    Text(
                        text = "+ Adicionar foto",
                        color = Color.DarkGray,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            // NOME

            Text(
                text = "Seu nome",
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )

            OutlinedTextField(
                value = nome,
                onValueChange = { nome = it },
                modifier = Modifier.fillMaxWidth(),
                placeholder = {
                    Text("Digite seu nome")
                },
                singleLine = true,
                shape = RoundedCornerShape(25.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // COMENTÁRIO

            Text(
                text = "Comentário",
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )

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
                    Text("Escreva seu comentário")
                },
                shape = RoundedCornerShape(20.dp)
            )

            Text(
                text = "${comentario.length}/$limiteComentario",
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(top = 4.dp),
                color = Color.Gray,
                fontSize = 11.sp
            )

            Spacer(modifier = Modifier.height(20.dp))

            // SALVAR ALTERAÇÕES

            Button(
                onClick = {

                    val comentarioAtualizado = comentarioOriginal.copy(
                        nome = nome.trim(),
                        comentario = comentario.trim(),
                        fotoUri = fotoUri?.toString()
                    )

                    viewModel.atualizarComentario(
                        comentarioAtualizado
                    )

                    onSalvo()
                },
                enabled = nome.isNotBlank() &&
                        comentario.isNotBlank(),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                shape = RoundedCornerShape(30.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFB4F02F),
                    contentColor = Color.Black
                )
            ) {

                Text(
                    text = "Salvar alterações",
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Composable
private fun FotoEdicao(
    uri: Uri,
    modifier: Modifier = Modifier
) {

    val context = LocalContext.current

    val bitmap by produceState<android.graphics.Bitmap?>(
        initialValue = null,
        key1 = uri
    ) {

        value = withContext(Dispatchers.IO) {

            try {
                context.contentResolver
                    .openInputStream(uri)
                    ?.use {
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
            contentDescription = "Foto do comentário",
            modifier = modifier,
            contentScale = ContentScale.Crop
        )

    } else {

        Box(
            modifier = modifier.background(Color.LightGray),
            contentAlignment = Alignment.Center
        ) {
            Text("Imagem indisponível")
        }
    }
}