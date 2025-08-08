package com.dak0ta.shift.feature.user.api.entities

data class User(
    val id: String,
    val gender: String,
    val titleName: String,
    val firstName: String,
    val lastName: String,
    val profilePicture: String,
    val username: String,
    val dateOfBirth: String,
    val dateOfRegistration: String,
    val address: String,
    val latitude: String,
    val longitude: String,
    val phoneNumber: String,
    val cellNumber: String,
    val email: String,
    val nat: String,
) {

    val fullName: String
        get() = "$titleName $firstName $lastName"
}
