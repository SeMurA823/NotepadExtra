package com.example.notepadextra.elements.pages.notes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.notepadextra.entities.NoteEntity
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle

@Composable
fun Note(noteEntity: NoteEntity) {
    Surface(modifier = Modifier.padding(10.dp)) {
        Surface(modifier = Modifier.clip(shape = RoundedCornerShape(10.dp))) {
            Column(Modifier.background(color = Color(0xFFEEFFFB)).padding(10.dp)) {
                Text(text = noteEntity.text, fontSize = 20.sp, fontWeight = FontWeight.SemiBold)
                Text(text = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT, FormatStyle.SHORT).format(noteEntity.date))
                ListTags(tagEntities = noteEntity.tags)
            }
        }
    }
}