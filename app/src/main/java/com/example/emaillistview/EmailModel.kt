package com.example.emaillistview

data class EmailModel(
    val sender: String,
    val subject: String,
    val content: String,
    val time: String,
    val backgroundColor: String
)