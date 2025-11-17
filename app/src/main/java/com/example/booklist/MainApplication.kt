package com.example.booklist

import android.app.Application
import com.example.booklist.modules.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MainApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            modules(listOf(appModule))
            androidContext(this@MainApplication)
        }
    }
}