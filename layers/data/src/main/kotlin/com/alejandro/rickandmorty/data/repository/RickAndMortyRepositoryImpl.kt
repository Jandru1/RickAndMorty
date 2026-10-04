package com.alejandro.rickandmorty.data.repository

import com.alejandro.rickandmorty.data.source.remotesource.RickAndMortyRemoteSource
import com.alejandro.rickandmorty.domain.model.CharacterModel
import com.alejandro.rickandmorty.domain.repository.RickAndMortyRepository

class RickAndMortyRepositoryImpl(
    val remoteSource: RickAndMortyRemoteSource
): RickAndMortyRepository {

    override suspend fun getCharacterList(): List<CharacterModel> =
        remoteSource.getCharacterList()
}