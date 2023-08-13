package dev.taah.stardew.packet.handshake

import dev.taah.stardew.connection.PlayerConnection
import dev.taah.stardew.packet.AbstractPacket
import dev.taah.stardew.packet.reliable.GeneralReliablePacket
import dev.taah.stardew.packet.reliable.ReliableType
import dev.taah.stardew.util.PacketBuffer
import java.util.Random

/**
 * @author Taah
 * @project stardew-server
 * @since 12:49 AM [12-08-2023]
 *
 */
class ServerboundConnectionEstablishedPacket : AbstractPacket<ServerboundConnectionEstablishedPacket>(133) {
    override fun deserialize(buffer: PacketBuffer) {
        println("Net time: ${buffer.readFloatLE()}")
    }

    override fun processPacket(packet: ServerboundConnectionEstablishedPacket, connection: PlayerConnection) {
//        connection.sendPacket(ClientboundConnectRespPacket(packet.byteArray))
//        connection.sendPacket(ClientboundDisconnectPacket())
        val farmerId = Random().nextLong(0, Long.MAX_VALUE)
        println("Chose farmer id ${farmerId}")
        connection.sendPacket(GeneralReliablePacket(farmerId, ReliableType.AVAILABLE_FARMHANDS) { buffer ->
            run {
                buffer.writeInt(1)
                buffer.writeInt(0);
                buffer.writeInt(0);
                buffer.writeByte(0)
            }
        })

        /*connection.sendPacket(GeneralReliablePacket(farmerId, ReliableType.WAITING_FOR_hOST) { buffer ->
            run {
                buffer.writeString("Strings\\UI:Client_WaitForHostLoad")
            }
        })*/
    }
}