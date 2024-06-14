package com.oysoft.studyapp.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.oysoft.studyapp.data.FlashCardRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeScreenViewModel @Inject constructor (private val repository: FlashCardRepository) :
    ViewModel() {

    fun onClickSyncQuestion() {
        viewModelScope.launch {
            repository.loadFlashCards()
        }
    }
}