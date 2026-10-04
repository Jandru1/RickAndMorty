package com.alejandro.rickandmorty.data.source.remotesource

import com.alejandro.rickandmorty.data.api.RickAndMortyApi
import com.alejandro.rickandmorty.data.source.remotesource.mapper.RickAndMortyRemoteMapper
import com.alejandro.rickandmorty.domain.model.CharacterListModel
import com.alejandro.rickandmorty.domain.model.CharacterModel

class RickAndMortyRemoteSourceImpl(
    private val api: RickAndMortyApi,
    private val mapper: RickAndMortyRemoteMapper
) : RickAndMortyRemoteSource{

    override suspend fun getCharacterList(page: Int): Result<CharacterListModel> =
        runCatching { mapper.toModel(api.getCharacterList(page)) }
}