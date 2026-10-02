package com.alejandro.rickandmorty.presentation.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alejandro.rickandmorty.domain.model.Character

@Preview(showBackground = true)
@Composable
fun CharacterListPreview() {
    val items = listOf(
        Character(name = "Jerry"),
        Character(name = "Summer"),
        Character(name = "Rick")
    )
    CharacterList(
        items,
        Modifier,
        {}
    )
}
@Composable
fun CharacterList(
    items: List<Character>,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Column(
        modifier = modifier
            .padding(5.dp)
    ) {
        items.forEach { item ->
            CharacterCard(
                character = item,
                modifier = modifier,
                onClick = onClick
            )
        }
    }
}