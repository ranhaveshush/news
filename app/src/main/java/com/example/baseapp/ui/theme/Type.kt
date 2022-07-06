package com.example.baseapp.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.example.baseapp.R

val Typography = Typography(
    defaultFontFamily = FontFamily(
        Font(R.font.montserrat_black, FontWeight.Black),
        Font(R.font.montserrat_extra_bold, FontWeight.ExtraBold),
        Font(R.font.montserrat_bold, FontWeight.Bold),
        Font(R.font.montserrat_semi_bold, FontWeight.SemiBold),
        Font(R.font.montserrat_regular, FontWeight.Normal),
        Font(R.font.montserrat_medium, FontWeight.Medium),
        Font(R.font.montserrat_light, FontWeight.Light),
        Font(R.font.montserrat_extra_light, FontWeight.ExtraLight),
        Font(R.font.montserrat_thin, FontWeight.Thin),
    ),
)
