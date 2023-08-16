package dev.taah.stardew.game.`object`.item

import dev.taah.stardew.game.`object`.StardewObject
import dev.taah.stardew.net.collection.NetList
import dev.taah.stardew.util.PacketBuffer

/**
 * @author Taah
 * @project stardew-server
 * @since 2:56 PM [16-08-2023]
 */
class Tool : Item() {

    var initialParentTileIndex: Int = 0
    var currentParentTileIndex: Int = 0
    var indexOfMenuItemView: Int = 0
    var stackable: Boolean = false
    var instantUse: Boolean = false
    var upgradeLevel: Int = 0
    var numAttachmentSlots: Int = 0
    var attachments: NetList<StardewObject> = NetList(false)
    var enchantments: NetList<Enchantment> = NetList()
    var isEfficient: Boolean = false
    var animationSpeedModifier: Float = 0f
    var previousEnchantments: NetList<String> = NetList()

    init {
        category = -99
    }

    override fun serialize(buffer: PacketBuffer) {
        super.serialize(buffer)

    }
}