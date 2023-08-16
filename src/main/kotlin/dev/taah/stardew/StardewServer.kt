package dev.taah.stardew

import com.google.common.collect.Maps
import dev.taah.stardew.connection.PlayerConnection
import dev.taah.stardew.game.Game
import dev.taah.stardew.protocol.PacketHandler
import dev.taah.stardew.protocol.ProtocolHandler
import dev.taah.stardew.util.UDPServerChannel
import io.netty.bootstrap.ServerBootstrap
import io.netty.channel.*
import java.net.InetSocketAddress

/**
 * @author Taah
 * @project stardew-server
 * @since 5:47 AM [11-08-2023]
 *
 */

fun main() {
    val bootstrap = ServerBootstrap()
        .group(DefaultEventLoopGroup())
        .childHandler(PacketHandler())
        .childHandler(object : ChannelInitializer<Channel>() {
            override fun initChannel(channel: Channel) {
                channel.pipeline()
                    .addLast(PacketHandler())
                    .addLast(object : ChannelDuplexHandler() {
                        @Throws(Exception::class)
                        override fun write(ctx: ChannelHandlerContext, msg: Any, promise: ChannelPromise) {
                            super.write(ctx, msg, promise)
                        }
                    })
            }
        })
    bootstrap.channel(UDPServerChannel::class.java)
    bootstrap.bind(24642).syncUninterruptibly()
    println("Started server on port 24642")
//    CrewmateServer.LOGGER.info("Server started /${InetAddress.getLocalHost().hostAddress}:22023")
}

class StardewServer {
    companion object {
        val HANDLER = ProtocolHandler()
        val CONNECTIONS: HashMap<InetSocketAddress, PlayerConnection> = Maps.newHashMap()
        var GAME = Game()
    }
}