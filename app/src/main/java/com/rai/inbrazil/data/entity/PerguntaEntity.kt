package com.rai.inbrazil.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "perguntas")
data class PerguntaEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val enunciado: String,
    val alternativaA: String,
    val alternativaB: String,
    val alternativaC: String,
    val alternativaD: String,
    val indiceRespostaCorreta: Int,
    val explicacao: String

)
