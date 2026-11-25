package com.rai.inbrazil.ui.theme.regions.nordeste

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.rai.inbrazil.R

// ==========================================
// MODELO DOS DESTINOS
// ==========================================

data class DestinoCeara(
    val titulo: String,
    val descricao: String,
    val imagem: Int
)

// ==========================================
// LISTA DE DESTINOS DO CEARÁ
// ==========================================

private val destinosCeara = listOf(

    DestinoCeara(
        titulo = "Jericoacoara",
        descricao = "Um dos destinos mais famosos do Ceará, conhecido por suas praias, dunas, lagoas e paisagens naturais. A região encanta visitantes com sua beleza e tranquilidade.",
        imagem = R.drawable.jericoacoara
    ),

    DestinoCeara(
        titulo = "Canoa Quebrada",
        descricao = "Localizada no litoral leste do Ceará, é conhecida por suas falésias coloridas, praias e pela famosa paisagem da lua e estrela esculpidas nas falésias.",
        imagem = R.drawable.canoa_quebrada
    ),

    DestinoCeara(
        titulo = "Beach Park",
        descricao = "Um dos principais complexos turísticos do Ceará, localizado em Aquiraz. É conhecido por suas atrações aquáticas e opções de lazer para toda a família.",
        imagem = R.drawable.beach_park
    )
)

// ==========================================
// MODAL DOS DESTINOS
// ==========================================

@Composable
fun ModalDestinosCeara(
    onDismiss: () -> Unit
) {

    Dialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties(
            usePlatformDefaultWidth = false
        )
    ) {

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    horizontal = 20.dp,
                    vertical = 35.dp
                ),
            contentAlignment = Alignment.BottomCenter
        ) {

            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.85f),
                shape = RoundedCornerShape(28.dp),
                color = Color(0xFFF2F3EE),
                shadowElevation = 12.dp
            ) {

                Column {

                    // CABEÇALHO
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(
                                horizontal = 20.dp,
                                vertical = 18.dp
                            )
                    ) {

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {

                            Text(
                                text = "Explore o Ceará",
                                fontSize = 25.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = Color(0xFF40433B)
                            )

                            Text(
                                text = "✕",
                                fontSize = 23.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF40433B),
                                modifier = Modifier.clickable {
                                    onDismiss()
                                }
                            )
                        }

                        Spacer(
                            modifier = Modifier.height(5.dp)
                        )

                        Text(
                            text = "Conheça alguns dos lugares mais incríveis do Ceará.",
                            fontSize = 14.sp,
                            color = Color.DarkGray
                        )
                    }

                    // LISTA DOS DESTINOS
                    LazyColumn(
                        modifier = Modifier.fillMaxSize(),
                        contentPadding = PaddingValues(
                            start = 16.dp,
                            end = 16.dp,
                            bottom = 20.dp
                        ),
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {

                        items(destinosCeara) { destino ->

                            CardDestinoCeara(
                                destino = destino
                            )
                        }
                    }
                }
            }
        }
    }
}

// ==========================================
// CARD DE CADA DESTINO
// ==========================================

@Composable
fun CardDestinoCeara(
    destino: DestinoCeara
) {

    Surface(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        color = Color.White,
        shadowElevation = 3.dp
    ) {

        Column {

            // IMAGEM
            Image(
                painter = painterResource(
                    id = destino.imagem
                ),
                contentDescription = destino.titulo,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(170.dp),
                contentScale = ContentScale.Crop
            )

            // INFORMAÇÕES
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(14.dp)
            ) {

                Text(
                    text = destino.titulo,
                    fontSize = 19.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = Color(0xFF40433B)
                )

                Spacer(
                    modifier = Modifier.height(7.dp)
                )

                Text(
                    text = destino.descricao,
                    fontSize = 13.sp,
                    lineHeight = 19.sp,
                    color = Color.DarkGray
                )
            }
        }
    }
}