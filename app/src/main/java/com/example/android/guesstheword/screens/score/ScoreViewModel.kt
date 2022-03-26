package com.example.android.guesstheword.screens.score

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class ScoreViewModel(finalScore: Int) : ViewModel() {
    var score = MutableLiveData(finalScore)

}
