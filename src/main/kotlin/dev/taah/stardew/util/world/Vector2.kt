package dev.taah.stardew.util.world

import dev.taah.stardew.util.PacketBuffer
import dev.taah.stardew.util.serialization.INetObject

/**
 * @author Taah
 * @project stardew-server
 * @since 5:23 AM [14-08-2023]
 */
class Vector2(var x: Float, var y: Float) : INetObject {
    companion object {
        val ZERO = Vector2(0f, 0f)
    }
    override fun serialize(buffer: PacketBuffer) {
        buffer.writeFloatLE(x)
        buffer.writeFloatLE(y)
    }

    override fun deserialize(buffer: PacketBuffer) {
    }
}