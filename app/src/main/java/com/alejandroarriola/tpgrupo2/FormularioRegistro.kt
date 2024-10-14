package com.alejandroarriola.tpgrupo2

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

//Carga la primera parte del UI con el formulario para regitrar el auto
@Composable
fun FormularioRegistro(
    marca: String,
    modelo: String,
    anho: String,
    precio: String,
    kilometraje: String,
    imagenURL: String,
    onMarcaChange: (String) -> Unit,
    onModeloChange: (String) -> Unit,
    onAnhoChange: (String) -> Unit,
    onPrecioChange: (String) -> Unit,
    onKilometrajeChange: (String) -> Unit,
    onImagenURLChange: (String) -> Unit,
    onRegistrarAuto: () -> Unit
) {
    Column {
        Spacer(modifier = Modifier.height(32.dp))

        Text(
            "Formulario de Autos",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = marca,
            onValueChange = onMarcaChange,
            label = { Text("Marca") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = modelo,
            onValueChange = onModeloChange,
            label = { Text("Modelo") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = anho,
            onValueChange = onAnhoChange,
            label = { Text("Año") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = precio,
            onValueChange = onPrecioChange,
            label = { Text("Precio") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = kilometraje,
            onValueChange = onKilometrajeChange,
            label = { Text("Kilometraje") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = imagenURL,
            onValueChange = onImagenURLChange,
            label = { Text("URL Imagen") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = onRegistrarAuto,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text("Registrar")
        }
    }
}