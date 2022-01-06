package com.example.mathcomposition.domain.usecases

import com.example.mathcomposition.domain.entity.GameSettings
import com.example.mathcomposition.domain.entity.Question
import com.example.mathcomposition.domain.repository.GameRepository

class GenerateQuestionUseCase(val repository: GameRepository) {
    operator fun invoke(maxSumValue: Int): Question{
        return repository.generateQuestion(maxSumValue = maxSumValue, COUNT_OF_OPTIONS)
    }

    private companion object{
        private const val COUNT_OF_OPTIONS = 6
    }
}