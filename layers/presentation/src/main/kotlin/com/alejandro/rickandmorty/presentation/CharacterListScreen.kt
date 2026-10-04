package com.alejandro.rickandmorty.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.alejandro.rickandmorty.domain.model.Character
import com.alejandro.rickandmorty.presentation.components.CharacterList

@Composable
fun CharacterListScreen(
    modifier: Modifier = Modifier,
    characterList: List<Character> = exampleList
) {
    CharacterList(
        modifier = modifier,
        characters = characterList,
        onClick = {}
    )
}


val exampleList = listOf(
    Character(name = "Million Ants",
        image = "https://rickandmortyapi.com/api/character/avatar/226.jpeg"),
    Character(name = "Simple Rick",
        image = "https://rickandmortyapi.com/api/character/avatar/322.jpeg"),
    Character(name = "Xing Ho",
        image = "https://rickandmortyapi.com/api/character/avatar/721.jpeg")
)