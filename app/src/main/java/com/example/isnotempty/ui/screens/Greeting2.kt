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
fun Greeting2(
    name: String,
    modifier: Modifier = Modifier,
    currentDestination: AppDestinations,
    tema: TemaColor
) {
    val contexto = LocalContext.current
    Column(modifier = modifier
        .fillMaxSize()
        .background(color = tema.fondo)
        .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = painterResource(id = R.drawable.ic_favorite), // sin el .xml
            contentDescription = "Descripción del icono",
            modifier = Modifier.size(150.dp) // Tamaño del vector
        )

        Text(text = "Agendalo Tu",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = tema.detalles)

        BotonPersonalizado(texto = "Iniciar Sesión", onClick = {
            Toast.makeText(contexto, "Sesion iniciada", Toast.LENGTH_SHORT).show()
        },
            colorFondo = tema.botones, colorTexto = tema.fondo)

        BotonPersonalizado(texto = "Crear Actividad Conjunta", onClick = { /*TODO*/ },
            colorFondo = tema.botones, colorTexto = tema.fondo)

        Spacer(modifier = Modifier.weight(1f))

        Text(text = "Vista Semanal",
            fontSize = 30.sp,
            fontStyle = FontStyle.Italic,
            color = tema.letras)

        Image(
            painter = painterResource(id = R.drawable.ic_account_box),
            contentDescription = "Descripción del icono",
            modifier = Modifier.size(600.dp)
        )



    }
}