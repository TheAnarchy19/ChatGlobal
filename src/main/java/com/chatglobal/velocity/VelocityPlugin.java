package com.chatglobal.velocity;

import com.chatglobal.common.ChatGlobalPlugin;
import com.velocitypowered.api.event.EventHandler;
import com.velocitypowered.api.event.player.ChatEvent;
import com.velocitypowered.api.plugin.Plugin;
import com.velocitypowered.api.proxy.Player;
import com.velocitypowered.api.proxy.ProxyServer;

@Plugin(id = "chatglobal", name = "ChatGlobal", version = "1.0")
public class VelocityPlugin {

    private final ProxyServer server;

    public VelocityPlugin(ProxyServer server) {
        this.server = server;
    }

    @EventHandler
    public void onChat(ChatEvent event) {
        if (event.getMessage().startsWith("/")) return;  

        String message = event.getMessage();
        String playerName = event.getPlayer().getUsername();

        String formattedMessage = ChatGlobalPlugin.getConfig().getString("chatSettings.prefix") + " " +
                                  ChatGlobalPlugin.getConfig().getString("chatSettings.format")
                                  .replace("{PLAYER_NAME}", playerName)
                                  .replace("{MESSAGE}", message);

        if (ChatGlobalPlugin.getConfig().getBoolean("pluginConfig.enableSpigot")) {
            formattedMessage = PlaceholderAPI.setPlaceholders(event.getPlayer(), formattedMessage);
        }

        for (Player player : server.getAllPlayers()) {
            player.sendMessage(formattedMessage);
        }

        event.setResult(ChatEvent.ChatResult.denied());
    }
}
