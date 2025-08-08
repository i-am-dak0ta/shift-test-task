package com.dak0ta.shift.feature.user.impl.di

import com.dak0ta.shift.feature.user.api.usecases.GetUserByIdUseCase
import com.dak0ta.shift.feature.user.api.usecases.GetUsersUseCase
import com.dak0ta.shift.feature.user.api.usecases.ObserveUsersUseCase
import com.dak0ta.shift.feature.user.api.usecases.RefreshUsersUseCase
import com.dak0ta.shift.feature.user.impl.data.api.RandomUserApi
import com.dak0ta.shift.feature.user.impl.data.api.UserService
import com.dak0ta.shift.feature.user.impl.data.api.UserServiceImpl
import com.dak0ta.shift.feature.user.impl.repository.UserRepository
import com.dak0ta.shift.feature.user.impl.repository.UserRepositoryImpl
import com.dak0ta.shift.feature.user.impl.usecases.GetUserByIdUseCaseImpl
import com.dak0ta.shift.feature.user.impl.usecases.GetUsersUseCaseImpl
import com.dak0ta.shift.feature.user.impl.usecases.ObserveUsersUseCaseImpl
import com.dak0ta.shift.feature.user.impl.usecases.RefreshUsersUseCaseImpl
import org.koin.core.module.Module
import org.koin.core.module.dsl.new
import org.koin.dsl.module
import retrofit2.Retrofit

val userImplModule: Module = module {
    factory<GetUsersUseCase> { new(::GetUsersUseCaseImpl) }
    factory<GetUserByIdUseCase> { new(::GetUserByIdUseCaseImpl) }
    factory<RefreshUsersUseCase> { new(::RefreshUsersUseCaseImpl) }
    factory<ObserveUsersUseCase> { new(::ObserveUsersUseCaseImpl) }
    single<UserService> { new(::UserServiceImpl) }
    single<UserRepository> { new(::UserRepositoryImpl) }
    single<RandomUserApi> {
        get<Retrofit>().create(RandomUserApi::class.java)
    }
}
