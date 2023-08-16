package dev.taah.stardew.packet.reliable

import dev.taah.stardew.connection.PlayerConnection
import dev.taah.stardew.packet.AbstractPacket
import dev.taah.stardew.packet.handshake.ServerboundConnectPacket
import dev.taah.stardew.util.PacketBuffer
import io.netty.buffer.ByteBufUtil
import java.util.Random
import java.util.function.Consumer
import java.util.function.Supplier

/**
 * @author Taah
 * @project stardew-server
 * @since 1:37 PM [12-08-2023]
 *
 */

// 0x13 = disconnect c2s
// Reliable Packet ID from NetDeliveryMethod
class GeneralReliablePacket() : AbstractPacket<GeneralReliablePacket>(0x43) {

    var farmerId: Long? = null
    var messageType: ReliableType? = null
    var serializer: Consumer<PacketBuffer>? = null

    constructor(farmerId: Long, messageType: ReliableType, serializer: Consumer<PacketBuffer>): this() {
        this.farmerId = farmerId
        this.messageType = messageType
        this.serializer = serializer
    }

    override fun deserialize(buffer: PacketBuffer) {
        var messageId = buffer.readByte().toInt()
        println("Message type: ${messageId}")
        if (messageId == 19)
        {
            println("farmer id: ${buffer.readLongLE()}")
        }

    }

    override fun serialize(buffer: PacketBuffer) {
        super.serialize(buffer)
        this.messageType?.let { buffer.writeByte(it.messageId.toInt()) }
        this.farmerId?.let { buffer.writeLongLE(it) }
        val index = buffer.writerIndex()
        buffer.writeUInt32(0)
        this.serializer?.accept(buffer)
        println("Before: ${ByteBufUtil.prettyHexDump(buffer)}")
        buffer.setIntLE(index, buffer.readableBytes() - index - 4)
        println("After: ${ByteBufUtil.prettyHexDump(buffer)}")
        println("Writing ${buffer.readableBytes() - index - 4} skippable bytes")
    }

    override fun processPacket(packet: GeneralReliablePacket, connection: PlayerConnection) {

    }
}