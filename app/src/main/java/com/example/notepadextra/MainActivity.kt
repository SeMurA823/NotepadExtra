package com.example.notepadextra

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.rememberNavController
import com.example.notepadextra.ui.theme.NotepadExtraTheme
import com.example.notepadextra.utils.NavigationGraph
import com.example.notepadextra.utils.NoteBottomNavigation
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            var navController = rememberNavController()
            val systemUiController = rememberSystemUiController()

            SideEffect {
                systemUiController.setStatusBarColor(
                    color = Color.Transparent,
                    darkIcons = true
                )
            }

            NotepadExtraTheme {
                Scaffold(
                    bottomBar = {
                        NoteBottomNavigation(navController = navController)
                    }
                ) {
                    Surface(modifier = Modifier.padding(it)) {
                        NavigationGraph(navController = navController)
                    }

                }
            }
        }
    }
}