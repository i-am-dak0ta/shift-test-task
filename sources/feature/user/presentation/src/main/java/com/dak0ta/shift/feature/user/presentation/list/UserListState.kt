package com.dak0ta.shift.feature.user.presentation.list

import com.dak0ta.shift.feature.user.api.entities.User

internal sealed interface UserListState {

    object Loading : UserListState
    data class Content(
        val users: List<User>,
        val isRefreshing: Boolean = false,
    ) : UserListState

    object Error : UserListState
}
