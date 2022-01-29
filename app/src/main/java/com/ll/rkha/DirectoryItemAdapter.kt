package com.ll.rkha

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ll.rkha.databinding.DirectoryItemBinding

class DirectoryItemAdapter( val clickListener: (directoryItemIt: Long) -> Unit)
        : ListAdapter<DirectoryItem, DirectoryItemAdapter.DirectoryItemViewHolder>(DirectoryDiffItemCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            : DirectoryItemViewHolder = DirectoryItemViewHolder.inflateFrom(parent)

    override fun onBindViewHolder(holder: DirectoryItemViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item, clickListener)
    }

    class DirectoryItemViewHolder( val binding : DirectoryItemBinding)
        : RecyclerView.ViewHolder(binding.root) {

        companion object {
            fun inflateFrom(parent: ViewGroup): DirectoryItemViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = DirectoryItemBinding
                    .inflate(layoutInflater, parent, false)
                return DirectoryItemViewHolder(binding)
            }
        }

        fun bind(item: DirectoryItem, clickListener: (directoryItemId: Long) -> Unit) {
            binding.directoryItem = item
            binding.root.setOnClickListener {
                clickListener(item.directoryItemId)
            }
        }
    }
}