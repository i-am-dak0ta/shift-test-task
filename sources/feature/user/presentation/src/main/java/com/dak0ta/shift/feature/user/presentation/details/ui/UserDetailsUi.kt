package com.dak0ta.shift.feature.user.presentation.details.ui

import com.dak0ta.shift.feature.user.presentation.list.ui.UserUiInfoItem

internal data class UserDetailsUi(
    val id: String,
    val gender: UserUiInfoItem,
    val fullName: String,
    val profilePicture: String,
    val username: UserUiInfoItem,
    val dateOfBirth: UserUiInfoItem,
    val dateOfRegistration: UserUiInfoItem,
    val address: UserUiInfoItem,
    val latitude: String,
    val longitude: String,
    val phoneNumber: UserUiInfoItem,
    val cellNumber: UserUiInfoItem,
    val email: UserUiInfoItem,
    val nat: UserUiInfoItem,
)
