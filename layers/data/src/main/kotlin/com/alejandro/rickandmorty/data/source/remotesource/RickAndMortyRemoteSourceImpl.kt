package com.alejandro.rickandmorty.data.source.remotesource

import com.alejandro.rickandmorty.data.api.RickAndMortyApi
import com.alejandro.rickandmorty.domain.model.CharacterModel

class RickAndMortyRemoteSourceImpl(
    val api: RickAndMortyApi
) : RickAndMortyRemoteSource{

    override suspend fun getCharacterList(): List<CharacterModel> =
        api.getCharacterList().toModel //Falta el mapeo a un modelo controlable
}