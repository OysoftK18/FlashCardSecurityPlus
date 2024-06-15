package com.oysoft.studyapp.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.oysoft.studyapp.data.remote.FlashCardRepository
import com.oysoft.studyapp.questions.FlashCard
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(private val repository: FlashCardRepository) :
    ViewModel() {

        val flashCards = repository.flashcards
    init {
        getFlashCards()
    }

    fun getFlashCards() {
        viewModelScope.launch {
            repository.getFlashCards()
        }
    }
}