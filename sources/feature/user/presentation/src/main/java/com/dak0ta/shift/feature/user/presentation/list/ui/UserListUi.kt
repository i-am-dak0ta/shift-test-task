package com.dak0ta.shift.feature.user.presentation.list.ui

internal data class UserListUi(
    val id: String,
    val fullName: String,
    val profilePicture: String,
    val address: UserUiInfoItem,
    val phoneNumber: UserUiInfoItem,
)
