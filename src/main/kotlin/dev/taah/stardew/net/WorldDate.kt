package dev.taah.stardew.net

import dev.taah.stardew.util.PacketBuffer
import dev.taah.stardew.util.serialization.INetObject
import dev.taah.stardew.util.serialization.NetObjectUtil.Companion.writeFields

/**
 * @author Taah
 * @project stardew-server
 * @since 3:08 AM [16-08-2023]
 */
class WorldDate : INetObject {
    var year: Int = 0
    var seasonIndex: Int = 0
    var dayOfMonth: Int = 0
    override fun serialize(buffer: PacketBuffer) {
        writeFields(buffer)
    }

    override fun deserialize(buffer: PacketBuffer) {
        TODO("Not yet implemented")
    }
}