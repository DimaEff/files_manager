package com.example.files_manager.feature_files_manager.presentation.all_files

import com.example.compose_test.feature_files_manager.domain.util.FilesOrder
import com.example.compose_test.feature_files_manager.domain.util.OrderType

sealed class AllFilesEvent {
    data class Ordering(val filesOrder: FilesOrder): AllFilesEvent()
//    data class ChangeOrderType(val orderType: OrderType): AllFilesEvent()
    data class FolderSelecting(val path: String): AllFilesEvent()
}
