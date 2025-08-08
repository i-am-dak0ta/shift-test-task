package com.dak0ta.shift.feature.user.ui.list

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.dak0ta.shift.common.navigation.LocalNavController
import com.dak0ta.shift.feature.user.api.navigation.UserDetailsDirection
import com.dak0ta.shift.feature.user.presentation.list.UserListAction
import com.dak0ta.shift.feature.user.presentation.list.UserListViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.koin.androidx.compose.koinViewModel

@Composable
fun UserListScreen() {
    val viewModel: UserListViewModel = koinViewModel()
    val state by viewModel.uiState.collectAsState()
    val navController = LocalNavController.current

    LaunchedEffect(viewModel) {
        viewModel.initialize()

        viewModel.action
            .onEach { action ->
                when (action) {
                    is UserListAction.NavigateToDetails -> {
                        navController.navigate(UserDetailsDirection.createRoute(action.userId))
                    }
                }
            }
            .launchIn(this)
    }

    UserListScreenContent(
        state = state,
        onUserClick = viewModel::onUserClick,
        onRefresh = viewModel::onRefresh,
        onRetryClick = viewModel::onRetryClick,
    )
}
