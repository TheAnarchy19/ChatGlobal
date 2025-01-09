package com.chatglobal.common;

import org.bukkit.configuration.file.FileConfiguration;

public class ConfigLoader {
    
    private static FileConfiguration config = ChatGlobalPlugin.getPlugin(ChatGlobalPlugin.class).getConfig();

    // Verificar si Spigot está habilitado
    public static boolean isSpigotEnabled() {
        return config.getBoolean("pluginConfig.enableSpigot", false);
    }

    // Verificar si BungeeCord está habilitado
    public static boolean isBungeeEnabled() {
        return config.getBoolean("pluginConfig.enableBungee", false);
    }

    // Verificar si Velocity está habilitado
    public static boolean isVelocityEnabled() {
        return config.getBoolean("pluginConfig.enableVelocity", false);
    }
}
