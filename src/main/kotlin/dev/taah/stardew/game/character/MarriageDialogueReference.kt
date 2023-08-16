package dev.taah.stardew.game.character

import dev.taah.stardew.util.PacketBuffer
import dev.taah.stardew.util.serialization.INetObject
import dev.taah.stardew.util.serialization.NetObjectUtil.Companion.writeFields

/**
 * @author Taah
 * @project stardew-server
 * @since 11:44 PM [15-08-2023]
 */
class MarriageDialogueReference : INetObject {
    var dialogueFile: String = ""
    var dialogueKey: String = ""
    var isGendered: Boolean = false
    var substitutions: List<String> = mutableListOf()
    override fun serialize(buffer: PacketBuffer) {
//        buffer.writeString(dialogueFile)
//        buffer.writeString(dialogueKey)
//        buffer.writeBoolean(isGendered)
//        buffer.writeNetList(substitutions) { t, u -> t!!.writeString(u) }
        writeFields(buffer)
    }

    override fun deserialize(buffer: PacketBuffer) {
        TODO("Not yet implemented")
    }
}