package com.example.android.guesstheword.screens.game

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import com.example.android.guesstheword.R

/** AndroidViewModel funciona como ViewModel pero permite recibir el contexto, para así poder acceder a recursos
 * https://stackoverflow.com/a/44155403/12270705
 * https://vtsen.hashnode.dev/recommended-ways-to-create-viewmodel-or-androidviewmodel
 * */

class GameViewModel(application: Application) : AndroidViewModel(application) {
    private val resources = application.resources

    var word = ""
    var score = 0

    private lateinit var wordList: MutableList<String>


    init {
        Log.i("GameViewModel", "GameViewModel created!")
        resetList()
        nextWord()
    }

    private fun resetList() {
        wordList = resources.getStringArray(R.array.palabras).toMutableList().apply { shuffle() }
    // TODO: Igual tiene sentido cargarla primero y solo hacer shuffle en cada reset?
    }


    /**
     * Callback called when the ViewModel is destroyed
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
        if (wordList.isNotEmpty()) {
            word = wordList.removeAt(0)  // Select and remove a word from the list
        }
    }
}
