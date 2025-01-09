package com.chatglobal.spigot;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import com.chatglobal.common.ChatManager;

public class SpigotChatListener implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        String message = event.getMessage();
        String playerName = event.getPlayer().getName();
        String formattedMessage = ChatManager.formatMessage(playerName, message);
        event.setFormat(formattedMessage);
    }
}
