package com.alejandro.rickandmorty.presentation.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alejandro.rickandmorty.domain.model.CharacterModel

@Preview(showBackground = true)
@Composable
fun CharacterListPreview() {
    val items = listOf(
        CharacterModel(name = "Jerry"),
        CharacterModel(name = "Summer"),
        CharacterModel(name = "Rick")
    )
    CharacterList(
        items,
        Modifier,
        {}
    )
}
@Composable
fun CharacterList(
    characterModels: List<CharacterModel>,
    modifier: Modifier = Modifier,
    onClick: (CharacterModel) -> Unit
) {
    LazyColumn(
        modifier = modifier
            .padding(5.dp)
    ) {
        items(
            items = characterModels,
        ) { character ->
            CharacterCard(
                characterModel = character,
                modifier = Modifier,
                onClick = { onClick(character) }
            )
        }
    }
}