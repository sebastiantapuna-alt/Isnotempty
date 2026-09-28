package com.example.isnotempty.data.model
//puede tener val password de atributo tmb
data class Usuario(val id: Int, val nombre: String, val email: String) {
    fun crearActividad(nombreActividad: String): AbstractActividad {
        return ActividadSolitaria(id, nombreActividad,
            "", this, false, SegmentoTiempo())
    }
}