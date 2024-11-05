package com.example.examatetask.view.screens

import StepItem
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.examatetask.R
import com.example.examatetask.ui.theme.backgroundColor
import com.example.examatetask.ui.theme.primaryTextColor
import com.example.examatetask.ui.theme.secondaryTextColor
import com.example.examatetask.view.components.ScreenTitle

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier
) {

    val stepTitles = listOf("Unite2:\nwhat is TCF", "Writing Tasks", "Oral Task", "Final Task")

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 0.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            ScreenTitle(title = "Home")

            Image(
                painter = painterResource(id = R.drawable.notification),
                contentDescription = null
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = AnnotatedString.Builder().apply {
                withStyle(style = SpanStyle(color = Color(0xFF374151), fontWeight = FontWeight.Normal)) {
                    append("Hi ")
                }
                withStyle(style = SpanStyle(color = primaryTextColor, fontWeight = FontWeight.Bold)) {
                    append("User Name")
                }
            }.toAnnotatedString(),
            fontSize = 20.sp
        )

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Top
        ) {
            item {
                Text(
                    text = "Study Plan",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = secondaryTextColor
                )

                Spacer(modifier = Modifier.height(16.dp))
            }

            // First step
            item {
                StepItem(stepNumber = "1", stepTitle = "Unite 1:\nwhat is examate", isDisabled = false)
            }

            // Disabled steps
            items(stepTitles) { stepTitle ->
                val stepNumber = (stepTitles.indexOf(stepTitle) + 2).toString()
                StepItem(stepNumber = stepNumber, stepTitle = stepTitle, isDisabled = true)
            }
        }
    }
}

@Composable
@Preview
fun HomeScreenPreview() {
    HomeScreen()
}