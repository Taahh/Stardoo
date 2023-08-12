package dev.taah.stardew.packet.handshake

import dev.taah.stardew.connection.PlayerConnection
import dev.taah.stardew.packet.AbstractPacket
import dev.taah.stardew.util.PacketBuffer

/**
 * @author Taah
 * @project stardew-server
 * @since 12:49 AM [12-08-2023]
 *
 */
class ServerboundPingPacket : AbstractPacket<ServerboundPingPacket>(0x81) {
    var pingNum = 0
    override fun deserialize(buffer: PacketBuffer) {
        pingNum = buffer.readByte().toInt()
        println("Incoming ping $pingNum")
    }

    override fun processPacket(packet: ServerboundPingPacket, connection: PlayerConnection) {
        connection.sendPacket(ClientboundPongPacket(packet.pingNum))
    }
}