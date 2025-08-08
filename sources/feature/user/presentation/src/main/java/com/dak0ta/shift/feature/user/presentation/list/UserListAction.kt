package com.dak0ta.shift.feature.user.presentation.list

sealed interface UserListAction {

    class NavigateToDetails(val userId: String) : UserListAction
}
