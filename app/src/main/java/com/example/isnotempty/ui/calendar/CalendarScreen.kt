package com.example.isnotempty.ui.calendar

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * CAPA DE INTERFAZ (VISTA DE CALENDARIO):
 * En esta carpeta (ui/calendar/) van los componentes visuales específicos de la agenda y calendario
 * (vista por mes, vista por día, selector de horas, listado de eventos programados).
 */
@Composable
fun CalendarScreen(
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.padding(16.dp)) {
        Text(text = "Pantalla de Calendario y Agenda")
    }
}
