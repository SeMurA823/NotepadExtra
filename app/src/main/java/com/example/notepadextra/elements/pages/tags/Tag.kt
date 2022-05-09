package com.example.notepadextra.elements.pages.tags

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.notepadextra.entities.TagEntity

@Composable
fun Tag(tagEntity: TagEntity, onClick: (TagEntity)->Unit, color: Color = MaterialTheme.colors.secondary) {

    Surface(modifier = Modifier.padding(5.dp), color = Color.Transparent) {
        Surface(
            modifier = Modifier.clip(shape = RoundedCornerShape(50)),
            color = Color.Transparent
        ) {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .background(color)
                    .padding(5.dp)
            ) {
                ClickableText(
                    text = AnnotatedString(tagEntity.name),
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Medium,
                        textAlign = TextAlign.Center
                    ),
                    onClick = {onClick(tagEntity)}
                )
            }
        }
    }
}