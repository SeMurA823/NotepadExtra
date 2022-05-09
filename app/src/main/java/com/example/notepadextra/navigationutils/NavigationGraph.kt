package com.example.notepadextra.navigationutils

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.notepadextra.elements.pages.NotePage
import com.example.notepadextra.elements.pages.tags.TagPage

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = NavigationRoutes.NOTES.toString()) {
        composable(NavigationRoutes.NOTES.toString()) {
            NotePage()
        }
        composable(NavigationRoutes.TAGS.toString()) {
            TagPage()
        }
    }

}