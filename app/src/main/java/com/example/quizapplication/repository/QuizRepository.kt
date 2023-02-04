package com.example.quizapplication.repository


import com.example.quizapplication.manager.AssertManager
import com.example.quizapplication.mapper.QuizResponseMapper
import com.example.quizapplication.model.Data

import com.example.quizapplication.utils.CustomResponse
import com.example.quizapplication.utils.LocalException


class QuizRepository(private val assertManager: AssertManager) {

    fun quizList(): CustomResponse<List<Data>?, LocalException> = QuizResponseMapper.mapp(assertManager)

    //   return assertManager.loadQuizData()

}