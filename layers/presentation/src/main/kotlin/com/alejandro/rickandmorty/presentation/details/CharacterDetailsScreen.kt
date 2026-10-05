package com.alejandro.rickandmorty.presentation.details

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.alejandro.rickandmorty.presentation.components.CharacterDetails
import com.alejandro.rickandmorty.presentation.components.ErrorScreen
import com.alejandro.rickandmorty.presentation.components.LoadingScreen
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf

@Composable
fun CharacterDetailsScreen(
    modifier: Modifier = Modifier,
    characterId: Int
) {

    val viewmodel : CharacterDetailsViewModel = koinViewModel { parametersOf(characterId) }
    val state by viewmodel.state.collectAsStateWithLifecycle()

    val character = state.characterDetails
    when {
        state.loading -> LoadingScreen()
        state.error -> ErrorScreen(
            modifier = modifier,
            onRetry = { viewmodel.loadDetails() }
        )
        character != null -> CharacterDetails(modifier, character)
    }
}