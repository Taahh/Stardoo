package dev.taah.stardew.game.customization

import dev.taah.stardew.game.`object`.Item
import dev.taah.stardew.util.PacketBuffer

/**
 * @author Taah
 * @project stardew-server
 * @since 9:47 PM [15-08-2023]
 */
class Boots : Item() {
    var defenseBonus: Int = 0
    var immunityBonus: Int = 0
    var indexInTileSheet: Int = 0
    var price: Int = 0
    var indexInColorSheet: Int = 0

    init {
        category = -97
    }
    override fun serialize(buffer: PacketBuffer) {
        super.serialize(buffer)
        buffer.writeIntLE(defenseBonus)
        buffer.writeIntLE(immunityBonus)
        buffer.writeIntLE(indexInTileSheet)
        buffer.writeIntLE(price)
        buffer.writeIntLE(indexInColorSheet)
    }

    override fun deserialize(buffer: PacketBuffer) {
        TODO("Not yet implemented")
    }
}