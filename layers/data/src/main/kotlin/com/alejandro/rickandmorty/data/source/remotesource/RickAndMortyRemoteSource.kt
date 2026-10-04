package com.alejandro.rickandmorty.data.source.remotesource

import com.alejandro.rickandmorty.domain.model.CharacterModel

interface RickAndMortyRemoteSource {

    suspend fun getCharacterList(): List<CharacterModel>
}