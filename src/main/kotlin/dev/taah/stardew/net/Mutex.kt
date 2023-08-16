package dev.taah.stardew.net

import dev.taah.stardew.util.PacketBuffer
import dev.taah.stardew.util.serialization.INetObject

/**
 * @author Taah
 * @project stardew-server
 * @since 11:11 PM [15-08-2023]
 */
class Mutex : INetObject {
    companion object {
        val NO_OWNER = -1L
    }
    var owner = -1L
    var lockRequest = 0L
    override fun serialize(buffer: PacketBuffer) {
        buffer.writeLongLE(owner)
        buffer.writeLongLE(lockRequest)
    }

    override fun deserialize(buffer: PacketBuffer) {
        TODO("Not yet implemented")
    }

}