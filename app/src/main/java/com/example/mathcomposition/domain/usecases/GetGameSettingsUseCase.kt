package com.example.mathcomposition.domain.usecases

import com.example.mathcomposition.domain.entity.GameSettings
import com.example.mathcomposition.domain.entity.Level
import com.example.mathcomposition.domain.repository.GameRepository

class GetGameSettingsUseCase(val repository: GameRepository) {
    operator fun invoke(level: Level): GameSettings{
        return repository.getGameSettings(level)
    }
}