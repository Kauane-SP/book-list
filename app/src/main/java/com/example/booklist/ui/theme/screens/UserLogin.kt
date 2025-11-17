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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import com.example.booklist.ui.theme.screens.dialog.ResetPasswordDialog
import com.example.booklist.ui.theme.subTitleRegister
import com.example.booklist.ui.theme.textStyleButton
import com.example.booklist.ui.theme.textStyleDefault
import com.example.booklist.ui.theme.titleRegister
import com.example.booklist.ui.theme.viewModel.BookEvents
import com.example.booklist.ui.theme.viewModel.UserAuthViewModel
import org.koin.compose.viewmodel.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserLogin(
    paddingValues: PaddingValues,
    navController: NavController,
    viewModel: UserAuthViewModel = koinViewModel()
) {

    val userModel: UserModel = UserModel()
    val context = LocalContext.current

    var userEmail by remember { mutableStateOf(userModel.email) }
    var userPassword by remember { mutableStateOf(userModel.password) }
    var passwordVisible by remember { mutableStateOf(false) }
    var resetPassword by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        viewModel.authenticationUser.collect { event ->
            when (event) {
                BookEvents.Success -> {
                    Toast.makeText(context, R.string.message_success_login, Toast.LENGTH_SHORT)
                        .show()
                    navController.navigate(R.string.route_home.toString())
                }

                is BookEvents.Error -> {
                    Toast.makeText(context, R.string.message_error_login, Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }
    }

    if (resetPassword) ResetPasswordDialog(onBack = { resetPassword = false })

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
                    "Bem vindo ao Book List",
                    style = titleRegister.copy(color = Color.White)
                )
                Text(
                    "Por favor preencha o login para continuar:",
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

                    Row(
                        Modifier
                            .fillMaxWidth()
                            .padding(top = 24.dp),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        ElevatedButton(
                            modifier = Modifier.fillMaxWidth(),
                            onClick = {
                                viewModel.authenticationUser(
                                    UserModel(
                                        email = userEmail,
                                        password = userPassword
                                    )
                                )
                            }
                        ) {
                            Text(
                                stringResource(R.string.button_login),
                                style = textStyleButton,
                                color = colorResource(R.color.purple_200)
                            )
                        }
                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 24.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text("Esqueceu a senha ?", style = subTitleRegister.copy(color = Color.Gray))

                        ElevatedButton(
                            modifier = Modifier
                                .padding(start = 16.dp)
                                .size(width = 190.dp, height = 30.dp),
                            colors = ButtonDefaults.elevatedButtonColors(
                                containerColor = colorResource(R.color.purple_500)
                            ),
                            onClick = {
                                resetPassword = true
                            }
                        ) {
                            Text(
                                "Resetar minha senha",
                                style = textStyleButton,
                                color = colorResource(R.color.white)
                            )
                        }
                    }

                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text("Não tem uma conta ?", style = subTitleRegister.copy(color = Color.Gray))

                ElevatedButton(
                    modifier = Modifier
                        .padding(start = 16.dp)
                        .size(width = 80.dp, height = 30.dp),
                    colors = ButtonDefaults.elevatedButtonColors(
                        containerColor = colorResource(R.color.purple_500)
                    ),
                    onClick = {
                        navController.navigate(R.string.route_register.toString())
                    }
                ) {
                    Text(
                        stringResource(R.string.button_go_to_register),
                        style = textStyleButton,
                        color = colorResource(R.color.white)
                    )
                }
            }
        }
    }
}