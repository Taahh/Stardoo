package dev.taah.stardew.packet.reliable

import dev.taah.stardew.connection.PlayerConnection
import dev.taah.stardew.packet.AbstractPacket
import dev.taah.stardew.packet.handshake.ServerboundConnectPacket
import dev.taah.stardew.util.PacketBuffer

/**
 * @author Taah
 * @project stardew-server
 * @since 1:37 PM [12-08-2023]
 *
 */

// 0x13 = disconnect c2s
class ServerboundReliablePacket : AbstractPacket<ServerboundConnectPacket>(0x43) {

    override fun deserialize(buffer: PacketBuffer) {

    }

    override fun processPacket(packet: ServerboundConnectPacket, connection: PlayerConnection) {
        TODO("Not yet implemented")
    }
}