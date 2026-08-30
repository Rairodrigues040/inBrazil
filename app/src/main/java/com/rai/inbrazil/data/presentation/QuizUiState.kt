package com.rai.inbrazil.data.presentation

import com.rai.inbrazil.data.model.Pergunta

data class QuizUiState(
    val carregando: Boolean = false,
    val perguntas: List<Pergunta> = emptyList(),
    val indicePerguntaAtual: Int = 0,
    val alternativaSelecionada: Int? = null,
    val respostaCorreta: Boolean? = null,
    val pontuacao: Int = 0,
    val quantidadeAcertos: Int = 0,
    val quantidadeErros: Int = 0,
    val quizFinalizado: Boolean = false
)