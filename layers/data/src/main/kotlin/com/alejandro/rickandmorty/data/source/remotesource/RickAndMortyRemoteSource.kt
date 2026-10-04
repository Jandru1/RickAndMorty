package com.alejandro.rickandmorty.data.source.remotesource

import com.alejandro.rickandmorty.domain.model.CharacterListModel

interface RickAndMortyRemoteSource {

    suspend fun getCharacterList(page: Int): CharacterListModel
}