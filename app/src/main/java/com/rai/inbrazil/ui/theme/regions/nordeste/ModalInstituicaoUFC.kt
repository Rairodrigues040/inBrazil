package com.rai.inbrazil.ui.theme.regions.nordeste

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.rai.inbrazil.R

@Composable
fun ModalInstituicaoUFC(
    onDismiss: () -> Unit
) {

    Dialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties(
            usePlatformDefaultWidth = false
        )
    ) {

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    horizontal = 20.dp,
                    vertical = 35.dp
                ),
            contentAlignment = Alignment.BottomCenter
        ) {

            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.85f),
                shape = RoundedCornerShape(28.dp),
                color = Color(0xFFF2F3EE),
                shadowElevation = 12.dp
            ) {

                Column {

                    // Cabeçalho
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(
                                horizontal = 20.dp,
                                vertical = 18.dp
                            )
                    ) {

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {

                            Text(
                                text = "Conheça a UFC",
                                fontSize = 25.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = Color(0xFF40433B)
                            )

                            Text(
                                text = "✕",
                                fontSize = 23.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF40433B),
                                modifier = Modifier
                                    .clickable {
                                        onDismiss()
                                    }
                            )
                        }

                        Spacer(
                            modifier = Modifier.height(5.dp)
                        )

                        Text(
                            text = "Educação, pesquisa e inovação no Ceará.",
                            fontSize = 14.sp,
                            color = Color.DarkGray
                        )
                    }

                    // Conteúdo
                    LazyColumn(
                        modifier = Modifier.fillMaxSize(),
                        contentPadding = PaddingValues(
                            horizontal = 16.dp,
                            vertical = 8.dp
                        ),
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {

                        item {

                            Image(
                                painter = painterResource(
                                    id = R.drawable.ufc_russas
                                ),
                                contentDescription = "Universidade Federal do Ceará",
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(190.dp)
                                    .padding(bottom = 8.dp),
                                contentScale = ContentScale.Crop
                            )

                            Text(
                                text = "Universidade Federal do Ceará",
                                fontSize = 21.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = Color(0xFF40433B)
                            )

                            Spacer(
                                modifier = Modifier.height(8.dp)
                            )

                            Text(
                                text = "A Universidade Federal do Ceará (UFC) é uma instituição pública federal de ensino superior, dedicada à formação acadêmica, à pesquisa científica e à extensão universitária.",
                                fontSize = 14.sp,
                                lineHeight = 21.sp,
                                color = Color.DarkGray
                            )
                        }

                        item {

                            Text(
                                text = "Campus de Russas",
                                fontSize = 19.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = Color(0xFF40433B)
                            )

                            Spacer(
                                modifier = Modifier.height(6.dp)
                            )

                            Text(
                                text = "Localizado no interior do Ceará, o Campus de Russas contribui para o desenvolvimento regional por meio da educação, da tecnologia e da formação de profissionais qualificados.",
                                fontSize = 14.sp,
                                lineHeight = 21.sp,
                                color = Color.DarkGray
                            )
                        }

                        item {

                            Text(
                                text = "Áreas de formação",
                                fontSize = 19.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = Color(0xFF40433B)
                            )

                            Spacer(
                                modifier = Modifier.height(6.dp)
                            )

                            Text(
                                text = "O campus oferece formação em diferentes áreas, com destaque para cursos relacionados à tecnologia e às engenharias.",
                                fontSize = 14.sp,
                                lineHeight = 21.sp,
                                color = Color.DarkGray
                            )
                        }

                        item {

                            Text(
                                text = "Ensino, pesquisa e extensão",
                                fontSize = 19.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = Color(0xFF40433B)
                            )

                            Spacer(
                                modifier = Modifier.height(6.dp)
                            )

                            Text(
                                text = "Além das atividades de ensino, a universidade desenvolve projetos de pesquisa e extensão que aproximam a comunidade acadêmica da sociedade.",
                                fontSize = 14.sp,
                                lineHeight = 21.sp,
                                color = Color.DarkGray
                            )
                        }
                    }
                }
            }
        }
    }
}