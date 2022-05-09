package com.example.notepadextra.elements.pages.tags

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Dialog
import com.example.notepadextra.di.ServiceLocator
import com.example.notepadextra.entities.TagEntity
import java.util.*

@Composable
fun TagPage() {

    var scrollState = rememberScrollState()
    val openCreateDialogState = remember {
        mutableStateOf(false)
    }

    var openEditDialogState by remember {
        mutableStateOf(Optional.empty<TagEntity>())
    }

    if (openEditDialogState.isPresent)
        Dialog(onDismissRequest = { openEditDialogState = Optional.empty<TagEntity>() }, content = {
            EditTagForm(oldValue = openEditDialogState.orElse(TagEntity.DUMMY), onClose = { openEditDialogState = Optional.empty<TagEntity>() })
        })
    if (openCreateDialogState.value)
        Dialog(
            onDismissRequest = { openCreateDialogState.value = false },
            content = {
                CreateTagForm(onClose = { openCreateDialogState.value = false })
            }
        )

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = { openCreateDialogState.value = true }) {
                Icon(Icons.Outlined.Add, contentDescription = "Add")
            }
        },
    ) {
        Column(
            modifier = Modifier
                .verticalScroll(scrollState)
                .fillMaxHeight()
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            ServiceLocator.getInstance()
                .tagDAO()
                .findAll()
                .forEach {
                    Tag(tagEntity = it, onClick = {openEditDialogState = Optional.of(it)})
                }
        }
    }
}