package com.alejandro.rickandmorty.presentation

import androidx.lifecycle.ViewModel
import com.alejandro.rickandmorty.domain.model.CharacterModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class CharacterListViewModel: ViewModel() {

    val _state = MutableStateFlow(CharacterListState())

    val state = _state.asStateFlow()

    init {
        loadCharacters()
    }


    private fun loadCharacters() {
        _state.update {
            it.copy(
                characterModelList = example
            )
        }
    }
}

val example = listOf(
    CharacterModel(name = "Million Ants",
        image = "https://rickandmortyapi.com/api/character/avatar/226.jpeg"),
    CharacterModel(name = "Simple Rick",
        image = "https://rickandmortyapi.com/api/character/avatar/322.jpeg"),
    CharacterModel(name = "Xing Ho",
        image = "https://rickandmortyapi.com/api/character/avatar/721.jpeg")
)