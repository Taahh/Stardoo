package dev.taah.stardew.game.entity

import dev.taah.stardew.game.`object`.Sprite
import dev.taah.stardew.net.FarmerRef
import dev.taah.stardew.net.Location
import dev.taah.stardew.net.Position
import dev.taah.stardew.util.PacketBuffer
import dev.taah.stardew.util.serialization.INetObject
import dev.taah.stardew.util.serialization.NetObjectUtil.Companion.writeFields
import dev.taah.stardew.util.world.Vector2

/**
 * @author Taah
 * @project stardew-server
 * @since 10:15 PM [12-08-2023]
 *
 */
open class Character(var sprite: Sprite? = null, position: Vector2? = null) : INetObject {
    val position: Position
    val currLocationRef: Location? = null
    var direction: Int = 0
    var speed: Int = 0
    var addedSpeed: Int = 0
    var name: String = ""
    var scale: Float = 1f
    var swimming: Boolean = false
    var collisionWithCharacters: Boolean = false
    var facingDirectionBeforeSpeakingToPlayer: Int = 0
    var faceTowardFarmerRadius: Int = 0
    var faceAwayFromFarmer: Boolean = false
    var whoToFace: FarmerRef? = null
    var faceTowardFarmerEvent: Int = 0
    var destroyObjectsUnderfoot: Boolean = false
    var forceOneTileWide: Boolean = false
    var modData: String = "" // In the code this is a "NetStringDictionary" so I want to maybe think it's a dictionary converted to a string? Unsure

    init {
        if (position != null) this.position = Position(position)
        else this.position = Position(Vector2.ZERO)
        if (sprite != null) this.name = sprite!!.name.replace("Characters\\", "")
    }
    override fun serialize(buffer: PacketBuffer) {
//        sprite?.serialize(buffer);
//        position.serialize(buffer);
//        buffer.writeIntLE(direction)
//        buffer.writeIntLE(speed)
//        buffer.writeIntLE(addedSpeed)
//        buffer.writeString(name)
//        buffer.writeFloatLE(scale)
//        currLocationRef?.serialize(buffer)
//        buffer.writeBoolean(swimming)
//        buffer.writeBoolean(collisionWithCharacters)
//        buffer.writeIntLE(facingDirectionBeforeSpeakingToPlayer)
//        buffer.writeIntLE(faceTowardFarmerRadius)
//        buffer.writeBoolean(faceAwayFromFarmer)
//        whoToFace?.serialize(buffer)
//        buffer.writeIntLE(faceTowardFarmerEvent)
//        buffer.writeBoolean(destroyObjectsUnderfoot)
//        buffer.writeBoolean(forceOneTileWide)
//        buffer.writeString(modData)
        writeFields(buffer)
    }

    override fun deserialize(buffer: PacketBuffer) {
        TODO("Not yet implemented")
    }
}