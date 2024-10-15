package com.alejandroarriola.tpgrupo2

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

data class Auto(
    var marca: String,
    var modelo: String,
    var anho: String,
    var precio: String,
    val kilometraje: String,
    val imagenUrl: String
)

//implementacion como viewmodel para que persista los datos tras una reconfiguacion de la pantalla (i.e. cambiar a dark mode)
class AutoViewModel : ViewModel() {
    val listaAutos = mutableStateListOf<Auto>()

    fun agregarAuto(auto: Auto) {
        listaAutos.add(auto)
    }

    fun removerAuto(auto: Auto) {
        listaAutos.remove(auto)
    }
}