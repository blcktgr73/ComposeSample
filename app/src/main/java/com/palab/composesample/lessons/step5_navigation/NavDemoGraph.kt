package com.palab.composesample.lessons.step5_navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.palab.composesample.navigation.Destinations

fun NavGraphBuilder.step5NavGraph(navController: NavController) {
    navigation(
        startDestination = Destinations.STEP5_LIST,
        route = Destinations.STEP5_GRAPH,
    ) {
        composable(Destinations.STEP5_LIST) {
            ItemListScreen(
                onItemClick = { id ->
                    navController.navigate(Destinations.step5Detail(id))
                },
                onBack = { navController.popBackStack() },
            )
        }
        composable(
            route = Destinations.STEP5_DETAIL_ROUTE,
            arguments = listOf(navArgument("itemId") { type = NavType.IntType }),
        ) { backStackEntry ->
            val itemId = backStackEntry.arguments?.getInt("itemId") ?: 0
            ItemDetailScreen(
                itemId = itemId,
                onBack = { navController.popBackStack() },
            )
        }
    }
}
