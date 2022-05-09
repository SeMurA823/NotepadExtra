package com.example.notepadextra.elements.pages

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Star
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.notepadextra.elements.pages.notes.Note
import com.example.notepadextra.entities.NoteEntity
import com.example.notepadextra.entities.TagEntity
import java.time.LocalDateTime
import java.util.*

@Composable
fun NotePage() {
    val scrollState = rememberScrollState()
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = { /*TODO*/ }) {
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
            Note(
                noteEntity = NoteEntity(
                    0,
                    "Дописать SQL Lite",
                    LocalDateTime.now(),
                    setOf(
                        TagEntity(2, "Важное"),
                        TagEntity(3, "Срочно")
                    )
                )
            )
            Note(
                noteEntity = NoteEntity(
                    0,
                    "Дописать SQL Lite",
                    LocalDateTime.now(),
                    setOf(
                        TagEntity(2, "Важное"),
                        TagEntity(3, "Срочно")
                    )
                )
            )
            Note(
                noteEntity = NoteEntity(
                    0,
                    "Дописать SQL Lite",
                    LocalDateTime.now(),
                    setOf(
                        TagEntity(2, "Важное"),
                        TagEntity(3, "Срочно")
                    )
                )
            )
            Note(
                noteEntity = NoteEntity(
                    0,
                    "Дописать SQL Lite",
                    LocalDateTime.now(),
                    setOf(
                        TagEntity(2, "Важное"),
                        TagEntity(3, "Срочно")
                    )
                )
            )
            Note(
                noteEntity = NoteEntity(
                    0,
                    "Дописать SQL Lite",
                    LocalDateTime.now(),
                    setOf(
                        TagEntity(2, "Важное"),
                        TagEntity(3, "Срочно")
                    )
                )
            )
            Note(
                noteEntity = NoteEntity(
                    0,
                    "Дописать SQL Lite",
                    LocalDateTime.now(),
                    setOf(
                        TagEntity(2, "Важное"),
                        TagEntity(3, "Срочно")
                    )
                )
            )
            Note(
                noteEntity = NoteEntity(
                    0,
                    "Дописать SQL Lite",
                    LocalDateTime.now(),
                    setOf(
                        TagEntity(2, "Важное"),
                        TagEntity(3, "Срочно")
                    )
                )
            )
            Note(
                noteEntity = NoteEntity(
                    0,
                    "Дописать SQL Lite",
                    LocalDateTime.now(),
                    setOf(
                        TagEntity(2, "Важное"),
                        TagEntity(3, "Срочно")
                    )
                )
            )
            Note(
                noteEntity = NoteEntity(
                    0,
                    "Дописать SQL Lite",
                    LocalDateTime.now(),
                    setOf(
                        TagEntity(2, "Важное"),
                        TagEntity(3, "Срочно")
                    )
                )
            )
            Note(
                noteEntity = NoteEntity(
                    0,
                    "Дописать SQL Lite",
                    LocalDateTime.now(),
                    setOf(
                        TagEntity(2, "Важное"),
                        TagEntity(3, "Срочно")
                    )
                )
            )
            Note(
                noteEntity = NoteEntity(
                    0,
                    "Дописать SQL Lite",
                    LocalDateTime.now(),
                    setOf(
                        TagEntity(2, "Важное"),
                        TagEntity(3, "Срочно")
                    )
                )
            )
            Note(
                noteEntity = NoteEntity(
                    0,
                    "Дописать SQL Lite",
                    LocalDateTime.now(),
                    setOf(
                        TagEntity(2, "Важное"),
                        TagEntity(3, "Срочно")
                    )
                )
            )
        }
    }
}