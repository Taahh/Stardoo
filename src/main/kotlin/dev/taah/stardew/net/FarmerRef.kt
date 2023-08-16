package dev.taah.stardew.net

import dev.taah.stardew.util.PacketBuffer
import dev.taah.stardew.util.serialization.INetObject

/**
 * @author Taah
 * @project stardew-server
 * @since 3:09 AM [15-08-2023]
 */
class FarmerRef : INetObject {

    var defined: Boolean = false
    var uid: Long = 0L
    override fun serialize(buffer: PacketBuffer) {
        buffer.writeBoolean(defined)
        buffer.writeLongLE(uid)
    }

    override fun deserialize(buffer: PacketBuffer) {
        TODO("Not yet implemented")
    }
}