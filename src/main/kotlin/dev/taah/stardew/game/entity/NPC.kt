package dev.taah.stardew.game.entity

import dev.taah.stardew.game.character.MarriageDialogueReference
import dev.taah.stardew.game.`object`.Sprite
import dev.taah.stardew.util.PacketBuffer
import dev.taah.stardew.util.serialization.NetObjectUtil.Companion.writeFields
import dev.taah.stardew.util.world.Vector2

/**
 * @author Taah
 * @project stardew-server
 * @since 11:43 PM [12-08-2023]
 *
 */
open class NPC(sprite: Sprite? = null, position: Vector2? = null) : Character(sprite, position) {
    var birthdaySeason: String = ""
    var birthdayDay: Int = 0
    var datable: Boolean = false
    var shouldPlayRobinHammerAnimation: Boolean = false
    var shouldPlaySpousePatioAnimation: Boolean = false
    var isWalkingTowardsPlayer: Boolean = false
    var moveTowardPlayerThreshold: Int = 0
    var age: Int = 0
    var manners: Int = 0
    var socialAnxiety: Int = 0
    var optimism: Int = 0
    var gender: Int = 0
    var breather: Boolean = false
    var isSleeping: Boolean = false
    var hideShadow: Boolean = false
    var isInvisible: Boolean = false
    var defaultMap: String = ""
    var defaultPosition: Vector2 = Vector2.ZERO
    var removeHenchmenEvent: Int = 0
    var doingEndOfRouteAnimation: Int = 0
    var goingToDoEndOfRouteAnimation: Int = 0
    var endOfRouteMessage: String = ""
    var endOfRouteBehaviorName: String = ""
    var lastSeenMovieWeek: Int = 0
    var currentMarriageDialogue: List<MarriageDialogueReference> = mutableListOf()
    var marriageDefaultDialogue: MarriageDialogueReference? = null
    var shouldSayMarriageDialogue: Boolean = false
    var hasBeenKissedToday: Boolean = false
    var syncedPortraitPath: String = ""
    var hasSaidAfternoonDialogue: Boolean = false
    var dayScheduleName: String = ""
    var islandScheduleName: String = ""
    var sleptInBed: Boolean = false
    var shouldWearIslandAttire: Boolean = false
    var isMovingOnPathFindPath: Boolean = false

    override fun serialize(buffer: PacketBuffer) {
        super.serialize(buffer)
        writeFields(buffer)
    }
}