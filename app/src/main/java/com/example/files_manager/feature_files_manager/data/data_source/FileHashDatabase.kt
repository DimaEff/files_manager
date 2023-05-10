package com.example.compose_test.feature_files_manager.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.compose_test.feature_files_manager.domain.models.FileHash

@Database(entities = [FileHash::class], version = 1)
abstract class FileHashDatabase : RoomDatabase() {
    abstract val fileHash: FileHashDao
}