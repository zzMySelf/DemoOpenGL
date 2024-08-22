package com.dxmpay.wallet.core.utils;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import androidx.appcompat.widget.ActivityChooserModel;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.core.BaseActivity;
import com.dxmpay.wallet.core.beans.BeanConstants;

public final class BaiduWalletUtils {
    public static final boolean IS_BAIDUAPP_PLUGIN = false;

    /* renamed from: ad  reason: collision with root package name */
    public static int f4261ad;

    /* renamed from: de  reason: collision with root package name */
    public static int f4262de;

    /* renamed from: fe  reason: collision with root package name */
    public static int f4263fe;
    public static int qw;

    public interface IRequestPermissionCallBack {
        void isAllAgree(Boolean bool);

        void isShow(String str, Boolean bool);

        void requestResult(String str, Boolean bool);
    }

    public static void finishActivityAnim(Context context) {
        if (context != null) {
            if (f4262de == 0 || f4263fe == 0) {
                f4262de = ResUtils.anim(context, "dxm_wallet_base_slide_from_left");
                f4263fe = ResUtils.anim(context, "dxm_wallet_base_slide_to_right");
            }
            if ((context instanceof Activity) && BeanConstants.needActAnimation) {
                ((Activity) context).overridePendingTransition(f4262de, f4263fe);
            }
            "BaiduWalletUtils-finishActivityAnim-context:" + context + ", mCloseEnter:" + f4262de + ", mCloseExit:" + f4263fe;
        }
    }

    public static String getBaiduappVersionCode(Context context) {
        return null;
    }

    public static String getBaiduappVersionName(Context context) {
        return null;
    }

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
                LogUtil.e("BaiduWalletUtils", e.getMessage(), e);
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

    public static void requestPermissionsDialog(String str, Activity activity, String[] strArr, IRequestPermissionCallBack iRequestPermissionCallBack) {
        DangerousPermissionUtils.getInstance().requestPermissionsDialog(str, activity, strArr, iRequestPermissionCallBack);
    }

    public static void startActivity(Intent intent, Context context) {
        if (context != null) {
            context.startActivity(intent);
        }
    }

    public static void startActivityAnim(Context context) {
        if (context != null) {
            if (qw == 0 || f4261ad == 0) {
                qw = ResUtils.anim(context, "dxm_wallet_base_slide_from_right");
                f4261ad = ResUtils.anim(context, "dxm_wallet_base_slide_to_left");
            }
            if ((context instanceof Activity) && BeanConstants.needActAnimation) {
                ((Activity) context).overridePendingTransition(qw, f4261ad);
            }
        }
    }
}
