package com.example.mathcomposition.presentation

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mathcomposition.R

class ChooseLevelFragment : Fragment() {

    companion object {
        fun newInstance() = ChooseLevelFragment()
    }

    private lateinit var viewModel: ChooseLevelViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_choose_level, container, false)
    }

}