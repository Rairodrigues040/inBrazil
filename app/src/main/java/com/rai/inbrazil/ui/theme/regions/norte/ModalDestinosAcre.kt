package com.rai.inbrazil.ui.theme.regions.norte

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.rai.inbrazil.data.destinosAcre

@Composable
fun ModalDestinosAcre(
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

                    // Cabeçalho do modal
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(
                                horizontal = 20.dp,
                                vertical = 18.dp
                            )
                    ) {

                        androidx.compose.foundation.layout.Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {

                            Text(
                                text = "Explore o Acre",
                                fontSize = 25.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = Color(0xFF40433B)
                            )

                            Text(
                                text = "✕",
                                fontSize = 23.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF40433B),
                                modifier = Modifier.clickable {
                                    onDismiss()
                                }
                            )
                        }

                        Spacer(
                            modifier = Modifier.height(5.dp)
                        )

                        Text(
                            text = "Conheça lugares incríveis da Amazônia.",
                            fontSize = 14.sp,
                            color = Color.DarkGray
                        )
                    }

                    // Lista dos destinos
                    LazyColumn(
                        modifier = Modifier.fillMaxSize(),
                        contentPadding = PaddingValues(
                            start = 16.dp,
                            end = 16.dp,
                            bottom = 20.dp
                        ),
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {

                        items(destinosAcre) { destino ->

                            CardDestinoAcre(
                                destino = destino
                            )
                        }
                    }
                }
            }
        }
    }
}