package com.dak0ta.shift.feature.user.impl.usecases

import com.dak0ta.shift.feature.user.api.usecases.RefreshUsersUseCase
import com.dak0ta.shift.feature.user.impl.repository.UserRepository

internal class RefreshUsersUseCaseImpl(
    private val repository: UserRepository
) : RefreshUsersUseCase {

    override suspend fun invoke() {
        repository.getUsersRemote()
    }
}
