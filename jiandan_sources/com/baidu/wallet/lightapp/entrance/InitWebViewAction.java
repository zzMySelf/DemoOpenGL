package com.baidu.wallet.lightapp.entrance;

import android.content.Context;
import com.baidu.wallet.lightapp.base.LightappWebViewCenter;
import com.baidu.wallet.router.RouterAction;
import com.baidu.wallet.router.RouterCallback;
import java.util.HashMap;

public class InitWebViewAction implements RouterAction {
    public void invoke(Context context, HashMap hashMap, RouterCallback routerCallback) {
        if (LightappWebViewCenter.isLightappWebViewCenterOn(context)) {
            LightappWebViewCenter.getInstance().initWebViewCore(context);
        }
    }
}
