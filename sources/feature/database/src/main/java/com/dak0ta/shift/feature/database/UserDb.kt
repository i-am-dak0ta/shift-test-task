package com.dak0ta.shift.feature.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class UserDb(
    @PrimaryKey val id: String,
    @ColumnInfo(name = "gender") val gender: String,
    @ColumnInfo(name = "title_name") val titleName: String,
    @ColumnInfo(name = "first_name") val firstName: String,
    @ColumnInfo(name = "last_name") val lastName: String,
    @ColumnInfo(name = "profile_picture") val profilePicture: String,
    @ColumnInfo(name = "username") val username: String,
    @ColumnInfo(name = "date_of_birth") val dateOfBirth: String,
    @ColumnInfo(name = "date_of_registration") val dateOfRegistration: String,
    @ColumnInfo(name = "address") val address: String,
    @ColumnInfo(name = "latitude") val latitude: String,
    @ColumnInfo(name = "longitude") val longitude: String,
    @ColumnInfo(name = "phone") val phoneNumber: String,
    @ColumnInfo(name = "cell") val cellNumber: String,
    @ColumnInfo(name = "email") val email: String,
    @ColumnInfo(name = "nat") val nat: String
)
