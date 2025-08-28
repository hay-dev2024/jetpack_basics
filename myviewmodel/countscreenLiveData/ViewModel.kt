package com.example.myviewmodel.countscreenLiveData

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

// LiveData 사용
class CounterViewModel: ViewModel() {
    private val _counter = MutableLiveData(0)
    val counter: LiveData<Int> get() = _counter


    fun incrementCounter() {
        _counter.value = (_counter.value ?: 0) + 1
    }
    fun decrementCounter() {
        _counter.value = (_counter.value ?: 0) - 1
    }
    fun resetCounter() {
        _counter.value = 0
    }
}