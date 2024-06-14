package com.oysoft.studyapp.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.oysoft.studyapp.data.FlashCardRepository
import com.oysoft.studyapp.questions.FlashCard
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

class FlashCardsViewModel @Inject constructor(private val repository: FlashCardRepository) :
    ViewModel() {

    var flashCard: StateFlow<List<FlashCard>> = repository.flashcards.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = emptyList()
    )
}