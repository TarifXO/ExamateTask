package com.example.examatetask.view.navigation

import com.example.examatetask.view.components.TutorialOverlay
import com.example.examatetask.view.screens.QuestionsScreen
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.examatetask.R
import com.example.examatetask.view.TutorialViewModel
import com.example.examatetask.view.screens.ConnectScreen
import com.example.examatetask.view.screens.HomeScreen
import com.example.examatetask.view.screens.ProfileScreen
import com.example.examatetask.view.screens.ToolsScreen

@Composable
fun ExamateNavigator(
    tutorialViewModel: TutorialViewModel
) {
    // Remember the NavController
    val navController = rememberNavController()

    // Get the current back stack entry
    val backstackState = navController.currentBackStackEntryAsState().value

    // Track the selected item in the bottom navigation bar
    var selectedItem by rememberSaveable { mutableIntStateOf(0) }
    selectedItem = remember(backstackState) {
        when (backstackState?.destination?.route) {
            Route.Home.route -> 0
            Route.Connect.route -> 1
            Route.Questions.route -> 2
            Route.Tools.route -> 3
            Route.Profile.route -> 4
            else -> 0
        }
    }

    // Determine if the bottom bar should be visible
    val isBottomBarVisible = remember(key1 = backstackState) {
        backstackState?.destination?.route == Route.Home.route ||
                backstackState?.destination?.route == Route.Connect.route ||
                backstackState?.destination?.route == Route.Questions.route ||
                backstackState?.destination?.route == Route.Tools.route ||
                backstackState?.destination?.route == Route.Profile.route
    }

    // Scaffold layout with bottom navigation bar
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            AnimatedVisibility(
                visible = isBottomBarVisible,
                enter = fadeIn(),
                exit = fadeOut()
            ) {
                BottomNavBar(
                    items = listOf(
                        BottomNavigationItem(
                            icon = R.drawable.home_unselected,
                            selectedIcon = R.drawable.home,
                            title = "Home"
                        ),
                        BottomNavigationItem(
                            icon = R.drawable.connect_unselected,
                            selectedIcon = R.drawable.connect,
                            title = "Connect"
                        ),
                        BottomNavigationItem(
                            icon = R.drawable.questions_unselected,
                            selectedIcon = R.drawable.questions,
                            title = "Questions"
                        ),
                        BottomNavigationItem(
                            icon = R.drawable.tools_unselecetd,
                            selectedIcon = R.drawable.tools,
                            title = "Tools"
                        ),
                        BottomNavigationItem(
                            icon = R.drawable.profile_unselected,
                            selectedIcon = R.drawable.profile,
                            title = "Profile"
                        )
                    ),
                    selected = selectedItem,
                    onItemClick = { index ->
                        when (index) {
                            0 -> navigateToTab(navController, Route.Home.route)
                            1 -> navigateToTab(navController, Route.Connect.route)
                            2 -> navigateToTab(navController, Route.Questions.route)
                            3 -> navigateToTab(navController, Route.Tools.route)
                            4 -> navigateToTab(navController, Route.Profile.route)
                        }
                    }
                )
            }
        }
    ) { innerPadding ->
        // Navigation host for managing navigation between screens
        NavHost(
            navController = navController,
            startDestination = Route.Home.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(route = Route.Home.route) {
                HomeScreen()
            }
            composable(route = Route.Connect.route) {
                ConnectScreen()
            }
            composable(route = Route.Questions.route) {
                QuestionsScreen()
            }
            composable(route = Route.Tools.route) {
                ToolsScreen()
            }
            composable(route = Route.Profile.route) {
                ProfileScreen()
            }
        }

        // Collect the current step of the tutorial
        val currentStep by tutorialViewModel.currentStep.collectAsState()
        if (currentStep > 0) {
            // Show the tutorial overlay if the tutorial is active
            TutorialOverlay(
                currentStep = currentStep,
                onNextStep = { tutorialViewModel.nextStep() },
                onSkip = { tutorialViewModel.skipTutorial() }
            )
        }
    }
}

// Function to navigate to a specific tab
private fun navigateToTab(navController: NavController, route: String) {
    navController.navigate(route) {
        navController.graph.startDestinationRoute?.let { homeScreen ->
            popUpTo(homeScreen) {
                saveState = true
            }
            restoreState = true
            launchSingleTop = true
        }
    }
}