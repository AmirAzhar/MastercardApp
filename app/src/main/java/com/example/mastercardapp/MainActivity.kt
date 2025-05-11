package com.example.mastercardapp

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
import com.example.mastercardapp.Screen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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

@Composable
fun CoverScreen(navController: NavHostController) {
    Text("Cover Screen")
}

@Composable
fun IntroScreen(navController: NavHostController) {
    Text("Intro Screen")
}

@Composable
fun TermsScreen(navController: NavHostController) {
    Text("Terms & Conditions Screen")
}