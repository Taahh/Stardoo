package dev.taah.stardew.net.friendship

import dev.taah.stardew.util.serialization.IShortEnum

/**
 * @author Taah
 * @project stardew-server
 * @since 3:11 AM [16-08-2023]
 */
enum class FriendshipStatus(override val value: Short) : IShortEnum {
    FRIENDLY(0),
    DATING(1),
    ENGAGED(2),
    MARRIED(3),
    DIVORCED(4)
}