package com.example.isnotempty.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.isnotempty.R
import com.example.isnotempty.ui.theme.IsnotemptyTheme
import com.example.isnotempty.ui.theme.TemaColor
import com.example.isnotempty.ui.theme.obtenerTema

@Composable
fun PantallaMati(
    name: String,
    modifier: Modifier = Modifier,
    currentDestination: AppDestinations,
    tema: TemaColor
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = tema.fondo)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // LOGO E IMAGEN
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "Logo",
            modifier = Modifier.size(80.dp)
        )

        // TÍTULO
        Text(
            text = "AGENDALOTU",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = tema.detalles
        )

        // BOTONES DE ACCIÓN
        Button(
            onClick = { /* TODO: Agendar actividad */ },
            colors = ButtonDefaults.buttonColors(containerColor = tema.botones)
        ) {
            Text(text = "Agendar actividad", color = tema.fondo)
        }

        Button(
            onClick = { /* TODO: Crear Actividad Conjunta */ },
            colors = ButtonDefaults.buttonColors(containerColor = tema.botones)
        ) {
            Text(text = "Crear Actividad Conjunta", color = tema.fondo)
        }

        Text(
            text = "Vista Semanal",
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold,
            color = tema.letras
        )

        // MALLA / GRILLA SEMANAL DE 7 COLUMNAS
        LazyVerticalGrid(
            columns = GridCells.Fixed(7),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
                .border(1.dp, tema.letras.copy(alpha = 0.5f))
        ) {
            items(84) {
                Box(
                    modifier = Modifier
                        .aspectRatio(1f)
                        .border(0.5.dp, tema.letras.copy(alpha = 0.2f)),
                    contentAlignment = Alignment.Center
                ) {
                    // Cuadrito vacío para la grilla semanal
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PantallaMatiPreview() {
    IsnotemptyTheme {
        PantallaMati(
            name = "Matias",
            currentDestination = AppDestinations.HOME,
            tema = obtenerTema(1)
        )
    }
}
