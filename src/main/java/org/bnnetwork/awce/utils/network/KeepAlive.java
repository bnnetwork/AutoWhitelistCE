package org.bnnetwork.awce.utils.network;

public class KeepAlive {
    private static final WebsocketManager websocketManager = new WebsocketManager();
    public static void keepAlive(){
        if (!websocketManager.isWebsocketCreated()) WebsocketManager.createWebsocket();
        WebsocketManager.sendMessage("keepalive");
    }

    //TODO �������߳�,���ڴ������������Դﵽ�����Ŀ��
}
