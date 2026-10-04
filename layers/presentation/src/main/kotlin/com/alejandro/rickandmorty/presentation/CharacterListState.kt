package com.alejandro.rickandmorty.presentation

import com.alejandro.rickandmorty.domain.model.CharacterModel

data class CharacterListState(
    val characterList: List<CharacterModel> = listOf(),
    val loading: Boolean = false,
    val currentPage: Int = 0,
    val hasNextPage: Boolean = true,
    val isError: Boolean = false
)