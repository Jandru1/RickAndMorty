package com.alejandro.rickandmorty.domain.model

data class CharacterModel(
    val id: Int,
    val name: String,
    val status: CharacterStatus,
    val species: String,
    val type: String,
    val gender: CharacterGender,
    val origin: String,
    val location: String,
    val image: String,
    val episode: List<String>,
    val url: String,
    val created: String
)