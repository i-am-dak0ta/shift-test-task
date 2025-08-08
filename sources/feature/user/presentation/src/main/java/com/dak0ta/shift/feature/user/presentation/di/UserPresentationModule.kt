package com.dak0ta.shift.feature.user.presentation.di

import com.dak0ta.shift.feature.user.presentation.details.UserDetailsViewModel
import com.dak0ta.shift.feature.user.presentation.details.ui.UserDetailsStateMapper
import com.dak0ta.shift.feature.user.presentation.list.UserListViewModel
import com.dak0ta.shift.feature.user.presentation.list.ui.UserListStateMapper
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val userPresentationModule = module {
    viewModelOf(::UserListViewModel)
    factoryOf(::UserListStateMapper)
    viewModelOf(::UserDetailsViewModel)
    factoryOf(::UserDetailsStateMapper)
}
