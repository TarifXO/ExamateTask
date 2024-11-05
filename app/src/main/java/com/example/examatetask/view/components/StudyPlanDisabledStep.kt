package com.example.examatetask.view.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.examatetask.R
import com.example.examatetask.ui.theme.backgroundColor
import com.example.examatetask.ui.theme.disabledColor

@Composable
fun DisabledStep(text: String, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.size(90.dp, 129.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        Canvas(modifier = Modifier.size(90.dp)) {
            drawCircle(
                color = disabledColor,
                radius = 41.dp.toPx(),
                style = Stroke(width = 6.dp.toPx())
            )

            drawCircle(
                color = disabledColor,
                radius = 27.dp.toPx()
            )
        }

        Box(
            modifier = Modifier.size(90.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = text,
                style = TextStyle(color = backgroundColor, fontSize = 24.sp)
            )
        }

        Canvas(modifier = Modifier.size(90.dp, 129.dp)) {
            drawLine(
                color = disabledColor,
                start = center.copy(y = 82.dp.toPx() + 6.dp.toPx()), // Adjusted to touch the outer circle
                end = center.copy(y = size.height),
                strokeWidth = 12.dp.toPx()
            )
        }

        Image(
            painter = painterResource(id = R.drawable.lock),
            contentDescription = null,
            modifier = Modifier
                .size(25.dp)
                .align(Alignment.BottomEnd)
                .offset(x = (-2).dp, y = (-44).dp)
        )
    }
}

@Composable
@Preview
fun DisabledStepPreview() {
    DisabledStep(
        text = "2"
    )
}