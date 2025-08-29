package com.example.mytodolist.todoscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


data class TodoItem(
    val todo: String,
    val isChecked: Boolean = false
)

class TodoViewModel: ViewModel() {

    private val _newItem = MutableStateFlow("")
    val newItem: StateFlow<String> = _newItem.asStateFlow()
    private val _toDoList = MutableStateFlow<List<TodoItem>>(emptyList())
    val toDoList: StateFlow<List<TodoItem>> = _toDoList.asStateFlow()

    fun updateNewItem(newItem: String) {
          _newItem.value = newItem
    }

    fun addTodo() {
        viewModelScope.launch {
            if (_newItem.value.isNotBlank()) {
                val newItem = TodoItem(todo = _newItem.value)
                _toDoList.update { currentList ->
                    currentList + newItem }
                _newItem.value = ""
            }
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

    fun toggleChecked(itemToggled: TodoItem) {
        _toDoList.update { currentList ->
            currentList.map { item ->
                if (item == itemToggled) {
                    item.copy(isChecked = !item.isChecked)
                } else {
                    item
                }
            }
        }
    }
}
