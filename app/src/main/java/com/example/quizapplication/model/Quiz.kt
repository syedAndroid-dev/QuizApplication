package com.example.quizapplication.model

data class Quiz(
    val questions: List<Questions>?,
    val message: String?,
    val status: Boolean?,
    val status_code: Int?
)

data class Questions(
    val question_id: String?,
    val options: List<Options>?,
    val order: Int?,
    val questionType: String?,
    val question_name: String?
)

data class Options(
    var option_id: String?,
    var answer: Boolean?,
    val text: String?
)