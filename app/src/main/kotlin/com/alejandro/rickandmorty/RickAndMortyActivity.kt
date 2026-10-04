package com.alejandro.rickandmorty

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.alejandro.rickandmorty.presentation.CharacterListScreen
import com.alejandro.rickandmorty.presentation.theme.RickAndMortyTheme

class RickAndMortyActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            RickAndMortyTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CharacterListScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}