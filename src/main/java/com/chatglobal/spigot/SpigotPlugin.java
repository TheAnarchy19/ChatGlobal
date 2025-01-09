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
        getServer().getPluginManager().registerEvents(this, this);
        ChatGlobalPlugin.enablePlaceholderAPI();
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        String message = event.getMessage();
        String playerName = event.getPlayer().getName();

        String formattedMessage = ChatGlobalPlugin.getConfig().getString("chatSettings.prefix") + " " +
                                  ChatGlobalPlugin.getConfig().getString("chatSettings.format")
                                  .replace("{PLAYER_NAME}", playerName)
                                  .replace("{MESSAGE}", message);

        if (ChatGlobalPlugin.getConfig().getBoolean("pluginConfig.enableSpigot")) {
            formattedMessage = PlaceholderAPI.setPlaceholders(event.getPlayer(), formattedMessage);
        }

        for (org.bukkit.entity.Player player : Bukkit.getOnlinePlayers()) {
            player.sendMessage(formattedMessage);
        }
        event.setCancelled(true);
    }
}
