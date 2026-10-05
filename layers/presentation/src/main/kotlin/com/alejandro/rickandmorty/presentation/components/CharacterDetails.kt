package com.alejandro.rickandmorty.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import com.alejandro.rickandmorty.domain.model.CharacterModel
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.alejandro.rickandmorty.domain.model.CharacterStatus

@Composable
fun CharacterDetails(
    modifier: Modifier = Modifier,
    character: CharacterModel
) {
    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState())
            .padding(15.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AsyncImage(
                model = character.image,
                contentDescription = character.name,
                modifier = Modifier.fillMaxWidth().aspectRatio(1f)
            )
            Text(
                textAlign = TextAlign.Center,
                text = character.name,
                color = Color.Black,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Column(
            modifier = Modifier.fillMaxWidth(),
        ) {
            InfoRow(
                modifier = Modifier.fillMaxWidth(),
                title = "Status :",
                value = character.status.toString(),
                isStatus = true,
                backgroundColor = character.status.toColor()
            )
            InfoRow(
                modifier = Modifier.fillMaxWidth(),
                title = "Especie: ",
                value = character.species
            )
            InfoRow(
                modifier = Modifier.fillMaxWidth(),
                title = "Tipo: ",
                value = character.type
            )
            InfoRow(
                modifier = Modifier.fillMaxWidth(),
                title = "Genero: ",
                value = character.gender.toString()
            )
        }
    }
}

private fun CharacterStatus.toColor(): Color =
    when (this) {
        CharacterStatus.ALIVE -> Color.Green
        CharacterStatus.DEAD -> Color.Red
        CharacterStatus.UNKNOWN -> Color.Gray
    }
