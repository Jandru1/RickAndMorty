package com.alejandro.rickandmorty.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.alejandro.rickandmorty.domain.model.CharacterModel
import com.alejandro.rickandmorty.presentation.R

@Preview(showBackground = true)
@Composable
fun CharacterCardPreview() {
    val characterModel = CharacterModel(
        image = "https://rickandmortyapi.com/api/character/avatar/705.jpeg",
        name = "Jerry"
    )
    CharacterCard(
        characterModel = characterModel,
        onClick = {}
    )
}


@Composable
fun CharacterCard(
    characterModel: CharacterModel,
    onClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .padding(8.dp),
        onClick = { onClick(characterModel.id) }
    ) {
        Row (
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(12.dp)
        ){
            Column(
                modifier = Modifier
                    .weight(0.35f)
            ) {
                AsyncImage(
                    model = characterModel.image,
                    contentDescription = "Imagen del personaje",
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(1f)
                )
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(3.dp),
                    textAlign = TextAlign.Center,
                    text = characterModel.name
                )
            }
            Column(
                modifier = Modifier.weight(0.65f)
                    .padding(start = 12.dp)
            ) {
                Text(
                    textAlign = TextAlign.Justify,
                    text = "${characterModel.name} es un personaje de especie ${characterModel.species}",
                    color = Color.White,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}