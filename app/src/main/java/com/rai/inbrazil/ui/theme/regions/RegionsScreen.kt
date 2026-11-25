package com.rai.inbrazil.ui.theme.regions

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.rai.inbrazil.R
import com.rai.inbrazil.data.Regiao
import com.rai.inbrazil.navigation.BottomBar
import com.rai.inbrazil.ui.theme.AdventureGreen
import com.rai.inbrazil.ui.theme.Azul_Marinho
import com.rai.inbrazil.ui.theme.Laranja
import com.rai.inbrazil.ui.theme.QuizGreen
import com.rai.inbrazil.ui.theme.QuizGreenDark
import com.rai.inbrazil.ui.theme.components.RegiaoCard

@Composable
fun RegionsScreen(navController: NavController) {

    val regioes = listOf(
        Regiao("Norte", R.drawable.norte),
        Regiao("Nordeste", R.drawable.nordeste)
    )

    val fraunces = FontFamily(Font(R.font.fraunces_extrabold))

    Scaffold(
    ) { innerPadding ->


        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(20.dp)
        ) {

            Text(
                text = "Rotas do Brasil",
                fontSize = 32.sp,
                modifier = Modifier
                    .padding(top = 25.dp)
                    .padding(horizontal = 14.dp),
                fontFamily = fraunces,
                fontWeight = FontWeight.Bold,
                color = Azul_Marinho
            )

            Text(
                text = "Escolha uma região para começar",
                fontSize = 16.sp,
                modifier = Modifier.padding(horizontal = 14.dp),
                fontWeight = FontWeight.SemiBold
            )

            Text(
                text = "2 REGIÕES - 2 ESTADOS",
                fontSize = 16.sp,
                modifier = Modifier.padding(horizontal = 14.dp),
                fontWeight = FontWeight.Bold,
                color = QuizGreenDark
            )

            Text(
                text = "Para onde vamos hoje?",
                fontSize = 32.sp,
                lineHeight = 40.sp,
                modifier = Modifier
                    .padding(top = 8.dp)
                    .padding(horizontal = 14.dp)
                    .width(300.dp),
                fontFamily = fraunces,
                fontWeight = FontWeight.Bold,
                color = Azul_Marinho
            )

            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                items(regioes) { regiao ->

                    RegiaoCard(regiao) {
                        when (regiao.nome) {
                            "Norte" -> navController.navigate("regiaoNorte")
                            "Nordeste" -> navController.navigate("regiaoNordeste")
                        }
                    }
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun visu() {
    val navController = rememberNavController()
    RegionsScreen(
        navController = navController
    )
}