package dev.taah.stardew.game.customization

import dev.taah.stardew.game.`object`.Item
import dev.taah.stardew.util.PacketBuffer
import dev.taah.stardew.util.serialization.INetObject

/**
 * @author Taah
 * @project stardew-server
 * @since 9:47 PM [15-08-2023]
 */
class Ring : Item() {
    var price: Int = 0
    var indexInTileSheet: Int = 0
    var uniqueID: Int = 0

    init {
        category = -96
    }
    override fun serialize(buffer: PacketBuffer) {
        super.serialize(buffer)
        buffer.writeIntLE(price)
        buffer.writeIntLE(indexInTileSheet)
        buffer.writeIntLE(uniqueID)
    }

    override fun deserialize(buffer: PacketBuffer) {
        TODO("Not yet implemented")
    }
}