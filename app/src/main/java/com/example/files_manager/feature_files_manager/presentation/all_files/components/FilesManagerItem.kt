package com.example.files_manager.feature_files_manager.presentation.all_files.components

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import java.io.File
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import com.example.compose_test.feature_files_manager.domain.util.sizeInMb


@Composable
fun FilesManagerItem(
    file: File,
    modifier: Modifier = Modifier
        .fillMaxWidth()
        .height(16.dp)
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(2.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Card(modifier = modifier) {
            Text(text = if (file.isDirectory) "d" else "f")
            Text(text = file.name)
            Text(text = file.extension)
            Text(text = file.sizeInMb.toString())
        }
    }
}
