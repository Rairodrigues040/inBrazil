package com.rai.inbrazil.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.rai.inbrazil.data.dao.PerguntaDao
import com.rai.inbrazil.data.entity.PerguntaEntity

@Database(entities = [PerguntaEntity::class], version = 1)
abstract class QuizDatabase : RoomDatabase() {

    abstract fun perguntaDao(): PerguntaDao

    companion object {
        //Volatile impede concorrência entre threads, ou seja, impede que duas criem um bd ao mesmo tempo
        @Volatile
        private var INSTANCE: QuizDatabase? = null

        fun getDatabase(context: Context): QuizDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    QuizDatabase::class.java,
                    "quiz.db").build()

                INSTANCE = instance
                instance
            }
        }
    }

}