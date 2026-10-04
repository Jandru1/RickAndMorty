package com.alejandro.rickandmorty.data.source.remotesource.mapper

import com.alejandro.rickandmorty.data.entity.ResponseCharacterEntity
import com.alejandro.rickandmorty.domain.model.CharacterModel

interface RickAndMortyRemoteMapper {

    abstract fun toModel(responseCharacterEntity: ResponseCharacterEntity) : List<CharacterModel>
}