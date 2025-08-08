package com.dak0ta.shift.feature.user.impl.repository

import com.dak0ta.shift.feature.user.api.entities.User
import kotlinx.coroutines.flow.Flow

internal interface UserRepository {

    suspend fun getUsers(): List<User>
    suspend fun getUserById(userId: String): User
    suspend fun getUsersRemote(): List<User>
    fun observeUsers(): Flow<List<User>>
}
