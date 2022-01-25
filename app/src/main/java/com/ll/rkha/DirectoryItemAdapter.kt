package com.ll.rkha

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class DirectoryItemAdapter : RecyclerView.Adapter<DirectoryItemAdapter.DirectoryItemViewHolder>() {
    var data = listOf<DirectoryItem>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount() = data.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            : DirectoryItemViewHolder = DirectoryItemViewHolder.inflateFrom(parent)

    override fun onBindViewHolder(holder: DirectoryItemViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item)
    }

    class DirectoryItemViewHolder(val rootView: CardView)
        : RecyclerView.ViewHolder(rootView) {
        val directoryItemName = rootView.findViewById<TextView>(R.id.last_name)
        val lotNumber = rootView.findViewById<TextView>(R.id.lot_number)

        companion object {
            fun inflateFrom(parent: ViewGroup): DirectoryItemViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater
                    .inflate(R.layout.directory_item, parent, false) as CardView
                return DirectoryItemViewHolder(view)
            }
        }

        fun bind(item: DirectoryItem) {
            directoryItemName.text = item.directoryItemName
            lotNumber.text = item.lotNumber.toString()
        }
    }
}