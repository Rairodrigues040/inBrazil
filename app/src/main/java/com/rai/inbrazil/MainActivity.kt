package com.rai.inbrazil

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.rai.inbrazil.data.database.QuizDatabase
import com.rai.inbrazil.data.presentation.QuizViewModel
import com.rai.inbrazil.data.repository.PerguntaRepository
import com.rai.inbrazil.navigation.AppNavigation
import com.rai.inbrazil.ui.theme.Bege
import com.rai.inbrazil.ui.theme.InBrazilTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val database = QuizDatabase.getDatabase(applicationContext)

        val dao = database.perguntaDao()

        val repository = PerguntaRepository(dao)

        val viewModel = QuizViewModel(repository)
        setContent {
            InBrazilTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Bege
                ) {
                    AppNavigation(viewModel)
                }
            }
        }
    }
}

