package com.example.examatetask.view.navigation

sealed class Route(val route: String) {

    data object ExamateNavigation : Route("examateNavigation")
    data object ExamateNavigator : Route("examateNavigator")
    data object Home : Route("home")
    data object Connect : Route("writingTask")
    data object Questions : Route("questions")
    data object Tools : Route("tools")
    data object Profile : Route("profile")
}