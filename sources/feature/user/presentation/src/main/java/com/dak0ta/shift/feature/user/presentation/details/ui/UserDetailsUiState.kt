package com.dak0ta.shift.feature.user.presentation.details.ui

import androidx.annotation.StringRes

internal sealed interface UserDetailsUiState {

    object Loading : UserDetailsUiState
    data class Content(
        @param:StringRes @field:StringRes val title: Int,
        val user: UserDetailsUi
    ) : UserDetailsUiState

    data class Error(
        @param:StringRes @field:StringRes val title: Int,
        @param:StringRes @field:StringRes val description: Int,
        @param:StringRes @field:StringRes val retryButtonText: Int,
    ) : UserDetailsUiState
}
