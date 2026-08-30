package com.rai.inbrazil.data.mapper

import com.rai.inbrazil.data.entity.PerguntaEntity
import com.rai.inbrazil.data.model.Pergunta

fun PerguntaEntity.toModel(): Pergunta {

    return Pergunta (
        id,
        enunciado,
        alternativaA,
        alternativaB,
        alternativaC,
        alternativaD,
        indiceRespostaCorreta,
        explicacao
    )
}

fun Pergunta.toEntity(): PerguntaEntity {
    return PerguntaEntity(
        id,
        texto,
        alternativaA,
        alternativaB,
        alternativaC,
        alternativaD,
        indiceRespostaCorreta,
        explicacao
    )
}