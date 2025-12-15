package com.lucas.sportsdemo.navigation

import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.compose.runtime.Composable
import com.lucas.sportsdemo.ui.theme.LeaguePage
import com.lucas.sportsdemo.ui.theme.GameDetailScreen

sealed class Screen(val route: String) {
    object League : Screen("league")
    object GameDetail : Screen("gameDetail/{gameId}") {
        fun createRoute(gameId: String?) = "gameDetail/$gameId"
    }
}

@Composable
fun AppNavHost() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.League.route
    ) {
        composable(Screen.League.route) {
            LeaguePage(
                onGameClick = { gameId ->
                    navController.navigate(Screen.GameDetail.createRoute(gameId))
                }
            )
        }

        composable(
            route = Screen.GameDetail.route,
            arguments = listOf(navArgument("gameId") { type = NavType.StringType })
        ) { backStackEntry ->
            val gameId = backStackEntry.arguments?.getString("gameId")!!
            GameDetailScreen(
                sport = "football",
                league = "nfl", // change league and sport later to work for all.
                gameId = gameId,
                onBack = { navController.popBackStack() }
            )
        }
    }
}