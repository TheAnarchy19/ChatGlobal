package com.chatglobal.spigot;

import com.chatglobal.common.ChatGlobalPlugin;
import com.chatglobal.common.ConfigLoader;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class SpigotPlugin extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Registrar eventos de chat
        getServer().getPluginManager().registerEvents(this, this);
        // Cargar configuración del plugin
        ChatGlobalPlugin.enablePlaceholderAPI();
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        // Obtener el mensaje del jugador y su nombre
        String message = event.getMessage();
        String playerName = event.getPlayer().getName();

        // Formatear el mensaje utilizando el formato de config.yml
        String formattedMessage = ChatGlobalPlugin.getConfig().getString("chatSettings.prefix") + " " +
                                  ChatGlobalPlugin.getConfig().getString("chatSettings.format")
                                  .replace("{PLAYER_NAME}", playerName)
                                  .replace("{MESSAGE}", message);

        // Si PlaceholderAPI está habilitado, sustituir placeholders
        if (ChatGlobalPlugin.getConfig().getBoolean("pluginConfig.enableSpigot")) {
            formattedMessage = PlaceholderAPI.setPlaceholders(event.getPlayer(), formattedMessage);
        }

        // Enviar el mensaje a todos los jugadores en Spigot
        for (org.bukkit.entity.Player player : Bukkit.getOnlinePlayers()) {
            player.sendMessage(formattedMessage);
        }

        // Cancelar el evento para evitar que el mensaje se envíe solo al canal de Spigot
        event.setCancelled(true);
    }
}
