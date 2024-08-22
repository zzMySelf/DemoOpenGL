package com.baidu.wallet.lightapp.entrance;

import android.content.Context;
import com.baidu.wallet.lightapp.base.LightAppWrapper;
import com.baidu.wallet.router.RouterAction;
import com.baidu.wallet.router.RouterCallback;
import java.util.HashMap;
import java.util.Set;

public class GetMethodListAction implements RouterAction {
    public void invoke(Context context, HashMap hashMap, RouterCallback routerCallback) {
        Set<String> methodList = LightAppWrapper.getInstance().getMethodList();
        if (routerCallback != null && methodList != null && methodList.size() > 0) {
            HashMap hashMap2 = new HashMap();
            hashMap2.put("data", methodList);
            routerCallback.onResult(0, hashMap2);
        }
    }
}
