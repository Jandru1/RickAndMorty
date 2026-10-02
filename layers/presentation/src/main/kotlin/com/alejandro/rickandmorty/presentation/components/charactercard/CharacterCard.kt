package com.alejandro.rickandmorty.presentation.components.charactercard

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.alejandro.rickandmorty.domain.model.Character
import com.alejandro.rickandmorty.presentation.R

@Preview(showBackground = true)
@Composable
fun CharacterCardPreview() {
    val character = Character(
        image = "https://rickandmortyapi.com/api/character/avatar/705.jpeg",
        name = "Jerry"
    )
    CharacterCard(
        character = character,
        onClick = {}
    )
}


@Composable
fun CharacterCard(
    character: Character,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {

    Card(
    ) {
        Row {
            Column(
            ) {
                AsyncImage(
                    model = character.image,
                    contentDescription = "Imagen del personaje",
                    placeholder = painterResource(id = R.drawable.squid_costume_jerry),
                    modifier = modifier.size(100.dp)
                )
                Text(
                    text = character.name
                )
            }
            Column(
                modifier = modifier.weight(1f)
            ) {
                Text(
                    text = "Hola, Jetpack Compose",
                    color = Color.Blue,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}