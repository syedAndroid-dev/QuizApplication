package com.example.quizapplication.manager

import android.content.Context
import com.example.quizapplication.model.Quiz
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class AssertManager(val context: Context) {

    fun loadQuizData(): Quiz {
        return Gson().fromJson(
            context.assets.open("quiz.json").bufferedReader(),
            object : TypeToken<Quiz>() {}.type
        )
//        val jsonString = context.resources.openRawResource(R.raw.quiz)
//            .bufferedReader().use { it.readText() }
//         Gson().fromJson(jsonString,Array<QuizList>::class.java)
//        quizDataList=quizData.toList()
//
//        return quizDataList
    }
}