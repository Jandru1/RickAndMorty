package com.alejandro.rickandmorty.presentation.details

import com.alejandro.rickandmorty.domain.model.CharacterModel

data class CharacterDetailsState(
    val characterDetails: CharacterModel? = null,
    val loading: Boolean = false,
    val error: Boolean = false
)