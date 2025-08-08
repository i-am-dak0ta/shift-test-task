package com.dak0ta.shift.feature.user.ui.details

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import com.dak0ta.shift.feature.user.presentation.details.ui.UserDetailsUiState
import com.dak0ta.shift.feature.user.ui.details.widget.UserDetailsCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun UserDetailsScreenContent(
    state: UserDetailsUiState,
    onBackClick: () -> Unit,
    onRetryClick: () -> Unit,
) {
    when (state) {
        is UserDetailsUiState.Loading -> {
            LoadingScreen()
        }

        is UserDetailsUiState.Content -> {
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
                        navigationIcon = {
                            IconButton(onClick = onBackClick) {
                                Icon(
                                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                    contentDescription = null
                                )
                            }
                        },
                    )
                },
            ) { innerPadding ->
                UserDetailsCard(
                    user = state.user,
                    modifier = Modifier
                        .verticalScroll(rememberScrollState())
                        .padding(innerPadding)
                )
            }
        }

        is UserDetailsUiState.Error -> {
            ErrorScreen(
                title = stringResource(state.title),
                description = stringResource(state.description),
                retryButtonText = stringResource(state.retryButtonText),
                onRetryClick = onRetryClick,
            )
        }
    }
}
