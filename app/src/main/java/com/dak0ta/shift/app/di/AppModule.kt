package com.dak0ta.shift.app.di

import com.dak0ta.shift.common.coroutine.di.coroutineModule
import com.dak0ta.shift.common.network.networkModule
import com.dak0ta.shift.feature.database.di.databaseModule
import com.dak0ta.shift.feature.user.impl.di.userImplModule
import com.dak0ta.shift.feature.user.presentation.di.userPresentationModule

val appModuleList = listOf(
    coroutineModule,
    networkModule,
    databaseModule,
    userImplModule,
    userPresentationModule,
)
