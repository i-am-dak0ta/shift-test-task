package com.dak0ta.shift.feature.user.api.usecases

import com.dak0ta.shift.feature.user.api.entities.User

interface GetUsersUseCase {

    suspend operator fun invoke(): List<User>
}
