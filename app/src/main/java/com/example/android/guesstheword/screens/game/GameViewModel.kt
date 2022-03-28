package com.example.android.guesstheword.screens.game

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android.guesstheword.screens.game.GameModel.GameState.JUGANDO
import com.example.android.guesstheword.screens.game.GameModel.GameState.TERMINADO


class GameViewModel(private val wordList: MutableList<String>) : ViewModel() {

    var model = GameModel(wordList)

    /** Las variables con LiveData serán una representación directa de la vista */
    var state = MutableLiveData(JUGANDO)
    var word = MutableLiveData(model.nextWord())
    var score = MutableLiveData(model.score)


    /** Métodos que reciben los eventos de la vista **/

    fun onSkip() {
        model.nextWord()?.let {
            score.value = --model.score
            word.value = it
        } ?: state.setValue(TERMINADO)
    }

    fun onCorrect() {
        model.nextWord()?.let {
            score.value = ++model.score
            word.value = it
        } ?: state.setValue(TERMINADO)
    }

    fun onReset() {
        model.reset()
        score.value=model.score
        word.value=model.nextWord()

    }

}
