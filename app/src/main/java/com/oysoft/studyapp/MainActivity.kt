package com.oysoft.studyapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.serpent.ui.theme.AppTheme
import com.oysoft.studyapp.screens.HomeScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme(darkTheme = true) {
                Scaffold { paddingScaffold ->
                    HomeScreen(modifier = Modifier.padding(paddingScaffold))
                }
            }
        }
    }
}

