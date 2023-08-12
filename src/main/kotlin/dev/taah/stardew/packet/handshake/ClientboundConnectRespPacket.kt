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
class ClientboundConnectRespPacket(private val array: ByteArray?) : AbstractPacket<ClientboundConnectRespPacket>(0x84) {
    override fun deserialize(buffer: PacketBuffer) {

    }

    override fun serialize(buffer: PacketBuffer) {
        super.serialize(buffer)
        buffer.writeBytes(array!!)
    }

    override fun processPacket(packet: ClientboundConnectRespPacket, connection: PlayerConnection) {
    }
}