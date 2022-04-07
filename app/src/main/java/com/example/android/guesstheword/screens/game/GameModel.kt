package com.example.android.guesstheword.screens.game


class GameModel(val wordList: Array<String>) {

    var word = ""
    var score = 0

    lateinit var wordListOnGame: MutableList<String>

    init {
        reset()
    }

    fun reset() {
        wordListOnGame = wordList.toMutableList()//.apply { shuffle() }
        score=0
        nextWord()
    }

    fun onSkip() {
        score--
        nextWord()
    }

    fun onCorrect() {
        score++
        nextWord()
    }

    private fun nextWord() {
        if (wordListOnGame.isNotEmpty()) {
            word = wordListOnGame.removeAt(0)
        }
    }
}