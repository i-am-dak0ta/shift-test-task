package com.dak0ta.shift.feature.user.impl.data.api.entities

import kotlinx.serialization.Serializable

@Serializable
internal data class UserApiResponse(
    val results: List<UserApi>
)
