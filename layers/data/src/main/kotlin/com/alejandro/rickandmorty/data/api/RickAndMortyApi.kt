package com.alejandro.rickandmorty.data.api

import com.alejandro.rickandmorty.data.entity.ResponseCharacterEntity
import retrofit2.http.GET

interface RickAndMortyApi {

    @GET(path)
    suspend fun getCharacterList(): ResponseCharacterEntity

}

const val path = "https://rickandmortyapi.com/api/character"