package com.dak0ta.shift.feature.user.impl.usecases

import com.dak0ta.shift.feature.user.api.entities.User
import com.dak0ta.shift.feature.user.api.usecases.ObserveUsersUseCase
import com.dak0ta.shift.feature.user.impl.repository.UserRepository
import kotlinx.coroutines.flow.Flow

internal class ObserveUsersUseCaseImpl(
    private val repository: UserRepository
) : ObserveUsersUseCase {

    override suspend fun invoke(): Flow<List<User>> {
        return repository.observeUsers()
    }
}
