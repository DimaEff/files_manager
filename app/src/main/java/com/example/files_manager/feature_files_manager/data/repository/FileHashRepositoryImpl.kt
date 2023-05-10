package com.example.compose_test.feature_files_manager.data.repository

import com.example.compose_test.feature_files_manager.data.data_source.FileHashDao
import com.example.compose_test.feature_files_manager.domain.models.FileHash
import com.example.compose_test.feature_files_manager.domain.repository.FileHashRepository

class FileHashRepositoryImpl(private val dao: FileHashDao) : FileHashRepository {
    override fun getFileHashByPath(path: String): FileHash? = dao.getFileHashByPath(path)
    override suspend fun insertFileHash(fileHash: FileHash) = dao.insertFileHash(fileHash)
    override suspend fun deleteFileHash(fileHash: FileHash) = dao.deleteFileHash(fileHash)
}
