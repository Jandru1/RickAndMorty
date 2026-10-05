package com.alejandro.rickandmorty.data.source.remotesource

import com.alejandro.rickandmorty.data.api.RickAndMortyApi
import com.alejandro.rickandmorty.data.source.remotesource.mapper.RickAndMortyRemoteMapper
import com.alejandro.rickandmorty.domain.model.CharacterListModel
import com.alejandro.rickandmorty.domain.model.CharacterModel
import retrofit2.HttpException
import kotlin.coroutines.cancellation.CancellationException

class RickAndMortyRemoteSourceImpl(
    private val api: RickAndMortyApi,
    private val mapper: RickAndMortyRemoteMapper
) : RickAndMortyRemoteSource{

    override suspend fun getCharacterList(page: Int, name: String?): Result<CharacterListModel> =
        runCatching { mapper.toModel(api.getCharacterList(page, name)) }
            .onFailure { if(it is CancellationException) throw it }
            .recoverCatching { error ->
                if(error is HttpException && error.code() == 404) {
                    CharacterListModel(
                        characters = emptyList(),
                        hasNextPage = false
                    )
                }
                else {
                    throw error
                }
            }

    override suspend fun getCharacterDetails(id: Int): Result<CharacterModel> =
        runCatching { mapper.toModel(api.getCharacterDetails(id)) }
}