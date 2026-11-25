package com.rai.inbrazil.ui.theme.regions.nordeste

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.rai.inbrazil.R
import com.rai.inbrazil.data.Regiao
import com.rai.inbrazil.ui.theme.components.PageReturn
import com.rai.inbrazil.ui.theme.components.RegiaoCard

@Composable
fun RegiaoNordeste(navController: NavController) {

    val estadosNorte = listOf(
        Regiao("Ceará", R.drawable.ceara_nordeste),
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(20.dp)
    ) {

        Row(verticalAlignment = Alignment.CenterVertically) {

            PageReturn(navController)

            Column(verticalArrangement = Arrangement.Center) {

                Text(
                    text = "Região Nordeste",
                    fontSize = 24.sp,
                    modifier = Modifier.padding(top = 20.dp),
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = "Estados:",
                    fontSize = 24.sp,
                    color = Color(0xD85D5C5C),
                    fontWeight = FontWeight.SemiBold
                )
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        LazyColumn {
            items(estadosNorte) { estados ->

                RegiaoCard(estados) {
                    when (estados.nome) {
                        "Ceará" -> {
                            navController.navigate("estadoCeara")
                        }
                    }
                }
            }
        }
    }
}