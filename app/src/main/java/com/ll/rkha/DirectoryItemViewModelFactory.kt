package com.ll.rkha

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class DirectoryItemViewModelFactory(private val dao: DirectoryItemDao)
    : ViewModelProvider.Factory {

    override fun <T: ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DirectoryViewModel::class.java)) {
            return DirectoryViewModel(dao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel")
    }
}