package gg.rsmod.game.protocol

import gg.rsmod.game.message.MessageEncoderSet
import gg.rsmod.game.message.Message
import io.netty.channel.ChannelHandlerContext
import io.netty.handler.codec.MessageToMessageEncoder
import org.apache.logging.log4j.LogManager

/**
 * An implementation of [MessageToMessageEncoder] which is responsible for taking
 * the [Message] and converting it into a [gg.rsmod.net.packet.GamePacket] so that
 * it may be written to a [io.netty.channel.Channel].
 *
 * @param encoders
 * The available [gg.rsmod.game.message.MessageEncoder]s for the current
 * [gg.rsmod.game.GameContext].
 *
 * @author Tom <rspsmods@gmail.com>
 */
class GameMessageEncoder(private val encoders: MessageEncoderSet) : MessageToMessageEncoder<Message>() {

    companion object {
        private val logger = LogManager.getLogger(GameMessageEncoder::class.java)
    }

    override fun encode(ctx: ChannelHandlerContext, msg: Message, out: MutableList<Any>) {
        val encoder = encoders.get(msg.javaClass)!!
        val packet = encoder.encode(msg)
        out.add(packet)
    }
}