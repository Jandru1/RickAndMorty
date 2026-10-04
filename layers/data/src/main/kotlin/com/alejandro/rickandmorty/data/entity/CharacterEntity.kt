package com.alejandro.rickandmorty.data.entity

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class CharacterEntity(
    @property:Json(name = "id") open val id: Int? = null,
    @property:Json(name = "name") open val name: String? = null,
    @property:Json(name = "status") open val status: String? = null,
    @property:Json(name = "species") open val species: String? = null,
    @property:Json(name = "type") open val type: String? = null,
    @property:Json(name = "gender") open val gender: String? = null,
    @property:Json(name = "origin") open val origin: OriginEntity? = null,
    @property:Json(name = "location") open val location: LocationEntity? = null,
    @property:Json(name = "image") open val image: String? = null,
    @property:Json(name = "episode") open val episode: List<String>? = null,
    @property:Json(name = "url") open val url: String? = null,
    @property:Json(name = "created") open val created: String? = null,
    )
/*

id": 1,
      "name": "Rick Sanchez",
      "status": "Alive",
      "species": "Human",
      "type": "",
      "gender": "Male",
      "origin": {
        "name": "Earth",
        "url": "https://rickandmortyapi.com/api/location/1"
      },
      "location": {
        "name": "Earth",
        "url": "https://rickandmortyapi.com/api/location/20"
      },
      "image": "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
      "episode": [
        "https://rickandmortyapi.com/api/episode/1",
        "https://rickandmortyapi.com/api/episode/2",
        // ...
      ],
      "url": "https://rickandmortyapi.com/api/character/1",
      "created": "2017-11-04T18:48:46.250Z"
 */