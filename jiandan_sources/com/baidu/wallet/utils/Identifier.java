package com.baidu.wallet.utils;

import com.baidu.wallet.core.NoProguard;
import com.baidu.wallet.core.utils.LogUtil;
import java.util.UUID;

public class Identifier implements NoProguard {
    public static String sSessionID;

    public static synchronized String sessionID() {
        String str;
        synchronized (Identifier.class) {
            if (sSessionID == null) {
                LogUtil.d("Creating a session id.");
                sSessionID = UUID.randomUUID().toString();
            }
            str = sSessionID;
        }
        return str;
    }
}
