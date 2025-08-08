package com.dak0ta.shift.app.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.dak0ta.shift.common.navigation.LocalNavController
import com.dak0ta.shift.feature.user.api.navigation.UserListDirection
import com.dak0ta.shift.feature.user.presentation.navigation.userNavGraph

@Composable
fun NavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    CompositionLocalProvider(LocalNavController provides navController) {
        NavHost(
            navController = navController,
            startDestination = UserListDirection.route,
            modifier = modifier
        ) {
            userNavGraph()
        }
    }
}
