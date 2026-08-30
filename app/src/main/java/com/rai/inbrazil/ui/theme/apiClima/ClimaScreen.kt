package com.rai.inbrazil.ui.theme.apiClima

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.rai.inbrazil.service.RetrofitInstance
import com.rai.inbrazil.ui.theme.Azul_Marinho

@Composable
fun ClimaScreen() {

    var temperatura by remember {
        mutableStateOf<Double?>(null)
    }

    LaunchedEffect(Unit) {

        val resposta = RetrofitInstance.api.buscarClima(
            latitude = -9.97499,
            longitude = -67.8243
        )

        temperatura = resposta.current_weather.temperature
    }

    Column {

        Text(
            text = if (temperatura != null) {
                "Rio Branco: $temperatura °C"
            } else {
                "Carregando..."
            },
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = 16.dp),
            color = Azul_Marinho
        )
    }
}