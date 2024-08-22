package com.baidu.swan.games.console;

import com.baidu.swan.apps.console.SwanAppLog;
import com.baidu.swan.apps.event.message.SwanAppCommonMessage;
import com.baidu.swan.apps.lifecycle.SwanAppController;
import java.util.ArrayList;
import java.util.List;

public class SwanGameLog {
    public static final String TYPE_DEBUG = "debug";
    public static final String TYPE_ERROR = "error";
    public static final String TYPE_INFO = "info";
    public static final String TYPE_LOG = "log";
    public static final String TYPE_WARN = "warn";
    private static volatile boolean sConsoleInitFinished = false;
    private static volatile boolean sLogSwitch = false;
    private static volatile List<SwanAppCommonMessage> sMessageCache = new ArrayList();

    private SwanGameLog() {
    }

    public static void setConsoleSwitch(boolean support) {
        sLogSwitch = support;
        SwanAppLog.setConsoleSwitch(support);
    }

    public static boolean getConsoleSwitch() {
        return sLogSwitch;
    }

    public static void resetConsoleInitState() {
        synchronized (SwanGameLog.class) {
            sMessageCache = new ArrayList();
        }
        sConsoleInitFinished = false;
    }

    public static void notifyConsoleInitFinished() {
        if (sLogSwitch && !sConsoleInitFinished) {
            synchronized (SwanGameLog.class) {
                if (sMessageCache != null) {
                    for (int i2 = 0; i2 < sMessageCache.size(); i2++) {
                        SwanAppController.getInstance().sendJSMessage("console", sMessageCache.get(i2));
                    }
                    sMessageCache.clear();
                    sMessageCache = null;
                }
            }
            sConsoleInitFinished = true;
        }
    }

    private static String parseJsLogTypeToString(int consoleLogLevel) {
        switch (consoleLogLevel) {
            case 1:
                return "log";
            case 2:
            case 6:
                return "debug";
            case 3:
                return "info";
            case 4:
                return "error";
            case 5:
                return "warn";
            default:
                return "log";
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int parseLogTypeToSystemLevel(java.lang.String r4) {
        /*
            int r0 = r4.hashCode()
            r1 = 3
            r2 = 4
            r3 = 2
            switch(r0) {
                case 107332: goto L_0x0035;
                case 3237038: goto L_0x002a;
                case 3641990: goto L_0x001f;
                case 95458899: goto L_0x0015;
                case 96784904: goto L_0x000b;
                default: goto L_0x000a;
            }
        L_0x000a:
            goto L_0x0040
        L_0x000b:
            java.lang.String r0 = "error"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x000a
            r0 = r2
            goto L_0x0041
        L_0x0015:
            java.lang.String r0 = "debug"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x000a
            r0 = r3
            goto L_0x0041
        L_0x001f:
            java.lang.String r0 = "warn"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x000a
            r0 = r1
            goto L_0x0041
        L_0x002a:
            java.lang.String r0 = "info"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x000a
            r0 = 1
            goto L_0x0041
        L_0x0035:
            java.lang.String r0 = "log"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x000a
            r0 = 0
            goto L_0x0041
        L_0x0040:
            r0 = -1
        L_0x0041:
            switch(r0) {
                case 0: goto L_0x004b;
                case 1: goto L_0x004a;
                case 2: goto L_0x0049;
                case 3: goto L_0x0047;
                case 4: goto L_0x0045;
                default: goto L_0x0044;
            }
        L_0x0044:
            return r3
        L_0x0045:
            r0 = 6
            return r0
        L_0x0047:
            r0 = 5
            return r0
        L_0x0049:
            return r1
        L_0x004a:
            return r2
        L_0x004b:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.swan.games.console.SwanGameLog.parseLogTypeToSystemLevel(java.lang.String):int");
    }

    public static void sendJsConsoleLog(int consoleLogLevel, String log) {
        sendJsConsoleLog(parseJsLogTypeToString(consoleLogLevel), log);
    }

    public static void sendJsConsoleLog(String logType, String log) {
        if (sLogSwitch) {
            sendLogMessageToSConsole(ConsoleMessage.newJsConsoleMessage(logType, log));
        }
    }

    public static void sendSystemLog(String logType, String log) {
        if (sLogSwitch) {
            sendLogMessageToSConsole(ConsoleMessage.newSystemMessage(logType, log));
        }
    }

    private static void sendLogMessageToSConsole(SwanAppCommonMessage message) {
        if (!sConsoleInitFinished) {
            synchronized (SwanGameLog.class) {
                if (sMessageCache != null) {
                    sMessageCache.add(message);
                    return;
                }
            }
        }
        SwanAppController.getInstance().sendJSMessage("console", message);
    }
}
