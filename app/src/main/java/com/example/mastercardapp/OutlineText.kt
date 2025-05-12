package com.example.mastercardapp

import android.graphics.Typeface
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp


@Composable
fun OutlineText(
    text: String,
    fontSizeSp: TextUnit = 32.sp,
    outlineWidth: Float = 4f,
    outlineColor: Color = Color.White,
    fillColor: Color = Color(0xFF646464) // hard code the wallpaper color
) {
    // Convert sp to px
    val density = LocalDensity.current
    val fontSizePx = with(density) { fontSizeSp.toPx() }

    Canvas(modifier = Modifier.wrapContentSize()) {
        val nativeCanvas = drawContext.canvas.nativeCanvas

        val paint = android.graphics.Paint().apply {
            isAntiAlias = true
            textSize = fontSizePx
            typeface = Typeface.create(Typeface.DEFAULT, Typeface.BOLD)
            textAlign = android.graphics.Paint.Align.LEFT
        }

        // outline
        paint.style = android.graphics.Paint.Style.STROKE
        paint.strokeWidth = outlineWidth
        paint.color = outlineColor.toArgb()
        nativeCanvas.drawText(text, 0f, fontSizePx, paint)

        // inside fill
        paint.style = android.graphics.Paint.Style.FILL
        paint.color = fillColor.toArgb()
        nativeCanvas.drawText(text, 0f, fontSizePx, paint)

    }
}

