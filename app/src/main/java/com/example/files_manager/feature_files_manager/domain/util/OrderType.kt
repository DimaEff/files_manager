package com.example.compose_test.feature_files_manager.domain.util

sealed class OrderType {
    object Ascending: OrderType()
    object Descending: OrderType()
}
