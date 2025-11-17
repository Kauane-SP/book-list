package com.example.booklist.ui.theme.screens

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedButton
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.booklist.R
import com.example.booklist.model.UserModel
import com.example.booklist.ui.theme.screens.dialog.AlertDialogBackLogin
import com.example.booklist.ui.theme.subTitleRegister
import com.example.booklist.ui.theme.textStyleButton
import com.example.booklist.ui.theme.textStyleDefault
import com.example.booklist.ui.theme.viewModel.BookEvents
import com.example.booklist.ui.theme.viewModel.UserAuthViewModel
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun UserRegister(
    paddingValues: PaddingValues,
    navController: NavController,
    viewModel: UserAuthViewModel = koinViewModel()
) {

    val userModel: UserModel = UserModel()
    val context = LocalContext.current

    var userEmail by remember { mutableStateOf(userModel.email) }
    var userPassword by remember { mutableStateOf(userModel.password) }
    var passwordVisible by remember { mutableStateOf(false) }
    var backToHome by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        viewModel.registerUserEvent.collect { event ->
            when (event) {
                BookEvents.Success -> {
                    Toast.makeText(
                        context,
                        R.string.message_success_register,
                        Toast.LENGTH_SHORT
                    ).show()
                    backToHome = true
                }

                is BookEvents.Error -> {
                    Toast.makeText(
                        context,
                        R.string.message_error_register,
                        Toast.LENGTH_SHORT
                    ).show()
                    backToHome = false
                }
            }
        }
    }

    if (backToHome) {
        AlertDialogBackLogin({ navController.navigate(R.string.route_login.toString()) })
    }

    Box(
        modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize()
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.3f),
            shape = RoundedCornerShape(
                topStart = 0.dp,
                topEnd = 0.dp,
                bottomStart = 60.dp,
                bottomEnd = 60.dp
            ),
            colors = CardDefaults.cardColors(
                containerColor = colorResource(R.color.purple_200)
            ),
            elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 60.dp, start = 32.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Top
            ) {
                Text(
                    stringResource(R.string.sub_title_user_register),
                    style = subTitleRegister.copy(color = Color.White),
                    modifier = Modifier.padding(top = 16.dp)
                )
            }
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 160.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            Card(
                modifier = Modifier.fillMaxWidth(0.9f),
                shape = RoundedCornerShape(24.dp),
                elevation = CardDefaults.elevatedCardElevation(defaultElevation = 8.dp),
                colors = CardDefaults.cardColors(
                    containerColor = colorResource(R.color.white)
                ),
            ) {

                Column(
                    modifier = Modifier.padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    OutlinedTextField(
                        modifier = Modifier.fillMaxWidth(),
                        label = { Text("email") },
                        value = userEmail,
                        onValueChange = { userEmail = it },
                        singleLine = true,
                        textStyle = textStyleDefault
                    )

                    OutlinedTextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp),
                        label = { Text("password") },
                        value = userPassword,
                        onValueChange = { userPassword = it },
                        singleLine = true,
                        textStyle = textStyleDefault,
                        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                        trailingIcon = {
                            val image = if (passwordVisible)
                                painterResource(R.drawable.baseline_visibility_24)
                            else painterResource(R.drawable.baseline_visibility_off_24)

                            IconButton(onClick = { passwordVisible = !passwordVisible }) {
                                Icon(painter = image, contentDescription = "")
                            }
                        }
                    )

                    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
                        ElevatedButton(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 16.dp),
                            onClick = {
                                viewModel.registerUser(
                                    UserModel(
                                        email = userEmail,
                                        password = userPassword
                                    )
                                )
                            }
                        ) {
                            Text(
                                stringResource(R.string.button_update),
                                style = textStyleButton,
                                color = colorResource(R.color.purple_200),
                                modifier = Modifier.padding(start = 8.dp)
                            )
                        }

                    }
                }
            }
        }
    }
}