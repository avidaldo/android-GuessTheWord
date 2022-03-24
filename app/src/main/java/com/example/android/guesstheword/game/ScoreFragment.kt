package com.example.android.guesstheword.game

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.navGraphViewModels
import com.example.android.guesstheword.R
import com.example.android.guesstheword.databinding.ScoreFragmentBinding


class ScoreFragment : Fragment() {
    private var _binding: ScoreFragmentBinding? = null
    private val binding get() = _binding!!

    //private val viewModel by activityViewModels<ViewModel>()
    private val viewModel: ViewModel
            by navGraphViewModels(R.id.nav_graph_game) {
                defaultViewModelProviderFactory
            }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = ScoreFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.score.observe(viewLifecycleOwner) {
            binding.scoreText.text = it.toString()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
