package com.example.isnotempty.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
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
import com.example.isnotempty.ui.theme.IsnotemptyTheme
import com.example.isnotempty.ui.theme.TemaColor
import com.example.isnotempty.ui.theme.obtenerTema
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import com.example.isnotempty.R

@Composable
fun Greeting(
    name: String,
    modifier: Modifier = Modifier,
    currentDestination: AppDestinations,
    tema: TemaColor
) {
    // Estados interactivos
    var contador by remember { mutableIntStateOf(0) }
    var textoIngresado by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = tema.fondo)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Título principal
        Text(
            text = "Hello $name!",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = tema.detalles
        )

        Text(
            text = "Estamos en la pestaña: ${currentDestination.label}",
            fontSize = 16.sp,
            color = tema.letras
        )

        // Tarjeta interactiva con contador y botones
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = tema.detalles.copy(alpha = 0.15f))
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Contador de clics: $contador",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = tema.letras
                )

                Spacer(modifier = Modifier.height(12.dp))

                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    Button(
                        onClick = { contador++ },
                        colors = ButtonDefaults.buttonColors(containerColor = tema.botones)
                    ) {
                        Text(text = "Sumar (+1)", color = tema.fondo)
                    }

                    Button(
                        onClick = { contador = 0 },
                        colors = ButtonDefaults.buttonColors(containerColor = tema.letras)
                    ) {
                        Text(text = "Reiniciar", color = tema.fondo)
                    }
                }
            }
        }

        // Campo para escribir texto
        OutlinedTextField(
            value = textoIngresado,
            onValueChange = { textoIngresado = it },
            label = { Text("Escribe algo aquí", color = tema.letras) },
            modifier = Modifier.fillMaxWidth(),
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = tema.letras,   // Color del texto escrito al enfocar
                unfocusedTextColor = tema.letras, // Color del texto escrito al desenfocar
                focusedBorderColor = tema.botones,
                unfocusedBorderColor = tema.letras,
                focusedLabelColor = tema.botones,
                unfocusedLabelColor = tema.botones //antes letrascolor
            )
        )

        if (textoIngresado.isNotEmpty()) {
            Text(
                text = "Escribiste: $textoIngresado",
                fontSize = 18.sp,
                fontStyle = FontStyle.Italic,
                color = tema.detalles
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Image(
            painter = painterResource(id = R.drawable.ic_home), // sin el .xml
            contentDescription = "Descripción del icono",
            modifier = Modifier.size(100.dp) // Tamaño del vector
        )

        Spacer(modifier = Modifier.weight(1f))

        Text(
            text = "67",
            fontSize = 40.sp,
            fontStyle = FontStyle.Italic,
            color = tema.letras
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    IsnotemptyTheme {
        Greeting(
            name = "Android",
            currentDestination = AppDestinations.HOME,
            tema = obtenerTema(1)
        )
    }
}
