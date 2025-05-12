package com.example.mastercardapp.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val MastercardColorScheme = darkColorScheme(
    primary = Primary,
    background = Background,
    surface = BackgroundLight,
    onPrimary = Color.White,
    onBackground = Color.White,
    onSurface = Gray
)

private val MastercardTypography = Typography(
    displayLarge = Typography().displayLarge.copy(fontFamily = Inter),
    displayMedium = Typography().displayMedium.copy(fontFamily = Inter),
    displaySmall = Typography().displaySmall.copy(fontFamily = Inter),
    headlineLarge = Typography().headlineLarge.copy(fontFamily = Inter),
    headlineMedium = Typography().headlineMedium.copy(fontFamily = Inter),
    headlineSmall = Typography().headlineSmall.copy(fontFamily = Inter),
    titleLarge = Typography().titleLarge.copy(fontFamily = Inter),
    titleMedium = Typography().titleMedium.copy(fontFamily = Inter),
    titleSmall = Typography().titleSmall.copy(fontFamily = Inter),
    bodyLarge = Typography().bodyLarge.copy(fontFamily = Inter),
    bodyMedium = Typography().bodyMedium.copy(fontFamily = Inter),
    bodySmall = Typography().bodySmall.copy(fontFamily = Inter),
    labelLarge = Typography().labelLarge.copy(fontFamily = Inter),
    labelMedium = Typography().labelMedium.copy(fontFamily = Inter),
    labelSmall = Typography().labelSmall.copy(fontFamily = Inter),
)

@Composable
fun MastercardAppTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = MastercardColorScheme,
        typography = MastercardTypography,
        content = content
    )
}
