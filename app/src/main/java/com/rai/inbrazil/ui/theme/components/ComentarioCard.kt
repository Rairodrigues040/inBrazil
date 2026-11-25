package com.rai.inbrazil.ui.theme.comentarios.components

import android.graphics.BitmapFactory
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
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
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun ComentarioCard(
    comentario: ComentarioEntity,
    onEditar: () -> Unit,
    onExcluir: () -> Unit
) {

    val dataFormatada = remember(comentario.data) {
        SimpleDateFormat(
            "dd/MM/yyyy",
            Locale("pt", "BR")
        ).format(Date(comentario.data))
    }

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFF2F3EE)
        )
    ) {

        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            // FOTO

            if (comentario.fotoUri != null) {

                FotoComentario(
                    uriString = comentario.fotoUri,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(180.dp)
                )

                Spacer(modifier = Modifier.height(12.dp))
            }

            // NOME E DATA

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    text = comentario.nome,
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF40433B)
                )

                Text(
                    text = dataFormatada,
                    fontSize = 11.sp,
                    color = Color.Gray
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            // ESTADO

            Surface(
                color = Color(0xFFC2E2C3),
                shape = RoundedCornerShape(20.dp)
            ) {

                Text(
                    text = comentario.estado,
                    modifier = Modifier.padding(
                        horizontal = 12.dp,
                        vertical = 5.dp
                    ),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF1D5B0B)
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            // COMENTÁRIO

            Text(
                text = comentario.comentario,
                fontSize = 14.sp,
                color = Color(0xFF40433B),
                lineHeight = 21.sp
            )

            Spacer(modifier = Modifier.height(16.dp))

            // BOTÕES

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {

                OutlinedButton(
                    onClick = onEditar,
                    modifier = Modifier.weight(1f),
                    shape = RoundedCornerShape(25.dp)
                ) {
                    Text("Editar")
                }

                Button(
                    onClick = onExcluir,
                    modifier = Modifier.weight(1f),
                    shape = RoundedCornerShape(25.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFB3261E)
                    )
                ) {
                    Text("Apagar")
                }
            }
        }
    }
}

@Composable
private fun FotoComentario(
    uriString: String,
    modifier: Modifier = Modifier
) {

    val context = LocalContext.current

    val bitmap by produceState<android.graphics.Bitmap?>(
        initialValue = null,
        key1 = uriString
    ) {

        value = withContext(Dispatchers.IO) {

            try {
                context.contentResolver
                    .openInputStream(Uri.parse(uriString))
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
            modifier = modifier.clip(
                RoundedCornerShape(18.dp)
            ),
            contentScale = ContentScale.Crop
        )

    } else {

        Box(
            modifier = modifier
                .clip(RoundedCornerShape(18.dp))
                .background(Color.LightGray),
            contentAlignment = Alignment.Center
        ) {
            Text("Imagem indisponível")
        }
    }
}