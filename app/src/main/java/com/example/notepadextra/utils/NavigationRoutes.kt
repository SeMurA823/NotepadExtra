package com.example.notepadextra.utils

import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Star
import androidx.compose.runtime.Composable
import com.example.notepadextra.R

enum class NavigationRoutes(
    val route: String,
    val icon: @Composable () -> Unit,
    val codeString: Int

) {

    NOTES("notes", {Icon(Icons.Outlined.Notifications, contentDescription = "Заметки")}, R.string.notes_tab_name),
    TAGS("tags", {Icon(Icons.Outlined.Star, contentDescription = "Теги")}, R.string.tags_tab_name),;

    override fun toString(): String {
        return name
    }}