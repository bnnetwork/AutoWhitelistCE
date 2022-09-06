package org.bnnetwork.awce.utils;

import org.bnnetwork.awce.Main;
import org.bnnetwork.awce.utils.files.FileManager;
import org.bnnetwork.awce.utils.network.GetPermission;
import org.bnnetwork.awce.utils.network.WebsocketManager;
import org.slf4j.Logger;

public class Init {
    private static final Logger logger = Main.getLogger();

    public static void Init() {
        FileManager.VerifyFiles();
        SettingsManager;
        //TODO 研究透配置系统之后将上面的内容替换为"如果存在配置文件则读取,不存在则生成默认的并提示用户"
        WebsocketManager.createWebsocket();
        GetPermission.getPermission();
        //TODO 上面的空格替换为配置文件中的serect
        //TODO 完成此初始化函数
    }
}
