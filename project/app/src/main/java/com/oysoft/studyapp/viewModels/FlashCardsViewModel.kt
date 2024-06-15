package com.oysoft.studyapp.viewModels

import androidx.lifecycle.ViewModel
import com.oysoft.studyapp.data.remote.FlashCardRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FlashCardsViewModel @Inject constructor(private val repository: FlashCardRepository) :
    ViewModel() {

        val list = repository.flashcards.value
    init {
        println(list)
    }
}