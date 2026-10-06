package com.alejandro.rickandmorty.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.alejandro.rickandmorty.domain.model.CharacterModel

@Composable
fun CharacterDetails(
    modifier: Modifier = Modifier,
    character: CharacterModel
) {
    Column(
        modifier = modifier
            .padding(15.dp)
    ) {
        CharacterHeader(
            modifier = Modifier.fillMaxWidth(),
            character = character
        )
        CharacterDetailsInfo(
            character = character,
            modifier = Modifier
        )
    }
}
