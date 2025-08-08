package com.dak0ta.shift.feature.user.presentation.details

import com.dak0ta.shift.feature.user.api.entities.User

internal sealed interface UserDetailsState {

    object Loading : UserDetailsState
    data class Content(val user: User) : UserDetailsState
    object Error : UserDetailsState
}
