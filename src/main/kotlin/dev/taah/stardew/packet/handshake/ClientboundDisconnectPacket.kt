package dev.taah.stardew.packet.handshake

import dev.taah.stardew.connection.PlayerConnection
import dev.taah.stardew.net.NetTime
import dev.taah.stardew.packet.AbstractPacket
import dev.taah.stardew.util.PacketBuffer

/**
 * @author Taah
 * @project stardew-server
 * @since 12:49 AM [12-08-2023]
 *
 */
class ClientboundDisconnectPacket : AbstractPacket<ClientboundDisconnectPacket>(0x87) {
    override fun deserialize(buffer: PacketBuffer) {
    }

    override fun serialize(buffer: PacketBuffer) {
        super.serialize(buffer)
        buffer.writeString("Your mom your mom your mom")
    }

    override fun processPacket(packet: ClientboundDisconnectPacket, connection: PlayerConnection) {
    }
}