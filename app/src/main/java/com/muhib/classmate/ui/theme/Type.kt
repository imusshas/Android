package com.muhib.classmate.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.googlefonts.GoogleFont
import com.muhib.classmate.R

val provider = GoogleFont.Provider(
    providerAuthority = "com.google.android.gms.fonts",
    providerPackage = "com.google.android.gms",
    certificates = R.array.com_google_android_gms_fonts_certs
)
val fontName = GoogleFont("Roboto Slab")

val RobotoSlab = FontFamily(
    Font(googleFont = fontName, fontProvider = provider)
)

// Set of Material typography styles to start with

val RobotoSlabTypography = Typography(
    displayLarge = TextStyle(fontFamily = RobotoSlab),
    displayMedium = TextStyle(fontFamily = RobotoSlab),
    displaySmall = TextStyle(fontFamily = RobotoSlab),

    headlineLarge = TextStyle(fontFamily = RobotoSlab),
    headlineMedium = TextStyle(fontFamily = RobotoSlab),
    headlineSmall = TextStyle(fontFamily = RobotoSlab),

    titleLarge = TextStyle(fontFamily = RobotoSlab),
    titleMedium = TextStyle(fontFamily = RobotoSlab),
    titleSmall = TextStyle(fontFamily = RobotoSlab),

    bodyLarge = TextStyle(fontFamily = RobotoSlab),
    bodyMedium = TextStyle(fontFamily = RobotoSlab),
    bodySmall = TextStyle(fontFamily = RobotoSlab),

    labelLarge = TextStyle(fontFamily = RobotoSlab),
    labelMedium = TextStyle(fontFamily = RobotoSlab),
    labelSmall = TextStyle(fontFamily = RobotoSlab),
)