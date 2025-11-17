package com.example.booklist.ui.theme.screens.dialog

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.booklist.R
import com.example.booklist.ui.theme.textStyleTitleAlert

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AlertDialogBackLogin(onBack: () -> Unit) {
    BasicAlertDialog(
        onDismissRequest = {}
    ) {
        Card(
            modifier = Modifier
                .padding(24.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                Text(
                    stringResource(R.string.message_success_register),
                    style = textStyleTitleAlert,
                    modifier = Modifier.padding(top = 14.dp)
                )
            }
            TextButton(onClick = {
                onBack()
            }, modifier = Modifier.padding(16.dp)) {
                Row(
                    horizontalArrangement = Arrangement.End,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Icon(
                        painter = painterResource(R.drawable.undo_24px),
                        contentDescription = "",
                        tint = colorResource(R.color.purple_200)
                    )
                    Text(
                        stringResource(R.string.alert_button_register),
                        modifier = Modifier.padding(start = 8.dp),
                        color = colorResource(R.color.purple_200)
                    )
                }
            }
        }
    }
}