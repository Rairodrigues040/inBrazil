package com.rai.inbrazil.ui.theme.comentarios

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rai.inbrazil.data.entity.ComentarioEntity
import com.rai.inbrazil.data.presentation.ComentarioViewModel
import com.rai.inbrazil.ui.theme.comentarios.components.ComentarioCard

private val VerdeFundo = Color(0xFF2C8950)
private val VerdeBotao = Color(0xFFB4F02F)
private val PretoTexto = Color(0xFF222222)

@Composable
fun ComentariosScreen(
    viewModel: ComentarioViewModel,
    onAdicionar: () -> Unit,
    onEditar: (ComentarioEntity) -> Unit
) {
    val comentarios by viewModel.comentarios.collectAsState()

    var comentarioParaExcluir by remember {
        mutableStateOf<ComentarioEntity?>(null)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(VerdeFundo)
            .statusBarsPadding()
            .padding(
                start = 20.dp,
                end = 20.dp,
                top = 20.dp,
                bottom = 100.dp
            )
    ) {

        // CABEÇALHO

        Text(
            text = "Compartilhe suas experiências",
            color = Color.White,
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = "Comentários",
            color = Color.White,
            fontSize = 34.sp,
            fontWeight = FontWeight.Black
        )

        Spacer(modifier = Modifier.height(24.dp))

        // BOTÃO ADICIONAR

        Button(
            onClick = onAdicionar,
            modifier = Modifier
                .fillMaxWidth()
                .height(54.dp),
            shape = RoundedCornerShape(30.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = VerdeBotao,
                contentColor = PretoTexto
            )
        ) {
            Text(
                text = "+ Adicionar comentário",
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        // CONTEÚDO PRINCIPAL

        if (comentarios.isEmpty()) {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Ainda não existem comentários.\nSeja o primeiro a compartilhar sua experiência!",
                    color = Color.White,
                    fontSize = 15.sp,
                    lineHeight = 23.sp,
                    textAlign = TextAlign.Center
                )
            }

        } else {

            LazyColumn(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                contentPadding = PaddingValues(bottom = 20.dp)
            ) {
                items(
                    items = comentarios,
                    key = { it.id }
                ) { comentario ->

                    ComentarioCard(
                        comentario = comentario,
                        onEditar = {
                            onEditar(comentario)
                        },
                        onExcluir = {
                            comentarioParaExcluir = comentario
                        }
                    )
                }
            }
        }
    }

    // DIÁLOGO DE CONFIRMAÇÃO

    comentarioParaExcluir?.let { comentario ->

        AlertDialog(
            onDismissRequest = {
                comentarioParaExcluir = null
            },
            title = {
                Text("Excluir comentário?")
            },
            text = {
                Text("Tem certeza de que deseja apagar este comentário?")
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        viewModel.excluirComentario(comentario)
                        comentarioParaExcluir = null
                    }
                ) {
                    Text(
                        text = "Excluir",
                        color = Color.Red
                    )
                }
            },
            dismissButton = {
                TextButton(
                    onClick = {
                        comentarioParaExcluir = null
                    }
                ) {
                    Text("Cancelar")
                }
            }
        )
    }
}