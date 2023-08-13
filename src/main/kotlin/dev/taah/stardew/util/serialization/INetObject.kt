package dev.taah.stardew.util.serialization

import dev.taah.stardew.connection.PlayerConnection
import dev.taah.stardew.util.PacketBuffer

/**
 * @author Taah
 * @project stardew-server
 * @since 11:45 PM [12-08-2023]
 *
 */
interface INetObject {
    fun serialize(buffer: PacketBuffer);
    fun deserialize(buffer: PacketBuffer)
}