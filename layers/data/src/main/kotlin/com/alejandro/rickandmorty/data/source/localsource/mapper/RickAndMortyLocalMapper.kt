package com.alejandro.rickandmorty.data.source.localsource.mapper

import com.alejandro.rickandmorty.data.entity.local.CharacterLocalEntity
import com.alejandro.rickandmorty.domain.model.CharacterModel

interface RickAndMortyLocalMapper {

    fun toLocal(character: CharacterModel, page: Int): CharacterLocalEntity
    fun toModel(character: CharacterLocalEntity): CharacterModel
}