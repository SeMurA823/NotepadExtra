package com.example.notepadextra.elements.pages

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.notepadextra.di.ServiceLocator
import com.example.notepadextra.elements.pages.notes.CreateNoteForm
import com.example.notepadextra.elements.pages.notes.EditNoteForm
import com.example.notepadextra.elements.pages.notes.Note
import com.example.notepadextra.entities.NoteEntity
import java.util.*

@Composable
fun NotePage() {
    val scrollState = rememberScrollState()

    var openCreateDialogState by remember {
        mutableStateOf(false)
    }

    var openEditDialogState by remember {
        mutableStateOf(Optional.empty<NoteEntity>())
    }

    if (openCreateDialogState)
        Dialog(
            onDismissRequest = { openCreateDialogState = false },
            content = {
                val scroll = rememberScrollState()
                Surface(modifier = Modifier
                    .fillMaxHeight(0.8f)
                    .verticalScroll(scroll)
                    .clip(RoundedCornerShape(10.dp))) {
                    CreateNoteForm(onClose = { openCreateDialogState = false })
                }

            }
        )

    if (openEditDialogState.isPresent)
        Dialog(
            onDismissRequest = { openEditDialogState = Optional.empty<NoteEntity>() },
            content = {
                val scroll = rememberScrollState()
                Surface(modifier = Modifier
                    .fillMaxHeight(0.8f)
                    .verticalScroll(scroll)
                    .clip(RoundedCornerShape(10.dp))) {
                    EditNoteForm(
                        noteEntity = openEditDialogState.orElse(NoteEntity.DUMMY),
                        onClose = { openEditDialogState = Optional.empty<NoteEntity>() }
                    )
                }

            }
        )

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = { openCreateDialogState = true }) {
                Icon(Icons.Outlined.Add, contentDescription = "Add")
            }
        },
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
    ) {
        Column(
            Modifier
                .verticalScroll(scrollState)
                .fillMaxHeight()
        ) {
            ServiceLocator.getInstance()
                .noteDAO()
                .findAll()
                .forEach { 
                    Note(noteEntity = it, onClick = {openEditDialogState = Optional.of(it)})
                }
        }
    }
}