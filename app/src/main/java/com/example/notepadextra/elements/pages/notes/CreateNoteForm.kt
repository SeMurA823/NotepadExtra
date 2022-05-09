package com.example.notepadextra.elements.pages.notes

import android.app.DatePickerDialog
import android.widget.DatePicker
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.notepadextra.R
import com.example.notepadextra.di.ServiceLocator
import com.example.notepadextra.entities.NoteEntity
import com.example.notepadextra.entities.TagEntity
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle
import java.util.*

@Composable
fun CreateNoteForm(onClose: () -> Unit) {

    var title by remember {
        mutableStateOf("")
    }

    var description by remember {
        mutableStateOf("")
    }

    var date by remember {
        mutableStateOf(LocalDate.now())
    }

    var tags = remember {
        mutableStateListOf<TagEntity>()
    }

    val datePickerDialog = DatePickerDialog(
        LocalContext.current,
        { _: DatePicker, mYear: Int, mMonth: Int, mDayOfMonth: Int ->
            date = LocalDate.of(mYear, mMonth, mDayOfMonth)
        }, date.year, date.monthValue, date.dayOfMonth
    )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .clip(RoundedCornerShape(10.dp))
            .background(MaterialTheme.colors.background)
            .padding(5.dp)
    ) {
        Text(
            text = stringResource(id = R.string.create_note),
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium,
            color = MaterialTheme.colors.secondary,
            modifier = Modifier.padding(5.dp)
        )
        OutlinedTextField(
            value = title,
            onValueChange = { title = it },
            label = { Text(text = "Название", color = MaterialTheme.colors.secondary) },
            placeholder = { Text(text = "", color = MaterialTheme.colors.secondary) },
            modifier = Modifier.padding(5.dp),
            textStyle = TextStyle(
                color = MaterialTheme.colors.secondary,
                fontWeight = FontWeight.Medium
            )
        )
        OutlinedTextField(
            value = description,
            onValueChange = { description = it },
            label = { Text(text = "Описание", color = MaterialTheme.colors.secondary) },
            placeholder = { Text(text = "", color = MaterialTheme.colors.secondary) },
            modifier = Modifier.padding(5.dp),
            textStyle = TextStyle(
                color = MaterialTheme.colors.secondary,
                fontWeight = FontWeight.Medium
            )
        )

        OutlinedButton(onClick = { datePickerDialog.show() }) {
            Text(text = date.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG)))
        }

        TagSelectForm(
            selected = tags
        )

        Button(
            onClick = {
                ServiceLocator.getInstance()
                    .noteDAO()
                    .insertWithTags(NoteEntity(UUID.randomUUID(), title = title, text = description, date = date, tags = tags.toSet()))
                onClose()
            },
            modifier = Modifier.padding(5.dp)
        ) {
            Text(text = stringResource(id = R.string.btn_done))
        }
    }
}

