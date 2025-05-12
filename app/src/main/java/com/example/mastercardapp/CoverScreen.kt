package com.example.mastercardapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.mastercardapp.OutlineText
import com.example.mastercardapp.ui.theme.Primary


@Composable
fun CoverScreen(navController: NavHostController) {
    Box(modifier = Modifier.fillMaxSize()) {

        // bg image
        Image(
            painter = painterResource(id = R.drawable.cover),
            contentDescription = "Cover Bg",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        // content
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp, vertical = 24.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
            ) {
                Spacer(modifier = Modifier.height(12.dp))

                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "Logo",
                    modifier = Modifier
                        .height(28.dp)
                        .padding(top = 4.dp)
                )

                Spacer(modifier = Modifier.height(20.dp))

                // Todo: Change Font
                Text(
                    text = "Mastercard\nPayment Wearable",
                    fontSize = 32.sp,
                    color = Color.White,
                    lineHeight = 42.sp,
                    fontWeight = FontWeight.Black
                )

                // outlined text
                OutlineText(text = "Experience")

                Spacer(modifier = Modifier.height(50.dp))

                Text(
                    text = "1 May 2025, Mastercard Experience Center.\nDuo Tower, Singapore.",
                    fontSize = 14.sp,
                    color = Color.White
                )
            }

            // continue btn
            Button(
                onClick = { navController.navigate(Screen.Intro.route) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp),
                shape = RoundedCornerShape(50),
                // FF to show 100% opacity
                colors = ButtonDefaults.buttonColors(containerColor = Primary)
            ) {
                Text("Continue", color = Color.White)
            }
        }
    }
}
