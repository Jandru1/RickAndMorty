package com.alejandro.rickandmorty.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.alejandro.rickandmorty.domain.model.CharacterModel
import com.alejandro.rickandmorty.domain.model.CharacterStatus
import com.alejandro.rickandmorty.presentation.theme.AliveGreen
import com.alejandro.rickandmorty.presentation.theme.DeadRed
import com.alejandro.rickandmorty.presentation.theme.UnknownGray

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
        Column(
            modifier = Modifier.fillMaxWidth()
                .verticalScroll(rememberScrollState())
        ) {
            InfoRow(
                modifier = Modifier.fillMaxWidth(),
                title = "Status",
                value = character.status.mapStatus(),
                isStatus = true,
                backgroundColor = character.status.toColor()
            )
            InfoRow(
                modifier = Modifier.fillMaxWidth(),
                title = "Especie",
                value = character.species
            )
            InfoRow(
                modifier = Modifier.fillMaxWidth(),
                title = "Tipo",
                value = character.type
            )
            InfoRow(
                modifier = Modifier.fillMaxWidth(),
                title = "Genero",
                value = character.gender.toString()
            )
        }
    }
}

private fun CharacterStatus.mapStatus(): String {
    return when (this) {
        CharacterStatus.ALIVE -> "Alive"
        CharacterStatus.DEAD -> "Dead"
        CharacterStatus.UNKNOWN -> "Unknown"
    }
}

private fun CharacterStatus.toColor(): Color =
    when (this) {
        CharacterStatus.ALIVE -> AliveGreen
        CharacterStatus.DEAD -> DeadRed
        CharacterStatus.UNKNOWN -> UnknownGray
    }
