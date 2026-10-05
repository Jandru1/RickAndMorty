package com.alejandro.rickandmorty.data.repository

import com.alejandro.rickandmorty.data.source.remotesource.RickAndMortyRemoteSource
import com.alejandro.rickandmorty.domain.model.CharacterListModel
import com.alejandro.rickandmorty.domain.model.CharacterModel
import com.alejandro.rickandmorty.domain.repository.RickAndMortyRepository

class RickAndMortyRepositoryImpl(
    private val remoteSource: RickAndMortyRemoteSource
): RickAndMortyRepository {

    override suspend fun getCharacterList(page: Int): Result<CharacterListModel> =
        remoteSource.getCharacterList(page)

    override suspend fun getCharacterDetails(id: Int): Result<CharacterModel> =
        remoteSource.getCharacterDetails(id)
}