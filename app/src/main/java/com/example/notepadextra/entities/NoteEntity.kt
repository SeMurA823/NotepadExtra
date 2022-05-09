package com.example.notepadextra.entities

import java.time.LocalDate
import java.time.LocalDateTime
import java.util.*

data class NoteEntity(val uuid: UUID, val title: String, val text: String, val date: LocalDate, val tags: Set<TagEntity>){
    companion object {
        val DUMMY = NoteEntity(UUID.randomUUID(), "", "", LocalDate.now(), setOf())
    }
}
