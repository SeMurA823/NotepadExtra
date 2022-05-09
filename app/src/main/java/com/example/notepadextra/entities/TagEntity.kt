package com.example.notepadextra.entities

import java.util.*
data class TagEntity(
    val uuid: UUID,
    var name: String){
    companion object{
        val DUMMY = TagEntity(UUID.randomUUID(), "")
    }
}