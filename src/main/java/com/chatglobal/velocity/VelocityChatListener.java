package com.chatglobal.velocity;

import com.velocitypowered.api.event.EventHandler;
import com.velocitypowered.api.event.player.ChatEvent;
import com.velocitypowered.api.event.Listener;
import com.chatglobal.common.ChatManager;

public class VelocityChatListener implements Listener {

    @EventHandler
    public void onChat(ChatEvent event) {
        String message = event.getMessage();
        String playerName = event.getPlayer().getUsername();
        String formattedMessage = ChatManager.formatMessage(playerName, message);
        event.setResult(ChatEvent.ChatResult.message(formattedMessage));
    }
}
