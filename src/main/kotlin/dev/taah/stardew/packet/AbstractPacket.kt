package dev.taah.stardew.packet

import dev.taah.stardew.util.PacketBuffer
import dev.taah.stardew.util.serialization.INetObject

/**
 * @author Taah
 * @project stardew-server
 * @since 12:30 AM [12-08-2023]
 *
 */
abstract class AbstractPacket<in T: AbstractPacket<T>>(val packetType: Int) : INetObject {

    open override fun serialize(buffer: PacketBuffer) {
        buffer.writeByte(packetType)
        buffer.writeByte(0)
        buffer.writeByte(0)
        buffer.writeShort(0);
    }
}