package com.rai.inbrazil.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.rai.inbrazil.data.entity.ComentarioEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ComentarioDao {

    @Insert
    suspend fun inserir(comentario: ComentarioEntity)

    @Update
    suspend fun atualizar(comentario: ComentarioEntity)

    @Delete
    suspend fun excluir(comentario: ComentarioEntity)

    @Query("SELECT * FROM comentarios ORDER BY data DESC")
    fun buscarTodos(): Flow<List<ComentarioEntity>>

    @Query("SELECT * FROM comentarios WHERE id = :id")
    suspend fun buscarPorId(id: Long): ComentarioEntity?

}