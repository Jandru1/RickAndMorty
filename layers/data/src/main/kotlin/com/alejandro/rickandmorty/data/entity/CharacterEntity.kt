package com.alejandro.rickandmorty.data.entity

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class CharacterEntity(
    @property:Json(name = "id") val id: Int? = null,
    @property:Json(name = "name") val name: String? = null,
    @property:Json(name = "status") val status: String? = null,
    @property:Json(name = "species") val species: String? = null,
    @property:Json(name = "type") val type: String? = null,
    @property:Json(name = "gender") val gender: String? = null,
    @property:Json(name = "origin") val origin: LocationDataEntity? = null,
    @property:Json(name = "location") val location: LocationDataEntity? = null,
    @property:Json(name = "image") val image: String? = null,
    @property:Json(name = "episode") val episode: List<String>? = null,
    @property:Json(name = "url") val url: String? = null,
    @property:Json(name = "created") val created: String? = null,
    )