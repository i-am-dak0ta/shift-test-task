package com.dak0ta.shift.app.di

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class ShiftApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@ShiftApplication)
            modules(appModuleList)
        }
    }
}
