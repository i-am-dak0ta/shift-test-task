package com.dak0ta.shift.feature.user.impl.usecases

import com.dak0ta.shift.feature.user.api.entities.User
import com.dak0ta.shift.feature.user.api.usecases.GetUsersUseCase
import com.dak0ta.shift.feature.user.impl.repository.UserRepository

internal class GetUsersUseCaseImpl(
    private val repository: UserRepository
) : GetUsersUseCase {

    override suspend fun invoke(): List<User> {
        return repository.getUsers()
    }
}
