package com.rai.inbrazil.data.presentation

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.PaintingStyle.Companion.Stroke
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rai.inbrazil.ui.theme.AdventureGreen
import com.rai.inbrazil.ui.theme.QuizBlack
import com.rai.inbrazil.ui.theme.QuizBlue
import com.rai.inbrazil.ui.theme.QuizCorrect
import com.rai.inbrazil.ui.theme.QuizGray
import com.rai.inbrazil.ui.theme.QuizGreen
import com.rai.inbrazil.ui.theme.QuizIncorrect
import com.rai.inbrazil.ui.theme.QuizOrange
import com.rai.inbrazil.ui.theme.QuizPurple
import com.rai.inbrazil.ui.theme.QuizWhite
import com.rai.inbrazil.ui.theme.QuizYellow

@Composable
fun QuizScreen(viewModel: QuizViewModel, onVoltarHome: () -> Unit) {
    val uiState by viewModel.uiState.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.iniciarQuiz()
    }

    QuizContent(
        uiState = uiState,
        onResponder = { indice ->
            viewModel.responder(indice)
        },
        onProximaPergunta = {
            viewModel.proximaPergunta()
        },
        onReiniciar = {
            viewModel.reiniciarQuiz()
        },
        onVoltarHome = onVoltarHome
    )
}

