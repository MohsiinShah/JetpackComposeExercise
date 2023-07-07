package com.example.jetpackcomposeexercise

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetpackcomposeexercise.navigation.Navigation
import com.example.jetpackcomposeexercise.ui.theme.JetPackComposeExerciseTheme

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Navigation()
        }
    }
}

@Composable
fun JetPackComposeApp(content: @Composable () -> Unit) {
    JetPackComposeExerciseTheme {
        content()
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetPackComposeApp {
        Navigation()
    }
}
