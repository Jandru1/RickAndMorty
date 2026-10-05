package com.alejandro.rickandmorty.presentation.components

import androidx.compose.ui.graphics.Color
import com.alejandro.rickandmorty.domain.model.CharacterGender
import com.alejandro.rickandmorty.domain.model.CharacterStatus
import com.alejandro.rickandmorty.presentation.theme.AliveGreen
import com.alejandro.rickandmorty.presentation.theme.DeadRed
import com.alejandro.rickandmorty.presentation.theme.UnknownGray


fun CharacterStatus.mapStatus(): String {
    return when (this) {
        CharacterStatus.ALIVE -> "Alive"
        CharacterStatus.DEAD -> "Dead"
        CharacterStatus.UNKNOWN -> "Unknown"
    }
}

fun CharacterStatus.mapColor(): Color =
    when (this) {
        CharacterStatus.ALIVE -> AliveGreen
        CharacterStatus.DEAD -> DeadRed
        CharacterStatus.UNKNOWN -> UnknownGray
    }

fun CharacterGender.mapGender(): String =
    when (this) {
        CharacterGender.MALE -> "Male"
        CharacterGender.FEMALE -> "Female"
        CharacterGender.GENDERLESS -> "Genderless"
        CharacterGender.UNKNOWN -> "Unknown"
    }
