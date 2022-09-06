package org.bnnetwork.awce.utils.network;

import net.minecraft.text.Text;
import org.bnnetwork.awce.Main;
import org.slf4j.Logger;

import javax.websocket.*;
import java.net.URI;

@ClientEndpoint
public class WebsocketManager {
    private static final Logger logger = Main.getLogger();
    private static boolean hasPerm = false;
    private static boolean isWebsocketCreated = false;

    private static Session session;

    @OnOpen
    private static void onOpen(Session session) {
        logger.info(Text.translatable("awce.websocket.created").toString());
        WebsocketManager.session = session;
        isWebsocketCreated = true;
    }

    public static void createWebsocket() {
        try {
            WebSocketContainer container = ContainerProvider.getWebSocketContainer();
            String uri = "ws://localhost:8080/ws/websocket";
            //TODO 将上面的URI替换为实际URI
            logger.info(Text.translatable("awce.websocket.creating").toString());
            container.connectToServer(WebsocketManager.class, URI.create(uri));
        } catch (Exception ex) {
            logger.error(Text.translatable("awce.websocket.creating.error").toString());
            logger.error(ex.getLocalizedMessage());
        }
    }

    @OnClose
    private static void onClose() {
        logger.info(Text.translatable("awce.websocket.closed").toString());
    }

    public static void closeWebsocket() {
        logger.info(Text.translatable("awce.websocket.closing").toString());
        try {
            session.close();
        } catch (Exception ex) {
            logger.error(Text.translatable("awce.websocket.closing.error").toString());
            logger.error(ex.getLocalizedMessage());
        }
    }

    @OnMessage
    private static void getMessage(String message) {
        if (!message.equals("success") && !message.equals("fail")) {
            message = ;
            //TODO 利用GSON解析message并存值
        } else if (message.equals("success")) {
            logger.info(Text.translatable("awce.verifyperm.passed").toString());
            hasPerm = true;
        } else {
            logger.info(Text.translatable("awce.verifyperm.failed").toString());
        }
    }

    public static void sendMessage(String message) {
        try {
            session.getBasicRemote().sendText(message);
        } catch (Exception e) {
            logger.error(Text.translatable("awce.websocket.sendmessage.error").toString());
            logger.error(e.getLocalizedMessage());
        }
    }

    @OnError
    public static void errorWebsocket(Throwable t) {
        logger.error(Text.translatable("awce.websocket.error").toString());
        logger.error(t.getLocalizedMessage());
    }

    public boolean isHasPerm() {
        return hasPerm;
    }

    public boolean isWebsocketCreated(){
        return isWebsocketCreated;
    }
}
