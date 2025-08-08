package com.dak0ta.shift.feature.user.impl.data.api.entities

import kotlinx.serialization.Serializable

@Serializable
internal data class LocationApi(
    val street: StreetApi,
    val city: String,
    val state: String,
    val country: String,
    val coordinates: CoordinatesApi
)
