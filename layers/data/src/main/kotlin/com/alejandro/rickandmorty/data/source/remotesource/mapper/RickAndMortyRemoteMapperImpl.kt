package com.alejandro.rickandmorty.data.source.remotesource.mapper

import com.alejandro.rickandmorty.data.entity.CharacterEntity
import com.alejandro.rickandmorty.data.entity.ResponseCharacterEntity
import com.alejandro.rickandmorty.domain.model.CharacterGender
import com.alejandro.rickandmorty.domain.model.CharacterModel
import com.alejandro.rickandmorty.domain.model.CharacterStatus


class RickAndMortyRemoteMapperImpl : RickAndMortyRemoteMapper {

    override fun toModel(responseCharacterEntity: ResponseCharacterEntity): List<CharacterModel> {
        return responseCharacterEntity.results.orEmpty().map {
            mapCharacter(it)
        }
    }

    private fun mapCharacter(characterEntity: CharacterEntity): CharacterModel {
        return CharacterModel(
            id = characterEntity.id ?: 0,
            name = characterEntity.name ?: "",
            status = characterEntity.status.mapStatus(),
            species = characterEntity.species ?: "",
            type = characterEntity.type ?: "",
            gender = characterEntity.gender.mapGender(),
            origin = characterEntity.origin?.name ?: "",
            location = characterEntity.location?.name ?: "",
            image = characterEntity.image ?: "",
            episode = characterEntity.episode ?: emptyList(),
            url = characterEntity.url ?: "",
            created = characterEntity.created ?: "",
        )
    }

    private fun String?.mapStatus(): CharacterStatus {
        return when (this) {
            "Alive" -> CharacterStatus.ALIVE
            "Dead" -> CharacterStatus.DEAD
            else -> CharacterStatus.UNKNOWN
        }
    }

    private fun String?.mapGender(): CharacterGender {
        return when (this) {
            "Female" -> CharacterGender.FEMALE
            "Male" -> CharacterGender.MALE
            "Genderless" -> CharacterGender.GENDERLESS
            else -> CharacterGender.UNKNOWN
        }
    }
}