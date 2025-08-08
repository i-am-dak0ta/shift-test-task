package com.dak0ta.shift.feature.user.ui.list

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.dak0ta.shift.common.design.ErrorScreen
import com.dak0ta.shift.common.design.LoadingScreen
import com.dak0ta.shift.feature.user.presentation.list.ui.UserListUiState
import com.dak0ta.shift.feature.user.ui.list.widget.UserList

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun UserListScreenContent(
    state: UserListUiState,
    onUserClick: (String) -> Unit,
    onRefresh: () -> Unit,
    onRetryClick: () -> Unit,
) {
    when (state) {
        is UserListUiState.Loading -> {
            LoadingScreen()
        }

        is UserListUiState.Content -> {
            Scaffold(
                topBar = {
                    TopAppBar(
                        windowInsets = WindowInsets(0.dp),
                        title = {
                            Text(
                                text = stringResource(state.title),
                                style = MaterialTheme.typography.headlineLarge
                            )
                        },
                    )
                },
            ) { innerPadding ->
                UserList(
                    state = state,
                    onUserClick = onUserClick,
                    onRefresh = onRefresh,
                    modifier = Modifier.padding(innerPadding)
                )
            }
        }

        is UserListUiState.Error -> {
            ErrorScreen(
                title = stringResource(state.title),
                description = stringResource(state.description),
                retryButtonText = stringResource(state.retryButtonText),
                onRetryClick = onRetryClick,
            )
        }
    }
}
