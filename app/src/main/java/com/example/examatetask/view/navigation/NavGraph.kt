package com.example.examatetask.view.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.example.examatetask.datastore.DataStoreManager
import com.example.examatetask.view.TutorialViewModel

@Composable
fun NavGraph(
    startDestination: String,
    tutorialViewModel: TutorialViewModel,
    dataStoreManager: DataStoreManager
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {

        navigation(
            startDestination = Route.ExamateNavigator.route,
            route = Route.ExamateNavigation.route
        ) {
            composable(Route.ExamateNavigator.route) {
                ExamateNavigator(tutorialViewModel)
            }
        }
    }
}