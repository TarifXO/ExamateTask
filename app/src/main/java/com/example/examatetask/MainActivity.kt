package com.example.examatetask

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.examatetask.datastore.DataStoreManager
import com.example.examatetask.ui.theme.ExamateTaskTheme
import com.example.examatetask.view.TutorialViewModel
import com.example.examatetask.view.TutorialViewModelFactory
import com.example.examatetask.view.navigation.NavGraph
import com.example.examatetask.view.navigation.Route

class MainActivity : ComponentActivity() {

    private val startDestination = Route.ExamateNavigation.route
    private lateinit var dataStoreManager: DataStoreManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataStoreManager = DataStoreManager(applicationContext)
        setContent {
            val tutorialViewModel: TutorialViewModel = viewModel(
                factory = TutorialViewModelFactory(dataStoreManager)
            )
            ExamateTaskTheme {
                NavGraph(
                    startDestination = startDestination,
                    dataStoreManager = dataStoreManager,
                    tutorialViewModel = tutorialViewModel
                )
            }
        }
    }
}