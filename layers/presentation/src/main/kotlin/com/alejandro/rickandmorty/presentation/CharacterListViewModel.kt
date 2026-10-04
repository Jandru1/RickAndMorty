package com.alejandro.rickandmorty.presentation

import android.util.Log
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
            result.onSuccess { model ->
                _state.update {
                    it.copy(
                        characterList = it.characterList + model.characters,
                        loading = false,
                        currentPage = 1 + it.currentPage,
                        hasNextPage = model.hasNextPage,
                        isError = false
                    )
                }
            }
            result.onFailure {
                _state.update {
                    it.copy(
                        loading = false,
                        isError = true
                    )
                }
                Log.w("RRRR", "Error loading characters ${it}")

            }
        }
    }

    fun loadNextPage() {
        with (state.value) { if (loading || !hasNextPage) return }
        _state.update {
            it.copy(
                loading = true,
                isError = false
            )
        }
        loadCharacters()
    }
}