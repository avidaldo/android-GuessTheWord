package com.example.android.guesstheword.screens.game

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class GameViewModelFactory(val stringArray: Array<String>) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(GameViewModel::class.java)) {
            return GameViewModel(stringArray) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}
