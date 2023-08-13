package dev.taah.stardew.protocol

import com.google.common.collect.Maps
import dev.taah.stardew.packet.AbstractPacket
import dev.taah.stardew.packet.handshake.*
import dev.taah.stardew.packet.reliable.GeneralReliablePacket
import kotlin.reflect.KClass
import kotlin.reflect.full.primaryConstructor

/**
 * @author Taah
 * @project stardew-server
 * @since 12:28 AM [12-08-2023]
 *
 */
class ProtocolHandler {
    companion object {
        val PACKET_MAP: HashMap<Int, KClass<AbstractPacket<*>>> = Maps.newHashMap()
    }

    constructor() {
//        this.registerPacket(0x00, NormalPacket::class as KClass<AbstractPacket<*>>)
//        this.registerPacket(0x08, HelloPacket::class as KClass<AbstractPacket<*>>)
//        this.registerPacket(0x01, ReliablePacket::class as KClass<AbstractPacket<*>>)
//        this.registerPacket(0x09, DisconnectPacket::class as KClass<AbstractPacket<*>>)
        this.registerPacket(0x88, ServerboundDiscoveryPacket::class as KClass<AbstractPacket<*>>)
        this.registerPacket(0x83, ServerboundConnectPacket::class as KClass<AbstractPacket<*>>)
        this.registerPacket(0x81, ServerboundPingPacket::class as KClass<AbstractPacket<*>>)
        this.registerPacket(133, ServerboundConnectionEstablishedPacket::class as KClass<AbstractPacket<*>>)
        this.registerPacket(134, GeneralAcknowledgePacket::class as KClass<AbstractPacket<*>>)
        this.registerPacket(67, GeneralReliablePacket::class as KClass<AbstractPacket<*>>)
    }

    fun registerPacket(id: Int, clazz: KClass<AbstractPacket<*>>) {
        PACKET_MAP[id] = clazz
    }

    fun <T : AbstractPacket<T>> getPacket(id: Int): AbstractPacket<T>? {
        if (!PACKET_MAP.containsKey(id)) {
            return null
        }
        val clazz = PACKET_MAP[id]
        val packet = clazz!!.primaryConstructor!!.call()
        return packet as AbstractPacket<T>
    }
}