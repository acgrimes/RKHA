package com.ll.rkha

import androidx.recyclerview.widget.DiffUtil

class DirectoryDiffItemCallback : DiffUtil.ItemCallback<DirectoryItem>() {

    override fun areItemsTheSame(oldItem: DirectoryItem, newItem: DirectoryItem): Boolean
        = (oldItem.directoryItemId == newItem.directoryItemId)

    override fun areContentsTheSame(oldItem: DirectoryItem, newItem: DirectoryItem): Boolean
        = (oldItem == newItem)
}