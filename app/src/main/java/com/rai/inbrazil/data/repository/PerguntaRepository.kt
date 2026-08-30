package com.rai.inbrazil.data.repository

import com.rai.inbrazil.data.dao.PerguntaDao
import com.rai.inbrazil.data.mapper.toEntity
import com.rai.inbrazil.data.mapper.toModel
import com.rai.inbrazil.data.model.Pergunta
import kotlin.collections.map


class PerguntaRepository(
    private val perguntaDao: PerguntaDao
) {

    suspend fun inserir(pergunta: Pergunta) {
        perguntaDao.inserir(pergunta.toEntity())
    }

    suspend fun inserirTodas(perguntas: List<Pergunta>) {
        perguntas.forEach { pergunta ->
            perguntaDao.inserir(pergunta.toEntity())
        }
    }

    suspend fun buscarTodas(): List<Pergunta> {
        return perguntaDao.buscarTodas()
            .map{ entity -> entity.toModel() }
    }


    suspend fun buscarPorId(id: Long): Pergunta? {
        return perguntaDao.buscarPorId(id)?.toModel()
    }

    suspend fun apagarTodas(){
        perguntaDao.apagarTodas()
    }

    suspend fun contarPerguntas(): Int {
        return perguntaDao.contarPerguntas().toInt()
    }
}
