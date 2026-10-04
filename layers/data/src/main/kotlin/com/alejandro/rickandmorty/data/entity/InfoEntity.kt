package com.alejandro.rickandmorty.data.entity

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class InfoEntity(
    @property:Json(name = "count") val count: Int,
    @property:Json(name = "pages") val pages: Int,
    @property:Json(name = "next") val next: String?,
    @property:Json(name = "prev") val prev: String?
)