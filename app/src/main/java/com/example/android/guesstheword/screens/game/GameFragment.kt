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

    private val viewModel: GameViewModel by viewModels() {
        /** Para evitar pasar el contexto (que puede ser una mayor fuente de errores),
         * leemos el recurso en el fragment y lo enviamos al viewModel como parámetro a
         * través de un ViewModelFactory */
        GameViewModelFactory(resources.getStringArray(R.array.palabras).toMutableList())
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = GameFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.correctButton.setOnClickListener { viewModel.onCorrect() }
        binding.skipButton.setOnClickListener { viewModel.onSkip() }
        binding.endGameButton.setOnClickListener { onEndGame() }


        viewModel.modelLiveData.observe(viewLifecycleOwner) { model ->

            // Cambios en la palabra:
            model.word?.let {  // Si la palabra no es null
                    binding.wordText.text = it // Se asigna la palabra al textView
                } ?: onEndOfWordList() // Si es null, índica que no quedan palabras

            // Cambios en la puntuación (score)
            binding.scoreText.text = model.score.toString()
        }


    }

    private fun onEndOfWordList() {
        Snackbar.make(binding.root, R.string.end_word_list, Snackbar.LENGTH_SHORT)
            .setAction("Reiniciar") { reset() }
            .show()
    }

    private fun reset() {
        viewModel.onReset()
    }


    private fun onEndGame() {
        Toast.makeText(activity, "Game has just finished", Toast.LENGTH_SHORT).show()
        viewModel.modelLiveData.value!!.score.let {
            val action = GameFragmentDirections.actionGameToScore(it)
            NavHostFragment.findNavController(this).navigate(action)
        }
    }

}

