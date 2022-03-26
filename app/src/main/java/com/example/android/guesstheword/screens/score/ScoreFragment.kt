package com.example.android.guesstheword.screens.score

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.android.guesstheword.databinding.ScoreFragmentBinding


class ScoreFragment : Fragment() {
    private var _binding: ScoreFragmentBinding? = null
    private val binding get() = _binding!!


    private val viewModel: ScoreViewModel by viewModels {
        /** Los ViewModel no tienen constructores con argumentos y requieren usar ViewModelFactory
         * cuando queremos pasar un argumento al ViewModel en su instanciación.
         * https://stackoverflow.com/questions/67810019/difference-between-by-viewmodels-and-viewmodel-creation-using-factory
         **/
        ScoreViewModelFactory(ScoreFragmentArgs.fromBundle(requireArguments()).score)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = ScoreFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /** Aquí no sería muy necesario el patrón observer ya que al puntuación no
         * sufre cambios durante el ciclo de vida del fragment. De hecho, tampoco
         * tiene demasiado sentido crear un ViewModel solo para esto. */
        viewModel.score.observe(viewLifecycleOwner) {
            binding.scoreText.text = it.toString()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
