package com.ll.rkha

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface BaseDao<T> {
    @Insert
    suspend fun insert(directoryItem: DirectoryItem)

    @Update
    suspend fun update(directoryItem: DirectoryItem)

    @Delete
    suspend fun delete(directoryItem: DirectoryItem)
}

@Dao
interface DirectoryItemDao : BaseDao<DirectoryItem> {
    @Query("SELECT * FROM directory_table WHERE directoryItemId = :key")
    fun get(key: Long): LiveData<DirectoryItem>

    @Query("SELECT * FROM directory_table ORDER BY directoryItemId DESC")
    fun getAll(): LiveData<List<DirectoryItem>>
}