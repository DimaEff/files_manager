package com.example.compose_test.feature_files_manager.domain.use_case

import java.io.File

class GetFilesByPath {
    operator fun invoke(path: String): List<File>? = File(path).listFiles()?.toList()
}
