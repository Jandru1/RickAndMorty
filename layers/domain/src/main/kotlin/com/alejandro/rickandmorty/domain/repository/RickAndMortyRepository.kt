package com.alejandro.rickandmorty.domain.repository

import com.alejandro.rickandmorty.domain.model.CharacterListModel
import com.alejandro.rickandmorty.domain.model.CharacterModel

interface RickAndMortyRepository {

    suspend fun getCharacterList(page: Int, name: String?): Result<CharacterListModel>
    suspend fun getCharacterDetails(id: Int): Result<CharacterModel>
}