package com.rai.inbrazil.ui.theme.regions.norte.cultura

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rai.inbrazil.R

private data class Cultura(
    val titulo: String,
    val descricao: String,
    val imagem: Int
)

private val culturasAcre = listOf(

    Cultura(
        titulo = "Povos indígenas",
        descricao = "Os povos indígenas do Acre representam uma importante parte da história e da diversidade cultural do estado. Entre os principais grupos estão os Huni Kuĩ (Kaxinawá), Ashaninka, Yawanawá, Shanenawa e Puyanawa. Suas comunidades preservam tradições, línguas, artesanatos, conhecimentos sobre plantas medicinais e formas próprias de relação com a natureza, contribuindo para a riqueza cultural e ambiental da Amazônia.",
        imagem = R.drawable.povos_indigenas
    ),

    Cultura(
        titulo = "Folclore",
        descricao = "O folclore acreano é marcado pela mistura de tradições indígenas, nordestinas e amazônicas. Suas lendas e manifestações culturais incluem histórias de seres encantados da floresta, como o Mapinguari, a Cobra-Grande e o Curupira. Também se destacam danças, músicas, festas populares e narrativas transmitidas entre gerações, que valorizam a identidade cultural e a relação dos povos acreanos com a natureza.",
        imagem = R.drawable.folclore
    ),

    Cultura(
        titulo = "Artesanato",
        descricao = "O artesanato acreano é uma expressão da rica diversidade cultural da região, fortemente influenciada pelos povos indígenas e pelas tradições amazônicas. Destacam-se peças produzidas com sementes, madeira, fibras naturais, cipós e palhas, como cestos, colares, pulseiras, cerâmicas e objetos decorativos. Essas produções valorizam os conhecimentos tradicionais, a identidade cultural e os recursos naturais da Amazônia.",
        imagem = R.drawable.artesanato
    )
)

@Composable
fun CulturaAcreDialog(
    onDismiss: () -> Unit
) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black.copy(alpha = 0.50f)),
        contentAlignment = Alignment.Center
    ) {

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.82f)
                .padding(horizontal = 24.dp),
            shape = RoundedCornerShape(28.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            ),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 12.dp
            )
        ) {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(18.dp)
            ) {

                // Cabeçalho
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Column(
                        modifier = Modifier.weight(1f)
                    ) {

                        Text(
                            text = "Cultura acreana",
                            fontSize = 23.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = Color(0xFF17683C)
                        )

                        Text(
                            text = "Tradições e identidade",
                            fontSize = 13.sp,
                            color = Color.Gray
                        )
                    }

                    androidx.compose.material3.IconButton(
                        onClick = onDismiss
                    ) {
                        Text(
                            text = "✕",
                            fontSize = 20.sp,
                            color = Color.DarkGray
                        )
                    }
                }

                Spacer(modifier = Modifier.height(12.dp))

                // Lista de culturas
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .verticalScroll(rememberScrollState())
                ) {

                    culturasAcre.forEachIndexed { index, cultura ->

                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 14.dp),
                            shape = RoundedCornerShape(18.dp),
                            colors = CardDefaults.cardColors(
                                containerColor = Color(0xFFF2F6EF)
                            )
                        ) {

                            Column(
                                modifier = Modifier.padding(14.dp)
                            ) {

                                Text(
                                    text = "0${index + 1}",
                                    color = Color(0xFF2F894F),
                                    fontSize = 13.sp,
                                    fontWeight = FontWeight.Bold
                                )

                                Spacer(modifier = Modifier.height(5.dp))

                                Text(
                                    text = cultura.titulo,
                                    fontSize = 19.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = Color(0xFF17683C)
                                )

                                Spacer(modifier = Modifier.height(10.dp))

                                Image(
                                    painter = painterResource(
                                        id = cultura.imagem
                                    ),
                                    contentDescription = cultura.titulo,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(150.dp)
                                        .clip(RoundedCornerShape(14.dp)),
                                    contentScale = ContentScale.Crop
                                )

                                Spacer(modifier = Modifier.height(10.dp))

                                Text(
                                    text = cultura.descricao,
                                    fontSize = 14.sp,
                                    lineHeight = 21.sp,
                                    color = Color(0xFF40433B)
                                )
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.height(10.dp))

                // Botão fechar
                Button(
                    onClick = onDismiss,
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Black
                    ),
                    shape = RoundedCornerShape(50.dp)
                ) {

                    Text(
                        text = "Fechar",
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}