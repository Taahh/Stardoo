package dev.taah.stardew.packet.reliable

/**
 * @author Taah
 * @project stardew-server
 * @since 5:02 AM [13-08-2023]
 */
enum class ReliableType(val messageId: Byte) {
    AVAILABLE_FARMHANDS(9),
    WAITING_FOR_hOST(11)
}