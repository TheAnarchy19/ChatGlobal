package com.chatglobal.common;

public class ChatManager {

    public static String formatMessage(String playerName, String message) {
        String format = ConfigLoader.getChatFormat();
        String prefix = ConfigLoader.getChatPrefix();
        return prefix + " " + format.replace("{PLAYER_NAME}", playerName).replace("{MESSAGE}", message);
    }

    public static void loadSpigotSettings() {
    }

    public static void loadBungeeSettings() {
    }

    public static void loadVelocitySettings() {
    }
}
