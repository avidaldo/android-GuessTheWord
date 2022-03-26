package com.example.android.guesstheword.screens.score

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/** Los ViewModel no tienen constructores con argumentos y requieren usar ViewModelFactory
 * cuando queremos pasar un argumento al ViewModel en su instanciación.
 *
 * Este constructor pasa el parámetro finalScore que (por ahora) se sigue recibiendo
 * con safeargs a través del gráfico de navegación. */
class ScoreViewModelFactory (private val finalScore: Int) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ScoreViewModel::class.java)) {
            return ScoreViewModel(finalScore) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}
