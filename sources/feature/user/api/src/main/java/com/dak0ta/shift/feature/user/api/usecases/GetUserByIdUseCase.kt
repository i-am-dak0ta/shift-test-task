package com.dak0ta.shift.feature.user.api.usecases

import com.dak0ta.shift.feature.user.api.entities.User

interface GetUserByIdUseCase {

    suspend operator fun invoke(userId: String): User
}
