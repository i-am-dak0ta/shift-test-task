package com.dak0ta.shift.feature.user.presentation.details.ui

import com.dak0ta.shift.common.resources.R
import com.dak0ta.shift.feature.user.presentation.details.UserDetailsState
import com.dak0ta.shift.feature.user.presentation.list.ui.UserUiInfoItem

internal class UserDetailsStateMapper : (UserDetailsState) -> UserDetailsUiState {

    override fun invoke(state: UserDetailsState): UserDetailsUiState {
        return when (state) {
            is UserDetailsState.Loading -> UserDetailsUiState.Loading
            is UserDetailsState.Content -> mapContentState(state)
            is UserDetailsState.Error -> mapErrorState()
        }
    }

    private fun mapContentState(state: UserDetailsState.Content): UserDetailsUiState.Content {
        return UserDetailsUiState.Content(
            title = R.string.screen_title_user_details,
            user = UserDetailsUi(
                id = state.user.id,
                gender = UserUiInfoItem(
                    icon = R.drawable.gender_24,
                    text = state.user.gender
                ),
                fullName = state.user.fullName,
                profilePicture = state.user.profilePicture,
                username = UserUiInfoItem(
                    icon = R.drawable.username_24,
                    text = state.user.username
                ),
                dateOfBirth = UserUiInfoItem(
                    icon = R.drawable.calendar_24,
                    text = state.user.dateOfBirth
                ),
                dateOfRegistration = UserUiInfoItem(
                    icon = R.drawable.calendar_24,
                    text = state.user.dateOfRegistration
                ),
                address = UserUiInfoItem(
                    icon = R.drawable.place_24,
                    text = state.user.address
                ),
                latitude = state.user.latitude,
                longitude = state.user.longitude,
                phoneNumber = UserUiInfoItem(
                    icon = R.drawable.phone_24,
                    text = state.user.phoneNumber
                ),
                cellNumber = UserUiInfoItem(
                    icon = R.drawable.cell_phone_24,
                    text = state.user.cellNumber
                ),
                email = UserUiInfoItem(
                    icon = R.drawable.email_24,
                    text = state.user.email
                ),
                nat = UserUiInfoItem(
                    icon = R.drawable.nationality_24,
                    text = state.user.nat
                ),
            )
        )
    }

    private fun mapErrorState(): UserDetailsUiState.Error {
        return UserDetailsUiState.Error(
            title = R.string.error_screen_title,
            description = R.string.error_screen_description,
            retryButtonText = R.string.retry_button_text,
        )
    }
}
