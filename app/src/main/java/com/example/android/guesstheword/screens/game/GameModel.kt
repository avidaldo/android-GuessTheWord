package com.example.android.guesstheword.screens.game


class GameModel(private val wordList: MutableList<String>) {

    var score = 0
    var wordListRound = wordList.apply { shuffle() }


    init {
        nextWord()
    }


    fun nextWord(): String? {
        if (wordListRound.isNotEmpty()) {
            return(wordList.removeAt(0))
        }
        return null; // Si la lista está vacía devolvemos null
    }
}