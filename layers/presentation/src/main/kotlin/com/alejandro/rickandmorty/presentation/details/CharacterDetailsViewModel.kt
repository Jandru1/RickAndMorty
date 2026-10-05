package com.alejandro.rickandmorty.presentation.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alejandro.rickandmorty.domain.usecase.GetCharacterDetailsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CharacterDetailsViewModel(
    private val characterId: Int,
    private val getCharacterDetailsUseCase: GetCharacterDetailsUseCase
) : ViewModel() {
    private val _state = MutableStateFlow(CharacterDetailsState())
    val state = _state.asStateFlow()

    init {
        loadDetails()
    }

    private fun loadDetails() {
        _state.update { it.copy(loading = true) }
        viewModelScope.launch {
            val result = getCharacterDetailsUseCase(characterId)
            result.onSuccess { character ->
                _state.update {
                    it.copy(
                        characterDetails = character,
                        loading = false,
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
}