package com.example.isnotempty.ui.calendar

import androidx.lifecycle.ViewModel
import com.example.isnotempty.data.model.Event
import com.example.isnotempty.data.repository.EventRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

/**
 * CAPA DE LÓGICA DE INTERFAZ (VIEWMODEL):
 * El ViewModel vive dentro de ui/calendar/ y se encarga de la LÓGICA de la pantalla.
 * Procesa acciones del usuario (crear evento, cambiar de fecha, filtrar reuniones)
 * y mantiene los datos guardados en memoria aunque el teléfono rote o cambie de tema.
 */
class CalendarViewModel(
    private val repository: EventRepository = EventRepository()
) : ViewModel() {

    private val _eventos = MutableStateFlow<List<Event>>(emptyList())
    val eventos: StateFlow<List<Event>> = _eventos

    fun agregarNuevoEvento(evento: Event) {
        repository.agregarEvento(evento)
        _eventos.value = repository.obtenerEventos()
    }
}
