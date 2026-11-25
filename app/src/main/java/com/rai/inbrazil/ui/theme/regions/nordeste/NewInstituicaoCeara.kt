package com.rai.inbrazil.ui.theme.regions.nordeste

import androidx.compose.foundation.Image
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
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.rai.inbrazil.R
import com.rai.inbrazil.ui.theme.components.PageReturn

private val AzulUFC = Color(0xFF173D66)
private val AzulClaroUFC = Color(0xFF59A5E8)
private val AmareloUFC = Color(0xFFFFD94A)

@Composable
fun NewInstituicaoCeara(
    navController: NavController
) {

    var mostrarModal by remember {
        mutableStateOf(false)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(AzulUFC)
    ) {

        // Conteúdo principal
        Box(
            modifier = Modifier
                .fillMaxSize()
                .blur(
                    radius = if (mostrarModal) 6.dp else 0.dp
                )
        ) {

            // Círculo decorativo amarelo
            Box(
                modifier = Modifier
                    .size(110.dp)
                    .offset(x = (-35).dp, y = (-35).dp)
                    .clip(CircleShape)
                    .background(AmareloUFC)
                    .align(Alignment.TopStart)
            )

            // Círculo decorativo azul
            Box(
                modifier = Modifier
                    .size(90.dp)
                    .offset(x = 40.dp, y = 85.dp)
                    .clip(CircleShape)
                    .background(AzulClaroUFC)
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
                        text = "Universidade",
                        color = Color.White,
                        fontSize = 32.sp,
                        fontWeight = FontWeight.ExtraBold
                    )
                }

                Spacer(
                    modifier = Modifier.height(12.dp)
                )

                Text(
                    text = "Conheça as instituições de ensino superior que fazem parte da história e do desenvolvimento acadêmico do Ceará.",
                    color = Color.White,
                    fontSize = 15.sp,
                    lineHeight = 21.sp,
                    fontWeight = FontWeight.Medium
                )

                Spacer(
                    modifier = Modifier.height(25.dp)
                )

                // Card da UFC
                CardInstituicaoUFC(
                    onClick = {
                        mostrarModal = true
                    }
                )
            }
        }

        // Modal
        if (mostrarModal) {

            ModalInstituicaoUFC(
                onDismiss = {
                    mostrarModal = false
                }
            )
        }
    }
}

// ==========================================
// CARD DA INSTITUIÇÃO
// ==========================================

@Composable
fun CardInstituicaoUFC(
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

            Image(
                painter = painterResource(
                    id = R.drawable.ufc_russas
                ),
                contentDescription = "Campus da UFC em Russas",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(190.dp)
                    .clip(
                        RoundedCornerShape(18.dp)
                    ),
                contentScale = ContentScale.Crop
            )

            Spacer(
                modifier = Modifier.height(10.dp)
            )

            Text(
                text = "Universidade Federal do Ceará",
                fontSize = 23.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color.Black
            )

            Text(
                text = "Campus de Russas",
                fontSize = 14.sp,
                color = Color.DarkGray
            )

            Spacer(
                modifier = Modifier.height(10.dp)
            )

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
                    text = "Conhecer instituição →",
                    color = Color.White,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}