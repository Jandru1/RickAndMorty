package com.alejandro.rickandmorty.data.entity

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class LocationEntity(
    @property:Json(name = "name") open val name: String? = null,
    @property:Json(name = "url") open val url: String? = null
)