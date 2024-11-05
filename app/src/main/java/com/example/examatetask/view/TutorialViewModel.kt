package com.example.examatetask.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.examatetask.datastore.DataStoreManager
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class TutorialViewModel(private val dataStoreManager: DataStoreManager) : ViewModel() {

    private val _currentStep = MutableStateFlow(0)
    val currentStep: StateFlow<Int> = _currentStep

    init {
        viewModelScope.launch {
            dataStoreManager.tutorialShown.collect { shown ->
                if (!shown) {
                    _currentStep.value = 1
                    // Set the tutorial shown flag to true as soon as the tutorial starts
                    dataStoreManager.setTutorialShown(true)
                }
            }
        }
    }

    fun nextStep() {
        _currentStep.value += 1
    }

    fun skipTutorial() {
        _currentStep.value = 0
        viewModelScope.launch {
            dataStoreManager.setTutorialShown(true)
        }
    }
}