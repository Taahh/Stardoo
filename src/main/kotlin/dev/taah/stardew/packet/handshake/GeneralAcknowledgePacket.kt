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
class GeneralAcknowledgePacket : AbstractPacket<GeneralAcknowledgePacket>(0x86) {
    var byteArray: ByteArray? = null
    override fun deserialize(buffer: PacketBuffer) {
        this.byteArray = buffer.byteArray
    }

    override fun serialize(buffer: PacketBuffer) {
        super.serialize(buffer)
        this.byteArray?.let { buffer.writeBytes(it) }
    }

    override fun processPacket(packet: GeneralAcknowledgePacket, connection: PlayerConnection) {
        connection.sendPacket(packet)
    }
}