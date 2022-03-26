package com.example.android.guesstheword.screens.game

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class GameViewModel(private val wordList: MutableList<String>) : ViewModel() {

    var word = MutableLiveData("")
    var score = MutableLiveData(0)

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
        // https://stackoverflow.com/questions/57219811/is-it-possible-to-increment-mutablelivedata-without-additional-variable
        score.value?.let { score.value = it-1 }
        nextWord()
    }

    fun onCorrect() {
        score.value?.let { score.value = it+1 }
        nextWord()
    }

    /**
     * Moves to the next word in the list.
     */
    private fun nextWord() {
        if (wordListRound.isNotEmpty()) {
            word.postValue(wordList.removeAt(0))
        }
    }
}
