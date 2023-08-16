package dev.taah.stardew.game

import dev.taah.stardew.game.entity.Character
import dev.taah.stardew.util.PacketBuffer
import dev.taah.stardew.util.serialization.INetObject

/**
 * @author Taah
 * @project stardew-server
 * @since 5:03 AM [14-08-2023]
 */
open class GameLocation(val mapPath: String, val name: String) : INetObject {
    val characters = mutableSetOf<Character>()
    override fun serialize(buffer: PacketBuffer) {
        buffer.writeString(mapPath)
    }

    override fun deserialize(buffer: PacketBuffer) {

    }
}