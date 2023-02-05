package com.example.quizapplication.model

data class QuizSubmittedModel(
    val answerData : List<Questions>?,
    val status:Boolean?= false,
    val message:String?
)

//data class SubmittedQuestions(
//    val questionId:String?,
//    val question:String?,
//    val options:List<SubmittedOptions>?
//)
//
//data class SubmittedOptions(
//    val optionId:String,
//    var selectedOption:Boolean?,
//    val optionText:String?
//)