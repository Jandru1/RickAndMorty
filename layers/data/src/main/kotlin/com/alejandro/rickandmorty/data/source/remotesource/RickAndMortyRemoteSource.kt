package com.alejandro.rickandmorty.data.source.remotesource

import com.alejandro.rickandmorty.domain.model.CharacterListModel
import com.alejandro.rickandmorty.domain.model.CharacterModel

interface RickAndMortyRemoteSource {

    suspend fun getCharacterList(page: Int): Result<CharacterListModel>
    suspend fun getCharacterDetails(id: Int): Result<CharacterModel>
}