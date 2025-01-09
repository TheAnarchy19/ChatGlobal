package com.chatglobal.bungee;

import com.chatglobal.common.ChatGlobalPlugin;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.api.event.AsyncChatEvent;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.api.ProxyServer;

public class BungeePlugin extends Plugin implements Listener {

    @Override
    public void onEnable() {
        getProxy().getPluginManager().registerListener(this, this);
    }

    @EventHandler
    public void onChat(AsyncChatEvent event) {
        String message = event.getMessage();
        String playerName = event.getSender().getName();

        String formattedMessage = ChatGlobalPlugin.getConfig().getString("chatSettings.prefix") + " " +
                                  ChatGlobalPlugin.getConfig().getString("chatSettings.format")
                                  .replace("{PLAYER_NAME}", playerName)
                                  .replace("{MESSAGE}", message);

        if (ChatGlobalPlugin.getConfig().getBoolean("pluginConfig.enableSpigot")) {
            formattedMessage = PlaceholderAPI.setPlaceholders(event.getSender(), formattedMessage);
        }

        for (net.md_5.bungee.api.proxy.ProxiedPlayer player : getProxy().getPlayers()) {
            player.sendMessage(formattedMessage);
        }

        event.setCancelled(true);
    }
}
