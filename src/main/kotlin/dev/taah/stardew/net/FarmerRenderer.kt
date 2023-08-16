package dev.taah.stardew.net

import dev.taah.stardew.util.PacketBuffer
import dev.taah.stardew.util.serialization.INetObject
import dev.taah.stardew.util.serialization.NetObjectUtil.Companion.writeFields
import java.awt.Color

/**
 * @author Taah
 * @project stardew-server
 * @since 2:08 PM [15-08-2023]
 */
class FarmerRenderer(val textureName: String, var heightOffset: Int, var eyes: Color, var skin: Int, var shoes: Int, var shirt: Int, var pants: Int) : INetObject {
    override fun serialize(buffer: PacketBuffer) {
//        buffer.writeString(textureName)
//        buffer.writeIntLE(heightOffset)
//        buffer.writeColor(eyes)
//        buffer.writeIntLE(skin)
//        buffer.writeIntLE(shirt)
//        buffer.writeIntLE(pants)
        writeFields(buffer)
    }

    override fun deserialize(buffer: PacketBuffer) {
        TODO("Not yet implemented")
    }
}