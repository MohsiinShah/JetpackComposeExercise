package com.example.jetpackcomposeexercise.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcomposeexercise.screens.HomeScreen
import com.example.jetpackcomposeexercise.screens.SettingsScreen

@Composable
fun Navigation(){

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreens.HomeScreen.name){
        composable(route = AppScreens.HomeScreen.name){
            HomeScreen(navController = navController)
        }

        composable(route = AppScreens.SettingScreen.name)
        { SettingsScreen(navController = navController) }
        
    }
}