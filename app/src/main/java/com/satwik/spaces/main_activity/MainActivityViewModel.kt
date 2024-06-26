package com.satwik.spaces.main_activity

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainActivityViewModel:ViewModel() {

    private val _isReady = MutableStateFlow(false)
    val isReady = _isReady.asStateFlow()

    init {
        viewModelScope.launch {
            /*
            * Adding this delay because i am not able to identify
            * the long running task on  main thread which is causing blank screen issue.
            */
            delay(1000)
            _isReady.value = true
        }
    }
}