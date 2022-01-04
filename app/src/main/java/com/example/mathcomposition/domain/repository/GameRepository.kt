package com.example.mathcomposition.domain.repository

import com.example.mathcomposition.domain.entity.GameSettings
import com.example.mathcomposition.domain.entity.Level
import com.example.mathcomposition.domain.entity.Question

interface GameRepository {

    fun generateQuestion(
        maxSumValue:Int,
        countOfOptions: Int
    ): Question

    fun getGameSettings(level: Level) : GameSettings

    fun doNothing()
}