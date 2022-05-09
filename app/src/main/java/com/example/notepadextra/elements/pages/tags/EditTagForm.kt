package com.example.notepadextra.elements.pages.tags

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.notepadextra.R
import com.example.notepadextra.di.ServiceLocator
import com.example.notepadextra.entities.TagEntity

@Composable
fun EditTagForm(oldValue: TagEntity, onClose: () -> Unit) {

    var editableTag by remember {
        mutableStateOf(TextFieldValue(oldValue.name))
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .clip(RoundedCornerShape(10.dp))
            .background(MaterialTheme.colors.background)
            .padding(5.dp)
    ) {
        Text(
            text = stringResource(id = R.string.edit_tag),
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium,
            color = MaterialTheme.colors.secondary,
            modifier = Modifier.padding(5.dp),
        )
        OutlinedTextField(
            value = editableTag,
            onValueChange = { editableTag = it },
            label = { Text(text = "Название", color = MaterialTheme.colors.secondary) },
            placeholder = { Text(text = "", color = MaterialTheme.colors.secondary) },
            modifier = Modifier.padding(5.dp),
            textStyle = TextStyle(
                color = MaterialTheme.colors.secondary,
                fontWeight = FontWeight.Medium
            )
        )
        Row() {
            Button(
                onClick = {
                    ServiceLocator.getInstance()
                        .tagDAO()
                        .delete(oldValue)
                    onClose()
                },
                modifier = Modifier.padding(5.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = MaterialTheme.colors.error
                )
            ) {
                Text(text = stringResource(id = R.string.btn_delete))
            }
            Button(
                onClick = {
                    ServiceLocator.getInstance()
                        .tagDAO()
                        .update(TagEntity(oldValue.uuid, editableTag.text))
                    onClose()
                },
                modifier = Modifier.padding(5.dp),
            ) {
                Text(text = stringResource(id = R.string.btn_done))
            }
        }
    }
}