package com.example.compose_test.feature_files_manager.domain.use_case

import com.example.compose_test.feature_files_manager.domain.models.FileHash
import com.example.compose_test.feature_files_manager.domain.repository.FileHashRepository
import com.example.compose_test.feature_files_manager.domain.util.FilesOrder
import com.example.compose_test.feature_files_manager.domain.util.OrderType
import java.io.File

class RunIndexingChangedFiles(
    private val repository: FileHashRepository
) {
    suspend operator fun invoke(): Collection<File> {
        val changedFiles = mutableListOf<File>()
        File("/data").walkTopDown().forEach {
            val filePath = it.absolutePath
            val fileHash = getFileBodyHash(it)

            val previousFileHash = repository.getFileHashByPath(filePath)?.hash

            if (fileHash != previousFileHash) {
                repository.insertFileHash(FileHash(filePath, fileHash))
                changedFiles.add(it)
            }
        }

        return changedFiles
    }

    private fun getFileBodyHash(file: File): Int = file.bufferedReader().readText().hashCode()
}
