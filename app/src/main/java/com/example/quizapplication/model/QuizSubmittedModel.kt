package com.example.quizapplication.model

data class SubmittedQuestions(
    var questionId:String?,
    var question:String?,
    val options:List<SubmittedOptions>
)

data class SubmittedOptions(
    var optionId:String,
    var isSelected:Boolean = false,
    var optionText:String?
)