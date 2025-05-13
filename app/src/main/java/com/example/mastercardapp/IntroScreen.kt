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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.runtime.saveable.rememberSaveable
import com.example.mastercardapp.ui.components.AppTopBar
import com.example.mastercardapp.ui.components.AppBottomBar
import com.example.mastercardapp.ui.theme.Background
import com.example.mastercardapp.ui.theme.Gray
import com.example.mastercardapp.ui.theme.Primary

// store details of the diff pages
data class IntroPage(val image: Int, val title: String, val description: String)

@Composable
fun IntroScreen(navController: NavHostController) {
    val pages = listOf(
        IntroPage(R.drawable.intro_1, "Pay and unlock in style", "The wearable uses tokenization to ensure hassle-free and secure payments, making your daily transactions smoother and more convenient."),
        IntroPage(R.drawable.intro_2, "Choose any Mastercard™", "Whether it’s a credit, debit, or prepaid card, you can tokenize it into the wearable within seconds. Ready for payment 24/7."),
        IntroPage(R.drawable.intro_3, "No battery —\nNo charging required", "Pay seamlessly and reliably without worrying about phone battery or carrying multiple cards.")
    )

    // this is like a useState that i can use to keep track of the slide im in
    var pageId by rememberSaveable { mutableIntStateOf(0) }
    val currPage = pages[pageId]

    // layout struct to help add bottom bar
    Scaffold(
        containerColor = Color.Black,
        bottomBar = {
            AppBottomBar(
                backLabel = "Back",
                nextLabel = "Next",
                onBack = {
                    if (pageId == 0) {
                        navController.navigate(Screen.Cover.route) {
                            popUpTo(Screen.Cover.route) { inclusive = true }
                        }
                    } else {
                        pageId--
                    }
                },
                onNext = {
                    if (pageId < pages.lastIndex) {
                        pageId++
                    } else {
                        navController.navigate(Screen.Terms.route)
                    }
                }
            )
        }

    ) { padding ->
        // actual content
        // vs normal box, we can have access to maxHeight and maxWidth -> allow for more responsiveness
        BoxWithConstraints(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .background(Background)
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
                    // Todo: maybe add a nice carousel like animation with swipe
                    Image(
                        painter = painterResource(id = currPage.image),
                        contentDescription = "Intro Bg",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )

                    // overlay top bar
                    AppTopBar(
                        onClose = {
                            navController.navigate(Screen.Cover.route) {
                                popUpTo(Screen.Cover.route) { inclusive = true }
                            }
                        }
                    )
                }

                // title and desc
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Background)
                        .padding(24.dp),
                    horizontalAlignment = Alignment.Start
                ) {
                    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        pages.forEachIndexed { index, _ ->
                            Box(
                                modifier = Modifier
                                    .size(10.dp)
                                    .background(
                                        if (index == pageId) Primary else Gray,
                                        CircleShape
                                    )
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = currPage.title,
                        fontSize = 22.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
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


