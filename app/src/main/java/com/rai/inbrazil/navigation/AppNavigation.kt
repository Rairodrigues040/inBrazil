package com.rai.inbrazil.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHost
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.rai.inbrazil.data.database.QuizDatabase
import com.rai.inbrazil.data.presentation.QuizScreen
import com.rai.inbrazil.data.presentation.QuizViewModel
import com.rai.inbrazil.data.repository.PerguntaRepository
import com.rai.inbrazil.ui.theme.regions.EstadoAcre
import com.rai.inbrazil.ui.theme.regions.RegiaoNorte
import com.rai.inbrazil.ui.theme.regions.RegionsScreen
import com.rai.inbrazil.ui.theme.regions.TelaTest2

@Composable
fun AppNavigation( viewModel: QuizViewModel) {

    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomBar(navController)
        }
    ) { paddingValues ->

        NavHost(
            navController = navController,
            startDestination = "regionsScreen",
            modifier = Modifier.padding(paddingValues)
        ){
            composable("regionsScreen") {
                RegionsScreen(navController)
            }

            composable("regiaoNorte") {
                RegiaoNorte(navController)
            }

            composable("estadoAcre"){
                EstadoAcre()
            }

            composable("quizScreen") {
                QuizScreen(
                    viewModel = viewModel
                )
            }
        }
    }


}

