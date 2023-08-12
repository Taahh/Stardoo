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
class ServerboundConnectPacket : AbstractPacket<ServerboundConnectPacket>(0x88) {
    var byteArray: ByteArray? = null
    override fun deserialize(buffer: PacketBuffer) {
        this.byteArray = buffer.byteArray
    }

    override fun processPacket(packet: ServerboundConnectPacket, connection: PlayerConnection) {
        connection.sendPacket(ClientboundConnectRespPacket(packet.byteArray))
    }
}