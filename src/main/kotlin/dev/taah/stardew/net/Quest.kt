package dev.taah.stardew.net

import dev.taah.stardew.util.PacketBuffer
import dev.taah.stardew.util.serialization.INetObject
import dev.taah.stardew.util.serialization.NetObjectUtil.Companion.writeFields

/**
 * @author Taah
 * @project stardew-server
 * @since 3:29 AM [16-08-2023]
 */
class Quest : INetObject {
    var rewardDescription: String = ""
    var completionString: String = ""
    var accepted: Boolean = false
    var completed: Boolean = false
    var dailyQuest: Boolean = false
    var showNew: Boolean = false
    var canBeCancelled: Boolean = false
    var destroy: Boolean = false
    var id: Int = 0
    var moneyReward: Int = 0
    var questType: Int = 0
    var nextQuests: List<Int> = mutableListOf()
    var dayQuestAccepted: Int = 0
    override fun serialize(buffer: PacketBuffer) {
        writeFields(buffer)
    }

    override fun deserialize(buffer: PacketBuffer) {
        TODO("Not yet implemented")
    }

}