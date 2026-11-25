package com.rai.inbrazil.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "comentarios")
data class ComentarioEntity(

    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,

    val nome: String,

    val comentario: String,

    val fotoUri: String? = null,

    val estado: String,

    val data: Long = System.currentTimeMillis()

)