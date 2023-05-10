package com.example.files_manager.feature_files_manager.presentation.all_files

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.files_manager.feature_files_manager.presentation.all_files.components.FilesManagerItem
import com.example.files_manager.feature_files_manager.presentation.all_files.components.OrderSection
import java.io.File

@Composable
fun AllFilesScreen(
    navController: NavController,
    viewModel: AllFilesViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    val scaffoldState = rememberScrollState()
    val scope = rememberCoroutineScope()

    Scaffold(
        bottomBar = {
            BottomAppBar() {
                Icon(Icons.Default.List, contentDescription = "List of files")
                Icon(Icons.Default.Search, contentDescription = "ChangedFiles")
            }
        }
    ) {
        OrderSection(onOrderChange = { viewModel.onEvent(AllFilesEvent.Ordering(it)) })
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(state.orderedFiles as List<File>) { file ->
                FilesManagerItem(file = file)
            }
        }
    }
}