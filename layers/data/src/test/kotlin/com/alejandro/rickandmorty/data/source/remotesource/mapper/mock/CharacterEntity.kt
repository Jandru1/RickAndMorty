package com.alejandro.rickandmorty.data.source.remotesource.mapper.mock

import com.alejandro.rickandmorty.data.entity.remote.CharacterEntity
import com.alejandro.rickandmorty.data.entity.remote.InfoEntity
import com.alejandro.rickandmorty.data.entity.remote.LocationDataEntity
import com.alejandro.rickandmorty.data.entity.remote.ResponseCharacterEntity


val LocationDataEntityMock = LocationDataEntity(
    name = "name",
    url = "url"
)

val CharacterEntityMock = CharacterEntity(
    id = 0,
    name = "Rick",
    status = "Alive",
    species = "species",
    type = "type",
    gender = "Male",
    origin = LocationDataEntityMock,
    location = LocationDataEntityMock,
    image = "image",
    episode = listOf("episode"),
    url = "url",
    created = "created",
)

val InfoEntityMock = InfoEntity(
    count = 0,
    pages = 0,
    next = "next",
    prev = "prev"
)

val ResponseCharacterEntityMock = ResponseCharacterEntity(
    info = InfoEntityMock,
    results = listOf(CharacterEntityMock)
)
