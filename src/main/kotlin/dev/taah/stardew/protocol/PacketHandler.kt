package dev.taah.stardew.protocol

import dev.taah.stardew.StardewServer
import dev.taah.stardew.connection.PlayerConnection
import dev.taah.stardew.packet.AbstractPacket
import dev.taah.stardew.util.PacketBuffer
import io.netty.buffer.ByteBuf
import io.netty.buffer.ByteBufUtil
import io.netty.channel.ChannelHandlerContext
import io.netty.channel.SimpleChannelInboundHandler
import java.net.InetSocketAddress
import java.util.*

/**
 * @author Taah
 * @project stardew-server
 * @since 5:52 AM [11-08-2023]
 *
 */

/*
discovery c2s
discovery response s2c
connect c2s
connect response s2c
ping c2s
pong s2c

ack c2s
ack s2c

send available farmhands s2c
 */

class PacketHandler : SimpleChannelInboundHandler<ByteBuf>() {
    override fun channelRead0(ctx: ChannelHandlerContext?, msg: ByteBuf?) {
        println("Message coming in from ${ctx?.channel()?.remoteAddress()}")

        val connection: PlayerConnection

        if (ctx!!.channel().hasAttr(PlayerConnection.CONNECTION_STRING)) {
            if (ctx.channel().attr(PlayerConnection.CONNECTION_STRING).get() == null)
            {
                return
            }
            connection = ctx.channel().attr(PlayerConnection.CONNECTION_STRING).get()
        } else {
            connection = PlayerConnection(ctx!!, UUID.randomUUID())
            ctx.channel().attr(PlayerConnection.CONNECTION_STRING).set(connection)
            StardewServer.CONNECTIONS[ctx.channel().remoteAddress() as InetSocketAddress] = connection
        }

        val buffer = PacketBuffer(msg!!)
        println(ByteBufUtil.prettyHexDump(buffer))

        val b = buffer.readUnsignedByte().toInt();
        println("Packet: $b, Fragment: ${buffer.readByte()}, Sequence: ${buffer.readByte()}, Payload Length: ${(buffer.readUnsignedShortLE()) / 8}")
        val packet = StardewServer.HANDLER.getPacket<AbstractPacket<*>>(b)

        if (packet != null) {
            println("Deserializing packet ${packet.javaClass.name}")
            packet.deserialize(buffer)
            packet.processPacket(packet, connection)
        }
        /*if (b == 136)
        {
            val buf = PacketBuffer()
            buf.writeByte(137)
            buf.writeByte(0)
            buf.writeByte(0)
            buf.writeShortLE(0);
            buf.writeString("1.5.5")
            buf.writeString("StardewValley")
            val length = buf.readableBytes() - 5
            println("length: $length")
            buf.setShortLE(3, (length - 7) * 8);
            println("sending ${ByteBufUtil.prettyHexDump(buf)}")
            ctx?.writeAndFlush(buf);
        } else if (b == 131)
        {
            println("Remainder: ${ByteBufUtil.prettyHexDump(buffer)}")
            val buf = PacketBuffer()
            buf.writeByte(132)
            buf.writeByte(0)
            buf.writeByte(0)
            buf.writeShortLE(0);
            buf.writeBytes(buffer.byteArray)
            val length = buf.readableBytes() - 5
            println("length: $length")
            buf.setShortLE(3, (length - 7) * 8);
            println("sending ${ByteBufUtil.prettyHexDump(buf)}")
            ctx?.writeAndFlush(buf);
        }*/
    }
}