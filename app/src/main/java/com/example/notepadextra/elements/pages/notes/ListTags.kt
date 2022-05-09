package com.example.notepadextra.elements.pages.notes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.notepadextra.entities.TagEntity

@Composable
fun ListTags(tagEntities: Set<TagEntity>) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp, 5.dp)
    ) {
        tagEntities.forEach {
            Surface(modifier = Modifier.padding(5.dp), color = Color.Transparent) {
                Surface(modifier = Modifier.clip(shape = RoundedCornerShape(50)), color = Color.Transparent) {
                    Text(
                        text = it.name,
                        color = Color.White,
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier
                            .background(MaterialTheme.colors.secondary)
                            .padding(5.dp)
                    )
                }
            }
        }
    }
}