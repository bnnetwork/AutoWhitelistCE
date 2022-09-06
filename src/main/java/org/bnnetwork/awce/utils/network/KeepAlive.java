package org.bnnetwork.awce.utils.network;

public class KeepAlive {
    private static final WebsocketManager websocketManager = new WebsocketManager();
    public static void keepAlive(){
        if (!websocketManager.isWebsocketCreated()) WebsocketManager.createWebsocket();
        WebsocketManager.sendMessage("keepalive");
    }

    //TODO 利用子线程,定期触发上述函数以达到保活的目的
}
