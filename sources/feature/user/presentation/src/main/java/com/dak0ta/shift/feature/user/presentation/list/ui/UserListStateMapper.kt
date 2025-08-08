package com.dak0ta.shift.feature.user.presentation.list.ui

import com.dak0ta.shift.common.resources.R
import com.dak0ta.shift.feature.user.api.entities.User
import com.dak0ta.shift.feature.user.presentation.list.UserListState

internal class UserListStateMapper : (UserListState) -> UserListUiState {

    override fun invoke(state: UserListState): UserListUiState {
        return when (state) {
            is UserListState.Loading -> UserListUiState.Loading
            is UserListState.Content -> mapContentState(state)
            is UserListState.Error -> mapErrorState()
        }
    }

    private fun mapContentState(state: UserListState.Content): UserListUiState.Content {
        return UserListUiState.Content(
            title = R.string.screen_title_user_list,
            users = mapUsersToUi(state.users),
            isRefreshing = state.isRefreshing,
        )
    }

    private fun mapUsersToUi(users: List<User>): List<UserListUi> {
        return users.map { user ->
            UserListUi(
                id = user.id,
                fullName = user.fullName,
                profilePicture = user.profilePicture,
                address = UserUiInfoItem(
                    icon = R.drawable.place_24,
                    text = user.address
                ),
                phoneNumber = UserUiInfoItem(
                    icon = R.drawable.phone_24,
                    text = user.phoneNumber
                ),
            )
        }
    }

    private fun mapErrorState(): UserListUiState.Error {
        return UserListUiState.Error(
            title = R.string.error_screen_title,
            description = R.string.error_screen_description,
            retryButtonText = R.string.retry_button_text,
        )
    }
}
