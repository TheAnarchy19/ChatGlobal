package com.chatglobal.bungee;

import com.chatglobal.common.ChatGlobalPlugin;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.api.event.AsyncChatEvent;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.api.ProxyServer;

public class BungeePlugin extends Plugin implements Listener {

    @Override
    public void onEnable() {
        // Registrar eventos
        getProxy().getPluginManager().registerListener(this, this);
    }

    @EventHandler
    public void onChat(AsyncChatEvent event) {
        String message = event.getMessage();
        String playerName = event.getSender().getName();

        // Formatear el mensaje utilizando la configuración
        String formattedMessage = ChatGlobalPlugin.getConfig().getString("chatSettings.prefix") + " " +
                                  ChatGlobalPlugin.getConfig().getString("chatSettings.format")
                                  .replace("{PLAYER_NAME}", playerName)
                                  .replace("{MESSAGE}", message);

        // Si PlaceholderAPI está habilitado en Spigot, reemplazar placeholders
        if (ChatGlobalPlugin.getConfig().getBoolean("pluginConfig.enableSpigot")) {
            formattedMessage = PlaceholderAPI.setPlaceholders(event.getSender(), formattedMessage);
        }

        // Enviar el mensaje a todos los jugadores de BungeeCord
        for (net.md_5.bungee.api.proxy.ProxiedPlayer player : getProxy().getPlayers()) {
            player.sendMessage(formattedMessage);
        }

        // Cancelar el evento para evitar que el mensaje se muestre solo en el servidor de BungeeCord
        event.setCancelled(true);
    }
}
