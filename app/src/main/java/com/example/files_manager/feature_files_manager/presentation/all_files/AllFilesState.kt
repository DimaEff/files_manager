package com.example.files_manager.feature_files_manager.presentation.all_files

import com.example.compose_test.feature_files_manager.domain.util.FilesOrder
import com.example.compose_test.feature_files_manager.domain.util.OrderType
import java.io.File

data class AllFilesState(
    val orderedFiles: Collection<File> = emptyList(),
    val filesOrder: FilesOrder = FilesOrder.Date(OrderType.Descending),
)
