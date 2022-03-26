package com.example.android.guesstheword.screens.score

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.android.guesstheword.databinding.ScoreFragmentBinding


class ScoreFragment : Fragment() {
    private var _binding: ScoreFragmentBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = ScoreFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /** Al mostrar datos que llegan como argumentos en el Bundle de creación,
         * no es necesario el ViewModel para mantener el estado, y tratándose símplemente de
         * un int, no parece necesario añadir más complejidad */
        binding.scoreText.text = ScoreFragmentArgs.fromBundle(requireArguments()).score.toString()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
