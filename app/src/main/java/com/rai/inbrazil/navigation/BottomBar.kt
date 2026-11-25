package com.rai.inbrazil.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

private val MenuGreen = Color(0xFFB7F236)
private val MenuWhite = Color(0xFFFFFFFF)
private val MenuBlack = Color(0xFF080808)

@Composable
fun BottomBar(navController: NavController) {

    val navBackStackEntry by
    navController.currentBackStackEntryAsState()

    val currentRoute = navBackStackEntry?.destination?.route

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .navigationBarsPadding()
            .padding(
                start = 16.dp,
                top = 12.dp,
                end = 16.dp,
                bottom = 20.dp
            )
            .height(64.dp)
            .background(
                color = MenuWhite,
                shape = CircleShape
            )
            .padding(4.dp),

        verticalAlignment = Alignment.CenterVertically

    ) {

        // INÍCIO
        BottomBarItem(
            texto = "Início",
            selecionado = currentRoute == "regionsScreen",
            icone = Icons.Default.Home,
            modifier = Modifier.weight(1f),
            onClick = {
                navController.navigate("regionsScreen") {
                    popUpTo("regionsScreen") {
                        inclusive = false
                    }
                    launchSingleTop = true
                }
            }
        )

        // QUIZ
        BottomBarItem(
            texto = "Quiz",
            selecionado = currentRoute == "quizScreen",
            icone = Icons.Default.Check,
            modifier = Modifier.weight(1f),
            onClick = {
                navController.navigate("quizScreen") {
                    launchSingleTop = true
                }
            }
        )

        // COMENTÁRIOS
        BottomBarItem(
            texto = "Nota",
            selecionado = currentRoute == "comentariosScreen",
            icone = Icons.Default.AddCircle,
            modifier = Modifier.weight(1f),
            onClick = {
                navController.navigate("comentariosScreen") {
                    launchSingleTop = true
                }
            }
        )
    }
}

@Composable
private fun BottomBarItem(
    texto: String,
    selecionado: Boolean,
    icone: androidx.compose.ui.graphics.vector.ImageVector,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {

    Row(
        modifier = modifier
            .fillMaxHeight()
            .background(
                color = if (selecionado) MenuGreen else Color.Transparent,
                shape = CircleShape
            )
            .clickable {
                if (!selecionado) {
                    onClick()
                }
            }
            .padding(horizontal = 12.dp),

        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically

    ) {

        Icon(
            imageVector = icone,
            contentDescription = texto,
            tint = MenuBlack,
            modifier = Modifier.size(26.dp)
        )

        Spacer(modifier = Modifier.width(10.dp))

        Text(
            text = texto,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = MenuBlack
        )
    }
}