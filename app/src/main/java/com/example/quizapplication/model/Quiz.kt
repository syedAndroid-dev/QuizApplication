package com.example.quizapplication.model

import com.google.gson.annotations.SerializedName

data class Quiz(
    @SerializedName("questions")
    val questions: List<Questions>?,
    val message: String?,
    val status: Boolean?,
    val status_code: Int?
)

data class Questions(
    @SerializedName("question_id")
    val question_id: String?,
    val options: List<Options>?,
    val order: Int?,
    val questionType: String?,
    @SerializedName("question_name")
    val question_name: String?
)

data class Options(
    @SerializedName("option_id")
    var option_id: String?,
    var answer: Boolean?,
    @SerializedName("text")
    val text: String?,
    var isSelected : Boolean=false
)