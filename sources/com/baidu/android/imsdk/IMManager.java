package com.baidu.android.imsdk;

import android.content.Context;
import com.baidu.android.imsdk.chatmessage.BindStateManager;
import com.baidu.android.imsdk.internal.BaseManager;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.internal.IMManagerImpl;
import com.baidu.android.imsdk.internal.IMSettings;
import com.baidu.android.imsdk.utils.NoProGuard;
import com.baidu.android.imsdk.utils.Utility;

public final class IMManager extends BaseManager implements NoProGuard {
    public static boolean enableDebugMode(Context context, boolean debugEnabled) {
        if (isNullContext(context)) {
            return false;
        }
        return IMSettings.enableDebugMode(context.getApplicationContext(), debugEnabled);
    }

    public static boolean init(Context context, int pl) {
        if (isNullContext(context)) {
            return false;
        }
        Context appContext = context.getApplicationContext();
        boolean result = IMConfigInternal.getInstance().setProductLine(appContext, pl);
        IMManagerImpl.getInstance(appContext);
        BindStateManager.activeUnBind(context);
        return result;
    }

    public static String getVersion() {
        return IMManagerImpl.getVersion();
    }

    public static String getIMDeviceId(Context context) {
        return Utility.getIMDeviceId(context);
    }
}
