package com.example.files_manager.feature_files_manager.presentation.all_files.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.compose_test.feature_files_manager.domain.util.FilesOrder
import com.example.compose_test.feature_files_manager.domain.util.OrderType

@Composable
fun OrderSection(
    modifier: Modifier = Modifier,
    filesOrder: FilesOrder = FilesOrder.Date(OrderType.Descending),
    onOrderChange: (FilesOrder) -> Unit
) {
    Column(
        modifier = modifier
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            DefaultRadioButton(
                text = "Size",
                selected = filesOrder is FilesOrder.Size,
                onSelect = { onOrderChange(FilesOrder.Size(filesOrder.orderType)) }
            )
            Spacer(modifier = Modifier.width(8.dp))
            DefaultRadioButton(
                text = "Date",
                selected = filesOrder is FilesOrder.Date,
                onSelect = { onOrderChange(FilesOrder.Date(filesOrder.orderType)) }
            )
            Spacer(modifier = Modifier.width(8.dp))
            DefaultRadioButton(
                text = "Extension",
                selected = filesOrder is FilesOrder.Extension,
                onSelect = { onOrderChange(FilesOrder.Extension(filesOrder.orderType)) }
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            IconButton(onClick = { /*TODO*/ }) {
                val buttonText = when (filesOrder.orderType) {
                    is OrderType.Ascending -> "↓"
                    is OrderType.Descending -> "↑"
                }
                Text(text = buttonText, style = MaterialTheme.typography.bodySmall)
            }
            DefaultRadioButton(
                text = "Ascending",
                selected = filesOrder.orderType is OrderType.Ascending,
                onSelect = {
                    onOrderChange(filesOrder.copy(OrderType.Ascending))
                }
            )
            Spacer(modifier = Modifier.width(8.dp))
            DefaultRadioButton(
                text = "Descending",
                selected = filesOrder.orderType is OrderType.Descending,
                onSelect = {
                    onOrderChange(filesOrder.copy(OrderType.Descending))
                }
            )
        }
    }
}