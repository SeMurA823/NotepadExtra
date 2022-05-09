package com.example.notepadextra.elements.pages.notes

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Done
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.notepadextra.R
import com.example.notepadextra.di.ServiceLocator
import com.example.notepadextra.elements.pages.tags.Tag
import com.example.notepadextra.entities.TagEntity

@Composable
fun TagSelectForm(selected: MutableList<TagEntity>) {


    var openDialogState by remember {
        mutableStateOf(false)
    }

    TextButton(onClick = { openDialogState = true }) {
        Text(text = stringResource(id = R.string.btn_select_tags))
    }
    Text(
        text = selected.map { x->x.name }.joinToString(separator = "\n"),
        color = MaterialTheme.colors.primary,
        textAlign = TextAlign.Center
    )
    
    if (openDialogState)
        Dialog(
            onDismissRequest = { openDialogState = false },
            content = {
                var scroll = rememberScrollState()
                Surface(modifier = Modifier.clip(RoundedCornerShape(10.dp))) {
                    Scaffold(
                        topBar = {
                                 TopAppBar() {
                                     Text(
                                         text = stringResource(id = R.string.select_tag),
                                         fontSize = 20.sp,
                                         textAlign = TextAlign.Center,
                                         fontWeight = FontWeight.SemiBold,
                                         modifier = Modifier.fillMaxWidth()
                                     )
                                 }
                        },
                        floatingActionButton = {
                            FloatingActionButton(onClick = { openDialogState = false }) {
                                Icon(Icons.Rounded.Done, contentDescription = "Done")
                            }
                        },
                        content = {
                            Column(
                                modifier = Modifier
                                    .verticalScroll(scroll)
                                    .fillMaxWidth()
                                    .padding(it),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center,
                            ) {
                                ServiceLocator.getInstance()
                                    .tagDAO()
                                    .findAll()
                                    .forEach {
                                        Tag(
                                            tagEntity = it,
                                            onClick = {
                                                if (!selected.remove(it))
                                                    selected.add(it)
                                            },
                                            color = (if (selected.contains(it)) MaterialTheme.colors.secondary else Color.LightGray)
                                        )
                                    }
                            }
                        }
                    )
                }
            },
        )
}