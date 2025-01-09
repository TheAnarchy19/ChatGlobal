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
        if (event.getMessage().startsWith("/")) return;  // Ignorar comandos

        String message = event.getMessage();
        String playerName = event.getPlayer().getUsername();

        // Formatear el mensaje utilizando la configuración
        String formattedMessage = ChatGlobalPlugin.getConfig().getString("chatSettings.prefix") + " " +
                                  ChatGlobalPlugin.getConfig().getString("chatSettings.format")
                                  .replace("{PLAYER_NAME}", playerName)
                                  .replace("{MESSAGE}", message);

        // Si PlaceholderAPI está habilitado en Spigot, reemplazar placeholders
        if (ChatGlobalPlugin.getConfig().getBoolean("pluginConfig.enableSpigot")) {
            formattedMessage = PlaceholderAPI.setPlaceholders(event.getPlayer(), formattedMessage);
        }

        // Enviar el mensaje a todos los jugadores de Velocity
        for (Player player : server.getAllPlayers()) {
            player.sendMessage(formattedMessage);
        }

        // Cancelar el evento para evitar que el mensaje se muestre solo en el servidor de Velocity
        event.setResult(ChatEvent.ChatResult.denied());
    }
}
