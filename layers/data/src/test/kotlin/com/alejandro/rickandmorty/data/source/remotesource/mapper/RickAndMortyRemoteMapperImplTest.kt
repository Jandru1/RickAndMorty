package com.alejandro.rickandmorty.data.source.remotesource.mapper

import com.alejandro.rickandmorty.data.entity.remote.CharacterEntity
import com.alejandro.rickandmorty.data.entity.remote.InfoEntity
import com.alejandro.rickandmorty.data.entity.remote.ResponseCharacterEntity
import com.alejandro.rickandmorty.data.source.remotesource.mapper.mock.CharacterEntityMock
import com.alejandro.rickandmorty.data.source.remotesource.mapper.mock.InfoEntityMock
import com.alejandro.rickandmorty.data.source.remotesource.mapper.mock.ResponseCharacterEntityMock
import com.alejandro.rickandmorty.domain.model.CharacterGender
import com.alejandro.rickandmorty.domain.model.CharacterListModel
import com.alejandro.rickandmorty.domain.model.CharacterModel
import com.alejandro.rickandmorty.domain.model.CharacterStatus
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class RickAndMortyRemoteMapperImplTest() {

    private val mapper = RickAndMortyRemoteMapperImpl()

    @Test
    fun `maps a character entity to a character model`() {
        val entity: CharacterEntity = CharacterEntityMock
        val model = mapper.toModel(entity)
        val expectedModel = CharacterModel(
            id = 0,
            name = "name",
            status = CharacterStatus.UNKNOWN,
            species = "species",
            type = "type",
            gender = CharacterGender.UNKNOWN,
            origin = "name",
            location = "name",
            image = "image",
            episode = listOf("episode"),
            url = "url",
            created = "created",
        )
        assertEquals(expectedModel, model)
    }

    @Test
    fun `map a character entity with null values`() {
        val entity = CharacterEntity()
        val result = mapper.toModel(entity)
        val expected = CharacterModel(
            id = 0,
            name = "",
            status = CharacterStatus.UNKNOWN,
            species = "",
            type = "",
            gender = CharacterGender.UNKNOWN,
            origin = "",
            location = "",
            image = "",
            episode = emptyList(),
            url = "",
            created = "",
        )
        assertEquals(expected, result)
    }

    @Test
    fun `maps a response entity to a character list model`() {
        val entity: ResponseCharacterEntity = ResponseCharacterEntityMock
        val model = mapper.toModel(entity)
        val expectedModel = CharacterListModel(
            characters = listOf(CharacterModel(
                id = 0,
                name = "name",
                status = CharacterStatus.UNKNOWN,
                species = "species",
                type = "type",
                gender = CharacterGender.UNKNOWN,
                origin = "name",
                location = "name",
                image = "image",
                episode = listOf("episode"),
                url = "url",
                created = "created",
            )),
            hasNextPage = true
        )
        assertEquals(expectedModel, model)
    }

    @ParameterizedTest
    @CsvSource(
        "Alive,ALIVE",
        "Dead,DEAD",
        "Unknown,UNKNOWN",
        "prueba,UNKNOWN"
    )
    fun `maps status`(input: String, expected: CharacterStatus) {
        val result = mapper.toModel(CharacterEntity(status = input))
        assertEquals(expected, result.status)
    }

    @Test
    fun `maps a response with next page`() {
        val response = ResponseCharacterEntity(
            info = InfoEntityMock,
            results = listOf(CharacterEntityMock)
        )
        val result = mapper.toModel(response)
        assertEquals(true, result.hasNextPage)
    }

    @Test
    fun `maps a response without next page`() {
        val response = ResponseCharacterEntity(
            info = InfoEntity(
                count = 0,
                pages = 0,
                next = null,
                prev = "prev"
            ),
            results = listOf(CharacterEntityMock)
        )
        val result = mapper.toModel(response)
        assertEquals(false, result.hasNextPage)
    }

}