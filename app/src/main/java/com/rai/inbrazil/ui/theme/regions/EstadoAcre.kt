package com.rai.inbrazil.ui.theme.regions

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rai.inbrazil.R
import com.rai.inbrazil.data.Regiao
import com.rai.inbrazil.ui.theme.Azul_Marinho
import com.rai.inbrazil.ui.theme.apiClima.ClimaScreen
import com.rai.inbrazil.ui.theme.components.RegiaoCard

@Composable
fun EstadoAcre(){

    val fraunces = FontFamily(Font(R.font.fraunces_extrabold))

    val rioBranco =
    Column(
        modifier = Modifier.fillMaxSize().padding(20.dp)
    ) {
        Text(
            text = "Região Norte",
            fontSize = 24.sp,
            modifier = Modifier.padding(top = 20.dp),
            fontWeight = FontWeight.Bold,
            color = Azul_Marinho,
            fontFamily = fraunces
        )

        Text(
            text = "Estados: Acre",
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color(0xD85D5C5C)
        )

        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = "O que você deseja conhecer no estado do Acre?",
            textAlign = TextAlign.Center,
            fontSize = 21.sp,
            fontWeight = FontWeight.Bold,
            color = Azul_Marinho,
            modifier = Modifier.fillMaxWidth(),

        )

        Spacer(modifier = Modifier.height(30.dp))

        Text(
            "Capital: ",
            color = Azul_Marinho,
            textAlign = TextAlign.Left,
            modifier = Modifier.padding(start = 16.dp),
            fontWeight = FontWeight.Bold
        )

        RegiaoCard(
            Regiao("Rio Branco", R.drawable.rio_branco),
            onClick = {}
        )

        Text(
            "Cultura: ",
            color = Azul_Marinho,
            textAlign = TextAlign.Left,
            modifier = Modifier.padding(start = 16.dp),
            fontWeight = FontWeight.Bold
        )

        RegiaoCard(
            Regiao("Cultura", R.drawable.cultura ),
            onClick = {}
        )

        Spacer(modifier = Modifier.height(16.dp))

        ClimaScreen()

    }
}