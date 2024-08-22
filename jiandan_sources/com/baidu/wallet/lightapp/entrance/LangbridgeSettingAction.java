package com.baidu.wallet.lightapp.entrance;

import android.content.Context;
import com.baidu.wallet.lightapp.multipage.h;
import com.baidu.wallet.router.RouterAction;
import com.baidu.wallet.router.RouterCallback;
import java.util.HashMap;

public class LangbridgeSettingAction implements RouterAction {
    public void invoke(Context context, HashMap hashMap, RouterCallback routerCallback) {
        h.a().a(context, (String) hashMap.get("config"));
    }
}
