package com.dak0ta.shift.feature.user.ui.details.widget

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
import com.dak0ta.shift.feature.user.presentation.details.ui.UserDetailsUi

@Composable
internal fun UserDetailsCard(
    user: UserDetailsUi,
    modifier: Modifier = Modifier,
) {
    Card(
        shape = RoundedCornerShape(32.dp),
        modifier = modifier.padding(horizontal = 16.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            UserDetailsCardHeader(
                user = user,
                modifier = Modifier.fillMaxWidth()
            )

            HorizontalDivider(Modifier, DividerDefaults.Thickness, DividerDefaults.color)

            UserDetailsCardInfo(
                user = user,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}
