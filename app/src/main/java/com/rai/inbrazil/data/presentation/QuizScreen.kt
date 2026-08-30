package com.rai.inbrazil.data.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun QuizScreen(viewModel: QuizViewModel) {
    val uiState by viewModel.uiState.collectAsState()

    if (uiState.quizFinalizado) {

        ResultadoQuizScreen(
            uiState = uiState, onReiniciar = {
                viewModel.reiniciarQuiz()
            })

        return
    }

    LaunchedEffect(Unit) {
        viewModel.iniciarQuiz()
    }

    val perguntaAtual = uiState.perguntas.getOrNull(
        uiState.indicePerguntaAtual
    )

    val alternativas = perguntaAtual?.let {
        listOf(
            it.alternativaA, it.alternativaB, it.alternativaC, it.alternativaD
        )
    } ?: emptyList()

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = perguntaAtual?.texto ?: "Carregando...",
            fontSize = 18.sp
        )

        Spacer(modifier = Modifier.height(24.dp))

        //o indice vem do forEachIndexed
        alternativas.forEachIndexed { indice, alternativa ->

            val selecionda = uiState.alternativaSelecionada == indice

            val correta = perguntaAtual?.indiceRespostaCorreta == indice


            Button(
                onClick = {
                    viewModel.responder(indice)
                }, modifier = Modifier
                    .width(300.dp)
                    .padding(vertical = 4.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = alternativa)

                    if (uiState.respostaCorreta != null) {

                        if (selecionda && uiState.respostaCorreta == false) {

                            Icon(
                                imageVector = Icons.Default.Close,
                                contentDescription = "Resposta errada"
                            )

                        } else if (correta) {

                            Icon(
                                imageVector = Icons.Default.Check,
                                contentDescription = "Resposta correta"
                            )
                        }
                    }
                }
            }
        }

        if (uiState.respostaCorreta != null && perguntaAtual != null) {

            Spacer(
                modifier = Modifier.height(16.dp)
            )

            Text(
                text = "Explicação:"
            )

            Text(
                text = perguntaAtual.explicacao,
                fontSize = 16.sp,
                textAlign = TextAlign.Center
            )

            Spacer(
                modifier = Modifier.height(16.dp)
            )

            Button(
                onClick = {
                    viewModel.proximaPergunta()
                }) {
                Text(
                    text = "Próxima pergunta"
                )
            }
        }

    }
}