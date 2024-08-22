package com.baidu.wallet.lightapp.entrance;

import android.content.Context;
import com.baidu.wallet.lightapp.multipage.LangbridgeSettings;
import com.baidu.wallet.lightapp.multipage.h;
import com.baidu.wallet.router.RouterAction;
import com.baidu.wallet.router.RouterCallback;
import java.util.HashMap;

public class LangbridgeOpenPollAction implements RouterAction {
    public void invoke(Context context, HashMap hashMap, RouterCallback routerCallback) {
        HashMap hashMap2 = new HashMap();
        LangbridgeSettings a = h.a().a(context);
        if (a != null) {
            hashMap2.put("openPoll", Boolean.valueOf(!a.MW_USE_OLD || a.MW_ON));
        }
        routerCallback.onResult(0, hashMap2);
    }
}
