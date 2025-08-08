package com.dak0ta.shift.feature.user.impl.data.api.entities

import kotlinx.serialization.Serializable

@Serializable
internal data class UserApi(
    val gender: String,
    val login: LoginApi,
    val name: NameApi,
    val location: LocationApi,
    val email: String,
    val phone: String,
    val cell: String,
    val nat: String,
    val picture: PictureApi,
    val dob: DobApi,
    val registered: RegisteredApi,
)
