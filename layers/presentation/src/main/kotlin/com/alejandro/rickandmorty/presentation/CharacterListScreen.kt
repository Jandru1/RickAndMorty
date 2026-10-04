package com.alejandro.rickandmorty.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.alejandro.rickandmorty.presentation.components.CharacterList
import org.koin.androidx.compose.koinViewModel

@Composable
fun CharacterListScreen(
    modifier: Modifier = Modifier,
) {

    val viewModel: CharacterListViewModel = koinViewModel()
    val state by viewModel.state.collectAsStateWithLifecycle()

    CharacterList(
        modifier = modifier,
        characterModels = state.characterModelList,
        onClick = {}
    )
}