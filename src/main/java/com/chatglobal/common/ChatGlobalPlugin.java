package com.chatglobal.common;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.plugin.java.JavaPlugin;
import net.md_5.bungee.api.plugin.Plugin;
import com.velocitypowered.api.plugin.Plugin;

public class ChatGlobalPlugin {

    public static void loadPlugin() {
        if (ConfigLoader.isSpigotEnabled()) {
            new SpigotPlugin().onEnable();
        }
        if (ConfigLoader.isBungeeEnabled()) {
            new BungeePlugin().onEnable();
        }
        if (ConfigLoader.isVelocityEnabled()) {
            new VelocityPlugin().onEnable();
        }
    }

    public static void enablePlaceholderAPI() {
        // Activar PlaceholderAPI si está disponible en Spigot
        if (ConfigLoader.isSpigotEnabled()) {
            if (PlaceholderAPI.getPlugin() != null) {
                // Aquí puedes configurar los placeholders si lo deseas
                System.out.println("PlaceholderAPI habilitado en Spigot.");
            } else {
                System.out.println("PlaceholderAPI no encontrado en Spigot.");
            }
        }
    }

    public static void sendMessageToAll(String message) {
        // Aquí podrías manejar la transmisión del mensaje entre servidores
    }
}