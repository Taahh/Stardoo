using System;
using HarmonyLib;
using Lidgren.Network;
using StardewModdingAPI;
using StardewValley;

namespace MultiplayerMod
{
    public class ModEntry : Mod
    {
        public static ModEntry Instance;
        public override void Entry(IModHelper helper)
        {
            Instance = this;
            Monitor.Log("Test");
            Monitor.Log(Game1.content.LoadString("Strings\\UI:CoopMenu_FailedProtocolVersion"));

            var harmony = new Harmony(this.ModManifest.UniqueID);
            harmony.PatchAll();
        }
    }
}