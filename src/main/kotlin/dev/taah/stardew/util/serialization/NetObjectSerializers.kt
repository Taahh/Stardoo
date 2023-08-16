package dev.taah.stardew.util.serialization

import dev.taah.stardew.util.PacketBuffer
import java.awt.Color
import java.util.function.BiConsumer
import java.util.function.Consumer
import java.util.function.Supplier

/**
 * @author Taah
 * @project stardew-server
 * @since 1:59 PM [16-08-2023]
 */
class NetObjectSerializers {
    companion object {
        private val serializers: MutableMap<Class<*>, BiConsumer<PacketBuffer, *>> = mutableMapOf()
        fun <T> getSerializer(type: Class<T>): BiConsumer<PacketBuffer, T>?
                where T: Any {
            return serializers[type] as BiConsumer<PacketBuffer, T>?
        }
        private fun <T> addSerializer(type: Class<T>, consumer: BiConsumer<PacketBuffer, T>)
        where T: Any {
            serializers[type] = consumer
        }
        init {
            addSerializer(String::class.java) { t, u -> t.writeString(u)}
            addSerializer(Int::class.java) { t, u -> t.writeIntLE(u)}
            addSerializer(Long::class.java) { t, u -> t.writeLongLE(u)}
            addSerializer(Short::class.java) { t, u -> t.writeShortLE(u.toInt())}
            addSerializer(Boolean::class.java) { t, u -> t.writeBoolean(u)}
            addSerializer(INetObject::class.java) { t, u -> u.serialize(t)}
            addSerializer(IShortEnum::class.java) { t, u -> t.writeShortLE(u.value.toInt())}
            addSerializer(Color::class.java) { t, u -> t.writeColor(u)}
        }
     }
}