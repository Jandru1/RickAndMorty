package com.alejandro.rickandmorty.data.repository

import com.alejandro.rickandmorty.data.source.localsource.RickAndMortyLocalSource
import com.alejandro.rickandmorty.data.source.remotesource.RickAndMortyRemoteSource
import com.alejandro.rickandmorty.domain.model.CharacterListModel
import com.alejandro.rickandmorty.domain.model.CharacterModel
import com.alejandro.rickandmorty.domain.repository.RickAndMortyRepository

class RickAndMortyRepositoryImpl(
    private val remoteSource: RickAndMortyRemoteSource,
    private val localSource: RickAndMortyLocalSource
): RickAndMortyRepository {

    override suspend fun getCharacterList(page: Int, name: String?): Result<CharacterListModel> {
        if (name != null) return remoteSource.getCharacterList(page, name)
        val local = localSource.getCharacterList(page)
        if ( local != null ) return Result.success(local)
        val remote = remoteSource.getCharacterList(page, name)
        if (remote.isSuccess) localSource.setCharacterList(page, remote.getOrThrow())
        return remote
    }

    override suspend fun getCharacterDetails(id: Int): Result<CharacterModel> {
        val local = localSource.getCharacterDetails(id)
        if ( local != null ) return Result.success(local)
        return remoteSource.getCharacterDetails(id)
    }
}