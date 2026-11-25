package com.rai.inbrazil.data.presentation

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rai.inbrazil.ui.theme.*

@Composable
fun ResultadoQuizScreen(
    uiState: QuizUiState,
    onReiniciar: () -> Unit,
    onVoltarHome: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(AdventureGreen)
            .padding(24.dp),

        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        // CARD PRINCIPAL
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = QuizWhite,
                    shape = RoundedCornerShape(36.dp)
                )
                .border(
                    width = 3.dp,
                    color = QuizBlack,
                    shape = RoundedCornerShape(36.dp)
                )
                .padding(28.dp),

            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // TÍTULO
            Text(
                text = "Quiz finalizado!",
                fontSize = 28.sp,
                fontWeight = FontWeight.ExtraBold,
                color = QuizBlack
            )

            Spacer(modifier = Modifier.height(28.dp))

            // PONTUAÇÃO
            Text(
                text = "${uiState.pontuacao}",
                fontSize = 64.sp,
                fontWeight = FontWeight.ExtraBold,
                color = AdventureGreen
            )

            Text(
                text = "Pontos",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = QuizBlack
            )

            Spacer(modifier = Modifier.height(28.dp))

            // ACERTOS
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        QuizGreen,
                        RoundedCornerShape(20.dp)
                    )
                    .padding(16.dp),

                verticalAlignment = Alignment.CenterVertically
            ) {

                Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = "Acertos",
                    tint = QuizBlack
                )

                Spacer(modifier = Modifier.width(12.dp))

                Text(
                    text = "Acertos: ${uiState.quantidadeAcertos}",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = QuizBlack
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            // ERROS
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        QuizIncorrect,
                        RoundedCornerShape(20.dp)
                    )
                    .padding(16.dp),

                verticalAlignment = Alignment.CenterVertically
            ) {

                Icon(
                    imageVector = Icons.Default.Close,
                    contentDescription = "Erros",
                    tint = QuizWhite
                )

                Spacer(modifier = Modifier.width(12.dp))

                Text(
                    text = "Erros: ${uiState.quantidadeErros}",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = QuizWhite
                )
            }

            Spacer(modifier = Modifier.height(32.dp))

            // BOTÃO REINICIAR
            Button(
                onClick = onReiniciar,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp),

                shape = CircleShape,

                colors = ButtonDefaults.buttonColors(
                    containerColor = QuizBlack,
                    contentColor = QuizWhite
                )
            ) {
                Text(
                    text = "Fazer novamente",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            Spacer(modifier = Modifier.height(12.dp))

            OutlinedButton(
                onClick = onVoltarHome,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp),
                shape = CircleShape,
                colors = ButtonDefaults.outlinedButtonColors(
                    containerColor = QuizWhite,
                    contentColor = QuizBlack
                ),
                border = BorderStroke(2.dp, QuizBlack)
            ) {
                Text(
                    text = "Voltar para Home",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}