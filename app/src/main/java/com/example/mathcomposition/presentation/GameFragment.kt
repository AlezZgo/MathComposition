package com.example.mathcomposition.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.mathcomposition.R
import com.example.mathcomposition.databinding.FragmentGameBinding
import com.example.mathcomposition.domain.entity.GameResult
import com.example.mathcomposition.domain.entity.GameSettings
import com.example.mathcomposition.domain.entity.Level

class GameFragment : Fragment() {

    private lateinit var level: Level

    private var _binding: FragmentGameBinding? = null
    private val binding: FragmentGameBinding
        get() = _binding ?: throw RuntimeException("FragmentGameBinding = null")

    companion object {
        private const val KEY_LEVEL = "level"
        const val NAME = "GameFragment"

        fun newInstance(level: Level): GameFragment {
            return GameFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(KEY_LEVEL, level)
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        parseArgs()
    }

    private lateinit var viewModel: GameViewModel

    private fun parseArgs() {
        requireArguments().getParcelable<Level>(KEY_LEVEL)?.let {
            level = it
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentGameBinding.inflate(inflater, container, false)
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvQuestion.setOnClickListener {
            launchGameFinishedFragment()
        }
    }

    fun launchGameFinishedFragment() {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(
                R.id.main_container,
                GameFinishedFragment.newInstance(
                    GameResult(
                        true,
                        20,
                        20,
                        GameSettings(
                            20,
                            10,
                            20,
                            30
                        )
                    )
                )
            )
            .addToBackStack(null)
            .commit()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}