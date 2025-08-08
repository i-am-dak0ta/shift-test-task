package com.dak0ta.shift.feature.database.di

import androidx.room.Room
import com.dak0ta.shift.feature.database.AppDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {
    single {
        Room.databaseBuilder(
            androidContext(),
            AppDatabase::class.java,
            "shift-db"
        )
            .fallbackToDestructiveMigration(false)
            .build()
    }

    single { get<AppDatabase>().userDao() }
}
