package com.example.quizapplication.model

data class QuizSubmittedModel(
    val answerData : List<SubmittedQuestions>?,
    val status:Boolean?= false,
    val message:String?
)

data class SubmittedQuestions(
    val questionId:String?,
    val question:String?,
    val options:List<SubmittedOptions>?
)

data class SubmittedOptions(
    val optionId:String,
    var answer:Boolean?,
    var isSelected:Boolean = false,
    val optionText:String?
)