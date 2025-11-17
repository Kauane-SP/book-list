package com.example.booklist.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)

val titleRegister = TextStyle (
    fontSize = 24.sp,
    fontStyle = FontStyle.Normal,
    fontWeight = FontWeight.Bold,
    letterSpacing = 1.sp,
    color = Color.DarkGray
)

val subTitleRegister = TextStyle (
    fontSize = 14.sp,
    fontStyle = FontStyle.Normal,
    fontWeight = FontWeight.Medium,
    color = Color.Black
)

val subTitleBook = TextStyle (
    fontSize = 14.sp,
    fontStyle = FontStyle.Normal,
    fontWeight = FontWeight.Medium,
    color = Color.Black
)

val titleAppBar = TextStyle (
    fontSize = 18.sp,
    fontStyle = FontStyle.Normal,
    fontWeight = FontWeight.Bold,
    letterSpacing = 1.sp,
    color = Color.White
)

val titleItemBook = TextStyle (
    fontSize = 18.sp,
    fontStyle = FontStyle.Normal,
    fontWeight = FontWeight.Bold,
    color = Color.DarkGray
)

val textStyleBookDefault = TextStyle (
    fontSize = 12.sp,
    fontStyle = FontStyle.Normal,
    fontWeight = FontWeight.Medium,
    color = Color.LightGray
)
val textStyleDefault = TextStyle (
    fontSize = 12.sp,
    fontStyle = FontStyle.Normal,
    fontWeight = FontWeight.Medium,
    color = Color.Black
)

val textStyleTitleAlert = TextStyle (
    fontSize = 16.sp,
    fontStyle = FontStyle.Normal,
    fontWeight = FontWeight.Normal,
    color = Color.Black
)

val textStyleTextAlert = TextStyle (
    fontSize = 12.sp,
    fontStyle = FontStyle.Normal,
    fontWeight = FontWeight.Normal,
    color = Color.DarkGray
)

val textStyleButton = TextStyle (
    fontSize = 12.sp,
    fontStyle = FontStyle.Normal,
    fontWeight = FontWeight.Medium,
)

val textStyleSinopse = TextStyle (
    fontSize = 12.sp,
    fontStyle = FontStyle.Normal,
    fontWeight = FontWeight.Medium,
    color = Color.Black,
    letterSpacing = 0.5.sp,
    lineHeight = 20.sp
)