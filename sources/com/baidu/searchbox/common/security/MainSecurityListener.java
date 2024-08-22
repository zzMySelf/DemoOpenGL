package com.baidu.searchbox.common.security;

import android.content.Context;
import com.baidu.searchbox.net.update.v2.SwitchListener;

public class MainSecurityListener extends SwitchListener {
    public static final String SWITCH = "main_security";

    public String getKey(String module, String action) {
        return SWITCH;
    }

    public boolean handleData(Context context, String module, String action, String key, boolean switcher) {
        SecurityPersistConfig.getInstance().setBoolean(SecurityPersistConfigConst.KEY_SEC_MAIN_CHECK, switcher);
        return true;
    }
}
