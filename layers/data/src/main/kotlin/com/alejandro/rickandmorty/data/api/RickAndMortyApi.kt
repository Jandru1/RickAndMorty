package com.alejandro.rickandmorty.data.api

import com.alejandro.rickandmorty.data.entity.ResponseCharacterEntity
import retrofit2.http.GET

interface RickAndMortyApi {

    @GET("character")
    suspend fun getCharacterList(): ResponseCharacterEntity

}