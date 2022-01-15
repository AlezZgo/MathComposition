package com.example.mathcomposition.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.mathcomposition.databinding.FragmentChooseLevelBinding
import com.example.mathcomposition.domain.entity.Level

class ChooseLevelFragment : Fragment() {

    private var _binding: FragmentChooseLevelBinding? = null
    private val binding: FragmentChooseLevelBinding
        get() = _binding ?: throw RuntimeException("FragmentGameFinished = null")

    companion object {
        const val NAME = "ChooseLevelFragment"
        fun newInstance() = ChooseLevelFragment()
    }

    private lateinit var viewModel: ChooseLevelViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentChooseLevelBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnTestLevel.setOnClickListener {
            launchGameFragment(Level.TEST)
        }
        binding.btnEasyLevel.setOnClickListener {
            launchGameFragment(Level.EASY)
        }
        binding.btnNormalLevel.setOnClickListener {
            launchGameFragment(Level.NORMAL)
        }
        binding.btnHardLevel.setOnClickListener {
            launchGameFragment(Level.HARD)
        }
    }

    private fun launchGameFragment(level: Level){
        findNavController().navigate(
            ChooseLevelFragmentDirections.actionChooseLevelFragmentToGameFragment(level)
        )
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }



}