package dev.taah.stardew.net

import dev.taah.stardew.util.PacketBuffer
import dev.taah.stardew.util.serialization.INetObject

/**
 * @author Taah
 * @project stardew-server
 * @since 11:31 PM [15-08-2023]
 */
class DancePartner : INetObject {
    var farmerRef: FarmerRef = FarmerRef()
    var villager = ""
    override fun serialize(buffer: PacketBuffer) {
        farmerRef.serialize(buffer)
        buffer.writeString(villager)
    }

    override fun deserialize(buffer: PacketBuffer) {
        TODO("Not yet implemented")
    }
}