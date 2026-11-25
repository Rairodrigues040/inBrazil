package com.rai.inbrazil.ui.theme.regions.norte

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.rai.inbrazil.ui.theme.components.PageReturn

// Cores da tela
private val VerdeAcre = Color(0xFF2F894F)
private val AmareloAcre = Color(0xFFFFD94A)
private val AzulAcre = Color(0xFF59A5E8)

@Composable
fun NewEstadoAcre(
    navController: NavController
) {

    var mostrarDestinos by remember {
        mutableStateOf(false)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(VerdeAcre)
    ) {

        // Conteúdo principal
        Box(
            modifier = Modifier
                .fillMaxSize()
                .blur(
                    radius = if (mostrarDestinos) 8.dp else 0.dp
                )
        ) {

            // Círculo amarelo
            Box(
                modifier = Modifier
                    .size(110.dp)
                    .offset(
                        x = (-35).dp,
                        y = (-35).dp
                    )
                    .clip(CircleShape)
                    .background(AmareloAcre)
                    .align(Alignment.TopStart)
            )

            // Círculo azul
            Box(
                modifier = Modifier
                    .size(90.dp)
                    .offset(
                        x = 40.dp,
                        y = 85.dp
                    )
                    .clip(CircleShape)
                    .background(AzulAcre)
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

                    Spacer(
                        modifier = Modifier.width(12.dp)
                    )

                    Text(
                        text = "Acre",
                        color = Color.White,
                        fontSize = 42.sp,
                        fontWeight = FontWeight.ExtraBold
                    )
                }

                Spacer(
                    modifier = Modifier.height(8.dp)
                )

                // Descrição
                Text(
                    text = "Estado da Amazônia na fronteira com Peru e Bolívia. Toque no card para ver tudo sobre o estado.",
                    color = Color.White,
                    fontSize = 15.sp,
                    lineHeight = 21.sp,
                    fontWeight = FontWeight.Medium
                )

                Spacer(
                    modifier = Modifier.height(20.dp)
                )

                // Card do Acre
                CardNewEstadoAcre(
                    onClick = {
                        mostrarDestinos = true
                    }
                )
            }
        }

        // Modal dos destinos
        if (mostrarDestinos) {

            ModalDestinosAcre(
                onDismiss = {
                    mostrarDestinos = false
                }
            )
        }
    }
}


// ==========================================
// CARD DO ESTADO
// ==========================================

@Composable
fun CardNewEstadoAcre(
    onClick: () -> Unit
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onClick()
            },
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

            // Ilustração
            IlustracaoNewAcre()

            Spacer(
                modifier = Modifier.height(10.dp)
            )

            Text(
                text = "Acre",
                fontSize = 26.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color.Black
            )

            Text(
                text = "Lugares, imagens e curiosidades",
                fontSize = 13.sp,
                color = Color.DarkGray
            )

            Spacer(
                modifier = Modifier.height(10.dp)
            )

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
// ILUSTRAÇÃO DA PAISAGEM
// ==========================================

@Composable
fun IlustracaoNewAcre() {

    Canvas(
        modifier = Modifier
            .fillMaxWidth()
            .height(190.dp)
            .clip(RoundedCornerShape(18.dp))
    ) {

        val largura = size.width
        val altura = size.height

        // Céu
        drawRect(
            brush = Brush.verticalGradient(
                colors = listOf(
                    Color(0xFFBCE8A8),
                    Color(0xFFDDF2C9)
                )
            )
        )

        // Sol
        drawCircle(
            color = Color(0xFFFFF3BD),
            radius = 25.dp.toPx(),
            center = Offset(
                x = largura * 0.20f,
                y = altura * 0.25f
            )
        )

        // Montanhas
        val montanha = Path().apply {

            moveTo(0f, altura * 0.65f)

            lineTo(
                largura * 0.25f,
                altura * 0.53f
            )

            lineTo(
                largura * 0.48f,
                altura * 0.63f
            )

            lineTo(
                largura * 0.72f,
                altura * 0.67f
            )

            lineTo(
                largura,
                altura * 0.55f
            )

            lineTo(largura, altura)
            lineTo(0f, altura)

            close()
        }

        drawPath(
            path = montanha,
            color = Color(0xFF9BC88B)
        )

        // Chão
        drawRect(
            color = Color(0xFF3C8A50),
            topLeft = Offset(
                x = 0f,
                y = altura * 0.72f
            ),
            size = Size(
                width = largura,
                height = altura * 0.28f
            )
        )

        // Posições das árvores
        val posicoes = listOf(
            0.13f to 0.57f,
            0.36f to 0.56f,
            0.61f to 0.54f,
            0.78f to 0.55f,
            0.97f to 0.54f
        )

        // Desenhando as árvores
        posicoes.forEachIndexed { index, (x, y) ->

            val centroX = largura * x
            val centroY = altura * y

            val tamanho = when (index) {
                0 -> 22.dp.toPx()
                1 -> 26.dp.toPx()
                2 -> 30.dp.toPx()
                3 -> 22.dp.toPx()
                else -> 26.dp.toPx()
            }

            // Tronco
            drawRect(
                color = Color(0xFF79502D),
                topLeft = Offset(
                    x = centroX - 3.dp.toPx(),
                    y = centroY + tamanho * 0.55f
                ),
                size = Size(
                    width = 7.dp.toPx(),
                    height = 38.dp.toPx()
                )
            )

            // Copa da árvore
            drawCircle(
                color = Color(0xFF17683C),
                radius = tamanho,
                center = Offset(
                    x = centroX,
                    y = centroY
                )
            )
        }
    }
}