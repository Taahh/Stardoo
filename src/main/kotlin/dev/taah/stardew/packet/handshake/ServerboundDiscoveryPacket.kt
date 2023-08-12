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
class ServerboundDiscoveryPacket : AbstractPacket<ServerboundDiscoveryPacket>(0x83) {
    override fun deserialize(buffer: PacketBuffer) {
    }

    override fun processPacket(packet: ServerboundDiscoveryPacket, connection: PlayerConnection) {
        connection.sendPacket(ClientboundDiscoveryRespPacket())
    }
}