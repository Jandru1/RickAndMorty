package com.alejandro.rickandmorty.presentation.details

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.alejandro.rickandmorty.presentation.components.CharacterDetails
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
    if(character != null) {
        CharacterDetails(
            modifier = modifier,
            character = character
        )
    }
}