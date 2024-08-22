package com.baidu.wallet.core.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import androidx.appcompat.widget.ActivityChooserModel;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.core.BaseActivity;
import com.baidu.wallet.core.beans.BeanConstants;
import com.baidu.wallet.permission.CommonPermissionCallback;

public final class BaiduWalletUtils {
    public static final boolean IS_BAIDUAPP_PLUGIN = false;
    public static int a;
    public static int b;
    public static int c;
    public static int d;

    public interface IRequestPermissionCallBack {
        void isAllAgree(Boolean bool);

        void isShow(String str, Boolean bool);

        void requestResult(String str, Boolean bool);
    }

    public static void finishActivityAnim(Context context) {
        if (context != null) {
            if (c == 0 || d == 0) {
                c = ResUtils.anim(context, "wallet_base_slide_from_left");
                d = ResUtils.anim(context, "wallet_base_slide_to_right");
            }
            if ((context instanceof Activity) && BeanConstants.needActAnimation) {
                ((Activity) context).overridePendingTransition(c, d);
            }
            LogUtil.v("xyz", "BaiduWalletUtils-finishActivityAnim-context:" + context + ", mCloseEnter:" + c + ", mCloseExit:" + d);
        }
    }

    public static String getBaiduappVersionCode(Context context) {
        return null;
    }

    public static String getBaiduappVersionName(Context context) {
        return null;
    }

    @SuppressLint({"NewApi"})
    public static String[] getForegroundActivityInfo(Context context) {
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            return new String[]{activity.getPackageName(), activity.getComponentName().getClassName()};
        } else if (context == null) {
            return null;
        } else {
            try {
                ActivityManager activityManager = (ActivityManager) context.getSystemService(ActivityChooserModel.ATTRIBUTE_ACTIVITY);
                ActivityManager.RunningTaskInfo runningTaskInfo = activityManager != null ? activityManager.getRunningTasks(1).get(0) : null;
                if (runningTaskInfo == null) {
                    return null;
                }
                ComponentName componentName = runningTaskInfo.topActivity;
                return new String[]{componentName.getPackageName(), componentName.getClassName()};
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    public static void invokeHostLightapp(Context context, String str) {
    }

    public static boolean isActivity(Context context) {
        return (context instanceof Activity) || (context instanceof BaseActivity);
    }

    public static boolean isNightMode() {
        return false;
    }

    public static void overridePendingTransitionNoAnim(Activity activity) {
        if (activity != null) {
            activity.overridePendingTransition(0, 0);
        }
    }

    public static CommonPermissionCallback requestPermissionsDialog(String str, Activity activity, String[] strArr, IRequestPermissionCallBack iRequestPermissionCallBack) {
        DangerousPermissionUtils.getInstance().requestPermissionsDialog(str, activity, strArr, iRequestPermissionCallBack);
        return null;
    }

    public static void startActivity(Intent intent, Context context) {
        if (context != null) {
            context.startActivity(intent);
        }
    }

    public static void startActivityAnim(Context context) {
        if (context != null) {
            if (a == 0 || b == 0) {
                a = ResUtils.anim(context, "wallet_base_slide_from_right");
                b = ResUtils.anim(context, "wallet_base_slide_to_left");
            }
            if ((context instanceof Activity) && BeanConstants.needActAnimation) {
                ((Activity) context).overridePendingTransition(a, b);
            }
        }
    }
}
