package com.example.notepadextra.elements.pages.tags

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Dialog
import com.example.notepadextra.entities.TagEntity

@Composable
fun TagPage() {

    var scrollState = rememberScrollState()
    var openDialogState = remember {
        mutableStateOf(false)
    }

    if (openDialogState.value)
        Dialog(
            onDismissRequest = { openDialogState.value = false },
            content = {
                CreateTagForm(onClose = { openDialogState.value = false })
            }
        )

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = { openDialogState.value = true }) {
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
            Tag(tagEntity = TagEntity(1, "Важное"))
            Tag(tagEntity = TagEntity(1, "Срочное"))
            Tag(tagEntity = TagEntity(1, "Супер важное"))
            Tag(tagEntity = TagEntity(1, "Важное"))
            Tag(tagEntity = TagEntity(1, "Срочное"))
            Tag(tagEntity = TagEntity(1, "Супер важное"))
            Tag(tagEntity = TagEntity(1, "Важное"))
            Tag(tagEntity = TagEntity(1, "Срочное"))
            Tag(tagEntity = TagEntity(1, "Супер важное"))
            Tag(tagEntity = TagEntity(1, "Важное"))
            Tag(tagEntity = TagEntity(1, "Срочное"))
            Tag(tagEntity = TagEntity(1, "Супер важное"))
            Tag(tagEntity = TagEntity(1, "Важное"))
            Tag(tagEntity = TagEntity(1, "Срочное"))
            Tag(tagEntity = TagEntity(1, "Супер важное"))
            Tag(tagEntity = TagEntity(1, "Важное"))
            Tag(tagEntity = TagEntity(1, "Срочное"))
            Tag(tagEntity = TagEntity(1, "Супер важное"))
            Tag(tagEntity = TagEntity(1, "Важное"))
            Tag(tagEntity = TagEntity(1, "Срочное"))
            Tag(tagEntity = TagEntity(1, "Супер важное"))
            Tag(tagEntity = TagEntity(1, "Супер важное"))
            Tag(tagEntity = TagEntity(1, "Важное"))
            Tag(tagEntity = TagEntity(1, "Срочное"))
            Tag(tagEntity = TagEntity(1, "Супер важное"))
            Tag(tagEntity = TagEntity(1, "Важное"))
            Tag(tagEntity = TagEntity(1, "Срочное"))
            Tag(tagEntity = TagEntity(1, "Супер важное"))
        }
    }
}