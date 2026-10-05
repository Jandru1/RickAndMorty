package com.alejandro.rickandmorty.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.alejandro.rickandmorty.presentation.CharacterListScreen
import com.alejandro.rickandmorty.presentation.details.CharacterDetailsScreen

@Composable
fun NavigationGraph(
    modifier: Modifier = Modifier
) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "list",
        modifier = modifier
    ) {
        composable("list") {
            CharacterListScreen(
                onClick = { navController.navigate("detail")}
            )
        }
        composable(route = "detail") {
            CharacterDetailsScreen()
        }
    }
}