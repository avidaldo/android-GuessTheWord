package com.example.android.guesstheword.screens.game

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class GameViewModel(private val wordList: MutableList<String>) : ViewModel() {

    var model = GameModel(wordList)

    /** Las dos variables con Livedata son una representación directa de la vista */
    var word = MutableLiveData("")
    var score = MutableLiveData(0)


    /** Métodos que reciben los eventos de la vista **/

    fun onSkip() {
        score.postValue(--model.score)
        word.postValue(model.nextWord())
    }

    fun onCorrect() {
        score.postValue(++model.score)
        word.postValue(model.nextWord())
    }

}
