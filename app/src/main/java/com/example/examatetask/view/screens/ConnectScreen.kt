package com.example.examatetask.view.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.examatetask.R
import com.example.examatetask.ui.theme.backgroundColor
import com.example.examatetask.ui.theme.disabledTextColor
import com.example.examatetask.ui.theme.primaryColor
import com.example.examatetask.ui.theme.secondaryTextColor
import com.example.examatetask.view.components.ScreenTitle
import kotlinx.coroutines.launch

@Composable
fun ConnectScreen(
    modifier: Modifier = Modifier
) {
    val tabs = listOf("Suggestions", "Chat")
    val coroutineScope = rememberCoroutineScope()
    var selectedTabIndex by remember { mutableIntStateOf(0) }

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
            ScreenTitle(title = "Connect")
        }

        Spacer(modifier = Modifier.height(16.dp))

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
                    text = { Text(
                        text = title,
                        fontWeight = FontWeight.Bold
                    ) },
                    unselectedContentColor = disabledTextColor,
                    selectedContentColor = primaryColor
                )
            }
        }

        // Content for each tab
        when (selectedTabIndex) {
            0 -> SuggestionsScreen()
            1 -> Text("Content for Tab 2", modifier = Modifier.padding(16.dp))
        }
    }
}

@Composable
fun SuggestionsScreen(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White) // Use appropriate background color
    ) {
        // Title and filter icon
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 16.dp)
        ) {
            Text(
                text = "Suggested Study Partners:",
                fontWeight = FontWeight.Bold,
                color = secondaryTextColor,
                fontSize = 16.sp,
            )

            Image(
                painter = painterResource(id = R.drawable.filter),
                contentDescription = null,
                modifier = Modifier.size(24.dp)
            )
        }

        // List of suggestion items
        LazyColumn(
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(5) { // Dummy items
                SuggestionItem()
            }
        }
    }
}

@Composable
fun SuggestionItem() {
    Card(
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier.fillMaxWidth(),
        colors = CardColors(
            containerColor = Color.White,
            contentColor = Color.Black,
            disabledContentColor = Color.Gray,
            disabledContainerColor = Color.LightGray
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        )

    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            // Profile icon
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .align(Alignment.Top)
                    .background(Color(0xFF00A99D), shape = CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "RS", color = Color.White, fontWeight = FontWeight.Bold)
            }

            Spacer(modifier = Modifier.width(16.dp))

            // User info
            Column{
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Reem Sayed",
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp,
                        color = Color.Black
                    )
                    Spacer(modifier = Modifier.width(40.dp))
                    Box(
                        modifier = Modifier
                            .background(primaryColor, shape = RoundedCornerShape(8.dp))
                            .padding(horizontal = 8.dp, vertical = 2.dp)
                    ) {
                        Text(
                            text = "Targeting: B1",
                            color = Color.White,
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }

                Text(
                    text = "Last seen online: Yesterday",
                    fontSize = 12.sp,
                    color = secondaryTextColor
                )

                Spacer(modifier = Modifier.height(8.dp))

                // Language badges
                Row(
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    LanguageBadge("English")
                    LanguageBadge("Arabic")
                    LanguageBadge("French")
                }
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth()
                .padding(start = 16.dp, top = 0.dp, end = 16.dp, bottom = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconWithText(iconRes = R.drawable.location, text = "Egypt")
            IconWithText(iconRes = R.drawable.gender, text = "Female")
            IconWithText(iconRes = R.drawable.age, text = "26")
            IconWithText(iconRes = R.drawable.calendar, text = "21 June 2023")
        }
    }
}

@Composable
fun LanguageBadge(text: String) {
    Box(
        modifier = Modifier
            .background(Color(0xFFDFF1F0), shape = RoundedCornerShape(8.dp))
            .padding(horizontal = 8.dp, vertical = 4.dp)
    ) {
        Text(
            text = text,
            fontSize = 10.sp,
            color = Color(0xFF00A99D),
            fontWeight = FontWeight.SemiBold
        )
    }
}

@Composable
fun IconWithText(iconRes: Int, text: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = iconRes),
            contentDescription = null,
            modifier = Modifier.size(16.dp)
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(
            text = text,
            fontSize = 12.sp,
            color = secondaryTextColor
        )
    }
}


@Composable
@Preview
fun ConnectScreenPreview() {
    ConnectScreen()
}