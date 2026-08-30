package com.rai.inbrazil.data.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rai.inbrazil.data.repository.PerguntaRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class QuizViewModel(private val repository: PerguntaRepository): ViewModel() {
    private val _uiState = MutableStateFlow(QuizUiState())

    val uiState: StateFlow<QuizUiState> = _uiState.asStateFlow()

    fun iniciarQuiz(){
        viewModelScope.launch {
            val quantidade = repository.contarPerguntas()

            if (quantidade == 0){
                repository.inserirTodas(perguntasIniciais)
            }

            val perguntas = repository.buscarTodas()
            _uiState.update { estado ->
                estado.copy(
                    perguntas = perguntas
                )
            }
        }
    }

    fun responder(indiceAlternativa: Int) {

        val estadoAtual = _uiState.value

        // Impede responder novamente
        if (estadoAtual.respostaCorreta != null) {
            return
        }

        val perguntaAtual = estadoAtual.perguntas.getOrNull(
            estadoAtual.indicePerguntaAtual
        ) ?: return

        val acertou =
            indiceAlternativa == perguntaAtual.indiceRespostaCorreta

        _uiState.update { estado ->

            estado.copy(
                alternativaSelecionada = indiceAlternativa,

                respostaCorreta = acertou,

                pontuacao = if (acertou) {
                    estado.pontuacao + 1
                } else {
                    estado.pontuacao
                },

                quantidadeAcertos = if (acertou) {
                    estado.quantidadeAcertos + 1
                } else {
                    estado.quantidadeAcertos
                },

                quantidadeErros = if (!acertou) {
                    estado.quantidadeErros + 1
                } else {
                    estado.quantidadeErros
                }
            )
        }
    }

    fun proximaPergunta() {

        _uiState.update { estado ->

            val ultimaPergunta =
                estado.indicePerguntaAtual >= estado.perguntas.lastIndex

            if (ultimaPergunta) {

                estado.copy(
                    quizFinalizado = true
                )

            } else {

                estado.copy(
                    indicePerguntaAtual =
                        estado.indicePerguntaAtual + 1,

                    alternativaSelecionada = null,

                    respostaCorreta = null
                )
            }
        }
    }

    fun reiniciarQuiz() {

        _uiState.update { estado ->

            estado.copy(
                indicePerguntaAtual = 0,
                alternativaSelecionada = null,
                respostaCorreta = null,
                pontuacao = 0,
                quantidadeAcertos = 0,
                quantidadeErros = 0,
                quizFinalizado = false
            )
        }
    }
}