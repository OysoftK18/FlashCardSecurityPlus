package com.oysoft.studyapp.data.repository

import android.app.Application
import com.oysoft.studyapp.data.remote.FlashCardRepository
import com.oysoft.studyapp.domain.repository.FlashCardsApiService
import com.oysoft.studyapp.questions.FlashCard
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

class FlashCardRepositoryImpl @Inject constructor(val apiService: FlashCardsApiService, val appContext: Application) :
    FlashCardRepository {

    private val _flashcards = MutableStateFlow<List<FlashCard>>(emptyList())
    override val flashcards: StateFlow<List<FlashCard>> = _flashcards.asStateFlow()

    override suspend fun getFlashCards() {
        try {
            val flashcardsList = apiService.getTva1()
            _flashcards.value = flashcardsList
            println(flashcards.value.toString())
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}