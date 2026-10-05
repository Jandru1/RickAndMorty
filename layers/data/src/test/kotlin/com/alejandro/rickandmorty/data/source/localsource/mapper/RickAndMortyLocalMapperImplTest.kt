package com.alejandro.rickandmorty.data.source.localsource.mapper

import com.alejandro.rickandmorty.domain.model.CharacterGender
import com.alejandro.rickandmorty.domain.model.CharacterModel
import com.alejandro.rickandmorty.domain.model.CharacterStatus
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class RickAndMortyLocalMapperImplTest {

    private val mapper = RickAndMortyLocalMapperImpl()

    @Test
    fun `a character saved and read back is the same character`() {
        val character = CharacterModel(
            id = 1,
            name = "Rick",
            status = CharacterStatus.ALIVE,
            species = "Human",
            type = "",
            gender = CharacterGender.MALE,
            origin = "Earth",
            location = "Citadel",
            image = "image",
            episode = listOf("episode1", "episode2"),
            url = "url",
            created = "created",
        )

        val result = mapper.toModel(mapper.toLocal(character, page = 3))

        assertEquals(character, result)
    }
}