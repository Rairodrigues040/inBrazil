package com.rai.inbrazil.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.rai.inbrazil.data.dao.ComentarioDao
import com.rai.inbrazil.data.dao.PerguntaDao
import com.rai.inbrazil.data.entity.ComentarioEntity
import com.rai.inbrazil.data.entity.PerguntaEntity

@Database(
    entities = [
        PerguntaEntity::class,
        ComentarioEntity::class
    ],
    version = 2,
    exportSchema = false
)
abstract class QuizDatabase : RoomDatabase() {

    abstract fun perguntaDao(): PerguntaDao

    abstract fun comentarioDao(): ComentarioDao

    companion object {

        @Volatile
        private var INSTANCE: QuizDatabase? = null

        // Migração da versão 1 para a versão 2
        private val MIGRATION_1_2 = object : Migration(1, 2) {

            override fun migrate(db: SupportSQLiteDatabase) {

                db.execSQL(
                    """
                    CREATE TABLE IF NOT EXISTS comentarios (
                        id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
                        nome TEXT NOT NULL,
                        comentario TEXT NOT NULL,
                        fotoUri TEXT,
                        estado TEXT NOT NULL,
                        data INTEGER NOT NULL
                    )
                    """.trimIndent()
                )
            }
        }

        fun getDatabase(context: Context): QuizDatabase {

            return INSTANCE ?: synchronized(this) {

                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    QuizDatabase::class.java,
                    "quiz.db"
                )
                    .addMigrations(MIGRATION_1_2)
                    .build()

                INSTANCE = instance

                instance
            }
        }
    }
}