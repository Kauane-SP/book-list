package com.example.booklist.ui.theme.screens

import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import com.example.booklist.R

@Composable
fun InitInlineEditableField(
    valueLabel: String,
    valueText: String,
    valueStyle: TextStyle,
    onValueChange: (String) -> Unit,
    isEditable: Boolean
) {
    var showEdit by remember { mutableStateOf(false) }

    Row {
        if (!showEdit && !isEditable) {
            Text(text = valueText, style = valueStyle)
        } else {
            OutlinedTextField(
                value = valueText,
                onValueChange = {
                    onValueChange(it)
                },
                label = { Text(valueLabel) },
                singleLine = false,
                modifier = Modifier.weight(1f),
                trailingIcon = {
                    IconButton(
                        onClick = {
                            showEdit = false
                        }
                    ) {
                        Icon(
                            Icons.Default.Edit,
                            contentDescription = stringResource(R.string.button_save)
                        )
                    }
                }
            )
        }
    }
}
