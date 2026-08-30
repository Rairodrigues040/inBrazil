package com.rai.inbrazil.data.model

data class Pergunta(
    val id: Long,
    val texto: String,
    val alternativaA: String,
    val alternativaB: String,
    val alternativaC: String,
    val alternativaD: String,
    val indiceRespostaCorreta: Int,
    val explicacao: String
)

