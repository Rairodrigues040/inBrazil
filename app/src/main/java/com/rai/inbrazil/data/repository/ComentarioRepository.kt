package com.rai.inbrazil.data.repository

import com.rai.inbrazil.data.dao.ComentarioDao
import com.rai.inbrazil.data.entity.ComentarioEntity
import kotlinx.coroutines.flow.Flow

class ComentarioRepository(
    private val comentarioDao: ComentarioDao
) {

    fun buscarTodos(): Flow<List<ComentarioEntity>> {
        return comentarioDao.buscarTodos()
    }

    suspend fun buscarPorId(id: Long): ComentarioEntity? {
        return comentarioDao.buscarPorId(id)
    }

    suspend fun inserir(comentario: ComentarioEntity) {
        comentarioDao.inserir(comentario)
    }

    suspend fun atualizar(comentario: ComentarioEntity) {
        comentarioDao.atualizar(comentario)
    }

    suspend fun excluir(comentario: ComentarioEntity) {
        comentarioDao.excluir(comentario)
    }
}