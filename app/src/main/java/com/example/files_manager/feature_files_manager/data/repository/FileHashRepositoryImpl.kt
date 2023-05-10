package com.example.compose_test.feature_files_manager.data.repository

import com.example.compose_test.feature_files_manager.data.data_source.FileHashDao
import com.example.compose_test.feature_files_manager.domain.models.FileHash
import com.example.compose_test.feature_files_manager.domain.repository.FileHashRepository
import kotlinx.coroutines.flow.Flow

class FileHashRepositoryImpl(private val dao: FileHashDao): FileHashRepository {
    override fun getFilesHashes(): Flow<List<FileHash>> = dao.getFilesHashes()
    override suspend fun insertFileHash(fileHash: FileHash) = dao.insertFileHash(fileHash)
    override suspend fun deleteFileHash(fileHash: FileHash) = dao.deleteFileHash(fileHash)
}
