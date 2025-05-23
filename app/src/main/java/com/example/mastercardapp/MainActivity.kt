package com.example.mastercardapp

import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mastercardapp.ui.theme.MastercardAppTheme
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.example.mastercardapp.screens.CoverScreen
import com.example.mastercardapp.screens.IntroScreen
import com.example.mastercardapp.screens.Screen
import com.example.mastercardapp.screens.TermsScreen


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        // force portrait
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        WindowInsetsControllerCompat(window, window.decorView).hide(WindowInsetsCompat.Type.systemBars())
        setContent {
            MastercardAppTheme {
                val navController = rememberNavController()
                AppNavigator(navController)
            }
        }
    }
}

@Composable
fun AppNavigator(navController: NavHostController) {
    Surface {
        NavHost(
            navController = navController,
            startDestination = Screen.Cover.route
        ) {
            composable(Screen.Cover.route) { CoverScreen(navController) }
            composable(Screen.Intro.route) { IntroScreen(navController) }
            composable(Screen.Terms.route) { TermsScreen(navController) }
        }
    }
}


