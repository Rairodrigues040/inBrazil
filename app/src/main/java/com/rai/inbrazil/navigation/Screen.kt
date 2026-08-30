package com.rai.inbrazil.navigation

sealed class Screen(val route: String){
    data object Home: Screen("regionsScreen")
    data object Quiz: Screen("quizScreen")
}

