package dev.taah.stardew.util.serialization

import dev.taah.stardew.net.friendship.FriendshipStatus
import dev.taah.stardew.util.PacketBuffer
import java.awt.Color
import java.time.LocalDateTime

/**
 * @author Taah
 * @project stardew-server
 * @since 12:26 AM [16-08-2023]
 */
class NetObjectUtil {
    companion object {
        fun <T> T.writeFields(buffer: PacketBuffer)
                where T: INetObject {
            this.javaClass.declaredFields.filter { f -> !f.isAnnotationPresent(IgnoreField::class.java) }
                .forEach {
                    val value = it.get(this) as Any
                    /*when (val value = it.get(this)) {
//                        is String -> buffer.writeString(value)
//                        is Int -> buffer.writeIntLE(value)
//                        is Long -> buffer.writeLongLE(value)
//                        is Boolean -> buffer.writeBoolean(value)
//                        is INetObject -> value.serialize(buffer)
//                        is Color -> buffer.writeColor(value)
//                        is FriendshipStatus -> buffer.writeShortLE(value.index.toInt())

                    }*/
                    val consumer = NetObjectSerializers.getSerializer(value.javaClass)
                    consumer?.accept(buffer, value)
                }
        }

    }
}