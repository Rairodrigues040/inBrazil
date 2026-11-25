package com.rai.inbrazil.ui.theme.regions.nordeste

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
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.compose.material3.Surface
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.Image
import androidx.compose.ui.layout.ContentScale
import com.rai.inbrazil.R
import com.rai.inbrazil.ui.theme.components.PageReturn

private val VerdeCeara = Color(0xFF2F894F)
private val AmareloCeara = Color(0xFFFFD94A)
private val AzulCeara = Color(0xFF59A5E8)

@Composable
fun NewEstadoNordeste(
    navController: NavController
) {

    var mostrarDestinos by remember {
        mutableStateOf(false)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(VerdeCeara)
    ) {

        // Círculo amarelo
        Box(
            modifier = Modifier
                .size(110.dp)
                .offset(x = (-35).dp, y = (-35).dp)
                .clip(CircleShape)
                .background(AmareloCeara)
                .align(Alignment.TopStart)
        )

        // Círculo azul
        Box(
            modifier = Modifier
                .size(90.dp)
                .offset(x = 40.dp, y = 85.dp)
                .clip(CircleShape)
                .background(AzulCeara)
                .align(Alignment.TopEnd)
        )

        // Conteúdo principal
        Column(
            modifier = Modifier
                .fillMaxSize()
                .then(
                    if (mostrarDestinos) Modifier
                    else Modifier
                )
                .padding(
                    horizontal = 20.dp,
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
                    text = "Ceará",
                    color = Color.White,
                    fontSize = 42.sp,
                    fontWeight = FontWeight.ExtraBold
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Descrição
            Text(
                text = "Terra de praias paradisíacas, cultura marcante e paisagens que encantam. Explore as riquezas do Ceará.",
                color = Color.White,
                fontSize = 15.sp,
                lineHeight = 21.sp,
                fontWeight = FontWeight.Medium
            )

            Spacer(modifier = Modifier.height(20.dp))

            // Card do Ceará
            CardNewEstadoCeara(
                onClick = {
                    mostrarDestinos = true
                }
            )
        }

        // Modal
        if (mostrarDestinos) {
            ModalDestinosCeara(
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
fun CardNewEstadoCeara(
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

            IlustracaoCeara()

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "Ceará",
                fontSize = 26.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color.Black
            )

            Text(
                text = "Lugares, história e curiosidades",
                fontSize = 13.sp,
                color = Color.DarkGray
            )

            Spacer(modifier = Modifier.height(10.dp))

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
// ILUSTRAÇÃO DO CEARÁ
// ==========================================

@Composable
fun IlustracaoCeara() {

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
                    Color(0xFFFFD98B),
                    Color(0xFFFFF0C2)
                )
            )
        )

        // Sol
        drawCircle(
            color = Color(0xFFFFC94A),
            radius = 27.dp.toPx(),
            center = Offset(
                x = largura * 0.78f,
                y = altura * 0.22f
            )
        )

        // Mar
        drawRect(
            color = Color(0xFF319CB0),
            topLeft = Offset(
                x = 0f,
                y = altura * 0.55f
            ),
            size = Size(
                width = largura,
                height = altura * 0.45f
            )
        )

        // Areia
        val areia = Path().apply {
            moveTo(0f, altura * 0.65f)
            lineTo(largura * 0.35f, altura * 0.58f)
            lineTo(largura * 0.65f, altura * 0.48f)
            lineTo(largura, altura * 0.60f)
            lineTo(largura, altura)
            lineTo(0f, altura)
            close()
        }

        drawPath(
            path = areia,
            color = Color(0xFFD6A36A)
        )

        // Duna
        val duna = Path().apply {
            moveTo(largura * 0.35f, altura * 0.58f)
            lineTo(largura * 0.65f, altura * 0.48f)
            lineTo(largura, altura * 0.60f)
            lineTo(largura, altura * 0.72f)
            lineTo(largura * 0.50f, altura * 0.75f)
            close()
        }

        drawPath(
            path = duna,
            color = Color(0xFFB9824E)
        )
    }
}