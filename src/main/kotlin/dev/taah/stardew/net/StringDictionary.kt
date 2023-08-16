package dev.taah.stardew.net

import dev.taah.stardew.util.PacketBuffer
import dev.taah.stardew.util.serialization.INetObject

/**
 * @author Taah
 * @project stardew-server
 * @since 3:22 AM [16-08-2023]
 */
class StringDictionary<T> : INetObject
where T: INetObject {
    val dict: Map<String, T>  = mutableMapOf()
    override fun serialize(buffer: PacketBuffer) {
        buffer.writeIntLE(dict.size)
        dict.forEach { (t, u) ->
            buffer.writeString(t)
            u.serialize(buffer)
        }
    }

    override fun deserialize(buffer: PacketBuffer) {
        TODO("Not yet implemented")
    }
}