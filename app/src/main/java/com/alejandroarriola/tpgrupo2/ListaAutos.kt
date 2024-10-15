package com.alejandroarriola.tpgrupo2

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.alejandroarriola.tpgrupo2.ui.theme.inversePrimaryDark
import java.util.Locale


//Dibuja la lista de autos registras. No se muestra por default al estar la lista vacio por defecto
@Composable
fun ListaAutos(listaAutos: MutableList<Auto>) {
    Spacer(modifier = Modifier.height(32.dp))

    Text(
        "Lista de Autos",
        style = MaterialTheme.typography.headlineMedium
    )

    Spacer(modifier = Modifier.height(4.dp))

    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(listaAutos) {
            TarjetaAuto(listaAutos = listaAutos, auto = it)
        }
    }
}

//Construye la tarjeta del auto en si
@SuppressLint("UnusedBoxWithConstraintsScope")
@Composable
fun TarjetaAuto(
    listaAutos: MutableList<Auto>,
    auto: Auto
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        shape = RoundedCornerShape(12.dp),
        border = BorderStroke(2.dp, inversePrimaryDark)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text(
                text = auto.marca,
                style = MaterialTheme.typography.headlineMedium
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = auto.modelo,
                style = MaterialTheme.typography.headlineSmall
            )

            Spacer(modifier = Modifier.height(8.dp))

            BoxWithConstraints(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
            ) {
                //val anchoPantalla = 95.dp --can be deleted

                LazyRow( //LazyRow solo admite "items" por lo que deben construirse las piezas en item{ }
                    modifier = Modifier.fillMaxWidth()
                ) {
                    item{ InfoAuto(titulo = "Año", valor = auto.anho, ancho = 70.dp) }
                    item{ InfoAuto(titulo = "Precio", valor = auto.precio, ancho = 130.dp) }
                    item{ InfoAuto(titulo = "Kms", valor = auto.kilometraje, ancho = 130.dp) }
                    item{ AsyncImage(
                        model = auto.imagenUrl,
                        contentDescription = null,
                        placeholder = painterResource(R.drawable.placeholder_image),
                        error = painterResource(R.drawable.placeholder_image),
                        modifier = Modifier
                            .size(100.dp)
                    ) }
                }
            }

            Button(
                onClick = { listaAutos.remove(auto) },
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                Text("Eliminar")
            }

            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Composable
fun InfoAuto(titulo: String, valor: String, ancho: Dp) {
    Column(
        modifier = Modifier
            .width(ancho)
            .fillMaxWidth()
            .padding(end = 4.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = titulo, style = MaterialTheme.typography.titleSmall)

        Spacer(modifier = Modifier.height(4.dp))

        //Text(text = valor, style = MaterialTheme.typography.headlineSmall)
        Text(text = String.format(Locale.GERMANY, "%,d", valor.toInt()), style = MaterialTheme.typography.headlineSmall)
    }
}