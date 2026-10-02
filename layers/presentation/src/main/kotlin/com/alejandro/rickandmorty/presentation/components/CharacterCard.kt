package com.alejandro.rickandmorty.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
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
        modifier = modifier
            .padding(8.dp),
        onClick = onClick
    ) {
        Row (
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier.padding(12.dp)
        ){
            Column(
                modifier = modifier
                    .width(IntrinsicSize.Min)
            ) {
                AsyncImage(
                    model = character.image,
                    contentDescription = "Imagen del personaje",
                    placeholder = painterResource(id = R.drawable.squid_costume_jerry),
                    modifier = modifier.size(100.dp),
                )
                Text(
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(3.dp),
                    textAlign = TextAlign.Center,
                    text = character.name
                )
            }
            Column(
                modifier = modifier.weight(1f)
                    .padding(start = 12.dp)
            ) {
                Text(
                    textAlign = TextAlign.Justify,
                    text = "${character.name} es un personaje de especie ${character.species}",
                    color = Color.Black,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}