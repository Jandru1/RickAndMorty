package com.alejandro.rickandmorty.data.source.remotesource.mapper

import com.alejandro.rickandmorty.data.entity.ResponseCharacterEntity
import com.alejandro.rickandmorty.domain.model.CharacterListModel
import com.alejandro.rickandmorty.domain.model.CharacterModel

interface RickAndMortyRemoteMapper {

    fun toModel(responseCharacterEntity: ResponseCharacterEntity) : CharacterListModel
}