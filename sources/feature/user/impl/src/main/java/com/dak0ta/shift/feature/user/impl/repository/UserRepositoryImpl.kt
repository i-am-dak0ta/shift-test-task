package com.dak0ta.shift.feature.user.impl.repository

import com.dak0ta.shift.feature.database.UserDao
import com.dak0ta.shift.feature.user.api.entities.User
import com.dak0ta.shift.feature.user.impl.data.api.UserService
import com.dak0ta.shift.feature.user.impl.mappers.toDb
import com.dak0ta.shift.feature.user.impl.mappers.toDomain
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map

internal class UserRepositoryImpl(
    private val userService: UserService,
    private val userDao: UserDao,
) : UserRepository {

    override suspend fun getUsers(): List<User> {
        val cached = userDao.getAll()
        if (cached.isNotEmpty()) {
            return cached.map { it.toDomain() }
        }
        return getUsersRemote()
    }

    override suspend fun getUserById(userId: String): User {
        val cached = userDao.getById(userId)
        return cached.toDomain()
    }

    override suspend fun getUsersRemote(): List<User> {
        val apiItems = userService.getAllUsers()
        val domainItems = apiItems.map { it.toDomain() }

        val entities = domainItems.map { it.toDb() }
        userDao.replaceAll(entities)

        return domainItems
    }

    override fun observeUsers(): Flow<List<User>> {
        return userDao.observeAll()
            .distinctUntilChanged()
            .map { list -> list.map { it.toDomain() } }
    }
}
