package com.alejandro.rickandmorty.data.entity

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class ResponseCharacterEntity(
    @property:Json(name = "info") val info: InfoEntity? = null,
    @property:Json(name = "results") val results: List<CharacterEntity>? = null
)