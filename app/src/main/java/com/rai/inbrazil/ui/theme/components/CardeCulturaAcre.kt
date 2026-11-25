package com.rai.inbrazil.ui.theme.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.dropShadow
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.DefaultShadowColor
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rai.inbrazil.R
import com.rai.inbrazil.ui.theme.Azul_Marinho
import com.rai.inbrazil.ui.theme.Orange

@Composable
fun CardeCulturaAcre(
    title: String,
    image: Painter,
    modifier: Modifier = Modifier,
    onButtonClick: () -> Unit = {}
) {
    // Container principal para segurar o Card + Sombra
    Box(
        modifier = modifier.width(260.dp)
    ) {
        // 1. A SOMBRA RÍGIDA (desenhada por trás)
        Box(
            modifier = Modifier
                .matchParentSize()
                .offset(x = 8.dp, y = 8.dp) // Altere para ajustar a direção/distância da sombra
                .background(
                    color = Color.White.copy(alpha = 0.5f), // Cor da sombra
                    shape = RoundedCornerShape(20.dp)
                )
        )

        // 2. O CARD PRINCIPAL (desenhado por cima)
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = Azul_Marinho,
                    shape = RoundedCornerShape(20.dp)
                )
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = title,
                color = Color.White,
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(16.dp))

            Image(
                painter = image,
                contentDescription = title,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(160.dp)
                    .clip(RoundedCornerShape(12.dp))
            )

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = onButtonClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Orange
                ),
                shape = RoundedCornerShape(10.dp)
            ) {
                Text(
                    text = "Saiba mais",
                    color = Color.Black,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true, backgroundColor = 0xFF0D1B2A)
@Composable
private fun TesteCulturaAcre() {
    CardeCulturaAcre(
        title = "Quadrilha",
        image = painterResource(R.drawable.quadrilha)
    )
}