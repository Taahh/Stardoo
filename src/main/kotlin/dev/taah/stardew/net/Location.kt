package dev.taah.stardew.net

import dev.taah.stardew.util.PacketBuffer
import dev.taah.stardew.util.serialization.INetObject

/**
 * @author Taah
 * @project stardew-server
 * @since 3:06 AM [15-08-2023]
 */
class Location(var locationName: String, var isStructure: Boolean) : INetObject {
    override fun serialize(buffer: PacketBuffer) {
        buffer.writeString(locationName)
        buffer.writeBoolean(isStructure)
    }

    override fun deserialize(buffer: PacketBuffer) {
        TODO("Not yet implemented")
    }
}