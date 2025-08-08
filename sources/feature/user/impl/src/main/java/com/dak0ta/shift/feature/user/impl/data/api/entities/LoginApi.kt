package com.dak0ta.shift.feature.user.impl.data.api.entities

import kotlinx.serialization.Serializable

@Serializable
internal data class LoginApi(
    val uuid: String,
    val username: String,
)
