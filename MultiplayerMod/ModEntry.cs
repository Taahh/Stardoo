using System;
using HarmonyLib;
using Lidgren.Network;
using StardewModdingAPI;

namespace MultiplayerMod
{
    public class ModEntry : Mod
    {
        public static ModEntry Instance;
        public override void Entry(IModHelper helper)
        {
            Instance = this;
            this.Monitor.Log("Test");

            var harmony = new Harmony(this.ModManifest.UniqueID);
            harmony.PatchAll();
        }
    }
}