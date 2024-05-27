package com.luminoir.validwordfinderwithbacktracking

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.luminoir.validwordfinderwithbacktracking.ui.theme.ValidWordFinderwithBacktrackingTheme

class MainActivity : ComponentActivity() {
    lateinit var navController: NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ValidWordFinderwithBacktrackingTheme {
                navController = rememberNavController()
                setUpNavGraph(navHostController = navController)
            }
        }
    }
}
