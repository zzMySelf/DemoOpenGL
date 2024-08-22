package com.baidu.nadcore.cmd.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.nadcore.cmd.runtime.CmdRuntime;
import com.baidu.nadcore.exp.AdExpRuntime;
import com.baidu.nadcore.safe.CollectionUtils;
import com.baidu.nadcore.utils.ActivityUtils;
import java.lang.ref.WeakReference;
import java.util.List;

public class OpenAppUtils {
    public static final Boolean DEBUG = false;
    private static final String TAG = "OpenAppUtils";

    public static void openApp(Context context, String scheme, String pkgName, final InterceptCallback callback, boolean needCheck) {
        final WeakReference<Context> contextRef = new WeakReference<>(context);
        boolean match = false;
        try {
            final Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(scheme));
            if (AdExpRuntime.plat().info().getGlobalConfInt("ali_dp_update_switch", 1) != 1 || !scheme.startsWith("tbopen")) {
                intent.setFlags(268435456);
            } else {
                intent.setFlags(805339136);
            }
            if (!needCheck || OpenAppManager.checkScheme(context, scheme)) {
                List<ResolveInfo> resolveInfo = context.getPackageManager().queryIntentActivities(intent, 0);
                int i2 = 0;
                while (true) {
                    if (i2 >= resolveInfo.size()) {
                        break;
                    }
                    ResolveInfo info = (ResolveInfo) CollectionUtils.get(resolveInfo, i2);
                    if (info != null) {
                        String pkg = info.activityInfo.packageName;
                        match = true;
                        if (TextUtils.equals(pkg, pkgName)) {
                            intent.setPackage(pkg);
                            break;
                        }
                    }
                    i2++;
                }
            }
            if (match) {
                if (needCheck) {
                    CmdRuntime.hostRouter().interceptDialog(scheme, pkgName, new InterceptCallback() {
                        public void onResult(boolean result) {
                            if (result) {
                                Context context = (Context) contextRef.get();
                                Context contextGet = context;
                                if (context != null) {
                                    ActivityUtils.startActivitySafely(contextGet, intent);
                                }
                            }
                            InterceptCallback interceptCallback = callback;
                            if (interceptCallback != null) {
                                interceptCallback.onResult(result);
                            }
                        }
                    });
                    return;
                }
                ActivityUtils.startActivitySafely(context, intent);
                if (callback != null) {
                    callback.onResult(true);
                }
            } else if (callback != null) {
                callback.onResult(false);
            }
        } catch (Exception e2) {
            if (callback != null) {
                callback.onResult(false);
            }
        }
    }

    public static boolean openAppByPkgName(Context context, String pkgName) {
        boolean ret = false;
        if (TextUtils.isEmpty(pkgName)) {
            return false;
        }
        Intent resolveIntent = new Intent("android.intent.action.MAIN");
        resolveIntent.addCategory("android.intent.category.LAUNCHER");
        resolveIntent.setPackage(pkgName);
        List<ResolveInfo> apps = context.getPackageManager().queryIntentActivities(resolveIntent, 0);
        if (apps.size() > 0) {
            ResolveInfo ri = apps.iterator().next();
            if (ri != null) {
                String className = ri.activityInfo.name;
                Intent intent = new Intent("android.intent.action.MAIN");
                intent.addCategory("android.intent.category.LAUNCHER");
                intent.setComponent(new ComponentName(pkgName, className));
                intent.setFlags(268435456);
                ret = true;
                try {
                    context.startActivity(intent);
                } catch (Exception e2) {
                    ret = false;
                }
            } else {
                ret = false;
            }
        }
        if (DEBUG.booleanValue() && !ret) {
            Log.e(TAG, "openAppByPkgName: " + pkgName + "  failed");
        }
        return ret;
    }
}
