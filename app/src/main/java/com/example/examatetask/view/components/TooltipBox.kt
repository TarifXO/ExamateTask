package com.example.examatetask.view.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import com.example.examatetask.R
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun TutorialOverlay(
    currentStep: Int,
    onNextStep: () -> Unit,
    onSkip: () -> Unit
) {
    // Define the steps and their descriptions
    val steps = listOf(
        TutorialStep(
            iconRes = R.drawable.home,
            description = "This is the home screen where your study plan is shown",
            alignment = Alignment.Center
        ),
        TutorialStep(
            iconRes = R.drawable.connect,
            description = "Here you can connect with study partners",
            alignment = Alignment.Center
        ),
        TutorialStep(
            iconRes = R.drawable.questions,
            description = "Access and filter questions here",
            alignment = Alignment.Center
        ),
        TutorialStep(
            iconRes = R.drawable.filter,
            description = "Use this filter to categorize questions",
            alignment = Alignment.Center
        )
    )

    // Only show the current step based on the step list
    if (currentStep in 1..steps.size) {
        val step = steps[currentStep - 1]
        HighlightedIcon(
            iconRes = step.iconRes,
            description = step.description,
            onNextStep = onNextStep,
            onSkip = onSkip,
            alignment = step.alignment,
            isHighlighted = true,
            verticalOffset = 0.dp
        )
    }
}

//data class for each tutorial step
data class TutorialStep(
    val iconRes: Int,
    val description: String,
    val alignment: Alignment
)

@Composable
fun HighlightedIcon(
    iconRes: Int,
    description: String,
    onNextStep: () -> Unit,
    onSkip: () -> Unit,
    alignment: Alignment,
    isHighlighted: Boolean,
    verticalOffset: Dp
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black.copy(alpha = 0.7f)),
        contentAlignment = alignment
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.offset(y = verticalOffset)
        ) {
            Icon(
                painter = painterResource(id = iconRes),
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier
                    .size(60.dp)
                    .background(if (isHighlighted) Color.Gray.copy(alpha = 0.5f) else Color.Transparent)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = description,
                color = Color.White,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row {
                TextButton(onClick = onSkip) {
                    Text("Skip", color = Color.White)
                }
                Spacer(modifier = Modifier.width(16.dp))
                TextButton(onClick = onNextStep) {
                    Text("Next", color = Color.White)
                }
            }
        }
    }
}