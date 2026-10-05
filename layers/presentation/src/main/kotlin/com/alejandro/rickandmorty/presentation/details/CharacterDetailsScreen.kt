package com.alejandro.rickandmorty.presentation.details

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun CharacterDetailsScreen(
    modifier: Modifier = Modifier,
    characterId: Int = 0
) {
    Text("Character details of $characterId")
}