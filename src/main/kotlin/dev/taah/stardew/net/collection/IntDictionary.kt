package dev.taah.stardew.net.collection

import dev.taah.stardew.util.PacketBuffer
import dev.taah.stardew.util.serialization.INetObject
import dev.taah.stardew.util.serialization.NetObjectSerializers

/**
 * @author Taah
 * @project stardew-server
 * @since 3:22 AM [16-08-2023]
 */
class IntDictionary<T> : INetObject {
    val dict: Map<Int, T>  = mutableMapOf()
    override fun serialize(buffer: PacketBuffer) {
        buffer.writeIntLE(dict.size)
        dict.forEach { (t, u) ->
            buffer.writeIntLE(t)
            //TODO: i'm supposed to write like another dict value here? according to netdictionary in code
            NetObjectSerializers.getSerializer(u!!.javaClass)?.accept(buffer, u)
        }
    }

    override fun deserialize(buffer: PacketBuffer) {
        TODO("Not yet implemented")
    }
}