package com.oysoft.studyapp.data

import com.oysoft.studyapp.questions.FlashCard
import com.oysoft.studyapp.utils.NetworkModule
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Singleton

@Singleton
class FlashCardRepository{

    private val _flashcards = MutableStateFlow<List<FlashCard>>(emptyList())
    val flashcards: StateFlow<List<FlashCard>> = _flashcards.asStateFlow()

    suspend fun loadFlashCards() {
        try {
            val flashcardsList = NetworkModule.flashcardApiService.getTva1()
            _flashcards.value = flashcardsList
            println(flashcards.value.toString())
        } catch (e: Exception) {
            // Handle error
            e.printStackTrace()
        }
    }
}