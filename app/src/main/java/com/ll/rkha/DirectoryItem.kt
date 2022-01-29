package com.ll.rkha

import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "directory_table")
data class DirectoryItem(

    @PrimaryKey(autoGenerate = true)
    var directoryItemId: Long = 0L,

    @ColumnInfo(name = "task_name")
    var directoryItemName: String = "",

    @ColumnInfo(name = "task_done")
    var lotNumber: Long = 10L

)