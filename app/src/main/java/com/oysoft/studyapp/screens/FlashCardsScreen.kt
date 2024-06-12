package com.oysoft.studyapp.screens

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import com.oysoft.studyapp.viewModels.FlashCardsViewModel

@Composable
fun FlashCardsScreen(modifier: Modifier = Modifier, flashCardsViewModel: FlashCardsViewModel) {
    var isFlipped by remember { mutableStateOf(false) }
    val rotation by animateFloatAsState(targetValue = if (isFlipped) 180f else 0f)
    val flashcards by flashCardsViewModel.flashcards.observeAsState(emptyList())
    var currentIndex by remember { mutableStateOf(0) }

    val currentFlashcard = flashcards[currentIndex]

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(32.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(320.dp)
                .graphicsLayer {
                    rotationX = rotation
                    cameraDistance = 8 * density
                }
                .clickable { isFlipped = !isFlipped },
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(if (isFlipped) Color.Green else Color.Yellow)
                    .padding(16.dp)
                    .graphicsLayer {
                        if (isFlipped) {
                            rotationX = -rotation
                        }
                    }
            ) {
                Text(if (isFlipped)
                    currentFlashcard.question
                else
                    currentFlashcard.answer)
            }
        }
    }
}