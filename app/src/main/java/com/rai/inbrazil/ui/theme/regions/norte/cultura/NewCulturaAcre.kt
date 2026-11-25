package com.rai.inbrazil.ui.theme.regions.norte.cultura

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.navigation.NavController
import com.rai.inbrazil.R
import com.rai.inbrazil.ui.theme.components.PageReturn

private val VerdeCultura = Color(0xFF2F894F)
private val AmareloCultura = Color(0xFFFFD94A)
private val AzulCultura = Color(0xFF59A5E8)

@Composable
fun NewCulturaAcre(
    navController: NavController
) {

    var mostrarPopup by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(VerdeCultura)
    ) {

        // Conteúdo principal da tela
        Box(
            modifier = Modifier
                .fillMaxSize()
                .then(
                    if (mostrarPopup) Modifier.blur(5.dp)
                    else Modifier
                )
        ) {

            // Círculo amarelo decorativo
            Box(
                modifier = Modifier
                    .size(110.dp)
                    .offset(x = (-35).dp, y = (-35).dp)
                    .clip(CircleShape)
                    .background(AmareloCultura)
                    .align(Alignment.TopStart)
            )

            // Círculo azul decorativo
            Box(
                modifier = Modifier
                    .size(90.dp)
                    .offset(x = 40.dp, y = 85.dp)
                    .clip(CircleShape)
                    .background(AzulCultura)
                    .align(Alignment.TopEnd)
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        horizontal = 28.dp,
                        vertical = 24.dp
                    )
            ) {

                // Cabeçalho
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    PageReturn(navController)

                    Spacer(modifier = Modifier.width(12.dp))

                    Text(
                        text = "Cultura",
                        color = Color.White,
                        fontSize = 38.sp,
                        fontWeight = FontWeight.ExtraBold
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                // Descrição
                Text(
                    text = "Conheça as tradições, os costumes e as manifestações culturais que fazem parte da identidade do povo acreano.",
                    color = Color.White,
                    fontSize = 15.sp,
                    lineHeight = 21.sp,
                    fontWeight = FontWeight.Medium
                )

                Spacer(modifier = Modifier.height(20.dp))

                // Card principal
                CardCulturaAcre(
                    onClick = {
                        mostrarPopup = true
                    }
                )
            }
        }

        // Pop-up
        if (mostrarPopup) {

            Dialog(
                onDismissRequest = {
                    mostrarPopup = false
                },
                properties = DialogProperties(
                    usePlatformDefaultWidth = false
                )
            ) {

                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 24.dp)
                        .heightIn(max = 620.dp),
                    shape = RoundedCornerShape(28.dp),
                    color = Color.White,
                    shadowElevation = 12.dp
                ) {

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .verticalScroll(rememberScrollState())
                            .padding(20.dp)
                    ) {

                        // Cabeçalho do pop-up
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {

                            Text(
                                text = "Cultura acreana",
                                fontSize = 25.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = Color.Black
                            )

                            Text(
                                text = "✕",
                                fontSize = 22.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.DarkGray,
                                modifier = Modifier
                                    .clickable {
                                        mostrarPopup = false
                                    }
                                    .padding(5.dp)
                            )
                        }

                        Spacer(modifier = Modifier.height(6.dp))

                        Text(
                            text = "Conheça algumas das principais manifestações culturais do Acre.",
                            fontSize = 14.sp,
                            lineHeight = 20.sp,
                            color = Color.DarkGray
                        )

                        Spacer(modifier = Modifier.height(18.dp))

                        // Cultura 1: Povos indígenas
                        ItemCultura(
                            titulo = "Povos indígenas",
                            imagem = R.drawable.povos_indigenas,
                            descricao = "Os povos indígenas do Acre representam uma importante parte da história e da diversidade cultural do estado. Entre os principais grupos estão os Huni Kuĩ (Kaxinawá), Ashaninka, Yawanawá, Shanenawa e Puyanawa. Suas comunidades preservam tradições, línguas, artesanatos, conhecimentos sobre plantas medicinais e formas próprias de relação com a natureza, contribuindo para a riqueza cultural e ambiental da Amazônia."
                        )

                        Spacer(modifier = Modifier.height(14.dp))

                        // Cultura 2: Folclore
                        ItemCultura(
                            titulo = "Folclore",
                            imagem = R.drawable.folclore_acre,
                            descricao = "O folclore acreano é marcado pela mistura de tradições indígenas, nordestinas e amazônicas. Suas lendas e manifestações culturais incluem histórias de seres encantados da floresta, como o Mapinguari, a Cobra-Grande e o Curupira. Também se destacam danças, músicas, festas populares e narrativas transmitidas entre gerações, que valorizam a identidade cultural e a relação dos povos acreanos com a natureza."
                        )

                        Spacer(modifier = Modifier.height(14.dp))

                        // Cultura 3: Artesanato
                        ItemCultura(
                            titulo = "Artesanato",
                            imagem = R.drawable.artesanato_acre,
                            descricao = "O artesanato acreano é uma expressão da rica diversidade cultural da região, fortemente influenciada pelos povos indígenas e pelas tradições amazônicas. Destacam-se peças produzidas com sementes, madeira, fibras naturais, cipós e palhas, como cestos, colares, pulseiras, cerâmicas e objetos decorativos. Essas produções valorizam os conhecimentos tradicionais, a identidade cultural e os recursos naturais da Amazônia."
                        )

                        Spacer(modifier = Modifier.height(20.dp))

                        // Botão fechar
                        Button(
                            onClick = {
                                mostrarPopup = false
                            },
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
    }
}


// ==========================================
// ITEM DE CULTURA NO POP-UP
// ==========================================

@Composable
fun ItemCultura(
    titulo: String,
    descricao: String,
    imagem: Int
) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(18.dp))
            .background(Color(0xFFF2F5F0))
            .padding(12.dp)
    ) {

        // Imagem da manifestação cultural
        Image(
            painter = painterResource(id = imagem),
            contentDescription = titulo,
            modifier = Modifier
                .fillMaxWidth()
                .height(170.dp)
                .clip(RoundedCornerShape(14.dp)),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(12.dp))

        // Título
        Text(
            text = titulo,
            fontSize = 19.sp,
            fontWeight = FontWeight.Bold,
            color = VerdeCultura
        )

        Spacer(modifier = Modifier.height(7.dp))

        // Descrição
        Text(
            text = descricao,
            fontSize = 14.sp,
            lineHeight = 21.sp,
            color = Color(0xFF40433B)
        )
    }
}


