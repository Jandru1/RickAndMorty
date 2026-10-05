package com.alejandro.rickandmorty.data.source.localsource

import com.alejandro.rickandmorty.domain.model.CharacterListModel
import com.alejandro.rickandmorty.domain.model.CharacterModel

interface RickAndMortyLocalSource {

    suspend fun getCharacterList(page: Int) : CharacterListModel?

    suspend fun setCharacterList(page: Int, characters: CharacterListModel)

    suspend fun getCharacterDetails(id: Int) : CharacterModel?
}