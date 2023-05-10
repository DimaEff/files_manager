package com.example.files_manager.feature_files_manager.domain.use_case

import com.example.compose_test.feature_files_manager.domain.use_case.GetFilesByPath
import com.example.compose_test.feature_files_manager.domain.use_case.OrderFiles
import com.example.compose_test.feature_files_manager.domain.use_case.RunIndexingChangedFiles

data class FilesManagerUseCases(
    val  getFilesByPath: GetFilesByPath,
    val orderingFiles: OrderFiles,
    val runIndexingChangedFiles: RunIndexingChangedFiles,
)
