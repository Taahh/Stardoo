package dev.taah.stardew.game.character

import dev.taah.stardew.net.WorldDate
import dev.taah.stardew.net.friendship.FriendshipStatus
import dev.taah.stardew.util.PacketBuffer
import dev.taah.stardew.util.serialization.INetObject
import dev.taah.stardew.util.serialization.NetObjectUtil.Companion.writeFields

/**
 * @author Taah
 * @project stardew-server
 * @since 3:07 AM [16-08-2023]
 */
class FriendshipData : INetObject {
    var points: Int = 0
    var giftsThisWeek: Int = 0
    var giftsToday: Int = 0
    var lastGiftDate: WorldDate = WorldDate()
    var talkedToToday: Boolean = false
    var proposalRejected: Boolean = false
    var weddingDate: WorldDate = WorldDate()
    var nextBirthingDate: WorldDate = WorldDate()
    var status: FriendshipStatus = FriendshipStatus.FRIENDLY
    var proposer: Long = 0L
    var roommateMarriage: Boolean = false
    override fun serialize(buffer: PacketBuffer) {
        writeFields(buffer)
    }

    override fun deserialize(buffer: PacketBuffer) {
        TODO("Not yet implemented")
    }
}