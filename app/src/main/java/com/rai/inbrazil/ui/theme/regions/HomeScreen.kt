package com.rai.inbrazil.ui.theme.regions

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.rai.inbrazil.ui.theme.regions.components.*

private val AdventureGreen = Color(0xFF2F894F)

@Composable
fun HomeScreen(
    navController: NavController
) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(AdventureGreen)
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 20.dp),

            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.height(50.dp))

            // Mapa e destinos
            MapSection(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(360.dp)
            )

            Spacer(modifier = Modifier.height(28.dp))

            // Título principal
            AdventureTitle()

            Spacer(modifier = Modifier.height(55.dp))

            // Botão de navegação
            ExploreButton(
                onClick = {
                    navController.navigate("regionsScreen") {
                        launchSingleTop = true
                    }
                }
            )

            Spacer(modifier = Modifier.height(35.dp))
        }
    }
}