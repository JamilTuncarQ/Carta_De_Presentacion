package com.example.cartadepresentacion

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cartadepresentacion.ui.theme.CartaDePresentacionTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CartaDePresentacionTheme {
                Surface (
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.onBackground
                ){
                    GreetingCartaPresentacion(
                        nombre = stringResource(R.string.nombre),
                        titulo = stringResource(R.string.estudiante),
                        numero = stringResource(R.string.numero),
                        correo = stringResource(R.string.correo),
                        github = stringResource(R.string.github)
                    )
                }
            }
        }
    }
}

@Composable
fun GreetingCartaPresentacion(
    nombre: String,
    titulo: String,
    numero: String,
    correo: String,
    github: String,
    modifier: Modifier = Modifier
) {
    val image1 = painterResource(R.drawable.persona_modified)
    val image2 = painterResource(R.drawable.telefono)
    val image3 = painterResource(R.drawable.email)
    val image4 = painterResource(R.drawable.github_logo)
    val fondo = painterResource(R.drawable.la_foto)
    Box (
        modifier = modifier.fillMaxSize()
    ) {
        Image(painter = fondo,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize(),
                alpha = 0.3f

        )
        Column (
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.align(Alignment.Center)
        ){
            Image(
                painter = image1,
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .width(100.dp)
                    .height(100.dp)
            )
            Text(
                text = nombre
            )
            Text(
                text = titulo
            )
        }
        Column (
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(16.dp)
                .offset(y = (-20).dp)
        ) {
            Row {
                Image(
                    painter = image2,
                    contentDescription = null,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .width(30.dp)
                        .height(30.dp)
                )
                Text(text = numero)
            }
            Row {
                Image(
                    painter = image3,
                    contentDescription = null,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .width(30.dp)
                        .height(30.dp)
                )
                Text(text = correo)
            }
            Row {
                Image(
                    painter = image4,
                    contentDescription = null,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .width(30.dp)
                        .height(30.dp)
                )
                Text(text = github)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CartaDePresentacionTheme {
        GreetingCartaPresentacion(
            nombre = stringResource(R.string.nombre),
            titulo = stringResource(R.string.estudiante),
            numero = stringResource(R.string.numero),
            correo = stringResource(R.string.correo),
            github = stringResource(R.string.github)
        )
    }
}
