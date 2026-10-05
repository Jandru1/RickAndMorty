package com.alejandro.rickandmorty.presentation.details

import com.alejandro.rickandmorty.domain.model.CharacterGender
import com.alejandro.rickandmorty.domain.model.CharacterModel
import com.alejandro.rickandmorty.domain.model.CharacterStatus
import com.alejandro.rickandmorty.domain.usecase.GetCharacterDetailsUseCase
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.io.IOException

@OptIn(ExperimentalCoroutinesApi::class)
class CharacterDetailsViewModelTest {

    private val testDispatcher = StandardTestDispatcher()

    private val getCharacterDetailsUseCase: GetCharacterDetailsUseCase = mockk()

    @BeforeEach
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
    }

    @AfterEach
    fun tearDown() {
        Dispatchers.resetMain()
    }
    @Test
    fun `load the details on start`() = runTest(testDispatcher) {
        coEvery { getCharacterDetailsUseCase(1) } returns Result.success(aCharacterModel(1))
        val viewModel = CharacterDetailsViewModel(1, getCharacterDetailsUseCase)
        advanceUntilIdle()

        val state = viewModel.state.value
        assertFalse(state.loading)
        assertFalse(state.error)
        assertEquals(aCharacterModel(1),state.characterDetails)
    }

    @Test
    fun `shows error when api call fails`() = runTest(testDispatcher) {
        coEvery { getCharacterDetailsUseCase(1) } returns Result.failure(IOException())
        val viewModel = CharacterDetailsViewModel(1, getCharacterDetailsUseCase)
        advanceUntilIdle()

        val state = viewModel.state.value
        assertTrue(state.error)
        assertFalse(state.loading)
        assertNull(state.characterDetails)

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