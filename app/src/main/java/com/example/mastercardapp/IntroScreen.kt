package com.example.mastercardapp

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronLeft
import androidx.compose.material3.Icon
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration

// store details of the diff pages
data class IntroPage(val image: Int, val title: String, val description: String)

// Todo: When navigating back from terms, it should go back to the last visited page
@Composable
fun IntroScreen(navController: NavHostController) {
    val pages = listOf(
        IntroPage(R.drawable.intro_1, "Pay and unlock in style", "The wearable uses tokenization to ensure hassle-free and secure payments, making your daily transactions smoother and more convenient."),
        IntroPage(R.drawable.intro_2, "Choose any Mastercard", "Whether it’s a credit, debit, or prepaid card, you can tokenize it in the same wearable. Ready for payment 24/7."),
        IntroPage(R.drawable.intro_3, "No battery — No charging", "Pay seamlessly and continuously, without worrying about phone battery or managing multiple cards.")
    )

    var pageId by remember { mutableIntStateOf(0) }
    val currPage = pages[pageId]

    // layout struct to help add bottom bar
    Scaffold(
        containerColor = Color.Black,
        bottomBar = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFF141414))
                    .padding(horizontal = 24.dp, vertical = 24.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    OutlinedButton(
                        onClick = {
                            if (pageId == 0) {
                                navController.navigate(Screen.Cover.route) {
                                    popUpTo(Screen.Cover.route) { inclusive = true }
                                }
                            } else {
                                pageId--
                            }
                        },
                        modifier = Modifier.weight(0.6f),
                        shape = RoundedCornerShape(50),
                        colors = ButtonDefaults.outlinedButtonColors(
                            contentColor = Color(0xFFFF6600)
                        ),
                        border = BorderStroke(1.dp, Color(0xFFFF6600))
                    ) {
                        Text("Back")
                    }

                    Spacer(modifier = Modifier.width(16.dp))

                    Button(
                        onClick = {
                            if (pageId < pages.lastIndex) {
                                pageId++
                            } else {
                                navController.navigate(Screen.Terms.route)
                            }
                        },
                        modifier = Modifier.weight(1.4f),
                        shape = RoundedCornerShape(50),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF6600))
                    ) {
                        Text("Next")
                    }
                }
            }
        }
    ) { padding ->
        // actual content
        // vs normal box, we can have access to maxHeight and maxWidth -> allow for more responsiveness
        BoxWithConstraints(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .background(Color(0xFF141414))
        ) {
            val imageHeight = maxHeight * 0.6f

            Column(modifier = Modifier.fillMaxSize()) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(imageHeight)
                        .padding(bottom = 16.dp)
                ) {
                    // bg image
                    Image(
                        painter = painterResource(id = currPage.image),
                        contentDescription = "Intro Bg",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )

                    // overlay top bar
                    // Todo: Add blur
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.Black.copy(alpha = 0.7f))
                            .padding(horizontal = 24.dp, vertical = 24.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.logo),
                            contentDescription = "Logo",
                            modifier = Modifier.height(24.dp)
                        )

                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                imageVector = Icons.Filled.ChevronLeft,
                                contentDescription = "Back",
                                tint = Color.White
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Button(
                                onClick = {
                                    navController.navigate(Screen.Cover.route) {
                                        popUpTo(Screen.Cover.route) { inclusive = true }
                                    }
                                },
                                shape = RoundedCornerShape(50),
                                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF6600)),
                                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 2.dp)
                            ) {
                                Text("Close", color = Color.White)
                            }
                        }
                    }
                }

                // title and desc
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0xFF141414))
                        .padding(24.dp),
                    horizontalAlignment = Alignment.Start
                ) {
                    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        pages.forEachIndexed { index, _ ->
                            Box(
                                modifier = Modifier
                                    .size(10.dp)
                                    .background(
                                        if (index == pageId) Color(0xFFFF6600) else Color.Gray,
                                        CircleShape
                                    )
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = currPage.title,
                        fontSize = 22.sp,
                        color = Color.White
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = currPage.description,
                        fontSize = 16.sp,
                        color = Color.LightGray
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "SKIP",
                        color = Color.White,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        style = LocalTextStyle.current.copy(textDecoration = TextDecoration.Underline),
                        modifier = Modifier.clickable {
                            navController.navigate(Screen.Terms.route)
                        }
                    )

                }

            }
        }


    }
}


