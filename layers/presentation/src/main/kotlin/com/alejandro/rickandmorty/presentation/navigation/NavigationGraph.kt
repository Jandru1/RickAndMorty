package com.alejandro.rickandmorty.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.alejandro.rickandmorty.presentation.details.CharacterDetailsScreen
import com.alejandro.rickandmorty.presentation.list.CharacterListScreen

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
        composable(
            route = "list"
        ) {
            CharacterListScreen(
                onClick = { id -> navController.navigate("detail/$id")}
            )
        }
        composable(
            route = "detail/{id}",
            arguments = listOf(
                navArgument("id") { type = NavType.IntType })
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getInt("id") ?: 0
            CharacterDetailsScreen(
                characterId = id
            )
        }
    }
}