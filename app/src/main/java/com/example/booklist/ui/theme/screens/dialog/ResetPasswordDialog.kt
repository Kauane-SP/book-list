package com.example.booklist.ui.theme.screens.dialog

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.booklist.R
import com.example.booklist.model.UserModel
import com.example.booklist.ui.theme.subTitleRegister
import com.example.booklist.ui.theme.textStyleButton
import com.example.booklist.ui.theme.textStyleDefault
import com.example.booklist.ui.theme.viewModel.BookEvents
import com.example.booklist.ui.theme.viewModel.UserAuthViewModel
import org.koin.compose.viewmodel.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ResetPasswordDialog(onBack: () -> Unit, viewModel: UserAuthViewModel = koinViewModel()) {

    val userModel: UserModel = UserModel()
    val context = LocalContext.current
    var userEmail by remember { mutableStateOf(userModel.email) }

    LaunchedEffect(Unit) {
        viewModel.resetUserPassword.collect {
            when (it) {
                BookEvents.Success -> {
                    Toast.makeText(
                        context,
                        "Tudo pronto, dentro de instantes chegará um email com as instruçoes",
                        Toast.LENGTH_LONG
                    ).show()
                }

                is BookEvents.Error -> {
                    Toast.makeText(
                        context,
                        "Ocorreu algum erro, tente novamente !",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

    BasicAlertDialog(
        onDismissRequest = {
            onBack
        }
    ) {
        Card(modifier = Modifier.padding(24.dp)) {
            Column(
                modifier = Modifier.padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                IconButton(
                    onClick = onBack
                ) {
                    Icon(
                        imageVector = Icons.Filled.Clear,
                        contentDescription = "Fechar",
                        tint = colorResource(R.color.purple_200)
                    )
                }
                Text("Digite o seu email", style = subTitleRegister)
                Text(
                    "Neste email iremos enviar as informações para criar uma nova senha:",
                    style = textStyleDefault,
                    modifier = Modifier.padding(top = 16.dp)
                )

                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth().padding(top = 16.dp),
                    label = { Text("email") },
                    value = userEmail,
                    onValueChange = { userEmail = it },
                    singleLine = true,
                    textStyle = textStyleDefault
                )

                ElevatedButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp),
                    onClick = {
                        viewModel.resetPassword(email = userEmail)
                    }
                ) {
                    Text(
                        "Enviar",
                        style = textStyleButton,
                        color = colorResource(R.color.purple_200),
                        modifier = Modifier.padding(start = 8.dp)
                    )
                }
            }
        }
    }
}