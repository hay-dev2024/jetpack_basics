package com.example.mynoteapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


data class MemoItem(
    val id: Int,
    val title: String,
    val content: String
)

class HomeViewModel : ViewModel() {
    private val _newMemoTitle = MutableStateFlow("")
    val newMemoTitle: StateFlow<String> = _newMemoTitle.asStateFlow()
    private val _newMemoContent = MutableStateFlow("")
    val newMemoContent: StateFlow<String> = _newMemoContent.asStateFlow()
    private val _editMemoTitle = MutableStateFlow("")
    val editMemoTitle: StateFlow<String> = _editMemoTitle.asStateFlow()
    private val _editMemoContent = MutableStateFlow("")
    val editMemoContent: StateFlow<String> = _editMemoContent.asStateFlow()
    private val _isEditing = MutableStateFlow(false)
    val isEditing: StateFlow<Boolean> = _isEditing.asStateFlow()
    private val _memoList = MutableStateFlow<List<MemoItem>>(emptyList())
    val memoList: StateFlow<List<MemoItem>> = _memoList.asStateFlow()


    fun updateNewMemoTitle(newTitle: String) {
        _newMemoTitle.value = newTitle
    }

    fun updateNewMemoContent(newContent: String) {
        _newMemoContent.value = newContent
    }

    fun addMemo() {
        viewModelScope.launch {
            if (_newMemoTitle.value.isNotBlank() && _newMemoContent.value.isNotBlank()) {
                val newId = _memoList.value.size
                _memoList.update { currentList ->
                    currentList + MemoItem(
                        id = newId,
                        title = _newMemoTitle.value,
                        content = _newMemoContent.value
                    )
                }
                _newMemoTitle.value = ""
                _newMemoContent.value = ""
            }
        }
    }

    fun getMemoById(memoId: Int): MemoItem? {
        return _memoList.value.find { it.id == memoId }
    }

    fun deleteMemo(memoId: Int) {
        viewModelScope.launch {
            _memoList.update { currentList ->
                val updatedList = currentList.toMutableList()
                updatedList.removeAll { it.id == memoId }
                updatedList.toList()
            }
        }
    }

    fun startEdit(memo: MemoItem) {
        _editMemoTitle.value = memo.title
        _editMemoContent.value = memo.content
        _isEditing.value = true
    }

    fun cancelEdit() {
        _editMemoTitle.value = ""
        _editMemoContent.value = ""
        _isEditing.value = false
    }

    fun editMemoTitle(newTitle: String) {
        _editMemoTitle.value = newTitle
    }

    fun editMemoContent(newContent: String) {
        _editMemoContent.value = newContent
    }

    fun editMemo(memoId: Int) {
        viewModelScope.launch {
            if (_editMemoTitle.value.isNotBlank() && _editMemoContent.value.isNotBlank()) {
                _memoList.update { currentList ->
                    currentList.map { memo ->
                        if (memo.id == memoId) {
                            memo.copy(
                                title = _editMemoTitle.value,
                                content = editMemoContent.value
                            )
                        } else {
                            memo
                        }

                    }
                }
            }
        }
    }
}