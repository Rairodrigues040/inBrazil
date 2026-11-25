package com.rai.inbrazil.data.repository

import com.rai.inbrazil.data.dao.PerguntaDao
import com.rai.inbrazil.data.mapper.toEntity
import com.rai.inbrazil.data.mapper.toModel
import com.rai.inbrazil.data.model.Pergunta
import kotlin.collections.map


class PerguntaRepository(
    private val perguntaDao: PerguntaDao
) {

    suspend fun inserirTodas(perguntas: List<Pergunta>) {
        perguntas.forEach { pergunta ->
            perguntaDao.inserir(pergunta.toEntity())
        }
    }

    suspend fun buscarTodas(): List<Pergunta> {
        return perguntaDao.buscarTodas()
            .map{ entity -> entity.toModel() }
    }

    suspend fun contarPerguntas(): Int {
        return perguntaDao.contarPerguntas().toInt()
    }

    suspend fun apagarTodas() {
        perguntaDao.apagarTodas()
    }
}
