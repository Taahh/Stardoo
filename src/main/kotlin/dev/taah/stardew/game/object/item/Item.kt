package dev.taah.stardew.game.`object`.item

import dev.taah.stardew.util.PacketBuffer
import dev.taah.stardew.util.serialization.INetObject

/**
 * @author Taah
 * @project stardew-server
 * @since 9:41 PM [15-08-2023]
 */
open class Item : INetObject {
    var specialVariable: Int = 0
    var category: Int = 0
    var name: String = ""
    var parentSheetIndex: Int = 0
    var hasBeenInInventory: Boolean = false
    var modData: String = ""
    override fun serialize(buffer: PacketBuffer) {
        buffer.writeIntLE(specialVariable)
        buffer.writeIntLE(category)
        buffer.writeString(name)
        buffer.writeIntLE(parentSheetIndex)
        buffer.writeBoolean(hasBeenInInventory)
        buffer.writeString(modData)
    }

    override fun deserialize(buffer: PacketBuffer) {
        TODO("Not yet implemented")
    }
}