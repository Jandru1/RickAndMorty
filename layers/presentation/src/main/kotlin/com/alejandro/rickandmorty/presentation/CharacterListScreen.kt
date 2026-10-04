package com.alejandro.rickandmorty.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.alejandro.rickandmorty.domain.model.CharacterModel
import com.alejandro.rickandmorty.presentation.components.CharacterList

@Composable
fun CharacterListScreen(
    modifier: Modifier = Modifier,
    characterModelList: List<CharacterModel> = exampleList
) {

    val viewModel: CharacterListViewModel = viewModel()
    val state by viewModel.state.collectAsStateWithLifecycle()

    CharacterList(
        modifier = modifier,
        characterModels = state.characterModelList,
        onClick = {}
    )
}


val exampleList = listOf(
    CharacterModel(name = "Million Ants"),
    CharacterModel(name = "Simple Rick"),
    CharacterModel(name = "Xing Ho")
)