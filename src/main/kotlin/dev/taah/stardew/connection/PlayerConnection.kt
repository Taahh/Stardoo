package dev.taah.stardew.connection

import dev.taah.stardew.packet.AbstractPacket
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
        packet.serialize(buffer)
        val len = (buffer.readableBytes() - 5 - 7) * 8
        buffer.setShortLE(3, len)
        channel.writeAndFlush(buffer)
        println("Sending ${packet.javaClass.name} with payload ${ByteBufUtil.prettyHexDump(buffer)}")
    }
}