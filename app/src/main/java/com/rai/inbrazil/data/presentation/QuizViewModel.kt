package com.rai.inbrazil.data.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rai.inbrazil.data.repository.PerguntaRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlin.time.Duration.Companion.milliseconds

class QuizViewModel(private val repository: PerguntaRepository) : ViewModel() {
    private val _uiState = MutableStateFlow(QuizUiState())

    private var cronometroJob: Job? = null

    val uiState: StateFlow<QuizUiState> = _uiState.asStateFlow()

    private fun iniciarCronometro() {

        // Cancela qualquer cronômetro anterior
        cronometroJob?.cancel()

        // Reinicia o tempo
        _uiState.update {
            it.copy(tempoRestante = 20)
        }

        cronometroJob = viewModelScope.launch {

            while (isActive) {

                delay(1000.milliseconds)

                val estadoAtual = _uiState.value

                // Interrompe se já respondeu ou terminou o quiz
                if (
                    estadoAtual.respostaCorreta != null ||
                    estadoAtual.quizFinalizado
                ) {
                    break
                }

                if (estadoAtual.tempoRestante <= 1) {

                    _uiState.update { estado ->

                        estado.copy(
                            tempoRestante = 0,
                            respostaCorreta = false,
                            alternativaSelecionada = null,
                            quantidadeErros = estado.quantidadeErros + 1
                        )
                    }

                    break

                } else {

                    _uiState.update { estado ->

                        estado.copy(
                            tempoRestante = estado.tempoRestante - 1
                        )
                    }
                }
            }
        }
    }

    fun iniciarQuiz() {
        viewModelScope.launch {

            repository.apagarTodas()
            repository.inserirTodas(perguntasIniciais)

            val perguntas = repository.buscarTodas()

            _uiState.update { estado ->
                estado.copy(
                    perguntas = perguntas,
                    indicePerguntaAtual = 0,
                    alternativaSelecionada = null,
                    respostaCorreta = null,
                    pontuacao = 0,
                    quantidadeAcertos = 0,
                    quantidadeErros = 0,
                    quizFinalizado = false
                )
            }

            if (perguntas.isNotEmpty()) {
                iniciarCronometro()
            }
        }
    }

    fun responder(indiceAlternativa: Int) {

        val estadoAtual = _uiState.value

        // Impede responder novamente
        if (estadoAtual.respostaCorreta != null) {
            return
        }

        // Impede responder depois que o tempo acabar
        if (estadoAtual.tempoRestante <= 0) {
            return
        }

        val perguntaAtual = estadoAtual.perguntas.getOrNull(
            estadoAtual.indicePerguntaAtual
        ) ?: return

        // Cancela o cronômetro
        cronometroJob?.cancel()

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

        cronometroJob?.cancel()

        var iniciarNovoCronometro = false

        _uiState.update { estado ->

            val ultimaPergunta =
                estado.indicePerguntaAtual >= estado.perguntas.lastIndex

            if (ultimaPergunta) {

                estado.copy(
                    quizFinalizado = true
                )

            } else {

                iniciarNovoCronometro = true

                estado.copy(

                    indicePerguntaAtual =
                        estado.indicePerguntaAtual + 1,

                    alternativaSelecionada = null,

                    respostaCorreta = null,

                    tempoRestante = 20
                )
            }
        }

        if (iniciarNovoCronometro) {
            iniciarCronometro()
        }
    }

    fun reiniciarQuiz() {

        cronometroJob?.cancel()

        _uiState.update { estado ->

            estado.copy(

                indicePerguntaAtual = 0,

                alternativaSelecionada = null,

                respostaCorreta = null,

                pontuacao = 0,

                quantidadeAcertos = 0,

                quantidadeErros = 0,

                quizFinalizado = false,

                tempoRestante = 20
            )
        }

        if (_uiState.value.perguntas.isNotEmpty()) {
            iniciarCronometro()
        }
    }
}