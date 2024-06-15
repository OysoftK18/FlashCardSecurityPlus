package com.oysoft.studyapp.data.remote

import com.oysoft.studyapp.questions.FlashCard
import kotlinx.coroutines.flow.StateFlow

interface FlashCardRepository{

    val flashcards: StateFlow<List<FlashCard>>
    suspend fun getFlashCards()
}