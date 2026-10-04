package com.alejandro.rickandmorty.data.source.remotesource

import com.alejandro.rickandmorty.data.api.RickAndMortyApi
import com.alejandro.rickandmorty.data.source.remotesource.mapper.RickAndMortyRemoteMapper
import com.alejandro.rickandmorty.domain.model.CharacterModel

class RickAndMortyRemoteSourceImpl(
    val api: RickAndMortyApi,
    private val mapper: RickAndMortyRemoteMapper
) : RickAndMortyRemoteSource{

    override suspend fun getCharacterList(): List<CharacterModel> =
        mapper.toModel(api.getCharacterList()) //Falta el mapeo a un modelo controlable
}