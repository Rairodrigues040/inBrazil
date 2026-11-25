package com.rai.inbrazil.ui.theme.regions.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TrendingTag(
    modifier: Modifier = Modifier
) {

    Text(
        text = "Em alta",
        modifier = modifier
            .background(
                Color(0xFFFFD84D),
                CircleShape
            )
            .border(
                2.dp,
                Color.Black,
                CircleShape
            )
            .padding(
                horizontal = 20.dp,
                vertical = 10.dp
            ),
        fontSize = 18.sp,
        fontWeight = FontWeight.ExtraBold,
        color = Color.Black
    )
}