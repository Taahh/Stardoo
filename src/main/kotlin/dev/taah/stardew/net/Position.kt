package dev.taah.stardew.net

import dev.taah.stardew.util.PacketBuffer
import dev.taah.stardew.util.serialization.INetObject
import dev.taah.stardew.util.world.Vector2

/**
 * @author Taah
 * @project stardew-server
 * @since 12:29 AM [15-08-2023]
 */
class Position(val vector: Vector2) : INetObject {
    var moving = false;
    var pausedEvent = false;
    override fun serialize(buffer: PacketBuffer) {
        vector.serialize(buffer)
        buffer.writeBoolean(pausedEvent)
        buffer.writeBoolean(moving)
    }

    override fun deserialize(buffer: PacketBuffer) {
        TODO("Not yet implemented")
    }
}