package com.dak0ta.shift.feature.user.api.usecases

import com.dak0ta.shift.feature.user.api.entities.User
import kotlinx.coroutines.flow.Flow

interface ObserveUsersUseCase {

    suspend operator fun invoke(): Flow<List<User>>
}
