package com.baidu.megapp.callback;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.baidu.megapp.util.MegUtils;

public class MegappCallbackController {
    private static final String TAG = "MegCallbackController";
    private Context mAppContext;
    private BottomToolBarCallback mBottomToolBarCallback;

    public MegappCallbackController(Context context) {
        this.mAppContext = context.getApplicationContext();
    }

    public synchronized BottomToolBarCallback getBottomToolBarCallback() {
        Class<?> clazz;
        try {
            ApplicationInfo info = getApplicationInfoWithMetaData();
            if (!(info == null || info.metaData == null)) {
                String className = info.metaData.getString(BottomToolBarCallback.META_DATA_NAME);
                if (!TextUtils.isEmpty(className) && (clazz = Class.forName(className)) != null) {
                    this.mBottomToolBarCallback = (BottomToolBarCallback) clazz.newInstance();
                }
            }
        } catch (ClassNotFoundException e2) {
            if (MegUtils.isDebug()) {
                e2.printStackTrace();
            }
        } catch (InstantiationException e3) {
            if (MegUtils.isDebug()) {
                e3.printStackTrace();
            }
        } catch (IllegalAccessException e4) {
            if (MegUtils.isDebug()) {
                e4.printStackTrace();
            }
        }
        return this.mBottomToolBarCallback;
    }

    public ApplicationInfo getApplicationInfoWithMetaData() {
        if (0 != 0) {
            return null;
        }
        try {
            return this.mAppContext.getPackageManager().getApplicationInfo(this.mAppContext.getPackageName(), 128);
        } catch (PackageManager.NameNotFoundException e2) {
            if (!MegUtils.isDebug()) {
                return null;
            }
            e2.printStackTrace();
            return null;
        } catch (RuntimeException e3) {
            if (!MegUtils.isDebug()) {
                return null;
            }
            e3.printStackTrace();
            return null;
        }
    }
}
