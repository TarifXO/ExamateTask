package com.example.examatetask.view.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults.SecondaryIndicator
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import com.example.examatetask.R
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.examatetask.ui.theme.backgroundColor
import com.example.examatetask.ui.theme.disabledTextColor
import com.example.examatetask.ui.theme.primaryColor
import com.example.examatetask.view.components.ScreenTitle
import kotlinx.coroutines.launch

@Composable
fun QuestionsScreen(
    modifier: Modifier = Modifier
) {
    val tabs = listOf("Writing", "Oral")
    val tabIcons = listOf(
        R.drawable.baseline_edit_24, // Icon for the first tab
        R.drawable.oral  // Icon for the second tab
    )
    val coroutineScope = rememberCoroutineScope()
    var selectedTabIndex by remember { mutableIntStateOf(0) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(start = 16.dp, end = 16.dp, top = 16.dp)
    ) {
        ScreenTitle(title = "Questions")

        TabRow(
            selectedTabIndex = selectedTabIndex,
            modifier = Modifier.fillMaxWidth(),
            containerColor = backgroundColor,
            indicator = { tabPositions ->
                SecondaryIndicator(
                    Modifier.tabIndicatorOffset(tabPositions[selectedTabIndex]),
                    color = primaryColor
                )
            }
        ) {
            tabs.forEachIndexed { index, title ->
                Tab(
                    selected = selectedTabIndex == index,
                    onClick = {
                        coroutineScope.launch {
                            selectedTabIndex = index
                        }
                    },
                    icon = {
                        Icon(
                            painter = painterResource(id = tabIcons[index]),
                            contentDescription = null,
                        )
                    },
                    text = { Text(
                        text = title,
                        fontWeight = FontWeight.Bold
                    ) },
                    unselectedContentColor = disabledTextColor,
                    selectedContentColor = primaryColor
                )
            }
        }

        when (selectedTabIndex) {
            0 -> WritingTabContent()
            1 -> OralTabContent()
        }
    }
}

@Composable
fun WritingTabContent() {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2), // Adjust the number of columns as needed
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.padding(top = 16.dp)
    ) {
        items(6) { index ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                colors = CardColors(
                    containerColor = Color.White,
                    contentColor = Color.Black,
                    disabledContentColor = Color.Gray,
                    disabledContainerColor = Color.LightGray
                ),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 4.dp
                ),
                shape = RoundedCornerShape(8.dp)
            ) {
                Column(
                    modifier = Modifier
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "10 sur 10 Questions",
                        fontSize = 12.sp,
                        color = Color.Gray,
                        modifier = Modifier
                            .background(Color(0xFFDDFBFB), RoundedCornerShape(4.dp))
                    )
                    Text(
                        text = listOf("Voyage", "Immigration", "Technologies", "Art et Culture", "Environment", "Travel")[index],
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "Progress 50%",
                        fontSize = 12.sp,
                        color = primaryColor
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    LinearProgressIndicator(
                        progress = {
                            0.5f // 50% progress
                        },
                        modifier = Modifier.fillMaxWidth(),
                        color = primaryColor,
                    )
                }
            }
        }
    }
}

@Composable
fun OralTabContent() {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.padding(top = 16.dp)
    ) {

        item {
            Row(
                modifier = Modifier
                    .background(Color(0xFFDDFBFB))
                    .padding(16.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Filter",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.width(8.dp))

                Image(
                    painter = painterResource(id = R.drawable.filter),
                    contentDescription = null,
                    modifier = Modifier.size(24.dp)
                )
            }
        }
        items(6) { index ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                colors = CardColors(
                    containerColor = Color.White,
                    contentColor = Color.Black,
                    disabledContentColor = Color.Gray,
                    disabledContainerColor = Color.LightGray
                ),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 4.dp
                ),
                shape = RoundedCornerShape(8.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Text("Events", color = Color.Black, fontSize = 12.sp)
                        Text("Task ${index + 1}", color = Color.Black, fontSize = 12.sp)
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Sample question content goes here. Adjust as necessary.",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(text = "11 answers", fontSize = 12.sp, color = disabledTextColor)
                        Text(text = "13 May 2023", fontSize = 12.sp, color = disabledTextColor)
                    }
                }
            }
        }
    }
}

@Composable
@Preview
fun QuestionsScreenPreview() {
    QuestionsScreen()
}
