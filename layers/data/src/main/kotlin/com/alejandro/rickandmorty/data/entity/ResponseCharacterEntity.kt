package com.alejandro.rickandmorty.data.entity

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class ResponseCharacterEntity(
    @property:Json(name = "info") open val info: InfoEntity? = null,
    @property:Json(name = "results") open val results: List<CharacterEntity>? = null
)