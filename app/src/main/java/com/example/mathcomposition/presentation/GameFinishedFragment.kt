package com.example.mathcomposition.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.mathcomposition.R
import com.example.mathcomposition.databinding.FragmentGameFinishedBinding
import com.example.mathcomposition.domain.entity.GameResult

class GameFinishedFragment : Fragment() {

    private lateinit var viewModel: GameFinishedViewModel

    private var _binding: FragmentGameFinishedBinding? = null
    private val binding: FragmentGameFinishedBinding
        get() = _binding ?: throw RuntimeException("FragmentGameFinished = null")

    val args by navArgs<GameFinishedFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGameFinishedBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupClickListeners()
        binding.gameResult = args.gameResult
    }

    private fun setupClickListeners() {
        binding.btnTryAgain.setOnClickListener {
            retryGame()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun retryGame() {
        findNavController().popBackStack()
    }
}