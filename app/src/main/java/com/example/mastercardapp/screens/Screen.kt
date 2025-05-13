package com.example.mastercardapp.screens

// define all the routes here
sealed class Screen(val route: String) {
    object Cover : Screen("cover")
    object Terms : Screen("terms")
    object Intro : Screen("intro")
}