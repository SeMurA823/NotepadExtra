package com.example.notepadextra.elements.pages.notes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.notepadextra.entities.NoteEntity
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Note(noteEntity: NoteEntity, onClick: (NoteEntity) -> Unit) {
    Surface(modifier = Modifier.padding(10.dp), onClick = { onClick(noteEntity) }) {
        Surface(modifier = Modifier.clip(shape = RoundedCornerShape(10.dp)).fillMaxWidth()) {
            Column(
                Modifier
                    .background(color = Color(0xFFEEFFFB))
                    .padding(10.dp)) {
                Text(
                    text = AnnotatedString(noteEntity.title),
                    fontSize = 24.sp, fontWeight = FontWeight.SemiBold
                )
                Text(text = noteEntity.text, fontSize = 18.sp, fontWeight = FontWeight.Normal)
                ListTags(tagEntities = noteEntity.tags)
                Text(
                    text = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG)
                        .format(noteEntity.date), color = MaterialTheme.colors.primary
                )
            }
        }
    }
}