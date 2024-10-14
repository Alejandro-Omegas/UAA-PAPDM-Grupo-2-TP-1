package com.alejandroarriola.tpgrupo2

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

//dibuja la pantalla: por una parte el formulario de registro, y debjao la lista de autos registrados (no se muestra al arrancar el app por no tiener registros aun)
@Composable
fun PantallaRegistro() {
    val listaAutos = remember { mutableStateListOf<Auto>() }
    var marca by remember { mutableStateOf("") }
    var modelo by remember { mutableStateOf("") }
    var anho by remember { mutableStateOf("") }
    var precio by remember { mutableStateOf("") }
    var kilometraje by remember { mutableStateOf("") }
    var imagenURL by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        FormularioRegistro(
            marca = marca,
            modelo = modelo,
            anho = anho,
            precio = precio,
            kilometraje = kilometraje,
            imagenURL = imagenURL,
            onMarcaChange = { marca = it },
            onModeloChange = { modelo = it },
            onAnhoChange = { anho = it},
            onPrecioChange = { precio = it},
            onKilometrajeChange = { kilometraje = it},
            onImagenURLChange = { imagenURL = it},
            onRegistrarAuto = {
                val nuevoAuto = Auto(marca, modelo, anho, precio, kilometraje, imagenURL)
                listaAutos.add(nuevoAuto)
                marca = ""
                modelo = ""
                anho = ""
                precio = ""
                kilometraje = ""
                imagenURL = ""
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        ListaAutos(listaAutos = listaAutos)
    }
}