package com.rai.inbrazil.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.rai.inbrazil.data.entity.PerguntaEntity

//Dao -> Essa interface contem operações do banco
@Dao
interface PerguntaDao {

    @Insert
    suspend fun inserir(pergunta: PerguntaEntity)

    @Query("SELECT * FROM perguntas")
    suspend fun buscarTodas(): List<PerguntaEntity>

    @Query("SELECT * FROM perguntas WHERE id = :id")
    suspend fun buscarPorId(id: Long): PerguntaEntity?

    @Query("DELETE FROM perguntas")
    suspend fun apagarTodas()

    @Query("SELECT COUNT(*) FROM perguntas")
    suspend fun contarPerguntas(): Int
}