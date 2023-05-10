package com.example.compose_test.feature_files_manager.data.data_source

import androidx.room.*
import com.example.compose_test.feature_files_manager.domain.models.FileHash

@Dao
interface FileHashDao {
    @Query("SELECT * FROM filehash WHERE path = :path")
    fun getFileHashByPath(path: String): FileHash?

    @Insert(onConflict = OnConflictStrategy.REPLACE, )
    suspend fun insertFileHash(fileHash: FileHash): Unit

    @Delete
    suspend fun deleteFileHash(fileHash: FileHash): Unit
}