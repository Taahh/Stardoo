package dev.taah.stardew.net.friendship

/**
 * @author Taah
 * @project stardew-server
 * @since 3:11 AM [16-08-2023]
 */
enum class FriendshipStatus(val index: Short) {
    FRIENDLY(0),
    DATING(1),
    ENGAGED(2),
    MARRIED(3),
    DIVORCED(4)
}