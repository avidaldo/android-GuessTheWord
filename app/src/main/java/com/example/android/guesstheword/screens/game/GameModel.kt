package com.example.android.guesstheword.screens.game


class GameModel(private val wordList: MutableList<String>) {

    enum class GameState {
        JUGANDO, TERMINADO
    }

    private var wordListRound = wordList.toMutableList().apply { shuffle() }
    var score = 0


    fun nextWord(): String? {
        if (wordListRound.isNotEmpty()) {
            return(wordListRound.removeAt(0))
        }
        return null // Si la lista está vacía devolvemos null
    }

    fun reset() {
        score = 0
        wordListRound = wordList.toMutableList().apply { shuffle() }
    }
}