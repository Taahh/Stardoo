package dev.taah.stardew.game.entity

import dev.taah.stardew.game.character.FriendshipData
import dev.taah.stardew.game.customization.Boots
import dev.taah.stardew.game.customization.Hat
import dev.taah.stardew.game.customization.Ring
import dev.taah.stardew.game.entity.animal.Horse
import dev.taah.stardew.game.`object`.item.Item
import dev.taah.stardew.game.`object`.Sprite
import dev.taah.stardew.net.*
import dev.taah.stardew.net.collection.IntDictionary
import dev.taah.stardew.net.collection.NetList
import dev.taah.stardew.net.collection.StringDictionary
import dev.taah.stardew.net.player.DancePartner
import dev.taah.stardew.net.player.FarmerRenderer
import dev.taah.stardew.util.PacketBuffer
import dev.taah.stardew.util.serialization.NetObjectUtil.Companion.writeFields
import dev.taah.stardew.util.world.Vector2
import java.awt.Color

/**
 * @author Taah
 * @project stardew-server
 * @since 11:43 PM [12-08-2023]
 *
 */
//TODO: Implement NetRef because a lot of these are supposed to be netrefs, I want to assume NetRef are references to objects that are held in the object and if they are null it doesn't write it but needs a double check
class Farmer(val uniqueId: Long, sprite: Sprite, position: Vector2) : Character(sprite, position) {

    var userId: String = ""
    var platformType: String = ""
    var platformId: String = ""
    var farmerRenderer: FarmerRenderer? = null
    var isMale: Boolean = false
    var bathingClothes: Boolean = false
    var shirt: Int = 0
    var pants: Int = 0
    var hair: Int = 0
    var shoes: Int = 0
    var accessory: Int = 0
    var facialHair: Int = 0
    var hairColor: Color = Color.white
    var pantColor: Color = Color.white
    var newEyeColor: Color = Color.white
    var items: List<Item> = mutableListOf()
    var currentToolIndex: Int = 0
    var temporaryItem: Item = Item()
    var cursorSlotItem: Item = Item()
    var fireToolEvent: Int = 0
    var beginUsingToolEvent: Int = 0
    var endUsingToolEvent: Int = 0
    var hat: Hat = Hat()
    var boots: Boots = Boots()
    var leftRing: Ring = Ring()
    var rightRing: Ring = Ring()
    var hidden: Boolean = false
    var inBed: Boolean = false
    var caveChoice: Int = 0
    var houseUpgradeLevel: Int = 0
    var daysUntilHouseUpgrade: Int = 0
    var magenticRadius: Int = 0
    var spouse: String = ""
    var mailReceived: NetList<String> = NetList()
    var mailForTomorrow: NetList<String> = NetList()
    var mailbox: NetList<String> = NetList()
    var eventsSeen: NetList<Int> = NetList()
    var secretNotesSeen: NetList<Int> = NetList()
    var mount: Horse = Horse()
    var dancePartner: DancePartner = DancePartner()
    var divorceTonight: Boolean = false
    var isCustomized: Boolean = false
    var homeLocation: String = ""
    var farmName: String = ""
    var favoriteThing: String = ""
    var horseName: String = ""
    var millisecondsPlayed: Long = 1L
    var festivalScore: Int = 0
    var friendshipData: StringDictionary<FriendshipData> = StringDictionary()
    var drinkAnimationEvent: Item? = null
    var eatAnimationEvent: Item? = null
    var sickAnimationEvent: Int = 0
    var passOutEvent: Int = 0
    var doEmoteEvent: String = ""
    var questLog: NetList<Quest> = NetList()
    var professions: NetList<Int> = NetList()
    var newLevels: NetList<Vector2> = NetList() // this is technically supposed to be a netlist of a Point object but the Point looked similar to Vector2
    var experiencePoints: NetList<Int> = NetList(false)
    var dialogueQuestionsAnswered: NetList<Int> = NetList()
    var cookingRecipes: StringDictionary<Int> = StringDictionary()
    var craftingRecipes: StringDictionary<Int> = StringDictionary()
    var activeDialogueEvents: StringDictionary<Int> = StringDictionary()
    var achievements: NetList<Int> = NetList()
    var specialItems: NetList<Int> = NetList()
    var specialBigCraftables: NetList<Int> = NetList()
    var farmingLevel: Int = 0
    var miningLevel: Int = 0
    var combatLevel: Int = 0
    var foragingLevel: Int = 0
    var fishingLevel: Int = 0
    var luckLevel: Int = 0
    var newSkillPointsToSpend: Int = 0
    var addedFarmingLevel: Int = 0
    var addedMiningLevel: Int = 0
    var addedCombatLevel: Int = 0
    var addedForagingLevel: Int = 0
    var addedFishingLevel: Int = 0
    var addedLuckLevel: Int = 0
    var maxStamina: Int = 0
    var currStamina: Float = 0f
    var maxItems: Int = 0
    var chestConsumedMineLevels: IntDictionary<Boolean> = IntDictionary()


    override fun serialize(buffer: PacketBuffer) {
        super.serialize(buffer)
//        buffer.writeLongLE(uniqueId)
//        buffer.writeString(userId)
//        buffer.writeString(platformType)
//        buffer.writeString(platformId)
//        farmerRenderer?.serialize(buffer)
//        buffer.writeBoolean(isMale)
//        buffer.writeBoolean(bathingClothes)
//        buffer.writeIntLE(shirt)
//        buffer.writeIntLE(pants)
//        buffer.writeIntLE(hair)
//        buffer.writeIntLE(shoes)
//        buffer.writeIntLE(accessory)
//        buffer.writeIntLE(facialHair)
//        buffer.writeColor(hairColor)
//        buffer.writeColor(pantColor)
//        buffer.writeColor(newEyeColor)
//        buffer.writeCollection(items) { t, u -> u.serialize(t!!) }
//        mount.serialize(buffer)
        writeFields(buffer)
    }
}