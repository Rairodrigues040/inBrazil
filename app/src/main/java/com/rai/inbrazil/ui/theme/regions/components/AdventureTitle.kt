package com.rai.inbrazil.ui.theme.regions.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rai.inbrazil.R

private val Fraunces = FontFamily(
    Font(R.font.fraunces_extrabold)
)

@Composable
fun AdventureTitle() {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Seu próximo destino",
            fontFamily = Fraunces,
            fontSize = 29.sp,
            color = Color.White,
            textAlign = TextAlign.Center
        )

        Box(
            contentAlignment = Alignment.Center
        ) {

            // Contorno preto
            Text(
                text = "Aventura",
                fontSize = 62.sp,
                fontWeight = FontWeight.Black,
                color = Color.Black,
                style = TextStyle(
                    drawStyle = Stroke(width = 6f)
                )
            )

            // Preenchimento branco
            Text(
                text = "Aventura",
                fontSize = 62.sp,
                fontWeight = FontWeight.Black,
                color = Color.White
            )
        }

        Box(
            modifier = Modifier
                .padding(top = 5.dp)
                .rotate(-3f)
                .background(
                    Color(0xFFB7F332),
                    RoundedCornerShape(18.dp)
                )
                .border(
                    3.dp,
                    Color.Black,
                    RoundedCornerShape(18.dp)
                )
                .padding(
                    horizontal = 30.dp,
                    vertical = 8.dp
                )
        ) {

            Text(
                text = "por perto",
                fontSize = 35.sp,
                fontWeight = FontWeight.Black,
                color = Color.Black
            )
        }
    }
}