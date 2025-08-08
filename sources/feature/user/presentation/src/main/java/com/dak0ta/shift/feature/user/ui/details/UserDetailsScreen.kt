package com.dak0ta.shift.feature.user.ui.details

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.dak0ta.shift.common.navigation.LocalNavController
import com.dak0ta.shift.feature.user.api.navigation.UserDetailsDirection
import com.dak0ta.shift.feature.user.presentation.details.UserDetailsAction
import com.dak0ta.shift.feature.user.presentation.details.UserDetailsViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf

@Composable
fun UserDetailsScreen() {
    val navController = LocalNavController.current
    val backStackEntry = navController.currentBackStackEntry
    val encodedId = backStackEntry?.arguments?.getString(UserDetailsDirection.ARG_USER_ID)
    val userId = UserDetailsDirection.decodeUserId(encodedId)
    val viewModel: UserDetailsViewModel = koinViewModel(parameters = { parametersOf(userId) })
    val state by viewModel.uiState.collectAsState()

    LaunchedEffect(viewModel) {
        viewModel.initialize()

        viewModel.action
            .onEach { action ->
                when (action) {
                    is UserDetailsAction.NavigateToList -> {
                        navController.popBackStack()
                    }
                }
            }
            .launchIn(this)
    }

    UserDetailsScreenContent(
        state = state,
        onBackClick = viewModel::onBackClick,
        onRetryClick = viewModel::onRetryClick,
    )
}
