package com.alejandro.rickandmorty.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.alejandro.rickandmorty.domain.model.CharacterModel

@Composable
fun CharacterDetailsInfo(
    character: CharacterModel,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
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
        InfoRow(
            modifier = Modifier.fillMaxWidth(),
            title = "Origin",
            value = character.origin
        )
        InfoRow(
            modifier = Modifier.fillMaxWidth(),
            title = "Last location",
            value = character.location
        )
        InfoRow(
            modifier = Modifier.fillMaxWidth(),
            title = "Episodes",
            value = character.episode.size.toString()
        )
    }
}