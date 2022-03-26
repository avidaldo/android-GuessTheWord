package com.example.android.guesstheword.screens.game

import android.util.Log
import androidx.lifecycle.ViewModel


class GameViewModel(private val wordList: MutableList<String>) : ViewModel() {

    var word = ""
    var score = 0

    var wordListRound = wordList.apply { shuffle() }


    init {
        Log.i("GameViewModel", "GameViewModel created!")
        resetList()
        nextWord()
    }

    private fun resetList() {
        wordListRound.apply { shuffle() }
    }


    /**
     * Método al que se llama cuando se destruye el ViewModel
     */
    override fun onCleared() {
        super.onCleared()
        Log.i("GameViewModel", "GameViewModel destroyed!")
    }

    /** Methods for updating the UI **/
    fun onSkip() {
        score--
        nextWord()
    }

    fun onCorrect() {
        score++
        nextWord()
    }

    /**
     * Moves to the next word in the list.
     */
    private fun nextWord() {
        if (wordListRound.isNotEmpty()) {
            word = wordListRound.removeAt(0)
        }
    }
}
