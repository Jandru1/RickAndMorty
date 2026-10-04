package com.alejandro.rickandmorty.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alejandro.rickandmorty.domain.model.CharacterModel
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
        loadCharacters()
    }


    private fun loadCharacters() {
        viewModelScope.launch {
            val result = getCharacterListUseCase(1)
            _state.update {
                it.copy(
                    characterModelList = result
                )
            }
        }
    }
}

val example = listOf(
    CharacterModel(
        name = "Million Ants",
        image = "https://rickandmortyapi.com/api/character/avatar/226.jpeg"),
    CharacterModel(
        name = "Simple Rick",
        image = "https://rickandmortyapi.com/api/character/avatar/322.jpeg"),
    CharacterModel(
        name = "Xing Ho",
        image = "https://rickandmortyapi.com/api/character/avatar/721.jpeg")
)