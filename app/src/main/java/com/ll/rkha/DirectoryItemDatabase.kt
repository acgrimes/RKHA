package com.ll.rkha

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [DirectoryItem::class], version = 3, exportSchema = false)
abstract class DirectoryItemDatabase : RoomDatabase() {
    abstract val directoryItemDao: DirectoryItemDao

    companion object {
        @Volatile
        private var INSTANCE: DirectoryItemDatabase? = null

        fun getInstance(context: Context): DirectoryItemDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        DirectoryItemDatabase::class.java,
                        "directory_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}