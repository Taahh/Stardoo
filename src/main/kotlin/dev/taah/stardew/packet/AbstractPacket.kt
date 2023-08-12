package dev.taah.stardew.packet

import dev.taah.stardew.connection.PlayerConnection
import dev.taah.stardew.util.PacketBuffer

/**
 * @author Taah
 * @project stardew-server
 * @since 12:30 AM [12-08-2023]
 *
 */
abstract class AbstractPacket<in T: AbstractPacket<T>>(val packetType: Int) {

    open fun serialize(buffer: PacketBuffer) {
        buffer.writeByte(packetType)
        buffer.writeByte(0)
        buffer.writeByte(0)
        buffer.writeShort(0);
    }
    abstract fun deserialize(buffer: PacketBuffer)
    abstract fun processPacket(packet: T, connection: PlayerConnection)
}