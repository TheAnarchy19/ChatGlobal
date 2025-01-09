package com.chatglobal.bungee;

import net.md_5.bungee.api.event.ChatEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.api.plugin.Plugin;
import com.chatglobal.common.ChatManager;

public class BungeeChatListener implements Listener {

    @EventHandler
    public void onChat(ChatEvent event) {
        String message = event.getMessage();
        String playerName = event.getSender().getName();
        String formattedMessage = ChatManager.formatMessage(playerName, message);
        event.setMessage(formattedMessage);
    }
}
