package dev.taah.stardew.packet.handshake

import dev.taah.stardew.connection.PlayerConnection
import dev.taah.stardew.net.world.Time
import dev.taah.stardew.packet.AbstractPacket
import dev.taah.stardew.util.PacketBuffer

/**
 * @author Taah
 * @project stardew-server
 * @since 12:49 AM [12-08-2023]
 *
 */
class ClientboundPongPacket(val pingNum: Int) : AbstractPacket<ClientboundPongPacket>(0x82) {
    override fun deserialize(buffer: PacketBuffer) {
    }

    override fun serialize(buffer: PacketBuffer) {
        super.serialize(buffer)
        buffer.writeByte(pingNum)
        buffer.writeFloatLE(Time.now().toFloat())
    }

    override fun processPacket(packet: ClientboundPongPacket, connection: PlayerConnection) {
    }
}