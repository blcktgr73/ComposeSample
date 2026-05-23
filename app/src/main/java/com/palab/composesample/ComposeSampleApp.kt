package com.palab.composesample

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.palab.composesample.navigation.ComposeSampleNavHost

@Composable
fun ComposeSampleApp() {
    val navController = rememberNavController()
    ComposeSampleNavHost(navController = navController)
}
