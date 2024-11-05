package com.example.examatetask.view.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SimpleStep1Drawable(text: String, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.size(88.dp, 129.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        Canvas(modifier = Modifier.size(88.dp)) {
            drawCircle(
                color = Color(0xFF29E4E4),
                radius = 41.dp.toPx(),
                style = Stroke(width = 6.dp.toPx())
            )

            drawCircle(
                color = Color(0xFFEEFDFD),
                radius = 27.dp.toPx()
            )

            // Draw the stroke circle
            drawCircle(
                color = Color(0xFF29E4E4),
                radius = 27.dp.toPx(),
                style = Stroke(width = 2.dp.toPx())
            )
        }

        Box(
            modifier = Modifier.size(88.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = text,
                style = TextStyle(color = Color(0xFF29E4E4), fontSize = 24.sp)
            )
        }

        Canvas(modifier = Modifier.size(88.dp, 129.dp)) {
            drawLine(
                color = Color(0xFFDDFBFB),
                start = center.copy(y = 82.dp.toPx() + 6.dp.toPx()), // Adjusted to touch the outer circle
                end = center.copy(y = size.height),
                strokeWidth = 12.dp.toPx()
            )
        }
    }
}

@Composable
@Preview
fun Step1DrawablePreview() {
    SimpleStep1Drawable(
        text = "1"
    )
}