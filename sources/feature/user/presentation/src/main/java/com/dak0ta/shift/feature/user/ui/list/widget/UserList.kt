package com.dak0ta.shift.feature.user.ui.list.widget

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dak0ta.shift.feature.user.presentation.list.ui.UserListUiState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun UserList(
    state: UserListUiState.Content,
    onUserClick: (String) -> Unit,
    onRefresh: () -> Unit,
    modifier: Modifier = Modifier,
) {
    PullToRefreshBox(
        isRefreshing = state.isRefreshing,
        onRefresh = { onRefresh() },
        modifier = modifier
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxWidth()
        ) {
            items(state.users, key = { it.id }) { user ->
                UserCard(
                    user = user,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    onUserClick = { onUserClick(user.id) }
                )
                Spacer(Modifier.height(16.dp))
            }
        }
    }
}
