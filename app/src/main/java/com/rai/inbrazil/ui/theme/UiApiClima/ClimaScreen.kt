package com.rai.inbrazil.ui.theme.UiApiClima

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.rai.inbrazil.service.RetrofitInstance
import com.rai.inbrazil.ui.theme.Azul_Marinho
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@Composable
fun ClimaScreen() {

    var temperatura by remember { mutableStateOf<Double?>(null) }
    var carregando by remember { mutableStateOf(true) }
    var erro by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        try {
            val resposta = withContext(Dispatchers.IO) {
                RetrofitInstance.api.buscarClima(
                    latitude = -9.97499,
                    longitude = -67.8243
                )
            }

            temperatura = resposta.current_weather.temperature
            erro = false

        } catch (e: Exception) {
            erro = true
            temperatura = null

        } finally {
            carregando = false
        }
    }

    Column {
        Text(
            text = when {
                carregando -> "Carregando clima..."
                temperatura != null -> "Rio Branco: $temperatura °C"
                erro -> "Clima indisponível sem conexão com a internet."
                else -> "Clima indisponível."
            },
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = 16.dp),
            color = Azul_Marinho
        )
    }
}