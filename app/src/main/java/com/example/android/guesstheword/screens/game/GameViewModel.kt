package com.example.android.guesstheword.screens.game

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class GameViewModel(private val wordList: MutableList<String>) : ViewModel() {

    private var model = GameModel(wordList)

    var modelLiveData = MutableLiveData(model)


    /** Métodos que reciben los eventos de la vista **/

    fun onSkip() {
        modelLiveData.value = model.apply {  // Actualizamos modelLiveData a model, después de
            nextWord()  // llamar a nextWord() (que asigna word=null si no quedan palabras en la lista)
            model.word?.also { model.score-- }  // y, si quedan palabras, decrementa el score
        }

    }

    fun onCorrect() {
        modelLiveData.value = model.apply {
            nextWord()
            model.word?.also { model.score++ }
        }
    }

    fun onReset() {
        modelLiveData.value = model.apply { reset() }
    }

}