// ==========================================
// CARD DA CULTURA
// ==========================================

@Composable
fun CardCulturaAcre(
    onClick: () -> Unit
) {

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(26.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        )
    ) {

        Column(
            modifier = Modifier.padding(10.dp)
        ) {

            // Ilustração cultural
            IlustracaoCulturaAcre()

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "Cultura acreana",
                fontSize = 25.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color.Black
            )

            Text(
                text = "Tradições, história e identidade",
                fontSize = 13.sp,
                color = Color.DarkGray
            )

            Spacer(modifier = Modifier.height(10.dp))

            // Botão explorar
            Button(
                onClick = onClick,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Black
                ),
                shape = RoundedCornerShape(50.dp),
                contentPadding = PaddingValues(
                    horizontal = 18.dp,
                    vertical = 7.dp
                )
            ) {

                Text(
                    text = "Explorar tudo →",
                    color = Color.White,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}


// ==========================================
// ILUSTRAÇÃO DA CULTURA ACREANA
// ==========================================

@Composable
fun IlustracaoCulturaAcre() {

    Canvas(
        modifier = Modifier
            .fillMaxWidth()
            .height(190.dp)
            .clip(RoundedCornerShape(18.dp))
    ) {

        val largura = size.width
        val altura = size.height

        // Fundo
        drawRect(
            brush = Brush.verticalGradient(
                colors = listOf(
                    Color(0xFFFFE7A3),
                    Color(0xFFFFF3D0)
                )
            )
        )

        // Sol
        drawCircle(
            color = Color(0xFFFFC94A),
            radius = 25.dp.toPx(),
            center = Offset(
                x = largura * 0.78f,
                y = altura * 0.22f
            )
        )

        // Montanhas ao fundo
        val montanhas = Path().apply {

            moveTo(0f, altura * 0.65f)

            lineTo(
                largura * 0.30f,
                altura * 0.48f
            )

            lineTo(
                largura * 0.55f,
                altura * 0.65f
            )

            lineTo(
                largura * 0.80f,
                altura * 0.50f
            )

            lineTo(largura, altura * 0.65f)

            lineTo(largura, altura)
            lineTo(0f, altura)

            close()
        }

        drawPath(
            path = montanhas,
            color = Color(0xFF8DBB78)
        )

        // Chão
        drawRect(
            color = Color(0xFF3C8A50),
            topLeft = Offset(
                x = 0f,
                y = altura * 0.75f
            ),
            size = Size(
                width = largura,
                height = altura * 0.25f
            )
        )

        // Tronco de seringueira
        drawRect(
            color = Color(0xFF79502D),
            topLeft = Offset(
                x = largura * 0.22f,
                y = altura * 0.35f
            ),
            size = Size(
                width = 17.dp.toPx(),
                height = altura * 0.45f
            )
        )

        // Copa da árvore
        drawCircle(
            color = Color(0xFF17683C),
            radius = 37.dp.toPx(),
            center = Offset(
                x = largura * 0.25f,
                y = altura * 0.34f
            )
        )

        // Casa tradicional estilizada
        val casa = Path().apply {

            moveTo(
                largura * 0.48f,
                altura * 0.65f
            )

            lineTo(
                largura * 0.65f,
                altura * 0.48f
            )

            lineTo(
                largura * 0.82f,
                altura * 0.65f
            )

            close()
        }

        drawPath(
            path = casa,
            color = Color(0xFF9B4D2E)
        )

        // Estrutura da casa
        drawRect(
            color = Color(0xFFE8B66B),
            topLeft = Offset(
                x = largura * 0.52f,
                y = altura * 0.65f
            ),
            size = Size(
                width = largura * 0.26f,
                height = altura * 0.20f
            )
        )

        // Porta
        drawRect(
            color = Color(0xFF79502D),
            topLeft = Offset(
                x = largura * 0.62f,
                y = altura * 0.70f
            ),
            size = Size(
                width = 20.dp.toPx(),
                height = 29.dp.toPx()
            )
        )
    }
}