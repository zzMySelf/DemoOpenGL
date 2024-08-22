package com.baidu.wallet.core;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityOptions;
import android.app.Application;
import android.app.Dialog;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import com.baidu.apollon.statusbar.ImmersiveKeyboardAdjust;
import com.baidu.apollon.utils.DisplayUtils;
import com.baidu.apollon.utils.DxmApplicationContextImpl;
import com.baidu.apollon.utils.GlobalUtils;
import com.baidu.apollon.utils.PhoneUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.api.Constants;
import com.baidu.wallet.base.statistics.DXMSdkSAUtils;
import com.baidu.wallet.base.statistics.StatServiceEvent;
import com.baidu.wallet.base.widget.LoadingDialog;
import com.baidu.wallet.base.widget.SafeScrollView;
import com.baidu.wallet.base.widget.dialog.PromptDialog;
import com.baidu.wallet.base.widget.dialog.PromptImageDialog;
import com.baidu.wallet.base.widget.dialog.listener.DelegateOnCancleListener;
import com.baidu.wallet.core.SDKBaseActivity;
import com.baidu.wallet.core.beans.NetworkBean;
import com.baidu.wallet.core.utils.BaiduWalletUtils;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.core.utils.WalletGlobalUtils;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class BaseActivity extends SDKBaseActivity implements NoProguard {
    public static final boolean DEBUG = false;
    public static final int DIALOG_GOTO_APP_DETAIL = 52;
    public static final int DIALOG_IMAGE_TIP = 2;
    public static final int DIALOG_NO_NETWORK = 11;
    public static final int DIALOG_PP_SET_PAYPWD = 25;
    public static final int DIALOG_PROMPT = 3;
    public static final int DIALOG_SELECT_PAYMENT = 32;
    public static final int DIALOG_WAIT_S0 = 0;
    public static final int DIALOG_WAIT_S1 = -1;
    public static final int DIALOG_WAIT_S2 = -2;
    public static final int SHOW_ICONCLOSE_INDEX = 2;
    public static final String TAG = "BaseActivity";
    public static final String WITH_ANIM = "with_anim";
    public static LinkedList<BaseActivity> mActivityStack = new LinkedList<>();
    public static int mLiveActivityNum = 0;
    public static float sNocompatDensity;
    public static float sNocompatScaleDensity;
    public int defaultLenth = 375;
    public boolean isSupportUIAdapatation = false;
    public boolean isTranslucentOrFloating = false;
    public boolean isWidthLimitedMode = true;
    public View mContent;
    public String mDialogMsg = "";
    public int mFlag = 0;
    public boolean mIsActivityInForeground = false;
    public boolean mIsMultiWindowAvailable = true;
    public boolean mIsShowMultiWindowTips = false;
    public ImmersiveKeyboardAdjust mKeyboardAdjust;
    public String mMultiWindowTipsID = "wallet_base_multi_window_tips";
    public View mNightModeView = null;
    public SafeScrollView mSafeScrollView = null;
    public long mTimeVal;
    public boolean mWindowNightMode = true;
    public b myOrientoinListener;
    public int oneBackWebViewDeep;
    public int showIconCloseStatus = 0;

    public static void addLiveActivityNum() {
        mLiveActivityNum++;
    }

    public static synchronized void addToTask(BaseActivity baseActivity) {
        synchronized (BaseActivity.class) {
            mActivityStack.remove(baseActivity);
            mActivityStack.add(baseActivity);
        }
    }

    public static synchronized void clearTask() {
        synchronized (BaseActivity.class) {
            Iterator it = mActivityStack.iterator();
            while (it.hasNext()) {
                ((BaseActivity) it.next()).finish();
            }
        }
    }

    public static synchronized void clearTaskExcept(BaseActivity baseActivity) {
        synchronized (BaseActivity.class) {
            Iterator it = mActivityStack.iterator();
            while (it.hasNext()) {
                BaseActivity baseActivity2 = (BaseActivity) it.next();
                if (baseActivity2 != baseActivity) {
                    baseActivity2.finish();
                }
            }
        }
    }

    public static synchronized void clearTasksTopOf(BaseActivity baseActivity) {
        synchronized (BaseActivity.class) {
            LogUtil.d("BaseActivity", "clearTasksTopOf. stack size = " + mActivityStack.size());
            int size = mActivityStack.size() + -1;
            while (true) {
                if (size <= 0) {
                    break;
                }
                BaseActivity baseActivity2 = mActivityStack.get(size);
                if (baseActivity2 == baseActivity) {
                    break;
                }
                baseActivity2.finish();
                size--;
            }
        }
    }

    public static synchronized void clearTasksWithActivityName(Class<?> cls) {
        synchronized (BaseActivity.class) {
            int size = mActivityStack.size() - 1;
            while (true) {
                if (size <= 0) {
                    break;
                }
                BaseActivity baseActivity = mActivityStack.get(size);
                if (baseActivity.getClass().equals(cls)) {
                    break;
                }
                baseActivity.finish();
                size--;
            }
        }
    }

    public static synchronized void clearTasksWithFlag(int i2) {
        synchronized (BaseActivity.class) {
            LogUtil.methodTrace("BaseActivity");
            LogUtil.d("BaseActivity", "clearTasksWithFlag. stack size = " + mActivityStack.size());
            Iterator it = mActivityStack.iterator();
            while (it.hasNext()) {
                BaseActivity baseActivity = (BaseActivity) it.next();
                if ((baseActivity.mFlag & i2) != 0) {
                    baseActivity.finish();
                    baseActivity.overridePendingTransition(0, 0);
                }
            }
        }
    }

    private void convertFromTranslucent() {
        try {
            Method declaredMethod = Activity.class.getDeclaredMethod("convertFromTranslucent", new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(getActivity(), new Object[0]);
        } catch (Throwable unused) {
        }
    }

    private void convertToTranslucent() {
        Object obj;
        Class cls;
        Object obj2;
        try {
            Class[] declaredClasses = Activity.class.getDeclaredClasses();
            int length = declaredClasses.length;
            int i2 = 0;
            while (true) {
                obj = null;
                if (i2 >= length) {
                    cls = null;
                    break;
                }
                cls = declaredClasses[i2];
                if (cls.getSimpleName().equals("TranslucentConversionListener")) {
                    break;
                }
                i2++;
            }
            if (cls != null) {
                obj2 = Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new InvocationHandler() {
                    public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
                        return null;
                    }
                });
            } else {
                obj2 = null;
            }
            if (Build.VERSION.SDK_INT >= 21) {
                try {
                    Method declaredMethod = Activity.class.getDeclaredMethod("getActivityOptions", new Class[0]);
                    declaredMethod.setAccessible(true);
                    obj = declaredMethod.invoke(this, new Object[0]);
                } catch (Exception unused) {
                }
                Method declaredMethod2 = Activity.class.getDeclaredMethod("convertToTranslucent", new Class[]{cls, ActivityOptions.class});
                declaredMethod2.setAccessible(true);
                declaredMethod2.invoke(getActivity(), new Object[]{obj2, obj});
                return;
            }
            Method declaredMethod3 = Activity.class.getDeclaredMethod("convertToTranslucent", new Class[]{cls});
            declaredMethod3.setAccessible(true);
            declaredMethod3.invoke(getActivity(), new Object[]{obj2});
        } catch (Throwable unused2) {
        }
    }

    public static void decLiveActivityNum() {
        mLiveActivityNum--;
    }

    public static BaseActivity getNextActivity(Activity activity) {
        if (activity == null) {
            return null;
        }
        LogUtil.d("BaseActivity", "getNextActivity，size()：" + mActivityStack.size());
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i3 >= mActivityStack.size()) {
                break;
            }
            BaseActivity baseActivity = mActivityStack.get(i3);
            LogUtil.d("BaseActivity", "getNextActivity，baseActivity：" + baseActivity);
            if (baseActivity == activity) {
                LogUtil.d("BaseActivity", "getNextActivity，相等的：" + baseActivity);
                i2 = i3;
                break;
            }
            i3++;
        }
        int i4 = i2 - 1;
        if (i4 >= 0) {
            return mActivityStack.get(i4);
        }
        return null;
    }

    public static BaseActivity getNextTopActivity() {
        int size = mActivityStack.size() - 2;
        if (size >= 0) {
            return mActivityStack.get(size);
        }
        return null;
    }

    public static BaseActivity getTopActivity() {
        return mActivityStack.getLast();
    }

    public static boolean isAppInForeground() {
        return mLiveActivityNum > 0;
    }

    private boolean isBaiduappPlugin() {
        return false;
    }

    private boolean isTranslucentOrFloating() {
        try {
            Class<?> cls = Class.forName("com.android.internal.R$styleable");
            Field declaredField = cls.getDeclaredField("Window");
            declaredField.setAccessible(true);
            TypedArray obtainStyledAttributes = obtainStyledAttributes((int[]) declaredField.get((Object) null));
            Field declaredField2 = cls.getDeclaredField("Window_windowIsTranslucent");
            declaredField2.setAccessible(true);
            Field declaredField3 = cls.getDeclaredField("Window_windowSwipeToDismiss");
            declaredField3.setAccessible(true);
            Field declaredField4 = cls.getDeclaredField("Window_windowIsFloating");
            declaredField4.setAccessible(true);
            boolean z = obtainStyledAttributes.getBoolean(((Integer) declaredField2.get((Object) null)).intValue(), false);
            boolean z2 = !obtainStyledAttributes.hasValue(((Integer) declaredField2.get((Object) null)).intValue()) && obtainStyledAttributes.getBoolean(((Integer) declaredField3.get((Object) null)).intValue(), false);
            if (obtainStyledAttributes.getBoolean(((Integer) declaredField4.get((Object) null)).intValue(), false) || z || z2) {
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static synchronized void removeFromTask(BaseActivity baseActivity) {
        synchronized (BaseActivity.class) {
            mActivityStack.remove(baseActivity);
        }
    }

    public static void setCustomDensity(@NonNull final Application application, boolean z, int i2) {
        int i3;
        DisplayMetrics displayMetrics = application.getResources().getDisplayMetrics();
        if (sNocompatDensity == 0.0f) {
            sNocompatDensity = displayMetrics.density;
            sNocompatScaleDensity = displayMetrics.scaledDensity;
            application.registerComponentCallbacks(new ComponentCallbacks() {
                public void onConfigurationChanged(Configuration configuration) {
                    if (configuration != null && configuration.fontScale > 0.0f) {
                        float unused = BaseActivity.sNocompatScaleDensity = application.getResources().getDisplayMetrics().scaledDensity;
                    }
                }

                public void onLowMemory() {
                }
            });
        }
        if (z) {
            i3 = displayMetrics.widthPixels;
        } else {
            i3 = displayMetrics.heightPixels;
        }
        float f = ((float) i3) / ((float) i2);
        displayMetrics.density = f;
        displayMetrics.scaledDensity = (sNocompatScaleDensity / sNocompatDensity) * f;
        displayMetrics.densityDpi = (int) (160.0f * f);
    }

    @TargetApi(24)
    private void showMultiWindowTips() {
        if (Build.VERSION.SDK_INT >= 24 && isInMultiWindowMode()) {
            if (this.mIsShowMultiWindowTips) {
                GlobalUtils.toast(this, ResUtils.getString(getActivity(), this.mMultiWindowTipsID), -1, 1);
            }
            if (!this.mIsMultiWindowAvailable) {
                finish();
            }
        }
    }

    public static void startActivityDownUpAnim(Context context) {
        if (context != null) {
            int anim = ResUtils.anim(context, "wallet_base_slide_from_bottom");
            int anim2 = ResUtils.anim(context, "wallet_base_slide_to_up");
            if (context instanceof Activity) {
                ((Activity) context).overridePendingTransition(anim, anim2);
            }
        }
    }

    public void cancleRequest() {
    }

    public void closeNightMode() {
        if (isWindowNightMode() && this.mNightModeView != null) {
            getWindowManager().removeViewImmediate(this.mNightModeView);
            this.mNightModeView = null;
        }
    }

    public void finish() {
        boolean z;
        super.finish();
        try {
            z = getIntent().getBooleanExtra("with_anim", true);
        } catch (Exception unused) {
            z = false;
        }
        if (isHalfLightBridge(getIntent())) {
            BaiduWalletUtils.overridePendingTransitionNoAnim(getActivity());
        } else if (z) {
            BaiduWalletUtils.finishActivityAnim(getActivity());
        } else {
            BaiduWalletUtils.overridePendingTransitionNoAnim(getActivity());
        }
    }

    public void finishWithoutAnim() {
        super.finish();
    }

    public Activity getActivity() {
        return super.getActivity();
    }

    public ArrayList<String> getHandlerFailureData(int i2, int i3, String str) {
        String str2;
        String str3 = "";
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            str2 = String.valueOf(i2);
            try {
                str3 = String.valueOf(i3);
            } catch (Exception unused) {
            }
        } catch (Exception unused2) {
            str2 = str3;
        }
        arrayList.add(str2);
        arrayList.add(str3);
        arrayList.add(str);
        return arrayList;
    }

    public void increaseIconCloseStatus() {
        int i2 = this.showIconCloseStatus;
        if (i2 < 2) {
            this.showIconCloseStatus = i2 + 1;
        }
    }

    public boolean isActivityInForeground() {
        return this.mIsActivityInForeground;
    }

    public boolean isHalfLightBridge(Intent intent) {
        return (intent == null || intent.getDoubleExtra(Constants.HALF_LIGHTBRIDGE_HEIGHT, -0.0d) == -0.0d) ? false : true;
    }

    public boolean isStatusbarTextColorBlack() {
        return true;
    }

    public boolean isWindowNightMode() {
        return this.mWindowNightMode;
    }

    public void keyBoardAdjustDetach() {
        View view;
        ImmersiveKeyboardAdjust immersiveKeyboardAdjust = this.mKeyboardAdjust;
        if (!(immersiveKeyboardAdjust == null || (view = this.mContent) == null)) {
            immersiveKeyboardAdjust.detachActivity(view);
        }
        this.mKeyboardAdjust = null;
        this.mContent = null;
    }

    public boolean needKeyboardAdjust() {
        return true;
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (BaiduWalletUtils.isNightMode()) {
            startNightMode();
        }
    }

    public void onBackPressed() {
        try {
            super.onBackPressed();
            this.showIconCloseStatus = 0;
        } catch (IllegalStateException unused) {
            if (Build.VERSION.SDK_INT >= 21) {
                finishAfterTransition();
            } else {
                finish();
            }
        }
        boolean booleanExtra = getIntent().getBooleanExtra("with_anim", true);
        if (isHalfLightBridge(getIntent())) {
            BaiduWalletUtils.overridePendingTransitionNoAnim(getActivity());
        } else if (booleanExtra) {
            BaiduWalletUtils.finishActivityAnim(getActivity());
        } else {
            BaiduWalletUtils.overridePendingTransitionNoAnim(getActivity());
        }
    }

    public void onBackPressedForWalletApp() {
        try {
            super.onBackPressed();
        } catch (IllegalStateException unused) {
            if (Build.VERSION.SDK_INT >= 21) {
                finishAfterTransition();
            } else {
                finish();
            }
        }
    }

    public void onBackPressedWithoutAnim() {
        try {
            super.onBackPressed();
        } catch (IllegalStateException unused) {
            if (Build.VERSION.SDK_INT >= 21) {
                finishAfterTransition();
            } else {
                finish();
            }
        }
        overridePendingTransition(0, 0);
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0079  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r7) {
        /*
            r6 = this;
            long r0 = java.lang.System.currentTimeMillis()
            r6.mTimeVal = r0
            android.content.pm.ApplicationInfo r0 = r6.getApplicationInfo()
            int r0 = r0.targetSdkVersion
            r1 = 26
            if (r0 <= r1) goto L_0x001f
            int r0 = android.os.Build.VERSION.SDK_INT
            if (r0 != r1) goto L_0x001f
            boolean r0 = r6.isTranslucentOrFloating()
            r6.isTranslucentOrFloating = r0
            if (r0 == 0) goto L_0x001f
            r6.convertFromTranslucent()
        L_0x001f:
            r0 = 1
            boolean r2 = r6.isBaiduappPlugin()     // Catch:{ Exception -> 0x002a }
            if (r2 != 0) goto L_0x002b
            r6.setRequestedOrientation(r0)     // Catch:{ Exception -> 0x002a }
            goto L_0x002b
        L_0x002a:
        L_0x002b:
            android.content.pm.ApplicationInfo r2 = r6.getApplicationInfo()
            int r2 = r2.targetSdkVersion
            r3 = 0
            r4 = 0
            if (r2 <= r1) goto L_0x0134
            int r2 = android.os.Build.VERSION.SDK_INT
            if (r2 != r1) goto L_0x0134
            java.lang.String r1 = com.baidu.wallet.core.beans.BeanConstants.CHANNEL_ID
            java.lang.String r2 = "iqiyi"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L_0x0065
            java.lang.Class<android.app.Activity> r1 = android.app.Activity.class
            java.lang.String r2 = "mActivityInfo"
            java.lang.reflect.Field r1 = r1.getDeclaredField(r2)     // Catch:{ NoSuchFieldException -> 0x0060, IllegalAccessException -> 0x005b }
            r1.setAccessible(r0)     // Catch:{ NoSuchFieldException -> 0x0060, IllegalAccessException -> 0x005b }
            if (r1 == 0) goto L_0x0076
            android.app.Activity r2 = r6.getActivity()     // Catch:{ NoSuchFieldException -> 0x0060, IllegalAccessException -> 0x005b }
            java.lang.Object r1 = r1.get(r2)     // Catch:{ NoSuchFieldException -> 0x0060, IllegalAccessException -> 0x005b }
            android.content.pm.ActivityInfo r1 = (android.content.pm.ActivityInfo) r1     // Catch:{ NoSuchFieldException -> 0x0060, IllegalAccessException -> 0x005b }
            goto L_0x0077
        L_0x005b:
            r1 = move-exception
            r1.printStackTrace()
            goto L_0x0076
        L_0x0060:
            r1 = move-exception
            r1.printStackTrace()
            goto L_0x0076
        L_0x0065:
            android.content.pm.PackageManager r1 = r6.getPackageManager()     // Catch:{ NameNotFoundException -> 0x0072 }
            android.content.ComponentName r2 = r6.getComponentName()     // Catch:{ NameNotFoundException -> 0x0072 }
            android.content.pm.ActivityInfo r1 = r1.getActivityInfo(r2, r4)     // Catch:{ NameNotFoundException -> 0x0072 }
            goto L_0x0077
        L_0x0072:
            r1 = move-exception
            r1.printStackTrace()
        L_0x0076:
            r1 = r3
        L_0x0077:
            if (r1 == 0) goto L_0x0134
            int r1 = r1.getThemeResource()
            android.app.Activity r2 = r6.getActivity()
            java.lang.String r5 = "EbpayThemeActivitTranslucent"
            int r2 = com.baidu.apollon.utils.ResUtils.style(r2, r5)
            if (r1 != r2) goto L_0x009b
            android.app.Activity r1 = r6.getActivity()
            java.lang.String r2 = "EbpayThemeActivitTranslucentForSystem26"
            int r1 = com.baidu.apollon.utils.ResUtils.style(r1, r2)
            r6.setTheme(r1)
            r6.convertToTranslucent()
            goto L_0x0134
        L_0x009b:
            android.app.Activity r2 = r6.getActivity()
            java.lang.String r5 = "EbpayThemeActivityWelcome.Dialog"
            int r2 = com.baidu.apollon.utils.ResUtils.style(r2, r5)
            if (r1 != r2) goto L_0x00b9
            android.app.Activity r1 = r6.getActivity()
            java.lang.String r2 = "EbpayThemeActivityWelcomeDialogForSystem26"
            int r1 = com.baidu.apollon.utils.ResUtils.style(r1, r2)
            r6.setTheme(r1)
            r6.convertToTranslucent()
            goto L_0x0134
        L_0x00b9:
            android.app.Activity r2 = r6.getActivity()
            java.lang.String r5 = "EbpayThemeActivityWelcome"
            int r2 = com.baidu.apollon.utils.ResUtils.style(r2, r5)
            if (r1 != r2) goto L_0x00d6
            android.app.Activity r1 = r6.getActivity()
            java.lang.String r2 = "EbpayThemeActivityWelcomeForSystem26"
            int r1 = com.baidu.apollon.utils.ResUtils.style(r1, r2)
            r6.setTheme(r1)
            r6.convertToTranslucent()
            goto L_0x0134
        L_0x00d6:
            android.app.Activity r2 = r6.getActivity()
            java.lang.String r5 = "CameraMist"
            int r2 = com.baidu.apollon.utils.ResUtils.style(r2, r5)
            if (r1 != r2) goto L_0x00f3
            android.app.Activity r1 = r6.getActivity()
            java.lang.String r2 = "CameraMistForSystem26"
            int r1 = com.baidu.apollon.utils.ResUtils.style(r1, r2)
            r6.setTheme(r1)
            r6.convertToTranslucent()
            goto L_0x0134
        L_0x00f3:
            android.app.Activity r2 = r6.getActivity()
            java.lang.String r5 = "Theme.LBSPaySDK_Transparent"
            int r2 = com.baidu.apollon.utils.ResUtils.style(r2, r5)
            if (r1 != r2) goto L_0x0110
            android.app.Activity r1 = r6.getActivity()
            java.lang.String r2 = "Theme.LBSPaySDK_Transparent_For_System_26"
            int r1 = com.baidu.apollon.utils.ResUtils.style(r1, r2)
            r6.setTheme(r1)
            r6.convertToTranslucent()
            goto L_0x0134
        L_0x0110:
            android.app.Activity r2 = r6.getActivity()
            java.lang.String r5 = "EbpayTranslucentThemeActivity"
            int r2 = com.baidu.apollon.utils.ResUtils.style(r2, r5)
            if (r1 != r2) goto L_0x012d
            android.app.Activity r1 = r6.getActivity()
            java.lang.String r2 = "EbpayTranslucentThemeActivity26"
            int r1 = com.baidu.apollon.utils.ResUtils.style(r1, r2)
            r6.setTheme(r1)
            r6.convertToTranslucent()
            goto L_0x0134
        L_0x012d:
            boolean r1 = r6.isTranslucentOrFloating
            if (r1 == 0) goto L_0x0134
            r6.convertToTranslucent()
        L_0x0134:
            super.onCreate(r7)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "onCreate-----"
            r1.append(r2)
            java.lang.Class r2 = r6.getClass()
            java.lang.String r2 = r2.getName()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "debug_msg"
            com.baidu.wallet.core.utils.LogUtil.e(r2, r1, r3)
            addToTask(r6)
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 27
            if (r1 < r2) goto L_0x017c
            android.content.ContentResolver r1 = r6.getContentResolver()
            java.lang.String r2 = "accelerometer_rotation"
            int r1 = android.provider.Settings.System.getInt(r1, r2, r4)
            if (r1 != r0) goto L_0x016b
            goto L_0x016c
        L_0x016b:
            r0 = 0
        L_0x016c:
            if (r0 == 0) goto L_0x017c
            com.baidu.wallet.core.b r0 = new com.baidu.wallet.core.b
            android.app.Activity r1 = r6.getActivity()
            r0.<init>(r1)
            r6.myOrientoinListener = r0
            r0.enable()
        L_0x017c:
            if (r7 == 0) goto L_0x019c
            java.lang.String r0 = "saveInfo"
            android.os.Bundle r7 = r7.getBundle(r0)
            java.lang.ClassLoader r0 = r6.getClassLoader()
            r7.setClassLoader(r0)
            java.lang.String r0 = "cashdeskcommondata"
            java.io.Serializable r7 = r7.getSerializable(r0)
            if (r7 == 0) goto L_0x019c
            boolean r0 = r7 instanceof com.baidu.wallet.core.beans.NetworkBean.SessionCache
            if (r0 == 0) goto L_0x019c
            com.baidu.wallet.core.beans.NetworkBean$SessionCache r7 = (com.baidu.wallet.core.beans.NetworkBean.SessionCache) r7
            com.baidu.wallet.core.beans.NetworkBean.SessionCache.sync(r7)
        L_0x019c:
            android.app.Activity r7 = r6.getActivity()
            r6.setImmersiveStatusBar(r7)
            boolean r7 = r6.isSupportUIAdapatation
            if (r7 == 0) goto L_0x01b2
            android.app.Application r7 = r6.getApplication()
            boolean r0 = r6.isWidthLimitedMode
            int r1 = r6.defaultLenth
            setCustomDensity(r7, r0, r1)
        L_0x01b2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.wallet.core.BaseActivity.onCreate(android.os.Bundle):void");
    }

    public Dialog onCreateDialog(int i2) {
        LogUtil.d("BaseActivity", "onCreateDialog. id = " + i2);
        if (i2 == -2 || i2 == -1 || i2 == 0) {
            return new LoadingDialog(this);
        }
        if (i2 != 2) {
            return new PromptDialog(getActivity());
        }
        return new PromptImageDialog(getActivity());
    }

    public void onDestroy() {
        b bVar;
        keyBoardAdjustDetach();
        closeNightMode();
        super.onDestroy();
        this.showIconCloseStatus = 0;
        removeFromTask(this);
        if (Build.VERSION.SDK_INT >= 27 && (bVar = this.myOrientoinListener) != null) {
            bVar.a();
            this.myOrientoinListener = null;
        }
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 != 82 || !keyEvent.isLongPress()) {
            return super.onKeyDown(i2, keyEvent);
        }
        return true;
    }

    @TargetApi(24)
    public void onMultiWindowModeChanged(boolean z) {
        if (Build.VERSION.SDK_INT >= 24) {
            super.onMultiWindowModeChanged(z);
            SafeScrollView safeScrollView = this.mSafeScrollView;
            if (safeScrollView != null) {
                safeScrollView.dismissKeyBoard();
            }
            if (z && isActivityInForeground()) {
                if (this.mIsShowMultiWindowTips) {
                    GlobalUtils.toast(this, ResUtils.getString(getActivity(), this.mMultiWindowTipsID), -1, 1);
                }
                if (!this.mIsMultiWindowAvailable) {
                    finish();
                }
            }
        }
    }

    public void onPause() {
        super.onPause();
        decLiveActivityNum();
        this.mIsActivityInForeground = false;
        ArrayList arrayList = new ArrayList();
        arrayList.add(getClass().getSimpleName());
        arrayList.add("out");
        if (statExtraDatasForPause() != null) {
            arrayList.addAll(statExtraDatasForPause());
        }
        DXMSdkSAUtils.onEventWithValues(StatServiceEvent.PAGE_STACK, arrayList);
    }

    public void onPrepareDialog(int i2, Dialog dialog) {
        LogUtil.d("BaseActivity", "onPrepareDialog. id = " + i2);
        if (i2 == -2) {
            LoadingDialog loadingDialog = (LoadingDialog) dialog;
            loadingDialog.setCancelable(true);
            loadingDialog.setOnCancelListener(new DelegateOnCancleListener(new DialogInterface.OnCancelListener() {
                public void onCancel(DialogInterface dialogInterface) {
                    BaseActivity.this.cancleRequest();
                }
            }, loadingDialog));
        } else if (i2 == -1) {
            LoadingDialog loadingDialog2 = (LoadingDialog) dialog;
            loadingDialog2.setCancelable(true);
            loadingDialog2.setOnCancelListener(new DelegateOnCancleListener(new DialogInterface.OnCancelListener() {
                public void onCancel(DialogInterface dialogInterface) {
                    BaseActivity.this.onBackPressed();
                }
            }, loadingDialog2));
        } else if (i2 == 0) {
            ((LoadingDialog) dialog).setCancelable(false);
        } else if (i2 == 3) {
            PromptDialog promptDialog = (PromptDialog) dialog;
            promptDialog.setMessage((CharSequence) this.mDialogMsg);
            promptDialog.setCanceledOnTouchOutside(false);
            promptDialog.hideNegativeButton();
        } else if (i2 == 11) {
            PromptDialog promptDialog2 = (PromptDialog) dialog;
            promptDialog2.setMessage((CharSequence) getString(ResUtils.string(getActivity(), "ebpay_no_network")));
            promptDialog2.setCanceledOnTouchOutside(false);
            promptDialog2.setNegativeBtn(ResUtils.string(getActivity(), "ebpay_cancel"), (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View view) {
                    WalletGlobalUtils.safeDismissDialog(BaseActivity.this, 11);
                }
            });
            promptDialog2.setPositiveBtn(ResUtils.string(getActivity(), "ebpay_setting"), (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View view) {
                    WalletGlobalUtils.safeDismissDialog(BaseActivity.this, 11);
                    try {
                        BaseActivity.this.startActivityForResult(new Intent("android.settings.SETTINGS"), 0);
                    } catch (Exception e) {
                        LogUtil.e("BaseActivity", "onPrepareDialog. DIALOG_NO_NETWORK. onClick", e);
                    }
                }
            });
        } else if (i2 != 52) {
            super.onPrepareDialog(i2, dialog);
        } else {
            final PromptDialog promptDialog3 = (PromptDialog) dialog;
            promptDialog3.setMessage((CharSequence) this.mDialogMsg);
            promptDialog3.setCanceledOnTouchOutside(false);
            promptDialog3.setPositiveBtn(ResUtils.getString(getActivity(), "ebpay_confirm"), (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View view) {
                    promptDialog3.dismiss();
                    String str = "";
                    try {
                        ApplicationInfo applicationInfo = PhoneUtils.getApplicationInfo(BaseActivity.this.getActivity());
                        if (applicationInfo != null) {
                            str = applicationInfo.packageName;
                        }
                        PhoneUtils.showInstalledAppOrDetails(BaseActivity.this.getActivity(), str);
                    } catch (Throwable unused) {
                    }
                }
            });
            promptDialog3.setNegativeBtn(ResUtils.getString(getActivity(), "ebpay_cancel"), (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View view) {
                    promptDialog3.dismiss();
                }
            });
        }
    }

    public void onResume() {
        super.onResume();
        addLiveActivityNum();
        this.mIsActivityInForeground = true;
        showMultiWindowTips();
        if (0 != this.mTimeVal) {
            DXMSdkSAUtils.onEventWithValues(StatServiceEvent.PAGE_STACK, Arrays.asList(new String[]{getClass().getSimpleName(), "in", String.valueOf(System.currentTimeMillis() - this.mTimeVal)}));
            this.mTimeVal = 0;
            return;
        }
        DXMSdkSAUtils.onEventWithValues(StatServiceEvent.PAGE_STACK, Arrays.asList(new String[]{getClass().getSimpleName(), "in", String.valueOf(0)}));
    }

    public void onSaveInstanceState(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        NetworkBean.SessionCache instance = NetworkBean.SessionCache.getInstance();
        if (instance != null) {
            bundle2.putSerializable("cashdeskcommondata", instance);
            bundle.putBundle("saveInfo", bundle2);
        }
        super.onSaveInstanceState(bundle);
    }

    public void onStart() {
        super.onStart();
    }

    public void setImmersiveStatusBar(Activity activity) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 19) {
            if (i2 >= 21) {
                Window window = activity.getWindow();
                window.getDecorView().setSystemUiVisibility(1280);
                window.addFlags(Integer.MIN_VALUE);
                window.setStatusBarColor(ResUtils.getColor(getActivity(), "ebpay_transparent"));
            } else {
                Window window2 = activity.getWindow();
                WindowManager.LayoutParams attributes = window2.getAttributes();
                attributes.flags = 67108864 | attributes.flags;
                window2.setAttributes(attributes);
            }
            this.mContent = findViewById(16908290);
            ImmersiveKeyboardAdjust immersiveKeyboardAdjust = new ImmersiveKeyboardAdjust();
            this.mKeyboardAdjust = immersiveKeyboardAdjust;
            if (immersiveKeyboardAdjust != null && this.mContent != null && needKeyboardAdjust()) {
                this.mKeyboardAdjust.attachActivity(this.mContent);
            }
        }
    }

    public void setIsMultiWindowAvailable(boolean z) {
        if (z != this.mIsMultiWindowAvailable) {
            this.mIsMultiWindowAvailable = z;
        }
    }

    public void setIsShowMultiWindowTips(boolean z) {
        if (z != this.mIsShowMultiWindowTips) {
            this.mIsShowMultiWindowTips = z;
        }
    }

    public void setMultiWindowTipsId(String str) {
        this.mMultiWindowTipsID = str;
    }

    public void setSafeScrollView(SafeScrollView safeScrollView) {
        this.mSafeScrollView = safeScrollView;
    }

    public void setUIAdaptationMode(boolean z, boolean z2, int i2) {
        this.isWidthLimitedMode = z2;
        this.defaultLenth = i2;
        this.isSupportUIAdapatation = z;
    }

    public void setWindowNightMode(boolean z) {
        this.mWindowNightMode = z;
    }

    public void showBaseDialog(int i2, String str) {
        this.mDialogMsg = str;
        WalletGlobalUtils.safeShowDialog(this, i2, str);
    }

    public boolean showCloseIcon(WebView webView) {
        try {
            int currentIndex = webView.copyBackForwardList().getCurrentIndex() + 1;
            if (currentIndex != this.oneBackWebViewDeep && this.oneBackWebViewDeep > 0 && this.showIconCloseStatus == 1) {
                this.showIconCloseStatus = 0;
                this.oneBackWebViewDeep = 0;
            }
            if (this.showIconCloseStatus == 1) {
                this.oneBackWebViewDeep = currentIndex;
            }
            if (this.showIconCloseStatus == 2) {
                return true;
            }
            return false;
        } catch (Exception e) {
            LogUtil.d("BaseActivity", e.toString());
            return false;
        }
    }

    public void startActivity(Intent intent) {
        startActivityForResult(intent, -1);
    }

    public void startActivityForResult(Class<?> cls, int i2) {
        startActivityForResult(new Intent(this, cls), i2);
    }

    public void startActivityForResultWithoutAnim(Intent intent, int i2) {
        super.startActivityForResult(intent, i2);
    }

    public void startActivityWithExtras(Bundle bundle, Class<?> cls) {
        startActivityWithExtras(bundle, cls, true);
    }

    public void startActivityWithoutAnim(Intent intent) {
        super.startActivityForResult(intent, -1);
    }

    public void startNightMode() {
        int i2;
        if (!isWindowNightMode()) {
            View findViewById = findViewById(ResUtils.id(DxmApplicationContextImpl.getApplicationContext(this), "night_mode_view"));
            if (findViewById != null) {
                findViewById.setBackgroundColor(ResUtils.getColor(this, "ebpay_black_transparent"));
            }
        } else if (this.mNightModeView == null) {
            if (getBottomBarType() == SDKBaseActivity.BottomBarType.NONE) {
                i2 = -1;
            } else {
                i2 = DisplayUtils.getDisplayHeight(this) - DisplayUtils.dip2px(DxmApplicationContextImpl.getApplicationContext(this), 42.0f);
            }
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-1, i2, 1002, 24, -2);
            LogUtil.d("baseActivity", "this.displayMetrics.density = " + getResources().getDisplayMetrics().density + " \n applicationCon.density = " + DxmApplicationContextImpl.getApplicationContext(this).getResources().getDisplayMetrics().density);
            LogUtil.d("baseActivity", "height = " + DisplayUtils.getDisplayHeight(this) + " \n bottomBarh = " + DisplayUtils.dip2px(this, 42.0f));
            layoutParams.gravity = 48;
            View view = new View(this);
            this.mNightModeView = view;
            view.setBackgroundColor(ResUtils.getColor(this, "ebpay_black_transparent"));
            getWindowManager().addView(this.mNightModeView, layoutParams);
        }
    }

    public ArrayList<String> statExtraDatasForPause() {
        return null;
    }

    public void startActivity(Class<?> cls) {
        startActivityForResult(new Intent(getActivity(), cls), -1);
    }

    public void startActivityWithExtras(Bundle bundle, Class<?> cls, boolean z) {
        if (bundle == null) {
            bundle = getIntent().getExtras();
        }
        Intent intent = new Intent(getActivity(), cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        if (z) {
            startActivity(intent);
        } else {
            startActivityWithoutAnim(intent);
        }
    }

    public void startActivityForResult(Intent intent, int i2) {
        super.startActivityForResult(intent, i2);
        BaiduWalletUtils.startActivityAnim(getActivity());
    }
}
