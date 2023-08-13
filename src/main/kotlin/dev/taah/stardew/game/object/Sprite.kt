package dev.taah.stardew.game.`object`

import dev.taah.stardew.util.PacketBuffer
import dev.taah.stardew.util.serialization.INetObject

/**
 * @author Taah
 * @project stardew-server
 * @since 11:44 PM [12-08-2023]
 *
 */
class Sprite(val name: String, val width: Int, val height: Int): INetObject {
    override fun serialize(buffer: PacketBuffer) {

    }

    override fun deserialize(buffer: PacketBuffer) {
        TODO("Not yet implemented")
    }
}