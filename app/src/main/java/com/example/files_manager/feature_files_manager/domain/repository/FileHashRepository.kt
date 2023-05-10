package com.example.compose_test.feature_files_manager.domain.repository

import com.example.compose_test.feature_files_manager.domain.models.FileHash
import kotlinx.coroutines.flow.Flow

interface FileHashRepository {
    fun getFilesHashes(): Flow<List<FileHash>>
    suspend fun insertFileHash(fileHash: FileHash): Unit
    suspend fun deleteFileHash(fileHash: FileHash): Unit
}