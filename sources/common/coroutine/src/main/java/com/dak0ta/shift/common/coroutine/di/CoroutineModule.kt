package com.dak0ta.shift.common.coroutine.di

import com.dak0ta.shift.common.coroutine.CoroutineDispatchers
import com.dak0ta.shift.common.coroutine.CoroutineDispatchersImpl
import org.koin.dsl.module

val coroutineModule = module {
    single<CoroutineDispatchers> { CoroutineDispatchersImpl() }
}
