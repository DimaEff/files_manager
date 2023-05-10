package com.example.compose_test.feature_files_manager.domain.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class FileHash(
    @PrimaryKey
    val path: String,
    val hash: Int
)
