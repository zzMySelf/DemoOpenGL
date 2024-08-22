package com.baidu.wallet.lightapp.business;

import android.app.Activity;
import android.content.Context;
import com.baidu.wallet.api.ILightAppListener;
import com.baidu.wallet.api.ILightappInvokerCallback;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

public abstract class BaseLightApp implements ILightAppListener {
    public boolean callShare(Activity activity, Map<String, String> map, ILightappInvokerCallback iLightappInvokerCallback) {
        return false;
    }

    public Set<String> getMethodList() {
        return Collections.emptySet();
    }

    public void lightappInvoke(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback) {
    }
}
