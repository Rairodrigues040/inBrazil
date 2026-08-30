package com.rai.inbrazil.ui.theme.regions

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.rai.inbrazil.R
import com.rai.inbrazil.data.Regiao
import com.rai.inbrazil.ui.theme.components.RegiaoCard


@Composable
fun RegiaoNorte(navController: NavController) {
    val estadosNorte = listOf(
        Regiao("Acre", R.drawable.acre_norte),
        Regiao("Amapá", R.drawable.amapa_norte),
        Regiao("Amazonas", R.drawable.amazonas_norte),
        Regiao("Pará", R.drawable.para_norte),
        Regiao("Rondônia", R.drawable.rondonia_norte),
        Regiao("Roraima", R.drawable.roraima_norte),
        Regiao("Tocantins", R.drawable.tocantins_norte),
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        Text(
            text = "Região Norte",
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

        Spacer(modifier = Modifier.height(20.dp))

        LazyColumn{
            items(estadosNorte){ estados ->
                RegiaoCard(estados) {
                    when(estados.nome){
                        "Acre" -> { navController.navigate("estadoAcre")}
                        "Amapá" -> {}
                        "Amazonas" -> {}
                        "Pará" -> {}
                        "Rondônia" -> {}
                        "Roraima" -> {}
                        "Tocantins" -> {}
                    }
                }
            }
        }

    }
}

@Preview(showSystemUi = true)
@Composable
fun norte() {

}