package com.alejandro.rickandmorty.data.api

import com.alejandro.rickandmorty.data.entity.CharacterEntity
import com.alejandro.rickandmorty.data.entity.ResponseCharacterEntity
import retrofit2.http.GET
import retrofit2.http.Query

interface RickAndMortyApi {

    @GET("character")
    suspend fun getCharacterList(@Query("page") page: Int): ResponseCharacterEntity

    @GET("character/{id}")
    suspend fun getCharacterDetails(@Query("id") id: Int): CharacterEntity
}