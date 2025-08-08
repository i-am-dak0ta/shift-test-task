package com.dak0ta.shift.feature.user.presentation.list

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.dak0ta.shift.common.coroutine.runSuspendCatching
import com.dak0ta.shift.common.network.BaseViewModel
import com.dak0ta.shift.feature.user.api.usecases.GetUsersUseCase
import com.dak0ta.shift.feature.user.api.usecases.ObserveUsersUseCase
import com.dak0ta.shift.feature.user.api.usecases.RefreshUsersUseCase
import com.dak0ta.shift.feature.user.presentation.list.ui.UserListStateMapper
import com.dak0ta.shift.feature.user.presentation.list.ui.UserListUiState
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

internal class UserListViewModel(
    private val getUsersUseCase: GetUsersUseCase,
    private val refreshUsersUseCase: RefreshUsersUseCase,
    private val observeUsersUseCase: ObserveUsersUseCase,
    mapper: UserListStateMapper
) : BaseViewModel() {

    private val dataState: MutableStateFlow<UserListState> = MutableStateFlow(UserListState.Loading)
    val uiState: StateFlow<UserListUiState> = dataState.map(mapper).stateInViewModel(UserListUiState.Loading)
    private val _action = Channel<UserListAction>(Channel.BUFFERED)
    val action: Flow<UserListAction> = _action.receiveAsFlow()

    override fun onFirstInit() {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch {
            runSuspendCatching {
                getUsersUseCase()
            }
                .onSuccess { users ->
                    dataState.value = UserListState.Content(users)
                    observeUsers()
                }
                .onFailure {
                    Log.e(TAG, "getUsersUseCase has failed", it)
                    dataState.value = UserListState.Error
                }
        }
    }

    private fun observeUsers() {
        viewModelScope.launch {
            observeUsersUseCase().onEach { newUsers ->
                updateContentState { currentContent ->
                    currentContent.copy(users = newUsers)
                }
            }
                .launchIn(this)
        }
    }

    internal fun onUserClick(userId: String) {
        viewModelScope.launch {
            _action.send(UserListAction.NavigateToDetails(userId))
        }
    }

    internal fun onRefresh() {
        viewModelScope.launch {
            updateContentState {
                it.copy(isRefreshing = true)
            }
            runSuspendCatching {
                refreshUsersUseCase()
            }
                .onFailure {
                    Log.e(TAG, "refreshUsersUseCase has failed", it)
                }
            updateContentState {
                it.copy(isRefreshing = false)
            }
        }
    }

    internal fun onRetryClick() {
        dataState.update { UserListState.Loading }
        loadData()
    }

    private fun updateContentState(block: (UserListState.Content) -> UserListState.Content) {
        dataState.update { oldState ->
            if (oldState is UserListState.Content) {
                block(oldState)
            } else {
                oldState
            }
        }
    }

    private companion object {

        const val TAG = "UserListViewModel"
    }
}
