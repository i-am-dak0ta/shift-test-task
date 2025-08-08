package com.dak0ta.shift.feature.user.impl.data.api

import com.dak0ta.shift.common.coroutine.CoroutineDispatchers
import com.dak0ta.shift.feature.user.impl.data.api.entities.UserApi
import kotlinx.coroutines.withContext

internal interface UserService {

    suspend fun getAllUsers(count: Int = 20): List<UserApi>
}

internal class UserServiceImpl(
    private val api: RandomUserApi,
    private val dispatchers: CoroutineDispatchers
) : UserService {

    override suspend fun getAllUsers(count: Int): List<UserApi> = withContext(dispatchers.io) {
        api.fetchUsers(results = count).results
    }
}
