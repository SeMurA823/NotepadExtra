package com.example.notepadextra

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.rememberNavController
import com.example.notepadextra.di.ServiceLocator
import com.example.notepadextra.navigationutils.NavigationGraph
import com.example.notepadextra.navigationutils.NoteBottomNavigation
import com.example.notepadextra.ui.theme.NotepadExtraTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.google.android.material.datepicker.MaterialDatePicker

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        ServiceLocator.init(this)

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