package com.example.baseapp.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Immutable
class Padding(
    val xSmall: Dp = 4.dp,
    val small: Dp = 8.dp,
    val medium: Dp = 16.dp,
    val large: Dp = 24.dp,
    val xLarge: Dp = 32.dp
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Padding) return false

        if (xSmall != other.xSmall) return false
        if (small != other.small) return false
        if (medium != other.medium) return false
        if (large != other.large) return false
        if (xLarge != other.xLarge) return false

        return true
    }

    override fun hashCode(): Int {
        var result = xSmall.hashCode()
        result = 31 * result + small.hashCode()
        result = 31 * result + medium.hashCode()
        result = 31 * result + large.hashCode()
        result = 31 * result + xLarge.hashCode()
        return result
    }

    override fun toString(): String {
        return "Padding(xSmall=$xSmall, small=$small, medium=$medium, large=$large, xLarge=$xLarge)"
    }
}
