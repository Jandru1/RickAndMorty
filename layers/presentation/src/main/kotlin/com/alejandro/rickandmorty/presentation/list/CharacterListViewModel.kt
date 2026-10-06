package com.alejandro.rickandmorty.presentation.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alejandro.rickandmorty.domain.usecase.GetCharacterListUseCase
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlin.time.Duration.Companion.milliseconds

class CharacterListViewModel(
    private val getCharacterListUseCase: GetCharacterListUseCase
): ViewModel() {

    private val _state = MutableStateFlow(CharacterListState())
    val state = _state.asStateFlow()

    private var loadJob : Job? = null
    private var searchJob : Job? = null

    init {
        loadNextPage()
    }

    private fun loadCharacters() {
        loadJob = viewModelScope.launch {
            val query = state.value.query.trim().ifBlank { null }
            val result = getCharacterListUseCase(state.value.currentPage+1, query)
            result.onSuccess { model ->
                _state.update {
                    it.copy(
                        characterList = it.characterList + model.characters,
                        loading = false,
                        currentPage = 1 + it.currentPage,
                        hasNextPage = model.hasNextPage,
                        error = false
                    )
                }
            }
            result.onFailure {
                _state.update {
                    it.copy(
                        loading = false,
                        error = true
                    )
                }
            }
        }
    }

    fun loadNextPage() {
        with (state.value) { if (loading || !hasNextPage) return }
        _state.update {
            it.copy(
                loading = true,
                error = false
            )
        }
        loadCharacters()
    }

    fun onQueryChange(query: String) {
        loadJob?.cancel()
        searchJob?.cancel()

        _state.update {
            it.copy(
                query = query,
                characterList = emptyList(),
                currentPage = 0,
                hasNextPage = true,
                error = false,
                loading = true
            )
        }

        searchJob = viewModelScope.launch {
            delay(400.milliseconds)
            loadCharacters()
        }
    }
}