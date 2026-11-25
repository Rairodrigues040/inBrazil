package com.rai.inbrazil.navigation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel as composeViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

// QUIZ
import com.rai.inbrazil.data.presentation.QuizScreen
import com.rai.inbrazil.data.presentation.QuizViewModel

// BANCO DE DADOS E COMENTÁRIOS
import com.rai.inbrazil.data.database.QuizDatabase
import com.rai.inbrazil.data.entity.ComentarioEntity
import com.rai.inbrazil.data.repository.ComentarioRepository
import com.rai.inbrazil.data.presentation.ComentarioViewModel
import com.rai.inbrazil.data.presentation.ComentarioViewModelFactory

// TELAS DE COMENTÁRIOS
import com.rai.inbrazil.ui.theme.comentarios.AdicionarComentarioScreen
import com.rai.inbrazil.ui.theme.comentarios.ComentariosScreen
import com.rai.inbrazil.ui.theme.comentarios.EditarComentarioScreen

// TELAS PRINCIPAIS
import com.rai.inbrazil.ui.theme.regions.HomeScreen
import com.rai.inbrazil.ui.theme.regions.RegionsScreen

// NORTE
import com.rai.inbrazil.ui.theme.regions.norte.EstadoAcre
import com.rai.inbrazil.ui.theme.regions.norte.NewEstadoAcre
import com.rai.inbrazil.ui.theme.regions.norte.RegiaoNorte
import com.rai.inbrazil.ui.theme.regions.norte.cultura.NewCulturaAcre

// NORDESTE
import com.rai.inbrazil.ui.theme.regions.nordeste.EstadoCeara
import com.rai.inbrazil.ui.theme.regions.nordeste.NewEstadoNordeste
import com.rai.inbrazil.ui.theme.regions.nordeste.NewInstituicaoCeara
import com.rai.inbrazil.ui.theme.regions.nordeste.RegiaoNordeste


@Composable
fun AppNavigation(viewModel: QuizViewModel) {

    val context = LocalContext.current

    // BANCO DE DADOS DOS COMENTÁRIOS

    val comentarioDatabase = remember {
        QuizDatabase.getDatabase(context)
    }

    val comentarioRepository = remember {
        ComentarioRepository(
            comentarioDatabase.comentarioDao()
        )
    }

    val comentarioFactory = remember {
        ComentarioViewModelFactory(comentarioRepository)
    }

    val comentarioViewModel: ComentarioViewModel = composeViewModel(
        factory = comentarioFactory
    )

    // COMENTÁRIO SELECIONADO PARA EDIÇÃO

    var comentarioSelecionado by remember {
        mutableStateOf<ComentarioEntity?>(null)
    }

    // NAVEGAÇÃO

    val navController = rememberNavController()

    val navBackStackEntry by
    navController.currentBackStackEntryAsState()

    val currentRoute = navBackStackEntry?.destination?.route

    Box(
        modifier = Modifier.fillMaxSize()
    ) {

        NavHost(
            navController = navController,
            startDestination = "homeScreen",
            modifier = Modifier.fillMaxSize(),

            enterTransition = {
                fadeIn(
                    animationSpec = tween(
                        durationMillis = 450,
                        easing = FastOutSlowInEasing
                    )
                )
            },

            exitTransition = {
                fadeOut(
                    animationSpec = tween(
                        durationMillis = 300,
                        easing = FastOutSlowInEasing
                    )
                )
            },

            popEnterTransition = {
                fadeIn(tween(450))
            },

            popExitTransition = {
                fadeOut(tween(300))
            }

        ) {

            // HOME

            composable("homeScreen") {
                HomeScreen(navController)
            }

            // REGIÕES

            composable("regionsScreen") {
                RegionsScreen(navController)
            }

            // REGIÃO NORTE

            composable("regiaoNorte") {
                RegiaoNorte(navController)
            }

            // ESTADO DO ACRE

            composable("estadoAcre") {
                EstadoAcre(navController)
            }

            // QUIZ

            composable("quizScreen") {

                QuizScreen(
                    viewModel = viewModel,
                    onVoltarHome = {
                        navController.navigate("regionsScreen") {
                            popUpTo("regionsScreen") {
                                inclusive = false
                            }
                            launchSingleTop = true
                        }
                    }
                )
            }

            // INFORMAÇÕES DO ACRE

            composable("newEstadoAcre") {
                NewEstadoAcre(navController)
            }

            // CULTURA DO ACRE

            composable("newCulturaAcre") {
                NewCulturaAcre(navController)
            }

            // REGIÃO NORDESTE

            composable("regiaoNordeste") {
                RegiaoNordeste(navController)
            }

            // ESTADO DO CEARÁ

            composable("estadoCeara") {
                EstadoCeara(navController)
            }

            // INFORMAÇÕES DO CEARÁ

            composable("newEstadoNordeste") {
                NewEstadoNordeste(navController)
            }

            // INSTITUIÇÃO UFC

            composable("newInstituacaoCeara") {
                NewInstituicaoCeara(navController)
            }

            // =====================================
            // FUNCIONALIDADE DE COMENTÁRIOS
            // =====================================

            // LISTA DE COMENTÁRIOS

            composable("comentariosScreen") {

                ComentariosScreen(
                    viewModel = comentarioViewModel,

                    onAdicionar = {
                        navController.navigate("adicionarComentario")
                    },

                    onEditar = { comentario ->

                        comentarioSelecionado = comentario

                        navController.navigate("editarComentario")
                    }
                )
            }

            // ADICIONAR COMENTÁRIO

            composable("adicionarComentario") {

                AdicionarComentarioScreen(
                    viewModel = comentarioViewModel,
                    estado = "Brasil",
                    onPublicado = {
                        navController.popBackStack()
                    }
                )
            }

            // EDITAR COMENTÁRIO

            composable("editarComentario") {

                val comentario = comentarioSelecionado

                if (comentario != null) {

                    EditarComentarioScreen(
                        comentarioOriginal = comentario,
                        viewModel = comentarioViewModel,
                        onSalvo = {
                            comentarioSelecionado = null
                            navController.popBackStack()
                        }
                    )
                }
            }
        }

        // BOTTOM BAR ANIMADA

        AnimatedVisibility(

            visible = currentRoute == "regionsScreen" ||
                    currentRoute == "comentariosScreen",

            modifier = Modifier.align(Alignment.BottomCenter),

            enter = fadeIn(
                animationSpec = tween(
                    durationMillis = 500,
                    delayMillis = 250
                )
            ) + slideInVertically(
                initialOffsetY = { it },
                animationSpec = tween(
                    durationMillis = 500,
                    delayMillis = 250,
                    easing = FastOutSlowInEasing
                )
            ),

            exit = fadeOut(
                animationSpec = tween(250)
            ) + slideOutVertically(
                targetOffsetY = { it },
                animationSpec = tween(250)
            )

        ) {
            BottomBar(navController)
        }
    }
}