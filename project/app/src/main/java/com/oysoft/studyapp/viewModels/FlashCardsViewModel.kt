package com.oysoft.studyapp.viewModels

import androidx.lifecycle.ViewModel
import com.oysoft.studyapp.data.remote.FlashCardRepository
import com.oysoft.studyapp.questions.FlashCard
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FlashCardsViewModel @Inject constructor(private val repository: FlashCardRepository) :
    ViewModel() {

    val listFlashCards = repository.flashcards

    fun getCurrentFlashCard(currentFlashCard: Int): FlashCard {
        return listFlashCards.value[currentFlashCard]
    }
}