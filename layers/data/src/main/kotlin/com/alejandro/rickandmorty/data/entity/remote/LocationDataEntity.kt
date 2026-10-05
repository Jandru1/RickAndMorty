package com.alejandro.rickandmorty.data.entity.remote

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class LocationDataEntity(
    @property:Json(name = "name") val name: String? = null,
    @property:Json(name = "url") val url: String? = null
)