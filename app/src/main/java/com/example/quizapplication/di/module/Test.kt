package com.example.quizapplication.di.module

import com.example.quizapplication.manager.AssertManager
import com.example.quizapplication.repository.QuizRepository
import com.example.quizapplication.ui.QuizViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object Test {
    fun modules() = repoModule + viewModelModule + commonModule
}

val repoModule = module {
    single {
        QuizRepository(get())
    }
}

val viewModelModule = module {

    viewModel{
        QuizViewModel(get())
    }
}

val commonModule = module {
    single {
        AssertManager(androidContext())
    }
}