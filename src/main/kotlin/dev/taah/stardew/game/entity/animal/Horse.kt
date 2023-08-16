package dev.taah.stardew.game.entity.animal

import dev.taah.stardew.game.customization.Hat
import dev.taah.stardew.game.entity.NPC
import dev.taah.stardew.game.`object`.Sprite
import dev.taah.stardew.net.FarmerRef
import dev.taah.stardew.net.Mutex
import dev.taah.stardew.util.PacketBuffer
import dev.taah.stardew.util.serialization.NetObjectUtil.Companion.writeFields
import dev.taah.stardew.util.world.Vector2
import java.util.UUID

/**
 * @author Taah
 * @project stardew-server
 * @since 11:03 PM [15-08-2023]
 */
class Horse : NPC() {
    var horseId: UUID = UUID.randomUUID()
    var rider: FarmerRef = FarmerRef()
    var mounting: Boolean = false
    var dismounting: Boolean = false
    var hat: Hat = Hat()
    var mutex = Mutex()
    var ownerId: Long = 0L

    init {
        this.sprite = Sprite("Animals\\horse", 32, 32)
    }

    override fun serialize(buffer: PacketBuffer) {
        super.serialize(buffer)
//        buffer.writeUUID(horseId)
//        rider.serialize(buffer)
//        buffer.writeBoolean(mounting)
//        buffer.writeBoolean(dismounting)
//        hat.serialize(buffer)
//        mutex.serialize(buffer)
//        buffer.writeLongLE(ownerId)
        writeFields(buffer)
    }
}