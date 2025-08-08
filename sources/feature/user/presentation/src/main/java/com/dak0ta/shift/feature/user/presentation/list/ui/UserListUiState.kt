package com.dak0ta.shift.feature.user.presentation.list.ui

import androidx.annotation.StringRes

internal sealed interface UserListUiState {

    object Loading : UserListUiState
    data class Content(
        @param:StringRes @field:StringRes val title: Int,
        val users: List<UserListUi>,
        val isRefreshing: Boolean = false,
    ) : UserListUiState

    data class Error(
        @param:StringRes @field:StringRes val title: Int,
        @param:StringRes @field:StringRes val description: Int,
        @param:StringRes @field:StringRes val retryButtonText: Int,
    ) : UserListUiState
}
