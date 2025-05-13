package com.example.mastercardapp.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.mastercardapp.R
import com.example.mastercardapp.ui.theme.Background
import com.example.mastercardapp.ui.theme.Primary

@Composable
// Todo: Add blur
fun AppTopBar(
    onClose: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
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

        Button(
            onClick = onClose,
            shape = RoundedCornerShape(50),
            colors = ButtonDefaults.buttonColors(containerColor = Primary),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 2.dp)
        ) {
            Text("Close", color = Color.White)
        }
    }
}


@Composable
fun AppBottomBar(
    backLabel: String,
    nextLabel: String,
    onBack: () -> Unit,
    onNext: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(Background)
            .padding(horizontal = 24.dp, vertical = 24.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        OutlinedButton(
            onClick = onBack,
            modifier = Modifier.weight(0.7f),
            shape = RoundedCornerShape(50),
            colors = ButtonDefaults.outlinedButtonColors(contentColor = Primary),
            border = BorderStroke(1.dp, Primary)
        ) {
            Text(backLabel)
        }

        Spacer(modifier = Modifier.width(16.dp))

        Button(
            onClick = onNext,
            modifier = Modifier.weight(1.3f),
            shape = RoundedCornerShape(50),
            colors = ButtonDefaults.buttonColors(containerColor = Primary)
        ) {
            Text(nextLabel)
        }
    }
}
