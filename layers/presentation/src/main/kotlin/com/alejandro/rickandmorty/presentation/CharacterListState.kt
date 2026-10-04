package com.alejandro.rickandmorty.presentation

import com.alejandro.rickandmorty.domain.model.CharacterModel

data class CharacterListState(
    val characterModelList: List<CharacterModel> = listOf(),
    val loading: Boolean = false
) {
}