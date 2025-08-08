package com.dak0ta.shift.feature.user.presentation.details

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.dak0ta.shift.common.coroutine.runSuspendCatching
import com.dak0ta.shift.common.network.BaseViewModel
import com.dak0ta.shift.feature.user.api.usecases.GetUserByIdUseCase
import com.dak0ta.shift.feature.user.presentation.details.ui.UserDetailsStateMapper
import com.dak0ta.shift.feature.user.presentation.details.ui.UserDetailsUiState
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

internal class UserDetailsViewModel(
    private val userId: String,
    private val getUserByIdUseCase: GetUserByIdUseCase,
    mapper: UserDetailsStateMapper
) : BaseViewModel() {

    private val dataState: MutableStateFlow<UserDetailsState> = MutableStateFlow(UserDetailsState.Loading)
    val uiState: StateFlow<UserDetailsUiState> = dataState.map(mapper).stateInViewModel(UserDetailsUiState.Loading)
    private val _action = Channel<UserDetailsAction>(Channel.BUFFERED)
    val action: Flow<UserDetailsAction> = _action.receiveAsFlow()

    override fun onFirstInit() {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch {
            runSuspendCatching {
                getUserByIdUseCase(userId)
            }
                .onSuccess { user ->
                    dataState.value = UserDetailsState.Content(user)
                }
                .onFailure {
                    Log.e(TAG, "getUserByIdUseCase has failed", it)
                    dataState.value = UserDetailsState.Error
                }
        }
    }

    internal fun onBackClick() {
        viewModelScope.launch {
            _action.send(UserDetailsAction.NavigateToList())
        }
    }

    internal fun onRetryClick() {
        dataState.update { UserDetailsState.Loading }
        loadData()
    }

    private companion object {

        const val TAG = "UserDetailsViewModel"
    }
}
