package com.example.hello

data class Project(
    val id: Long,
    var title: String,
    val notes: MutableList<Note> = mutableListOf()
)

data class Note(
    var content: String
)
