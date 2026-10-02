package com.alejandro.rickandmorty.domain.model

data class Character(
    val id: Int = 0,
    val name: String = "RICK",
    val status: CharacterStatus = CharacterStatus.UNKNOWN,
    val species: String = "Especie",
    val type: String = "tipo",
    val gender: CharacterGender = CharacterGender.UNKNOWN,
    val origin: String = "",
    val location: String = "",
    val image: String = "",
    val episode: List<String> = listOf(""),
    val url: String = "",
    val created: String = ""
)