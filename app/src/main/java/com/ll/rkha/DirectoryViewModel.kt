package com.ll.rkha

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class DirectoryViewModel(val dao: DirectoryItemDao) : ViewModel() {
    var newRKHAName = ""

    val directoryItems = dao.getAll()

    fun addDirectoryItem() {
        viewModelScope.launch {
            val directoryItem = DirectoryItem()
            directoryItem.directoryItemName = newRKHAName
            dao.insert(directoryItem)
        }
    }
}