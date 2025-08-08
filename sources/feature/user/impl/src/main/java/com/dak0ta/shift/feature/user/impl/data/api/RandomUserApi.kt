package com.dak0ta.shift.feature.user.impl.data.api

import com.dak0ta.shift.feature.user.impl.data.api.entities.UserApiResponse
import retrofit2.http.GET
import retrofit2.http.Query

internal interface RandomUserApi {

    @GET("api/")
    suspend fun fetchUsers(
        @Query("results") results: Int
    ): UserApiResponse
}
