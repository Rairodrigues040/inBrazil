package com.rai.inbrazil.ui.theme.regions.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DestinationCard(
    title: String,
    subtitle: String,
    color: Color,
    modifier: Modifier = Modifier
) {

    Row(
        modifier = modifier
            .background(
                Color.White,
                RoundedCornerShape(28.dp)
            )
            .padding(12.dp),

        verticalAlignment = Alignment.CenterVertically
    ) {

        // Imagem ilustrativa do destino
        Box(
            modifier = Modifier
                .size(82.dp)
                .background(
                    color,
                    RoundedCornerShape(22.dp)
                )
        )

        Spacer(modifier = Modifier.width(12.dp))

        Column(
            modifier = Modifier.weight(1f)
        ) {

            Text(
                text = title,
                fontSize = 19.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                lineHeight = 23.sp
            )

            Spacer(modifier = Modifier.height(5.dp))

            Text(
                text = subtitle,
                fontSize = 14.sp,
                color = Color.Gray
            )
        }
    }
}