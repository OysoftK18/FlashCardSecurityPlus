package com.oysoft.studyapp.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.oysoft.studyapp.questions.Flashcard

class FlashCardsViewModel : ViewModel(){
    private val _flashcards = MutableLiveData<List<Flashcard>>()
    val flashcards: LiveData<List<Flashcard>> = _flashcards

    init {
        loadFlashCards()
    }

    private fun loadFlashCards() {
        _flashcards.value = listOf(
            Flashcard(id = 1,"What is phishing?", "It's when a person fake to be another in order to make you do something"),
            Flashcard(id = 2,"What is vishing?", "It's when a person fake to be another via voice in order to make you do something"),
            Flashcard(id = 3,"What is smishing?", "It's when a person fake to be another via sms in order to make you do something")
        )
    }
}