package com.dak0ta.shift.feature.user.impl.usecases

import com.dak0ta.shift.feature.user.api.entities.User
import com.dak0ta.shift.feature.user.api.usecases.GetUserByIdUseCase
import com.dak0ta.shift.feature.user.impl.repository.UserRepository

internal class GetUserByIdUseCaseImpl(
    private val repository: UserRepository
) : GetUserByIdUseCase {

    override suspend fun invoke(userId: String): User {
        return repository.getUserById(userId)
    }
}
