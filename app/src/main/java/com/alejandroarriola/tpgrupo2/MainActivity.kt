package com.alejandroarriola.tpgrupo2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.alejandroarriola.tpgrupo2.ui.theme.Tpgrupo2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Tpgrupo2Theme {
                //el surface contiene el color de fondo, por lo que es necesario para apreciar el dark mode en su totalidad
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    PantallaRegistro()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Tpgrupo2Theme {
        PantallaRegistro()
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingDarkPreview() {
    Tpgrupo2Theme(darkTheme = true) {
        PantallaRegistro()
    }
}