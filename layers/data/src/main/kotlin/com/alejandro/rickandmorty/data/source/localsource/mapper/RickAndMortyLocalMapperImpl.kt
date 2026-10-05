package com.alejandro.rickandmorty.data.source.localsource.mapper

import com.alejandro.rickandmorty.data.entity.local.CharacterLocalEntity
import com.alejandro.rickandmorty.data.entity.local.PageLocalEntity
import com.alejandro.rickandmorty.domain.model.CharacterModel

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
    override fun toModel(character: CharacterLocalEntity): CharacterModel {
        TODO("Not yet implemented")
    }
}