package com.alejandro.rickandmorty.presentation.list

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.alejandro.rickandmorty.presentation.components.CharacterList
import org.koin.androidx.compose.koinViewModel

@Composable
fun CharacterListScreen(
    modifier: Modifier = Modifier,
    onClick: (Int) -> Unit
) {

    val viewModel: CharacterListViewModel = koinViewModel()
    val state by viewModel.state.collectAsStateWithLifecycle()

    CharacterList(
        modifier = modifier,
        characterModels = state.characterList,
        onClick = onClick,
        onLoadMore = { viewModel.loadNextPage() },
        hasNextPage = state.hasNextPage,
        isError = state.isError
    )
}