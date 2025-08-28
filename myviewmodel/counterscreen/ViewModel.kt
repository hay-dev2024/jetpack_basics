package com.example.myviewmodel.counterscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

// StateFlow 사용
//class CounterViewModel: ViewModel() {
//    private val _counter = MutableStateFlow(0)
//    val counter: StateFlow<Int> = _counter.asStateFlow()
//
//    fun incrementCounter() {
//        viewModelScope.launch {
//            _counter.value += 1
//        }
//    }
//    fun decrementCounter() {
//        viewModelScope.launch {
//            _counter.value -= 1
//        }
//    }
//    fun resetCounter() {
//        viewModelScope.launch {
//            _counter.value = 0
//        }
//    }
//}