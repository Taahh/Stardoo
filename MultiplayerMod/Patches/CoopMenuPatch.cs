using System;
using HarmonyLib;
using StardewValley;
using StardewValley.Menus;
using StardewValley.Network;

namespace MultiplayerMod.Patches
{
    [HarmonyPatch(typeof(CoopMenu))]
    public static class CoopMenuPatch
    {
        [HarmonyPrefix]
        [HarmonyPatch("enterIPPressed")]
        public static bool ChangeAddress(CoopMenu __instance)
        {
            ModEntry.Instance.Monitor.Log("Enter IP Pressed");
            string last_entered_ip = "";
            try
            {
                StartupPreferences startupPreferences = new StartupPreferences();
                startupPreferences.loadPreferences(false, false);
                last_entered_ip = startupPreferences.lastEnteredIP;
            }
            catch (Exception)
            {
            }
            string title = Game1.content.LoadString("Strings\\UI:CoopMenu_EnterIP");
            
            ModEntry.Instance.Helper.Reflection.GetMethod(__instance, "setMenu").Invoke(new TitleTextInputMenu(title, delegate(string address)
            {
                try
                {
                    StartupPreferences startupPreferences2 = new StartupPreferences();
                    startupPreferences2.loadPreferences(false, false);
                    startupPreferences2.lastEnteredIP = address;
                    startupPreferences2.savePreferences(false, false);
                }
                catch (Exception)
                {
                }
                if (address == "")
                {
                    address = "127.0.0.1:24642"/*"localhost"*/;
                }

                Multiplayer multiplayer = ModEntry.Instance.Helper.Reflection
                    .GetField<Multiplayer>(typeof(Game1), "multiplayer").GetValue();
                ModEntry.Instance.Helper.Reflection.GetMethod(__instance, "setMenu").Invoke(new FarmhandMenu(multiplayer.InitClient(new LidgrenClient(address))));
            }, last_entered_ip, "join_menu"));
            return false;
        }
    }
}