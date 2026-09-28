package com.example.isnotempty

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.graphics.toColorInt
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.isnotempty.ui.screens.IsnotemptyApp
import com.example.isnotempty.ui.theme.IsnotemptyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        enableEdgeToEdge(
            //TODO acordate q tu celular esta en modo proteccion de la vista y no se ve igual
            //si en lugar usaramos el .light, el color de el sistema cambia
            //para poder generar contraste con la app
            statusBarStyle = SystemBarStyle.dark(
                scrim = "#FF000000".toColorInt()
                //,darkScrim = "#FFE3CFBA".toColorInt()
            )
        )
        setContent {
            IsnotemptyTheme {
                IsnotemptyApp()
            }
        }
    }
}
