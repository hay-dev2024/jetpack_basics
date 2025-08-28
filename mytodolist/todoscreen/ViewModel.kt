package com.example.mytodolist.todoscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class TodoViewModel: ViewModel() {

    private val _newItem = MutableStateFlow("")
    val newItem: StateFlow<String> = _newItem.asStateFlow()

    private val _toDoList = MutableStateFlow<List<String>>(emptyList())
    val toDoList: StateFlow<List<String>> = _toDoList.asStateFlow()

    fun updateNewItem(newItem: String) {
          _newItem.value = newItem
    }

    // 코루틴 이용하기
    fun addTodo() {
        viewModelScope.launch {
            _toDoList.update { currentList ->
                currentList + _newItem.value
            }
            _newItem.value = ""
        }
    }

    fun deleteTodo(index: Int) {
        viewModelScope.launch {
            _toDoList.update { currentList ->
                val updatedList = currentList.toMutableList().apply {
                    if (index in indices) removeAt(index)
                }
                updatedList
            }
        }
    }
}
