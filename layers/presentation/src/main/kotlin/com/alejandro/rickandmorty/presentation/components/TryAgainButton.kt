package com.alejandro.rickandmorty.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun PreviewTryAgainButton() {
    TryAgainButton(
        onLoadMore = {}
    )
}

@Composable
fun TryAgainButton(
    onLoadMore: () -> Unit
) {
    Column(
        modifier = Modifier.padding(5.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text("No se han podido cargar los personajes")
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = { onLoadMore() },
        ) {
            Text(text = "Try Again")
        }
    }
}