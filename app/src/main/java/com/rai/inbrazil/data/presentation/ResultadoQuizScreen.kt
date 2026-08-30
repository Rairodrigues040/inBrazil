package com.rai.inbrazil.data.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ResultadoQuizScreen(
    uiState: QuizUiState,
    onReiniciar: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "Quiz finalizado!"
        )

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        Text(
            text = "Pontuação: ${uiState.pontuacao}"
        )

        Text(
            text = "Acertos: ${uiState.quantidadeAcertos}"
        )

        Text(
            text = "Erros: ${uiState.quantidadeErros}"
        )

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        Button(
            onClick = onReiniciar
        ) {
            Text(
                text = "Fazer novamente"
            )
        }
    }
}