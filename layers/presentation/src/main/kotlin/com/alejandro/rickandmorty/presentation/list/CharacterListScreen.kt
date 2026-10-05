package com.alejandro.rickandmorty.presentation.list

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.alejandro.rickandmorty.presentation.components.CharacterList
import com.alejandro.rickandmorty.presentation.components.ErrorScreen
import com.alejandro.rickandmorty.presentation.components.LoadingScreen
import org.koin.androidx.compose.koinViewModel

@Composable
fun CharacterListScreen(
    modifier: Modifier = Modifier,
    onClick: (Int) -> Unit
) {

    val viewModel: CharacterListViewModel = koinViewModel()
    val state by viewModel.state.collectAsStateWithLifecycle()

    when {
        state.loading && state.characterList.isEmpty()-> LoadingScreen()
        state.error && state.characterList.isEmpty() -> ErrorScreen(onRetry = { viewModel.loadNextPage() })
        state.characterList.isNotEmpty() ->
            CharacterList(
                modifier = modifier,
                characterModels = state.characterList,
                onClick = onClick,
                onLoadMore = { viewModel.loadNextPage() },
                hasNextPage = state.hasNextPage,
                isError = state.error
            )
    }

}