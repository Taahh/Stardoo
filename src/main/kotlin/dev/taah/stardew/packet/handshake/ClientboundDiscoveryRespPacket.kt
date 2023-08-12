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
class ClientboundDiscoveryRespPacket : AbstractPacket<ClientboundDiscoveryRespPacket>(0x89) {
    override fun deserialize(buffer: PacketBuffer) {
    }

    override fun serialize(buffer: PacketBuffer) {
        super.serialize(buffer)
        buffer.writeString("1.5.5")
        buffer.writeString("StardewValley")
    }

    override fun processPacket(packet: ClientboundDiscoveryRespPacket, connection: PlayerConnection) {
    }
}