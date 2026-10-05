package com.alejandro.rickandmorty.data.repository

import com.alejandro.rickandmorty.data.source.localsource.RickAndMortyLocalSource
import com.alejandro.rickandmorty.data.source.remotesource.RickAndMortyRemoteSource
import com.alejandro.rickandmorty.domain.model.CharacterGender
import com.alejandro.rickandmorty.domain.model.CharacterListModel
import com.alejandro.rickandmorty.domain.model.CharacterModel
import com.alejandro.rickandmorty.domain.model.CharacterStatus
import io.mockk.Runs
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.just
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import java.io.IOException


class RickAndMortyRepositoryImplTest {

    private val remoteSource: RickAndMortyRemoteSource = mockk()
    private val localSource: RickAndMortyLocalSource = mockk()
    private val repository = RickAndMortyRepositoryImpl(remoteSource, localSource)

    private val characterList = CharacterListModel(
        characters = listOf(aCharacterModel(id = 1)),
        hasNextPage = true,
    )

    @Test
    fun `search character goes to remote and does not use local`() = runTest {
        coEvery { remoteSource.getCharacterList(1, "rick") } returns Result.success(characterList)

        val result = repository.getCharacterList(1, "rick")

        assertEquals(characterList, result.getOrNull())
        coVerify(exactly = 0) { localSource.getCharacterList(any()) }
        coVerify(exactly = 0) { localSource.setCharacterList(any(), any()) }
    }

    @Test
    fun `using local source instead of remote for list`() = runTest {
        coEvery { localSource.getCharacterList(1) } returns characterList

        val result = repository.getCharacterList(1, null)

        assertEquals(characterList, result.getOrNull())
        coVerify(exactly = 0) { remoteSource.getCharacterList(any(), any()) }
    }

    @Test
    fun `using remote source and saving data in local source for list`() = runTest {
        coEvery { localSource.getCharacterList(1) } returns null
        coEvery { remoteSource.getCharacterList(1, null) } returns Result.success(characterList)
        coEvery { localSource.setCharacterList(1, characterList) } just Runs

        val result = repository.getCharacterList(1, null)

        assertEquals(characterList, result.getOrNull())
        coVerify { localSource.setCharacterList(1, characterList) }
    }

    @Test
    fun `not saving data when error for list`() = runTest {
        coEvery { localSource.getCharacterList(1) } returns null
        coEvery { remoteSource.getCharacterList(1, null) } returns Result.failure(IOException())

        val result = repository.getCharacterList(1, null)

        assertTrue(result.isFailure)
        coVerify(exactly = 0) { localSource.setCharacterList(any(), any()) }
    }

    @Test
    fun `using local source instead of remote for details`() = runTest {
        val character = aCharacterModel(id = 1)
        coEvery { localSource.getCharacterDetails(1) } returns character

        val result = repository.getCharacterDetails(1)

        assertEquals(character, result.getOrNull())
        coVerify(exactly = 0) { remoteSource.getCharacterDetails(any()) }
    }

    private fun aCharacterModel(id: Int) = CharacterModel(
        id = id,
        name = "Rick",
        status = CharacterStatus.ALIVE,
        species = "Human",
        type = "",
        gender = CharacterGender.MALE,
        origin = "Earth",
        location = "Citadel",
        image = "image",
        episode = listOf("episode"),
        url = "url",
        created = "created",
    )
}