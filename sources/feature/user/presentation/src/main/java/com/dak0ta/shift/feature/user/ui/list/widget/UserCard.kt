package com.dak0ta.shift.feature.user.ui.list.widget

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dak0ta.shift.feature.user.presentation.list.ui.UserListUi

@Composable
internal fun UserCard(
    user: UserListUi,
    modifier: Modifier = Modifier,
    onUserClick: (String) -> Unit = {}
) {
    Card(
        onClick = { onUserClick(user.id) },
        shape = RoundedCornerShape(32.dp),
        modifier = modifier
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            UserCardHeader(
                user = user,
                modifier = Modifier.fillMaxWidth()
            )

            HorizontalDivider(Modifier, DividerDefaults.Thickness, DividerDefaults.color)

            UserCardInfo(
                user = user,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}
