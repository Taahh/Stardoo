using System;
using System.Diagnostics;
using HarmonyLib;
using Lidgren.Network;
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
            ModEntry.Instance.Monitor.Log($"Attempting to validate version {version}");
        }
    }
}