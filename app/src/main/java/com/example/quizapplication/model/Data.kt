package com.example.quizapplication.model

data class Data(
    val _id: String?,
    val attachments: Attachments?,
    val options: List<Option>?,
    val order: Int?,
    val questionType: String?,
    val text: String?
)