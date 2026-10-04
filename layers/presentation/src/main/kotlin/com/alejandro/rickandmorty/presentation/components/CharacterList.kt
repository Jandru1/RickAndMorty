package com.alejandro.rickandmorty.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
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
        characterModels = items,
        onClick = {}
    )
}
@Composable
fun CharacterList(
    characterModels: List<CharacterModel>,
    modifier: Modifier = Modifier,
    onClick: (CharacterModel) -> Unit,
    hasNextPage: Boolean = true,
    onLoadMore: () -> Unit = {},
    isError: Boolean = false
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
        if(hasNextPage) {

            item {
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center,
                ) {
                    if(isError) {
                        TryAgainButton(onLoadMore)
                    }
                    else {
                        LaunchedEffect(Unit) { onLoadMore() }
                        CircularProgressIndicator()
                    }
                }
            }
        }
    }
}
