package com.baidu.searchbox.silence;

import android.content.Context;
import android.net.Uri;
import com.baidu.android.common.logging.Log;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.update.UpdateUtils;

public final class SilenceUtil {
    private static final boolean DEBUG = AppConfig.isDebug();
    public static final String EXTRA_FLAGS = "flags";
    public static final String EXTRA_PACKAGE_NAME = "packagename";
    private static final String TAG = "SilenceUtil";

    private SilenceUtil() {
    }

    public static void doInstallPacakge(Context context, Uri packageUri, String installer) {
        if (DEBUG) {
            Log.d(TAG, "doInstallPacakge");
        }
        UpdateUtils.installClientUpdateApk(context, packageUri.toString(), installer);
    }
}
