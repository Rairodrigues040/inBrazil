package com.rai.inbrazil.ui.theme.regions.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.Modifier
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.rai.inbrazil.R

@Composable
fun MapSection(
    modifier: Modifier = Modifier
) {

    Box(
        modifier = modifier
    ) {

        // Mapa
        Image(
            painter = painterResource(R.drawable.home_map),
            contentDescription = "Mapa de destinos turísticos",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(45.dp))
        )

        // Card superior
        DestinationCard(
            title = "Mirante do Pôr do Sol",
            subtitle = "1,2 km · Aberto agora",
            color = Color(0xFFF36527),
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(top = 25.dp)
                .fillMaxWidth(0.78f)
        )

        // Card inferior
        DestinationCard(
            title = "Centro Histórico",
            subtitle = "2,3 km · Tour guiado",
            color = Color(0xFF5AA5E5),
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(bottom = 15.dp)
                .fillMaxWidth(0.82f)
        )

        // Tag
        TrendingTag(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(start = 15.dp, bottom = 12.dp)
        )
    }
}