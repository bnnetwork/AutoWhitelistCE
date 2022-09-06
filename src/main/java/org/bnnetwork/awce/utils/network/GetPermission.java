package org.bnnetwork.awce.utils.network;

import org.bnnetwork.awce.Main;

public class GetPermission {
    private static final WebsocketManager websocketManager = new WebsocketManager();

    public void getPermission(String serect) {
        if (websocketManager.isWebsocketCreated()) WebsocketManager.createWebsocket();
        WebsocketManager.sendMessage(serect);
        if (!websocketManager.isHasPerm()) Main.onDisable();
    }
}
