package com.alejandro.rickandmorty.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
        Column(
            modifier = Modifier.fillMaxWidth()
                .verticalScroll(rememberScrollState())
        ) {
            InfoRow(
                modifier = Modifier.fillMaxWidth(),
                title = "Status",
                value = character.status.mapStatus(),
                isStatus = true,
                backgroundColor = character.status.mapColor()
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
                value = character.gender.mapGender()
            )
        }
    }
}
