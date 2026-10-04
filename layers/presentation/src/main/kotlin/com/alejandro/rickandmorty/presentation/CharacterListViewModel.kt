package com.alejandro.rickandmorty.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alejandro.rickandmorty.domain.usecase.GetCharacterListUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CharacterListViewModel(
    private val getCharacterListUseCase: GetCharacterListUseCase
): ViewModel() {

    private val _state = MutableStateFlow(CharacterListState())

    val state = _state.asStateFlow()

    init {
        loadNextPage()
    }

    private fun loadCharacters() {
        viewModelScope.launch {
            val result = getCharacterListUseCase(state.value.currentPage+1)
            _state.update {
                it.copy(
                    characterList = result.characters + state.value.characterList,
                    loading = false,
                    currentPage = 1 + state.value.currentPage,
                    hasNextPage = result.hasNextPage
                )
            }

        }
    }

    public fun loadNextPage() {
        with (state.value) { if (loading || !hasNextPage) return }
        _state.update {
            it.copy(loading = true)
        }
        loadCharacters()
    }
}