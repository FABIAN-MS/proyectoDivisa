package com.example.proyectodivisas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import com.example.proyectodivisas.ui.theme.ProyectoDivisasTheme
import com.example.proyectodivisas.worker.ExchangeRateWorker
import java.util.concurrent.TimeUnit



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Programa el Worker para que se ejecute cada 10 segundos (para pruebas)
        val workRequest = PeriodicWorkRequestBuilder<ExchangeRateWorker>(
            1, TimeUnit.HOURS // Intervalo de ejecución: 10 segundos
        ).build()

        WorkManager.getInstance(this).enqueue(workRequest)

        setContent {
            ProyectoDivisasTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Sincronización programada cada 10 segundos",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "¡Hola, $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ProyectoDivisasTheme {
        Greeting("Android")
    }
}