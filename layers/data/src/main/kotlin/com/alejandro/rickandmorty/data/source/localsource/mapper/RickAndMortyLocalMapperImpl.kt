package com.alejandro.rickandmorty.data.source.localsource.mapper

import com.alejandro.rickandmorty.data.entity.local.CharacterLocalEntity
import com.alejandro.rickandmorty.domain.model.CharacterGender
import com.alejandro.rickandmorty.domain.model.CharacterModel
import com.alejandro.rickandmorty.domain.model.CharacterStatus

class RickAndMortyLocalMapperImpl : RickAndMortyLocalMapper {
    override fun toLocal(character: CharacterModel, page: Int): CharacterLocalEntity =
        CharacterLocalEntity(
            id = character.id,
            name = character.name,
            status = character.status.name,
            species = character.species,
            type = character.type,
            gender = character.gender.name,
            origin = character.origin,
            location = character.location,
            image = character.image,
            episode = character.episode.joinToString(","),
            url = character.url,
            created = character.created,
            page = page
        )

    override fun toModel(character: CharacterLocalEntity): CharacterModel =
        CharacterModel(
            id = character.id,
            name = character.name,
            status = CharacterStatus.valueOf(character.status),
            species = character.species,
            type = character.type,
            gender = CharacterGender.valueOf(character.gender),
            origin = character.origin,
            location = character.location,
            image = character.image,
            episode = character.episode.split(","),
            url = character.url,
            created = character.created
        )
}