@Composable
fun QuizContent(
    uiState: QuizUiState,
    onResponder: (Int) -> Unit,
    onProximaPergunta: () -> Unit,
    onReiniciar: () -> Unit,
    onVoltarHome: () -> Unit
) {

    if (uiState.quizFinalizado) {
        ResultadoQuizScreen(
            uiState = uiState,
            onReiniciar = onReiniciar,
            onVoltarHome = onVoltarHome
        )
        return
    }

    val perguntaAtual = uiState.perguntas.getOrNull(
        uiState.indicePerguntaAtual
    )

    val alternativas = perguntaAtual?.let {
        listOf(
            it.alternativaA,
            it.alternativaB,
            it.alternativaC,
            it.alternativaD
        )
    } ?: emptyList()

    val coresAlternativas = listOf(
        QuizOrange,
        QuizBlue,
        QuizYellow,
        QuizPurple
    )

    val letras = listOf("A", "B", "C", "D")

    val totalPerguntas = uiState.perguntas.size

    val perguntasRespondidas = uiState.indicePerguntaAtual +
            if (uiState.respostaCorreta != null) 1 else 0

    val progresso = if (totalPerguntas > 0) {
        perguntasRespondidas.toFloat() / totalPerguntas
    } else {
        0f
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(AdventureGreen)
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 24.dp, vertical = 32.dp),

        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // CABEÇALHO
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = "Pergunta ${uiState.indicePerguntaAtual + 1} de $totalPerguntas",
                color = QuizWhite,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )

            QuizTimer(
                tempoRestante = uiState.tempoRestante
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        // BARRA DE PROGRESSO
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(20.dp)
                .border(
                    width = 3.dp,
                    color = QuizBlack,
                    shape = CircleShape
                )
                .background(
                    color = QuizWhite,
                    shape = CircleShape
                )
        ) {

            Box(
                modifier = Modifier
                    .fillMaxWidth(progresso.coerceIn(0f, 1f))
                    .height(20.dp)
                    .background(
                        color = QuizGreen,
                        shape = CircleShape
                    )
            )
        }

        Spacer(modifier = Modifier.height(40.dp))

        // CARD DA PERGUNTA
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = QuizWhite,
                    shape = RoundedCornerShape(36.dp)
                )
                .padding(28.dp),

            horizontalAlignment = Alignment.Start
        ) {

            Text(
                text = "InBrazil",
                modifier = Modifier
                    .background(
                        QuizYellow,
                        RoundedCornerShape(50.dp)
                    )
                    .border(
                        2.dp,
                        QuizBlack,
                        RoundedCornerShape(50.dp)
                    )
                    .padding(
                        horizontal = 20.dp,
                        vertical = 8.dp
                    ),
                color = QuizBlack,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = perguntaAtual?.texto ?: "Carregando...",
                color = QuizBlack,
                fontSize = 25.sp,
                fontWeight = FontWeight.ExtraBold
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        // ALTERNATIVAS
        alternativas.forEachIndexed { indice, alternativa ->

            val selecionada =
                uiState.alternativaSelecionada == indice

            val correta =
                perguntaAtual?.indiceRespostaCorreta == indice

            val corFundo = when {
                uiState.respostaCorreta != null && correta ->
                    QuizCorrect

                uiState.respostaCorreta != null && selecionada ->
                    QuizIncorrect

                uiState.respostaCorreta != null ->
                    QuizWhite.copy(alpha = 0.55f)

                else -> QuizWhite
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 7.dp)
                    .background(
                        color = corFundo,
                        shape = CircleShape
                    )
                    .border(
                        width = 3.dp,
                        color = QuizBlack,
                        shape = CircleShape
                    )
                    .clickable(
                        enabled = uiState.respostaCorreta == null
                    ) {
                        onResponder(indice)
                    }
                    .padding(
                        horizontal = 14.dp,
                        vertical = 12.dp
                    ),

                verticalAlignment = Alignment.CenterVertically
            ) {

                // LETRA DA ALTERNATIVA
                Box(
                    modifier = Modifier
                        .size(48.dp)
                        .background(
                            color = coresAlternativas[indice],
                            shape = CircleShape
                        )
                        .border(
                            width = 3.dp,
                            color = QuizBlack,
                            shape = CircleShape
                        ),

                    contentAlignment = Alignment.Center
                ) {

                    Text(
                        text = letras[indice],
                        color = QuizBlack,
                        fontSize = 21.sp,
                        fontWeight = FontWeight.ExtraBold
                    )
                }

                Spacer(modifier = Modifier.width(16.dp))

                Text(
                    text = alternativa,
                    modifier = Modifier.weight(1f),
                    color = if (
                        uiState.respostaCorreta != null &&
                        selecionada &&
                        !correta
                    ) QuizWhite else QuizBlack,
                    fontSize = 19.sp,
                    fontWeight = FontWeight.Bold
                )

                if (uiState.respostaCorreta != null) {

                    if (correta) {
                        Icon(
                            imageVector = Icons.Default.Check,
                            contentDescription = "Resposta correta",
                            tint = QuizBlack
                        )
                    } else if (selecionada) {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = "Resposta incorreta",
                            tint = QuizWhite
                        )
                    }
                }
            }
        }

        // EXPLICAÇÃO E PRÓXIMA PERGUNTA
        if (uiState.respostaCorreta != null && perguntaAtual != null) {

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = perguntaAtual.explicacao,
                color = QuizWhite,
                fontSize = 16.sp,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = onProximaPergunta,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp),
                shape = CircleShape,
                colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                    containerColor = QuizBlack,
                    contentColor = QuizWhite
                )
            ) {

                Text(
                    text = "Próxima pergunta",
                    fontSize = 19.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Composable
fun QuizTimer(
    tempoRestante: Int
) {
    val progresso = tempoRestante / 20f

    Box(
        modifier = Modifier
            .size(84.dp)
            .background(
                color = QuizBlack,
                shape = CircleShape
            )
            .padding(5.dp)
            .background(
                color = QuizWhite,
                shape = CircleShape
            ),
        contentAlignment = Alignment.Center
    ) {

        Canvas(
            modifier = Modifier
                .fillMaxSize()
                .padding(5.dp)
        ) {

            val espessura = 8.dp.toPx()

            // Círculo de fundo
            drawArc(
                color = QuizGray,
                startAngle = -90f,
                sweepAngle = 360f,
                useCenter = false,
                style = Stroke(
                    width = espessura,
                    cap = StrokeCap.Round
                )
            )

            // Progresso do cronômetro
            drawArc(
                color = QuizOrange,
                startAngle = -90f,
                sweepAngle = 360f * progresso.coerceIn(0f, 1f),
                useCenter = false,
                style = Stroke(
                    width = espessura,
                    cap = StrokeCap.Round
                )
            )
        }

        // Tempo restante
        Text(
            text = tempoRestante.toString(),
            fontSize = 25.sp,
            fontWeight = FontWeight.ExtraBold,
            color = QuizBlack
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun QuizScreenPreview() {

    MaterialTheme {
        QuizContent(
            uiState = QuizUiState(
                perguntas = emptyList(),
                indicePerguntaAtual = 0,
                alternativaSelecionada = null,
                respostaCorreta = null,
                quizFinalizado = false
            ),
            onResponder = {},
            onProximaPergunta = {},
            onReiniciar = {},
            onVoltarHome = {}
        )
    }
}