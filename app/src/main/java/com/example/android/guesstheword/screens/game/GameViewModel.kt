package com.example.android.guesstheword.screens.game

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class GameViewModel(val stringArray: Array<String>) : ViewModel() {

    val model = GameModel(stringArray)
    var modelLiveData = MutableLiveData(model)


    private fun updateViewModel() {
        modelLiveData.value = model
    }


    fun onSkip() {
        model.onSkip()
        updateViewModel()
    }

    fun onCorrect() {
        model.onCorrect()
        updateViewModel()
    }

    fun reset() {
        model.reset()
        updateViewModel()
    }

}
