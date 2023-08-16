package dev.taah.stardew.game.customization

import dev.taah.stardew.game.`object`.Item
import dev.taah.stardew.util.PacketBuffer
import dev.taah.stardew.util.serialization.INetObject

/**
 * @author Taah
 * @project stardew-server
 * @since 9:45 PM [15-08-2023]
 */
class Hat :
    Item() {
    var hatId: Int = 0
    var ignoreHairOffset: Boolean = false
    var hairDrawType: Int = 0
    var isPrismatic: Boolean = false

    init {
        category = -95
    }

    override fun serialize(buffer: PacketBuffer) {
        super.serialize(buffer)
        buffer.writeIntLE(hatId)
        buffer.writeBoolean(ignoreHairOffset)
        buffer.writeIntLE(hairDrawType)
        buffer.writeBoolean(isPrismatic)
    }

    override fun deserialize(buffer: PacketBuffer) {
        TODO("Not yet implemented")
    }
}