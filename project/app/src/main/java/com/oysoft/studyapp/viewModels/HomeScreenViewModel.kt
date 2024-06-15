package com.oysoft.studyapp.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.oysoft.studyapp.data.remote.FlashCardRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor (private val repository: FlashCardRepository) :
    ViewModel() {

        fun getFlashCards() {
        viewModelScope.launch {
            repository.getFlashCards()
        }
    }
}