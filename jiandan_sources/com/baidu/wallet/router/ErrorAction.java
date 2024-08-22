package com.baidu.wallet.router;

import android.content.Context;
import com.baidu.wallet.core.NoProguard;
import java.util.HashMap;

public class ErrorAction implements NoProguard, RouterAction {
    public static final String DEFAULT_MESSAGE = "Something was really wrong.";

    public void invoke(Context context, HashMap hashMap, RouterCallback routerCallback) {
        if (routerCallback != null) {
            HashMap hashMap2 = new HashMap();
            hashMap2.put("errorMsg", "Something was really wrong.");
            routerCallback.onResult(5, hashMap2);
        }
    }
}
