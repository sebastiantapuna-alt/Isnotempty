package com.example.isnotempty.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import android.widget.Toast
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.ui.platform.LocalContext
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.isnotempty.R
import com.example.isnotempty.ui.components.BotonPersonalizado
import com.example.isnotempty.ui.components.ContadorCard
import com.example.isnotempty.ui.components.EntradaTextoField
import com.example.isnotempty.ui.theme.IsnotemptyTheme
import com.example.isnotempty.ui.theme.TemaColor
import com.example.isnotempty.ui.theme.obtenerTema

@Composable
fun Greeting3(name: String,
              modifier: Modifier = Modifier,
              currentDestination: AppDestinations,
              tema: TemaColor){
    var textoo by remember { mutableStateOf("") }

    Column(modifier = modifier
        .fillMaxSize()
        .background(color = tema.fondo)
        .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {

        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            /*EntradaTextoField(
                valor = textoo,
                onValueChange = { textoo = it },
                label = "Escribe algo aquí",
                tema = tema
            )*/

            BotonPersonalizado(texto = "Iniciar Sesión", onClick = { /*TODO*/ },
                colorFondo = tema.botones, colorTexto = tema.fondo)

        }

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)
        ) {
            items(30) { index ->
                Text(
                    text = "Evento / Tarea #${index + 1}",
                    modifier = Modifier.padding(16.dp),
                    color = tema.letras
                )
            }
        }

    }
}