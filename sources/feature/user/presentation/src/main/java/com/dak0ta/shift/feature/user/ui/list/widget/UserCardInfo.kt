package com.dak0ta.shift.feature.user.ui.list.widget

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.dak0ta.shift.feature.user.presentation.list.ui.UserListUi

@Composable
internal fun UserCardInfo(
    user: UserListUi,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        UserCardInfoItem(
            icon = painterResource(user.phoneNumber.icon),
            text = user.phoneNumber.text
        )

        UserCardInfoItem(
            icon = painterResource(user.address.icon),
            text = user.address.text
        )
    }
}
