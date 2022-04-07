package com.example.android.guesstheword.screens.game

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.NavHostFragment
import com.example.android.guesstheword.R
import com.example.android.guesstheword.databinding.GameFragmentBinding
import com.google.android.material.snackbar.Snackbar


class GameFragment : Fragment() {
    private var _binding: GameFragmentBinding? = null
    private val binding get() = _binding!!

    private val viewModel: GameViewModel by viewModels {
        GameViewModelFactory(resources.getStringArray(R.array.palabras))
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = GameFragmentBinding.inflate(inflater, container, false)


        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.modelLiveData.observe(viewLifecycleOwner) {
            if (it.wordListOnGame.isNotEmpty()) {
                binding.scoreText.text = it.score.toString()
                binding.wordText.text = it.word
            } else {
                Snackbar.make(view, "Fin de palabras", Snackbar.LENGTH_SHORT)
                    .setAction("Reiniciar") {viewModel.reset()}
                    .show()
            }
        }

        binding.correctButton.setOnClickListener { onCorrect() }
        binding.skipButton.setOnClickListener { onSkip() }
        binding.endGameButton.setOnClickListener { onEndGame() }
    }

    /** Methods for buttons presses **/

    private fun onSkip() {
        viewModel.onSkip()
    }

    private fun onCorrect() {
        viewModel.onCorrect()
    }

    private fun onEndGame() {
        val action = GameFragmentDirections.actionGameToScore(
            viewModel.modelLiveData.value?.score ?: 0
        )
        NavHostFragment.findNavController(this).navigate(action)
    }


}
