package dev.taah.stardew.game

import dev.taah.stardew.game.entity.NPC
import dev.taah.stardew.game.location.FarmCave
import dev.taah.stardew.game.location.Town
import dev.taah.stardew.game.`object`.Sprite
import dev.taah.stardew.util.world.Vector2

/**
 * @author Taah
 * @project stardew-server
 * @since 4:14 AM [13-08-2023]
 */
class Game {
    var year = 1
    var currentSeason = "spring"
    var dayOfMonth = 0
    var locations = mutableListOf<GameLocation>()

    constructor()
    {
        locations.add(FarmCave())
        locations.add(Town())
        locations.add(GameLocation("Maps\\JoshHouse", "JoshHouse"))
        locations.last().characters.add(NPC(Sprite("Characters\\George", 16, 32), Vector2(1024f, 1408f)))
        locations.last().characters.add(NPC(Sprite("Characters\\Evelyn", 16, 32), Vector2(128f, 1088f)))
        locations.last().characters.add(NPC(Sprite("Characters\\Alex", 16, 32), Vector2(1216f, 320f)))
        locations.add(GameLocation("Maps\\HaleyHouse", "HaleyHouse"))
        locations.last().characters.add(NPC(Sprite("Characters\\Emily", 16, 32), Vector2(1024f, 320f)))
        locations.last().characters.add(NPC(Sprite("Characters\\Haley", 16, 32), Vector2(512f, 440f)))
        locations.add(GameLocation("Maps\\SamHouse", "SamHouse"))
        locations.last().characters.add(NPC(Sprite("Characters\\Jodi", 16, 32), Vector2(256f, 320f)))
        locations.last().characters.add(NPC(Sprite("Characters\\Sam", 16, 32), Vector2(1408f, 832f)))
        locations.last().characters.add(NPC(Sprite("Characters\\Vincent", 16, 32), Vector2(640f, 1472f)))
        //add kent if necessary
        // come back taah
    }
}