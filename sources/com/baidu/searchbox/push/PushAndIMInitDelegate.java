package com.baidu.searchbox.push;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.imsdk.ImSdkManager;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;

public class PushAndIMInitDelegate extends ProviderDelegation {
    private static final boolean DEBUG = AppConfig.isDebug();
    public static final String IM_INIT = "im_init";
    public static final String KEY_INIT = "init_key";
    public static final String PUSH_INIT = "push_init";
    private static final String TAG = "PushAndIMInitDelegate";

    public Bundle execCall(Bundle bundle) {
        if (DEBUG) {
            Log.d(TAG, "当前是否为主进程:" + ProcessUtils.isMainProcess());
        }
        if (ProcessUtils.isMainProcess()) {
            String initEvent = bundle.getString(KEY_INIT);
            if (TextUtils.equals(initEvent, PUSH_INIT) && !PushManager.getInstance(AppRuntime.getAppContext()).isPushInited()) {
                PushManager.getInstance(AppRuntime.getAppContext()).startPushService();
            }
            if (TextUtils.equals(initEvent, IM_INIT)) {
                ImSdkManager.getInstance(AppRuntime.getAppContext()).init();
            }
        }
        return this.mResult;
    }

    public static Bundle createBundle(String key) {
        Bundle bundle = new Bundle();
        bundle.putString(KEY_INIT, key);
        return bundle;
    }
}
