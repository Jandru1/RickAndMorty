package com.alejandro.rickandmorty.domain.model

data class CharacterListModel(
    val characters: List<CharacterModel>,
    val hasNextPage: Boolean
)