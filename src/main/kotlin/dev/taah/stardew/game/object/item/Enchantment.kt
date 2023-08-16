package dev.taah.stardew.game.`object`.item

import dev.taah.stardew.util.PacketBuffer
import dev.taah.stardew.util.serialization.INetObject

/**
 * @author Taah
 * @project stardew-server
 * @since 3:05 PM [16-08-2023]
 */
class Enchantment : INetObject {
    var level: Int = 0
    override fun serialize(buffer: PacketBuffer) {
        buffer.writeIntLE(level)
    }

    override fun deserialize(buffer: PacketBuffer) {
        TODO("Not yet implemented")
    }
}