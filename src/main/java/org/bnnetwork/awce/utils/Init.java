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
        //TODO �о�͸����ϵͳ֮������������滻Ϊ"������������ļ����ȡ,������������Ĭ�ϵĲ���ʾ�û�"
        WebsocketManager.createWebsocket();
        GetPermission.getPermission();
        //TODO ����Ŀո��滻Ϊ�����ļ��е�serect
        //TODO ��ɴ˳�ʼ������
    }
}
