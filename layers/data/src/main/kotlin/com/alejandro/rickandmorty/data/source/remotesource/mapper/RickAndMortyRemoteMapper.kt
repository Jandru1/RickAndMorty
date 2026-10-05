package com.alejandro.rickandmorty.data.source.remotesource.mapper

import com.alejandro.rickandmorty.data.entity.remote.CharacterEntity
import com.alejandro.rickandmorty.data.entity.remote.ResponseCharacterEntity
import com.alejandro.rickandmorty.domain.model.CharacterListModel
import com.alejandro.rickandmorty.domain.model.CharacterModel

interface RickAndMortyRemoteMapper {

    fun toModel(responseCharacterEntity: ResponseCharacterEntity) : CharacterListModel

    fun toModel(characterEntity: CharacterEntity) : CharacterModel
}