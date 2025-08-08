package com.dak0ta.shift.feature.user.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.dak0ta.shift.feature.user.api.navigation.UserDetailsDirection
import com.dak0ta.shift.feature.user.api.navigation.UserListDirection
import com.dak0ta.shift.feature.user.ui.details.UserDetailsScreen
import com.dak0ta.shift.feature.user.ui.list.UserListScreen

fun NavGraphBuilder.userNavGraph() {
    composable(UserListDirection.route) {
        UserListScreen()
    }

    composable(
        route = UserDetailsDirection.route,
        arguments = listOf(
            navArgument(UserDetailsDirection.ARG_USER_ID) {
                type = NavType.StringType
                nullable = false
            }
        )
    ) { backStackEntry -> UserDetailsScreen() }
}
