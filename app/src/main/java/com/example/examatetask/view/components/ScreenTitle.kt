package com.example.examatetask.view.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.examatetask.ui.theme.titleColor

@Composable
fun ScreenTitle(
    title: String,
) {
    // Screen title bar
    Text(
        text = title,
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold,
        color = titleColor,
        textAlign = TextAlign.Start,
    )
}

@Composable
@Preview
fun ScreenTitlePreview() {
    ScreenTitle(
        title = "Home"
    )
}