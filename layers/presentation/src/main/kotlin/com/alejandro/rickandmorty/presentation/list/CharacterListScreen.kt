package com.alejandro.rickandmorty.presentation.list

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.alejandro.rickandmorty.presentation.components.CharacterList
import com.alejandro.rickandmorty.presentation.components.EmptyScreen
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

    Column(
        modifier = modifier
    ) {
        TextField(
            label = { Text("Search") },
            modifier = Modifier.fillMaxWidth().padding(20.dp),
            value = state.query,
            onValueChange = { viewModel.onQueryChange(it) },
            trailingIcon = {
                if(state.query.isNotEmpty()) {
                    IconButton(onClick = { viewModel.onQueryChange("") }) {
                        Icon(
                            imageVector = Icons.Default.Clear,
                            contentDescription = "Clear"
                        )
                    }
                }
            }
        )
        Box(
            modifier = Modifier.weight(1f)
        ) {
            when {
                state.loading && state.characterList.isEmpty()-> LoadingScreen(Modifier)
                state.error && state.characterList.isEmpty() -> ErrorScreen(onRetry = { viewModel.loadNextPage() }, Modifier)
                state.characterList.isEmpty() && state.query.isNotBlank() -> EmptyScreen(query = state.query, Modifier)
                state.characterList.isNotEmpty() ->
                    CharacterList(
                        modifier = Modifier,
                        characterModels = state.characterList,
                        onClick = onClick,
                        onLoadMore = { viewModel.loadNextPage() },
                        hasNextPage = state.hasNextPage,
                        isError = state.error
                    )
            }
        }
    }
}

