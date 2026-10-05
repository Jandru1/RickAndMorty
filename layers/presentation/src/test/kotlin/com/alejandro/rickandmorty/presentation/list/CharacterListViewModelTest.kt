package com.alejandro.rickandmorty.presentation.list

import com.alejandro.rickandmorty.domain.model.CharacterGender
import com.alejandro.rickandmorty.domain.model.CharacterListModel
import com.alejandro.rickandmorty.domain.model.CharacterModel
import com.alejandro.rickandmorty.domain.model.CharacterStatus
import com.alejandro.rickandmorty.domain.usecase.GetCharacterListUseCase
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.io.IOException

@OptIn(ExperimentalCoroutinesApi::class)
class CharacterListViewModelTest {

    private val testDispatcher = StandardTestDispatcher()
    private val getCharacterListUseCase: GetCharacterListUseCase = mockk()

    private val page1 =
        CharacterListModel(characters = listOf(aCharacterModel(id = 1)), hasNextPage = true)
    private val page2: CharacterListModel
        get() = CharacterListModel(characters = listOf(aCharacterModel(id = 2)), hasNextPage = false)

    @BeforeEach
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
    }

    @AfterEach
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `loads the first page on start`() = runTest(testDispatcher) {
        coEvery { getCharacterListUseCase(1, null) } returns Result.success(page1)

        val viewModel = CharacterListViewModel(getCharacterListUseCase)
        advanceUntilIdle()

        val state = viewModel.state.value
        assertEquals(page1.characters, state.characterList)
        assertEquals(1, state.currentPage)
        assertTrue(state.hasNextPage)
        assertFalse(state.loading)
        assertFalse(state.error)
    }

    @Test
    fun `shows error when first page fails`() = runTest(testDispatcher) {
        coEvery { getCharacterListUseCase(1, null) } returns Result.failure(IOException())

        val viewModel = CharacterListViewModel(getCharacterListUseCase)
        advanceUntilIdle()

        val state = viewModel.state.value
        assertTrue(state.error)
        assertFalse(state.loading)
        assertTrue(state.characterList.isEmpty())
    }

    @Test
    fun `appends the next page to the list`() = runTest(testDispatcher) {
        coEvery { getCharacterListUseCase(1, null) } returns Result.success(page1)
        coEvery { getCharacterListUseCase(2, null) } returns Result.success(page2)

        val viewModel = CharacterListViewModel(getCharacterListUseCase)
        advanceUntilIdle()
        viewModel.loadNextPage()
        advanceUntilIdle()

        val state = viewModel.state.value
        assertEquals(page1.characters + page2.characters, state.characterList)
        assertEquals(2, state.currentPage)
        assertFalse(state.hasNextPage)
    }

    @Test
    fun `search for characters only request the last query`() = runTest(testDispatcher) {
        coEvery { getCharacterListUseCase(1, null) } returns Result.success(page1)
        coEvery { getCharacterListUseCase(1, "rick") } returns Result.success(page2)

        val viewModel = CharacterListViewModel(getCharacterListUseCase)
        advanceUntilIdle()
        viewModel.onQueryChange("r")
        viewModel.onQueryChange("ri")
        viewModel.onQueryChange("ric")
        viewModel.onQueryChange("rick")
        advanceUntilIdle()

        coVerify(exactly = 0) { getCharacterListUseCase(1, "r") }
        coVerify(exactly = 0) { getCharacterListUseCase(1, "ri") }
        coVerify(exactly = 0) { getCharacterListUseCase(1, "ric") }
        coVerify(exactly = 1) { getCharacterListUseCase(1, "rick") }
        assertEquals(page2.characters, viewModel.state.value.characterList)
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