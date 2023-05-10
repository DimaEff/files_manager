package com.example.files_manager.feature_files_manager.presentation.all_files

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.compose_test.feature_files_manager.domain.util.FilesOrder
import com.example.files_manager.feature_files_manager.domain.use_case.FilesManagerUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import java.io.File
import javax.inject.Inject

@HiltViewModel
class AllFilesViewModel @Inject constructor(
    private val filesManagerUseCases: FilesManagerUseCases
) : ViewModel() {
    private val _state = mutableStateOf(AllFilesState())
    val state: State<AllFilesState> = _state

//    init {
//        val path = "/data"
//        getFilesAndOrder(path)
//    }

    fun onEvent(event: AllFilesEvent) {
        when (event) {
            is AllFilesEvent.Ordering -> {
                if (checkIsOrderTypeChanged(state.value.filesOrder, event.filesOrder)) {
                    return
                }

                orderFiles(state.value.orderedFiles, event.filesOrder)
            }
            is AllFilesEvent.FolderSelecting -> getFilesAndOrder(event.path)
        }
    }

    private fun getFilesAndOrder(path: String) {
        val files = filesManagerUseCases.getFilesByPath(path)
        orderFiles(files ?: emptyList(), state.value.filesOrder)
    }

    private fun orderFiles(files: Collection<File>, filesOrder: FilesOrder) {
        val orderedFiles = filesManagerUseCases.orderingFiles(files, filesOrder)
        _state.value = state.value.copy(
            orderedFiles = orderedFiles
        )
    }

    private fun checkIsOrderTypeChanged(
        stateFilesOrder: FilesOrder,
        eventFilesOrder: FilesOrder
    ): Boolean =
        stateFilesOrder::class == eventFilesOrder::class && stateFilesOrder.orderType == eventFilesOrder.orderType
}