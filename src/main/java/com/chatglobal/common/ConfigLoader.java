package com.chatglobal.common;

import org.bukkit.configuration.file.FileConfiguration;

public class ConfigLoader {
    
    private static FileConfiguration config = ChatGlobalPlugin.getPlugin(ChatGlobalPlugin.class).getConfig();

    public static boolean isSpigotEnabled() {
        return config.getBoolean("pluginConfig.enableSpigot", false);
    }

    public static boolean isBungeeEnabled() {
        return config.getBoolean("pluginConfig.enableBungee", false);
    }

    public static boolean isVelocityEnabled() {
        return config.getBoolean("pluginConfig.enableVelocity", false);
    }
}
