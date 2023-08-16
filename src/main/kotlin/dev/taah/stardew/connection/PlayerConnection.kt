package dev.taah.stardew.connection

import dev.taah.stardew.packet.AbstractPacket
import dev.taah.stardew.packet.reliable.GeneralReliablePacket
import dev.taah.stardew.util.PacketBuffer
import io.netty.buffer.ByteBufUtil
import io.netty.channel.ChannelHandlerContext
import io.netty.util.AttributeKey
import java.util.UUID

/**
 * @author Taah
 * @project stardew-server
 * @since 12:51 AM [12-08-2023]
 *
 */
class PlayerConnection(@Transient val channel: ChannelHandlerContext, val uniqueId: UUID, val clientName: String = "") {
    companion object {
        val CONNECTION_STRING: AttributeKey<PlayerConnection> = AttributeKey.newInstance("player_conn")
    }
    fun sendPacket(packet: AbstractPacket<*>) {
        val buffer = PacketBuffer()
        // packet id
        // sequence
        // fragment
        // this
        packet.serialize(buffer)
        val len = buffer.readableBytes()
        println("Sending length: $len")
        buffer.setShortLE(3, len * 8)
        channel.writeAndFlush(buffer.retain())
        println("Sending ${packet.javaClass.name} with payload ${ByteBufUtil.prettyHexDump(buffer)}")
    }
}