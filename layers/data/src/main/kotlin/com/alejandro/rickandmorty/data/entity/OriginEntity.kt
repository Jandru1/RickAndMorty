package com.alejandro.rickandmorty.data.entity

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class OriginEntity(
    @property:Json(name = "name") val name: String? = null,
    @property:Json(name = "url") val url: String? = null
)