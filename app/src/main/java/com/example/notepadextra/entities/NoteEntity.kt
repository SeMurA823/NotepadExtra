package com.example.notepadextra.entities

import java.time.LocalDateTime
import java.util.*

data class NoteEntity(val id: Long, val text: String, val date: LocalDateTime, val tags: Set<TagEntity>)
