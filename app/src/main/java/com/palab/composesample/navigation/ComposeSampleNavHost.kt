package com.palab.composesample.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.palab.composesample.lessons.capstone_dashboard.DashboardScreen
import com.palab.composesample.lessons.home.LessonsHomeScreen
import com.palab.composesample.lessons.step1_counter.CounterScreen
import com.palab.composesample.lessons.step2_login.LoginScreen
import com.palab.composesample.lessons.step3_search.UserSearchScreen
import com.palab.composesample.lessons.step4_flow.NewsScreen
import com.palab.composesample.lessons.step5_navigation.step5NavGraph
import com.palab.composesample.lessons.step6_hybrid.WebViewScreen

@Composable
fun ComposeSampleNavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Destinations.HOME,
    ) {
        composable(Destinations.HOME) {
            LessonsHomeScreen(onLessonClick = { route -> navController.navigate(route) })
        }
        composable(Destinations.STEP1_COUNTER) {
            CounterScreen(onBack = { navController.popBackStack() })
        }
        composable(Destinations.STEP2_LOGIN) {
            LoginScreen(onBack = { navController.popBackStack() })
        }
        composable(Destinations.STEP3_SEARCH) {
            UserSearchScreen(onBack = { navController.popBackStack() })
        }
        composable(Destinations.STEP4_FLOW) {
            NewsScreen(onBack = { navController.popBackStack() })
        }
        step5NavGraph(navController)
        composable(Destinations.STEP6_HYBRID) {
            WebViewScreen(onBack = { navController.popBackStack() })
        }
        composable(Destinations.CAPSTONE_DASHBOARD) {
            DashboardScreen(onBack = { navController.popBackStack() })
        }
    }
}
