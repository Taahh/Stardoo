using System;
using System.Diagnostics;
using HarmonyLib;
using Lidgren.Network;
using StardewValley;
using StardewValley.Network;

namespace MultiplayerMod.Patches
{
    [HarmonyPatch]
    public static class LidgrenClientPatch
    {
        [HarmonyPatch(typeof(NetConnection), "ReceivedMessage")]
        public static void Postfix(NetConnection __instance, [HarmonyArgument(0)] NetIncomingMessage msg)
        {
            ModEntry.Instance.Monitor.Log($"Received message {msg.MessageType}");
        }

        [HarmonyPostfix]
        [HarmonyPatch(typeof(NetConnection), "SendPing")]
        public static void PrintNetTime()
        {
            ModEntry.Instance.Monitor.Log($"Net time: {NetTime.Now}");
            ModEntry.Instance.Monitor.Log($"Stopwatch: {Stopwatch.GetTimestamp()}");
        }
        
        [HarmonyPostfix]
        [HarmonyPatch(typeof(NetPeer), "CreateIncomingMessage", new Type[2] { typeof(NetIncomingMessageType), typeof(byte[])})]
        public static void CreatingMessage([HarmonyArgument(0)] NetIncomingMessageType tp)
        {
            ModEntry.Instance.Monitor.Log($"Incoming message type: {tp}");
        }
        
        [HarmonyPostfix]
        [HarmonyPatch(typeof(NetConnection), nameof(NetConnection.SetStatus))]
        public static void SettingStatus([HarmonyArgument(0)] NetConnectionStatus status, [HarmonyArgument(1)] string reason)
        {
            ModEntry.Instance.Monitor.Log($"Set status to {status} with reason {reason}");
        }

        [HarmonyPostfix]
        [HarmonyPatch(typeof(LidgrenClient), "validateProtocol")]
        public static void Validate([HarmonyArgument(0)] string version)
        {
            ModEntry.Instance.Monitor.Log($"Attempting to validate version {version ?? "bruh"}");
            Console.WriteLine(version);
        }

        [HarmonyPrefix]
        [HarmonyPatch(typeof(LidgrenClient), nameof(LidgrenClient.disconnect))]
        public static bool disconnect()
        {
            ModEntry.Instance.Monitor.Log($"Farmer ID: {Game1.player?.uniqueMultiplayerID.Value}");
            return true;
        }

        [HarmonyPrefix]
        [HarmonyPatch(typeof(Client), "processIncomingMessage")]
        public static void Prefix([HarmonyArgument(0)] IncomingMessage message)
        {
            ModEntry.Instance.Monitor.Log($"received incoming msg {message.MessageType} and {message.FarmerID}");
        }
    }
}