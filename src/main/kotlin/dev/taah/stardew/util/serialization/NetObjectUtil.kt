package dev.taah.stardew.util.serialization

import dev.taah.stardew.net.friendship.FriendshipStatus
import dev.taah.stardew.util.PacketBuffer
import java.awt.Color

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
                    when (val value = it.get(this)) {
                        is String -> buffer.writeString(value)
                        is Int -> buffer.writeIntLE(value)
                        is Long -> buffer.writeLongLE(value)
                        is Boolean -> buffer.writeBoolean(value)
                        is List<*> -> {
                            buffer.writeNetList(value) { t, u ->
                                when (u) {
                                    is String -> t!!.writeString(u)
                                    is Int -> t!!.writeIntLE(u)
                                    is INetObject -> u.serialize(t!!)
                                }
                            }
                        }
                        is INetObject -> value.serialize(buffer)
                        is Color -> buffer.writeColor(value)
                        is FriendshipStatus -> buffer.writeShortLE(value.index.toInt())
                    }
                }
        }
    }
}