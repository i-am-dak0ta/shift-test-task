package com.dak0ta.shift.feature.user.api.navigation

import com.dak0ta.shift.common.navigation.Direction
import java.net.URLDecoder
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

object UserDetailsDirection : Direction {

    const val ARG_USER_ID = "userId"
    const val ROUTE_PATTERN = "user_details/{$ARG_USER_ID}"

    override val route: String = ROUTE_PATTERN

    fun createRoute(userId: String): String {
        val encoded = URLEncoder.encode(userId, StandardCharsets.UTF_8.toString())
        return "user_details/$encoded"
    }

    fun decodeUserId(encoded: String?): String? =
        encoded?.let { URLDecoder.decode(it, StandardCharsets.UTF_8.toString()) }
}
