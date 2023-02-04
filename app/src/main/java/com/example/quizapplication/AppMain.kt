package com.example.quizapplication

import android.app.Application
import com.example.quizapplication.di.module.Test
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class AppMain:Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@AppMain)
            modules(Test.modules())
        }
    }
}