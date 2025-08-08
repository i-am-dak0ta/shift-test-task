package com.dak0ta.shift.feature.user.impl.mappers

import com.dak0ta.shift.feature.database.UserDb
import com.dak0ta.shift.feature.user.api.entities.User
import com.dak0ta.shift.feature.user.impl.data.api.entities.UserApi

internal fun UserApi.toDomain() = User(
    id = login.uuid,
    gender = gender,
    titleName = name.title,
    firstName = name.first,
    lastName = name.last,
    profilePicture = picture.large,
    username = login.username,
    address = "${location.country}, ${location.state}, ${location.city}, ${location.street.name}, " +
        "${location.street.number}",
    latitude = location.coordinates.latitude,
    longitude = location.coordinates.longitude,
    dateOfBirth = dob.date,
    dateOfRegistration = registered.date,
    phoneNumber = phone,
    cellNumber = cell,
    email = email,
    nat = nat,
)

internal fun UserDb.toDomain() = User(
    id = id,
    gender = gender,
    titleName = titleName,
    firstName = firstName,
    lastName = lastName,
    profilePicture = profilePicture,
    username = username,
    dateOfBirth = dateOfBirth,
    dateOfRegistration = dateOfRegistration,
    address = address,
    latitude = latitude,
    longitude = longitude,
    phoneNumber = phoneNumber,
    cellNumber = cellNumber,
    email = email,
    nat = nat,
)

internal fun User.toDb() = UserDb(
    id = id,
    gender = gender,
    titleName = titleName,
    firstName = firstName,
    lastName = lastName,
    profilePicture = profilePicture,
    username = username,
    dateOfBirth = dateOfBirth,
    dateOfRegistration = dateOfRegistration,
    address = address,
    latitude = latitude,
    longitude = longitude,
    phoneNumber = phoneNumber,
    cellNumber = cellNumber,
    email = email,
    nat = nat,
)
