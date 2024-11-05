package com.example.examatetask.view.navigation

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.examatetask.R
import com.example.examatetask.ui.theme.backgroundColor
import com.example.examatetask.ui.theme.disabledTextColor
import com.example.examatetask.ui.theme.primaryColor

@Composable
fun BottomNavBar(
    items: List<BottomNavigationItem>,
    selected: Int,
    onItemClick: (Int) -> Unit
) {
    NavigationBar(
        modifier = Modifier
            .shadow(6.dp),
        containerColor = backgroundColor
    ) {
        items.forEachIndexed { index, item ->
            val isSelected = index == selected
            val iconRes = if (isSelected) item.selectedIcon else item.icon
            NavigationBarItem(
                selected = isSelected,
                onClick = { onItemClick(index) },
                icon = {
                    Column(
                        horizontalAlignment = CenterHorizontally,
                        modifier = Modifier
                            .width(60.dp)
                    ) {
                        Image(
                            painter = painterResource(id = iconRes),
                            contentDescription = null,
                            modifier = Modifier
                                .size(30.dp)
                        )

                        Spacer(modifier = Modifier.height(4.dp))

                        Text(
                            modifier = Modifier
                                .fillMaxWidth()
                                .align(CenterHorizontally),
                            text = item.title,
                            fontSize = 12.sp,
                            textAlign = TextAlign.Center,
                            maxLines = 1,
                            fontWeight = FontWeight.Bold,
                            overflow = TextOverflow.Visible,
                            color = if (isSelected) primaryColor else disabledTextColor
                        )
                    }
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = primaryColor,
                    unselectedIconColor = Color.White,
                    indicatorColor = backgroundColor
                )
            )
        }
    }
}

data class BottomNavigationItem(
    @DrawableRes val icon: Int,
    @DrawableRes val selectedIcon: Int,
    val title: String
)

@Composable
@Preview
fun BottomNavBarPreview() {
    BottomNavBar(
        items = listOf(
            BottomNavigationItem(icon = R.drawable.home_unselected, selectedIcon = R.drawable.home, title = "Home"),
            BottomNavigationItem(icon = R.drawable.connect_unselected, selectedIcon = R.drawable.connect, title = "Connect"),
            BottomNavigationItem(icon = R.drawable.questions_unselected, selectedIcon = R.drawable.questions, title = "Questions"),
            BottomNavigationItem(icon = R.drawable.tools_unselecetd, selectedIcon = R.drawable.tools, title = "Tools"),
            BottomNavigationItem(icon = R.drawable.profile_unselected, selectedIcon = R.drawable.profile, title = "Profile")
        ),
        selected = 0,
        onItemClick = {}
    )
}