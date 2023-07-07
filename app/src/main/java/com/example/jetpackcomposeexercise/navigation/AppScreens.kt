package com.example.jetpackcomposeexercise.navigation

enum class AppScreens {

    HomeScreen,
    SettingScreen;

    companion object{

        fun fromRoute(route: String?): AppScreens =
            when(route?.substringBefore("/")){
                HomeScreen.name -> HomeScreen
                SettingScreen.name -> SettingScreen
                null -> HomeScreen
                else -> throw IllegalArgumentException("Route $route is not recognised")
            }
    }

}