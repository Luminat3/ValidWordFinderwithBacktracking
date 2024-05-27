package com.luminoir.validwordfinderwithbacktracking

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun setUpNavGraph(navHostController: NavHostController)
{
    NavHost(navController = navHostController, startDestination = Screen.main.route)
    {
        composable(route = Screen.main.route)
        {
            AlgorithmApp()
        }
    }
}