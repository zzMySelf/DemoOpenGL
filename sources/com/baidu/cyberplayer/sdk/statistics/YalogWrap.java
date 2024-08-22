package com.baidu.cyberplayer.sdk.statistics;

import com.baidu.cyberplayer.sdk.InstallBase;
import com.baidu.cyberplayer.sdk.context.ICyberMediaContext;
import com.baidu.cyberplayer.sdk.context.ICyberOnlineLog;

public class YalogWrap {
    private static final String YALOGGER_CLASS_NAME = "com.baidu.yalog.Logger";
    private static final String YALOGGER_MANAGER_CLASS_NAME = "com.baidu.yalog.LoggerManager";
    private static final String YALOG_SPACE = "dumedia";
    private static final String YALOG_UBCID = "5529";
    private static volatile YalogWrap sInstance;

    private YalogWrap() {
    }

    public static YalogWrap getInstance() {
        if (sInstance == null) {
            synchronized (YalogWrap.class) {
                if (sInstance == null) {
                    sInstance = new YalogWrap();
                }
            }
        }
        return sInstance;
    }

    public void writeYalog(int level, String tag, String content) {
        ICyberOnlineLog cyberOnlineLog;
        try {
            ICyberMediaContext cyberMediaContext = InstallBase.getCyberMediaContext();
            if (cyberMediaContext != null && (cyberOnlineLog = cyberMediaContext.getCyberOnlineLog()) != null) {
                switch (level) {
                    case 2:
                        cyberOnlineLog.logV(YALOG_UBCID, tag, content);
                        return;
                    case 3:
                        cyberOnlineLog.logD(YALOG_UBCID, tag, content);
                        return;
                    case 4:
                        cyberOnlineLog.logI(YALOG_UBCID, tag, content);
                        return;
                    case 5:
                        cyberOnlineLog.logW(YALOG_UBCID, tag, content);
                        return;
                    case 6:
                    case 9:
                        cyberOnlineLog.logE(YALOG_UBCID, tag, content);
                        return;
                    default:
                        return;
                }
            }
        } catch (Exception e2) {
        }
    }
}
