package com.example.examatetask.view.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.examatetask.ui.theme.backgroundColor
import com.example.examatetask.view.components.ScreenTitle

@Composable
fun ProfileScreen() {
    Column(
        modifier = Modifier.fillMaxSize()
            .background(backgroundColor),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        ScreenTitle(title = "Profile Screen")
    }
}