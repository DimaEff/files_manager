package com.example.compose_test.feature_files_manager.domain.util

sealed class FilesOrder(val orderType: OrderType) {
    class Size(orderType: OrderType): FilesOrder(orderType)
    class Date(orderType: OrderType): FilesOrder(orderType)
    class Extension(orderType: OrderType): FilesOrder(orderType)
}
