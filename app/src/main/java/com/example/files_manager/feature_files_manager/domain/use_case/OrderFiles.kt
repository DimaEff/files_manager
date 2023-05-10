package com.example.compose_test.feature_files_manager.domain.use_case

import com.example.compose_test.feature_files_manager.domain.util.FilesOrder
import com.example.compose_test.feature_files_manager.domain.util.OrderType
import com.example.compose_test.feature_files_manager.domain.util.size
import java.io.File

class OrderFiles {
    operator fun invoke(
        files: Collection<File>,
        filesOrder: FilesOrder = FilesOrder.Size(OrderType.Descending)
    ): List<File> {
        return when(filesOrder) {
            is FilesOrder.Size -> sortByOrderAndProperty(files, filesOrder.orderType) { it.size }
            is FilesOrder.Date -> sortByOrderAndProperty(files, filesOrder.orderType) { it.lastModified() }
            is FilesOrder.Extension -> sortByOrderAndProperty(files, filesOrder.orderType) { it.extension }
        }
    }

    private fun <T : Comparable<T>>sortByOrderAndProperty(files: Collection<File>, orderType: OrderType, selector: (File) -> T) = when(orderType) {
        is OrderType.Ascending -> files.sortedBy(selector)
        is OrderType.Descending -> files.sortedByDescending(selector)
    }
}
