package com.example.booklist.ui.theme.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.booklist.R
import com.example.booklist.ui.theme.textStyleTextAlert
import com.example.booklist.ui.theme.textStyleTitleAlert

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AlertErrorDialog(onBack: () -> Unit) {

    BasicAlertDialog(
        onDismissRequest = {}
    ) {
        Card(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(stringResource(R.string.alert_title), style = textStyleTitleAlert)
                Text(
                    stringResource(R.string.alert_text),
                    style = textStyleTextAlert,
                    modifier = Modifier.padding(top = 16.dp)
                )
                TextButton(onClick = { onBack() }, modifier = Modifier.padding(top = 24.dp)) {
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
                            stringResource(R.string.alert_button),
                            modifier = Modifier.padding(start = 8.dp),
                            color = colorResource(R.color.purple_200)
                        )
                    }

                }
            }
        }
    }
}
