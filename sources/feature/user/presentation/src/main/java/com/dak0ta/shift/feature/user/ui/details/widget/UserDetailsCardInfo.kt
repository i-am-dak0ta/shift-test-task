package com.dak0ta.shift.feature.user.ui.details.widget

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri
import com.dak0ta.shift.feature.user.presentation.details.ui.UserDetailsUi
import com.dak0ta.shift.feature.user.ui.list.widget.UserCardInfoItem

@Suppress("LongMethod")
@Composable
internal fun UserDetailsCardInfo(
    user: UserDetailsUi,
    modifier: Modifier = Modifier,
) {
    val context = LocalContext.current

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        UserCardInfoItem(
            icon = painterResource(user.phoneNumber.icon),
            text = user.phoneNumber.text,
            modifier = Modifier.clickable {
                val intent = Intent(Intent.ACTION_DIAL).apply {
                    data = "tel:${user.phoneNumber.text}".toUri()
                }
                context.startActivity(intent)
            }
        )

        UserCardInfoItem(
            icon = painterResource(user.cellNumber.icon),
            text = user.cellNumber.text,
            modifier = Modifier.clickable {
                val intent = Intent(Intent.ACTION_DIAL).apply {
                    data = "tel:${user.cellNumber.text}".toUri()
                }
                context.startActivity(intent)
            }
        )

        UserCardInfoItem(
            icon = painterResource(user.email.icon),
            text = user.email.text,
            modifier = Modifier.clickable {
                val intent = Intent(Intent.ACTION_SENDTO).apply {
                    data = "mailto:${user.email.text}".toUri()
                }
                context.startActivity(intent)
            }
        )

        UserCardInfoItem(
            icon = painterResource(user.address.icon),
            text = user.address.text,
            modifier = Modifier.clickable {
                val uri = "geo:${user.latitude},${user.longitude}?q=${Uri.encode(user.address.text)}".toUri()
                val intent = Intent(Intent.ACTION_VIEW, uri)
                context.startActivity(intent)
            }
        )

        UserCardInfoItem(
            icon = painterResource(user.gender.icon),
            text = user.gender.text
        )

        UserCardInfoItem(
            icon = painterResource(user.username.icon),
            text = user.username.text
        )

        UserCardInfoItem(
            icon = painterResource(user.dateOfBirth.icon),
            text = user.dateOfBirth.text
        )

        UserCardInfoItem(
            icon = painterResource(user.dateOfRegistration.icon),
            text = user.dateOfRegistration.text
        )

        UserCardInfoItem(
            icon = painterResource(user.nat.icon),
            text = user.nat.text
        )
    }
}
