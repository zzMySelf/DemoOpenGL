package com.dxmpay.wallet.core;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityOptions;
import android.app.Application;
import android.app.Dialog;
import android.content.ComponentCallbacks;
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
import androidx.annotation.NonNull;
import com.dxmpay.apollon.statusbar.ImmersiveKeyboardAdjust;
import com.dxmpay.apollon.utils.DisplayUtils;
import com.dxmpay.apollon.utils.GlobalUtils;
import com.dxmpay.apollon.utils.PhoneUtils;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.base.widget.LoadingDialog;
import com.dxmpay.wallet.base.widget.SafeScrollView;
import com.dxmpay.wallet.base.widget.dialog.PromptDialog;
import com.dxmpay.wallet.base.widget.dialog.PromptImageDialog;
import com.dxmpay.wallet.base.widget.dialog.listener.DelegateOnCancleListener;
import com.dxmpay.wallet.core.SDKBaseActivity;
import com.dxmpay.wallet.core.beans.NetworkBean;
import com.dxmpay.wallet.core.utils.BaiduWalletUtils;
import com.dxmpay.wallet.core.utils.LogUtil;
import com.dxmpay.wallet.core.utils.WalletGlobalUtils;
import com.dxmpay.wallet.statistics.api.StatisticManager;
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
    public static final String TAG = "BaseActivity";
    public static final String TOA_BEGIN = "TOA_BeginToAdapt";
    public static final String TOA_EXCEPTION = "TOA_Exception";
    public static final String TOA_TARGET = "TOA_InTranslucentActivity";
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
    public String mMultiWindowTipsID = "dxm_wallet_base_multi_window_tips";
    public View mNightModeView = null;
    public SafeScrollView mSafeScrollView = null;
    public boolean mWindowNightMode = true;
    public a myOrientoinListener;

    public class ad implements DialogInterface.OnCancelListener {
        public ad() {
        }

        public void onCancel(DialogInterface dialogInterface) {
            BaseActivity.this.onBackPressed();
        }
    }

    public class de implements DialogInterface.OnCancelListener {
        public de() {
        }

        public void onCancel(DialogInterface dialogInterface) {
            BaseActivity.this.cancleRequest();
        }
    }

    public class fe implements View.OnClickListener {
        public fe() {
        }

        public void onClick(View view) {
            WalletGlobalUtils.safeDismissDialog(BaseActivity.this, 11);
        }
    }

    public class qw implements InvocationHandler {
        public qw() {
        }

        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            return null;
        }
    }

    public class rg implements View.OnClickListener {
        public rg() {
        }

        public void onClick(View view) {
            WalletGlobalUtils.safeDismissDialog(BaseActivity.this, 11);
            try {
                BaseActivity.this.startActivityForResult(new Intent("android.settings.SETTINGS"), 0);
            } catch (Exception e) {
                LogUtil.e("BaseActivity", "onPrepareDialog. DIALOG_NO_NETWORK. onClick", e);
            }
        }
    }

    public class th implements View.OnClickListener {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ PromptDialog f4237ad;

        public th(PromptDialog promptDialog) {
            this.f4237ad = promptDialog;
        }

        public void onClick(View view) {
            this.f4237ad.dismiss();
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
    }

    public static class uk implements ComponentCallbacks {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ Application f4239ad;

        public uk(Application application) {
            this.f4239ad = application;
        }

        public void onConfigurationChanged(Configuration configuration) {
            if (configuration != null && configuration.fontScale > 0.0f) {
                float unused = BaseActivity.sNocompatScaleDensity = this.f4239ad.getResources().getDisplayMetrics().scaledDensity;
            }
        }

        public void onLowMemory() {
        }
    }

    public class yj implements View.OnClickListener {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ PromptDialog f4240ad;

        public yj(PromptDialog promptDialog) {
            this.f4240ad = promptDialog;
        }

        public void onClick(View view) {
            this.f4240ad.dismiss();
        }
    }

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
            "clearTasksTopOf. stack size = " + mActivityStack.size();
            int size = mActivityStack.size() - 1;
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
                baseActivity.finishWithoutAnim();
                size--;
            }
        }
    }

    public static synchronized void clearTasksWithFlag(int i2) {
        synchronized (BaseActivity.class) {
            LogUtil.methodTrace("BaseActivity");
            "clearTasksWithFlag. stack size = " + mActivityStack.size();
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

    public static synchronized void clearTasksWithFlagWithoutAnim(int i2) {
        synchronized (BaseActivity.class) {
            LogUtil.methodTrace("BaseActivity");
            "clearTasksWithFlag. stack size = " + mActivityStack.size();
            Iterator it = mActivityStack.iterator();
            while (it.hasNext()) {
                BaseActivity baseActivity = (BaseActivity) it.next();
                if ((baseActivity.mFlag & i2) != 0) {
                    baseActivity.finishWithoutAnim();
                }
            }
        }
    }

    private void convertFromTranslucent() {
        try {
            Method declaredMethod = Activity.class.getDeclaredMethod("convertFromTranslucent", new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(getActivity(), new Object[0]);
        } catch (Throwable th2) {
            StatisticManager.onEventWithValues(TOA_EXCEPTION, Arrays.asList(new String[]{th2.toString()}));
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
                obj2 = Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new qw());
            } else {
                obj2 = null;
            }
            if (Build.VERSION.SDK_INT >= 21) {
                Method declaredMethod = Activity.class.getDeclaredMethod("getActivityOptions", new Class[0]);
                declaredMethod.setAccessible(true);
                obj = declaredMethod.invoke(this, new Object[0]);
                Method declaredMethod2 = Activity.class.getDeclaredMethod("convertToTranslucent", new Class[]{cls, ActivityOptions.class});
                declaredMethod2.setAccessible(true);
                declaredMethod2.invoke(getActivity(), new Object[]{obj2, obj});
                return;
            }
            Method declaredMethod3 = Activity.class.getDeclaredMethod("convertToTranslucent", new Class[]{cls});
            declaredMethod3.setAccessible(true);
            declaredMethod3.invoke(getActivity(), new Object[]{obj2});
        } catch (Exception e) {
            StatisticManager.onEventWithValues(TOA_EXCEPTION, Arrays.asList(new String[]{e.toString()}));
        } catch (Throwable th2) {
            StatisticManager.onEventWithValues(TOA_EXCEPTION, Arrays.asList(new String[]{th2.toString()}));
        }
    }

    public static void decLiveActivityNum() {
        mLiveActivityNum--;
    }

    public static synchronized void finishActivityWithActivityName(Class<?> cls) {
        synchronized (BaseActivity.class) {
            if (mActivityStack != null && mActivityStack.size() > 0) {
                int i2 = 0;
                while (true) {
                    if (i2 >= mActivityStack.size()) {
                        break;
                    }
                    BaseActivity baseActivity = mActivityStack.get(i2);
                    if (baseActivity.getClass().equals(cls)) {
                        baseActivity.finishWithoutAnim();
                        break;
                    }
                    i2++;
                }
            }
        }
    }

    public static BaseActivity getTopActivity() throws Throwable {
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
            LogUtil.e("BaseActivity", e.getMessage(), e);
            StatisticManager.onEventWithValues(TOA_EXCEPTION, Arrays.asList(new String[]{e.toString()}));
            return false;
        }
    }

    public static synchronized void removeFromTask(BaseActivity baseActivity) {
        synchronized (BaseActivity.class) {
            mActivityStack.remove(baseActivity);
        }
    }

    public static void setCustomDensity(@NonNull Application application, boolean z, int i2) {
        int i3;
        DisplayMetrics displayMetrics = application.getResources().getDisplayMetrics();
        if (sNocompatDensity == 0.0f) {
            sNocompatDensity = displayMetrics.density;
            sNocompatScaleDensity = displayMetrics.scaledDensity;
            application.registerComponentCallbacks(new uk(application));
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

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0032, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized boolean tasksIsExistActivityWithActivityName(java.lang.Class<?> r4) {
        /*
            java.lang.Class<com.dxmpay.wallet.core.BaseActivity> r0 = com.dxmpay.wallet.core.BaseActivity.class
            monitor-enter(r0)
            java.util.LinkedList<com.dxmpay.wallet.core.BaseActivity> r1 = mActivityStack     // Catch:{ all -> 0x0033 }
            r2 = 0
            if (r1 == 0) goto L_0x0031
            java.util.LinkedList<com.dxmpay.wallet.core.BaseActivity> r1 = mActivityStack     // Catch:{ all -> 0x0033 }
            int r1 = r1.size()     // Catch:{ all -> 0x0033 }
            if (r1 <= 0) goto L_0x0031
            r1 = 0
        L_0x0011:
            java.util.LinkedList<com.dxmpay.wallet.core.BaseActivity> r3 = mActivityStack     // Catch:{ all -> 0x0033 }
            int r3 = r3.size()     // Catch:{ all -> 0x0033 }
            if (r1 >= r3) goto L_0x0031
            java.util.LinkedList<com.dxmpay.wallet.core.BaseActivity> r3 = mActivityStack     // Catch:{ all -> 0x0033 }
            java.lang.Object r3 = r3.get(r1)     // Catch:{ all -> 0x0033 }
            com.dxmpay.wallet.core.BaseActivity r3 = (com.dxmpay.wallet.core.BaseActivity) r3     // Catch:{ all -> 0x0033 }
            java.lang.Class r3 = r3.getClass()     // Catch:{ all -> 0x0033 }
            boolean r3 = r3.equals(r4)     // Catch:{ all -> 0x0033 }
            if (r3 == 0) goto L_0x002e
            monitor-exit(r0)
            r4 = 1
            return r4
        L_0x002e:
            int r1 = r1 + 1
            goto L_0x0011
        L_0x0031:
            monitor-exit(r0)
            return r2
        L_0x0033:
            r4 = move-exception
            monitor-exit(r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dxmpay.wallet.core.BaseActivity.tasksIsExistActivityWithActivityName(java.lang.Class):boolean");
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
        if (z) {
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

    public boolean isActivityInForeground() {
        return this.mIsActivityInForeground;
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
        } catch (IllegalStateException unused) {
            if (Build.VERSION.SDK_INT >= 21) {
                finishAfterTransition();
            } else {
                finish();
            }
        }
        if (getIntent().getBooleanExtra("with_anim", true)) {
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

    /* JADX WARNING: Removed duplicated region for block: B:40:0x00ec  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r9) {
        /*
            r8 = this;
            java.lang.String r0 = "TOA_Exception"
            android.content.Context r1 = r8.getApplicationContext()
            android.content.Context r2 = r8.getApplicationContext()
            com.dxmpay.wallet.statistics.impl.StatConfig r2 = com.dxmpay.wallet.statistics.impl.StatConfig.getInstance(r2)
            com.duxiaoman.dxmpay.statistics.StatApi.init(r1, r2)
            com.dxmpay.wallet.statistics.impl.SensorsSyncHttpImpl r1 = new com.dxmpay.wallet.statistics.impl.SensorsSyncHttpImpl
            r1.<init>()
            com.duxiaoman.dxmpay.statistics.StatApi.setSyncHttpImpl(r1)
            android.content.pm.ApplicationInfo r1 = r8.getApplicationInfo()
            int r1 = r1.targetSdkVersion
            r2 = 26
            if (r1 <= r2) goto L_0x003c
            int r1 = android.os.Build.VERSION.SDK_INT
            if (r1 != r2) goto L_0x003c
            java.lang.String r1 = "TOA_BeginToAdapt"
            com.dxmpay.wallet.statistics.api.StatisticManager.onEvent(r1)
            boolean r1 = r8.isTranslucentOrFloating()
            r8.isTranslucentOrFloating = r1
            if (r1 == 0) goto L_0x003c
            java.lang.String r1 = "TOA_InTranslucentActivity"
            com.dxmpay.wallet.statistics.api.StatisticManager.onEvent(r1)
            r8.convertFromTranslucent()
        L_0x003c:
            r1 = 1
            boolean r3 = r8.isBaiduappPlugin()     // Catch:{ Exception -> 0x0056 }
            if (r3 != 0) goto L_0x0063
            boolean r3 = com.dxmpay.wallet.core.utils.BaiduWalletFixOUtils.gIsSpecialPlugin     // Catch:{ Exception -> 0x0056 }
            if (r3 == 0) goto L_0x0052
            boolean r3 = r8.isTranslucentOrFloating     // Catch:{ Exception -> 0x0056 }
            if (r3 == 0) goto L_0x0052
            com.dxmpay.wallet.core.utils.BaiduWalletFixOUtils.fixOrientation(r8)     // Catch:{ Exception -> 0x0056 }
            r8.convertToTranslucent()     // Catch:{ Exception -> 0x0056 }
            goto L_0x0063
        L_0x0052:
            r8.setRequestedOrientation(r1)     // Catch:{ Exception -> 0x0056 }
            goto L_0x0063
        L_0x0056:
            java.lang.String r3 = "setRequestedOrientation throw exception"
            java.lang.String[] r3 = new java.lang.String[]{r3}
            java.util.List r3 = java.util.Arrays.asList(r3)
            com.dxmpay.wallet.statistics.api.StatisticManager.onEventWithValues(r0, r3)
        L_0x0063:
            android.content.pm.ApplicationInfo r3 = r8.getApplicationInfo()
            int r3 = r3.targetSdkVersion
            r4 = 0
            r5 = 0
            if (r3 <= r2) goto L_0x01c3
            int r3 = android.os.Build.VERSION.SDK_INT
            if (r3 != r2) goto L_0x01c3
            java.lang.String r2 = com.dxmpay.wallet.core.beans.BeanConstants.CHANNEL_ID
            java.lang.String r3 = "iqiyi"
            boolean r2 = r3.equals(r2)
            java.lang.String r3 = "BaseActivity"
            if (r2 == 0) goto L_0x00c5
            java.lang.Class<android.app.Activity> r2 = android.app.Activity.class
            java.lang.String r6 = "mActivityInfo"
            java.lang.reflect.Field r2 = r2.getDeclaredField(r6)     // Catch:{ NoSuchFieldException -> 0x00ad, IllegalAccessException -> 0x0095 }
            r2.setAccessible(r1)     // Catch:{ NoSuchFieldException -> 0x00ad, IllegalAccessException -> 0x0095 }
            if (r2 == 0) goto L_0x00e9
            android.app.Activity r6 = r8.getActivity()     // Catch:{ NoSuchFieldException -> 0x00ad, IllegalAccessException -> 0x0095 }
            java.lang.Object r2 = r2.get(r6)     // Catch:{ NoSuchFieldException -> 0x00ad, IllegalAccessException -> 0x0095 }
            android.content.pm.ActivityInfo r2 = (android.content.pm.ActivityInfo) r2     // Catch:{ NoSuchFieldException -> 0x00ad, IllegalAccessException -> 0x0095 }
            goto L_0x00ea
        L_0x0095:
            r2 = move-exception
            java.lang.String[] r6 = new java.lang.String[r1]
            java.lang.String r7 = r2.toString()
            r6[r5] = r7
            java.util.List r6 = java.util.Arrays.asList(r6)
            com.dxmpay.wallet.statistics.api.StatisticManager.onEventWithValues(r0, r6)
            java.lang.String r0 = r2.getMessage()
            com.dxmpay.wallet.core.utils.LogUtil.e(r3, r0, r2)
            goto L_0x00e9
        L_0x00ad:
            r2 = move-exception
            java.lang.String[] r6 = new java.lang.String[r1]
            java.lang.String r7 = r2.toString()
            r6[r5] = r7
            java.util.List r6 = java.util.Arrays.asList(r6)
            com.dxmpay.wallet.statistics.api.StatisticManager.onEventWithValues(r0, r6)
            java.lang.String r0 = r2.getMessage()
            com.dxmpay.wallet.core.utils.LogUtil.e(r3, r0, r2)
            goto L_0x00e9
        L_0x00c5:
            android.content.pm.PackageManager r2 = r8.getPackageManager()     // Catch:{ NameNotFoundException -> 0x00d2 }
            android.content.ComponentName r6 = r8.getComponentName()     // Catch:{ NameNotFoundException -> 0x00d2 }
            android.content.pm.ActivityInfo r2 = r2.getActivityInfo(r6, r5)     // Catch:{ NameNotFoundException -> 0x00d2 }
            goto L_0x00ea
        L_0x00d2:
            r2 = move-exception
            java.lang.String[] r6 = new java.lang.String[r1]
            java.lang.String r7 = r2.toString()
            r6[r5] = r7
            java.util.List r6 = java.util.Arrays.asList(r6)
            com.dxmpay.wallet.statistics.api.StatisticManager.onEventWithValues(r0, r6)
            java.lang.String r0 = r2.getMessage()
            com.dxmpay.wallet.core.utils.LogUtil.e(r3, r0, r2)
        L_0x00e9:
            r2 = r4
        L_0x00ea:
            if (r2 == 0) goto L_0x01c3
            int r0 = r2.getThemeResource()
            android.app.Activity r2 = r8.getActivity()
            java.lang.String r3 = "DxmEbpayThemeActivitTranslucent"
            int r2 = com.dxmpay.apollon.utils.ResUtils.style(r2, r3)
            if (r0 != r2) goto L_0x010e
            android.app.Activity r0 = r8.getActivity()
            java.lang.String r2 = "DxmEbpayThemeActivitTranslucentForSystem26"
            int r0 = com.dxmpay.apollon.utils.ResUtils.style(r0, r2)
            r8.setTheme(r0)
            r8.convertToTranslucent()
            goto L_0x01c3
        L_0x010e:
            android.app.Activity r2 = r8.getActivity()
            java.lang.String r3 = "DxmEbpayThemeActivityWelcome.Dialog"
            int r2 = com.dxmpay.apollon.utils.ResUtils.style(r2, r3)
            if (r0 != r2) goto L_0x012c
            android.app.Activity r0 = r8.getActivity()
            java.lang.String r2 = "DxmEbpayThemeActivityWelcomeDialogForSystem26"
            int r0 = com.dxmpay.apollon.utils.ResUtils.style(r0, r2)
            r8.setTheme(r0)
            r8.convertToTranslucent()
            goto L_0x01c3
        L_0x012c:
            android.app.Activity r2 = r8.getActivity()
            java.lang.String r3 = "DxmEbpayThemeActivityWelcome"
            int r2 = com.dxmpay.apollon.utils.ResUtils.style(r2, r3)
            java.lang.String r3 = "DxmEbpayThemeActivityWelcomeForSystem26"
            if (r0 != r2) goto L_0x014a
            android.app.Activity r0 = r8.getActivity()
            int r0 = com.dxmpay.apollon.utils.ResUtils.style(r0, r3)
            r8.setTheme(r0)
            r8.convertToTranslucent()
            goto L_0x01c3
        L_0x014a:
            android.app.Activity r2 = r8.getActivity()
            java.lang.String r6 = "DxmCameraMist"
            int r2 = com.dxmpay.apollon.utils.ResUtils.style(r2, r6)
            if (r0 != r2) goto L_0x0167
            android.app.Activity r0 = r8.getActivity()
            java.lang.String r2 = "DxmCameraMistForSystem26"
            int r0 = com.dxmpay.apollon.utils.ResUtils.style(r0, r2)
            r8.setTheme(r0)
            r8.convertToTranslucent()
            goto L_0x01c3
        L_0x0167:
            android.app.Activity r2 = r8.getActivity()
            java.lang.String r6 = "Theme.LBSPaySDK_Transparent"
            int r2 = com.dxmpay.apollon.utils.ResUtils.style(r2, r6)
            if (r0 != r2) goto L_0x0184
            android.app.Activity r0 = r8.getActivity()
            java.lang.String r2 = "Theme.LBSPaySDK_Transparent_For_System_26"
            int r0 = com.dxmpay.apollon.utils.ResUtils.style(r0, r2)
            r8.setTheme(r0)
            r8.convertToTranslucent()
            goto L_0x01c3
        L_0x0184:
            android.app.Activity r2 = r8.getActivity()
            java.lang.String r6 = "dxmTranslucentTheme"
            int r2 = com.dxmpay.apollon.utils.ResUtils.style(r2, r6)
            if (r0 != r2) goto L_0x01a1
            android.app.Activity r0 = r8.getActivity()
            java.lang.String r2 = "translucentSDK_Transparent_For_System_26"
            int r0 = com.dxmpay.apollon.utils.ResUtils.style(r0, r2)
            r8.setTheme(r0)
            r8.convertToTranslucent()
            goto L_0x01c3
        L_0x01a1:
            android.app.Activity r2 = r8.getActivity()
            java.lang.String r6 = "merTranslucentTheme"
            int r2 = com.dxmpay.apollon.utils.ResUtils.style(r2, r6)
            if (r0 != r2) goto L_0x01bc
            android.app.Activity r0 = r8.getActivity()
            int r0 = com.dxmpay.apollon.utils.ResUtils.style(r0, r3)
            r8.setTheme(r0)
            r8.convertToTranslucent()
            goto L_0x01c3
        L_0x01bc:
            boolean r0 = r8.isTranslucentOrFloating
            if (r0 == 0) goto L_0x01c3
            r8.convertToTranslucent()
        L_0x01c3:
            super.onCreate(r9)
            java.lang.Class r0 = r8.getClass()
            r0.getName()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "onCreate-----"
            r0.append(r2)
            java.lang.Class r2 = r8.getClass()
            java.lang.String r2 = r2.getName()
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            java.lang.String r2 = "debug_msg"
            com.dxmpay.wallet.core.utils.LogUtil.e(r2, r0, r4)
            addToTask(r8)
            int r0 = android.os.Build.VERSION.SDK_INT
            r2 = 27
            if (r0 < r2) goto L_0x0212
            android.content.ContentResolver r0 = r8.getContentResolver()
            java.lang.String r2 = "accelerometer_rotation"
            int r0 = android.provider.Settings.System.getInt(r0, r2, r5)
            if (r0 != r1) goto L_0x0201
            goto L_0x0202
        L_0x0201:
            r1 = 0
        L_0x0202:
            if (r1 == 0) goto L_0x0212
            com.dxmpay.wallet.core.a r0 = new com.dxmpay.wallet.core.a
            android.app.Activity r1 = r8.getActivity()
            r0.<init>(r1)
            r8.myOrientoinListener = r0
            r0.enable()
        L_0x0212:
            if (r9 == 0) goto L_0x0225
            java.lang.String r0 = "cashdeskcommondata"
            java.io.Serializable r9 = r9.getSerializable(r0)
            if (r9 == 0) goto L_0x0225
            boolean r0 = r9 instanceof com.dxmpay.wallet.core.beans.NetworkBean.SessionCache
            if (r0 == 0) goto L_0x0225
            com.dxmpay.wallet.core.beans.NetworkBean$SessionCache r9 = (com.dxmpay.wallet.core.beans.NetworkBean.SessionCache) r9
            com.dxmpay.wallet.core.beans.NetworkBean.SessionCache.sync(r9)
        L_0x0225:
            android.app.Activity r9 = r8.getActivity()
            r8.setImmersiveStatusBar(r9)
            boolean r9 = r8.isSupportUIAdapatation
            if (r9 == 0) goto L_0x023b
            android.app.Application r9 = r8.getApplication()
            boolean r0 = r8.isWidthLimitedMode
            int r1 = r8.defaultLenth
            setCustomDensity(r9, r0, r1)
        L_0x023b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dxmpay.wallet.core.BaseActivity.onCreate(android.os.Bundle):void");
    }

    public Dialog onCreateDialog(int i2) {
        "onCreateDialog. id = " + i2;
        if (i2 == -2 || i2 == -1 || i2 == 0) {
            return new LoadingDialog(this);
        }
        if (i2 != 2) {
            return new PromptDialog(getActivity());
        }
        return new PromptImageDialog(getActivity());
    }

    public void onDestroy() {
        a aVar;
        keyBoardAdjustDetach();
        closeNightMode();
        super.onDestroy();
        removeFromTask(this);
        if (Build.VERSION.SDK_INT >= 27 && (aVar = this.myOrientoinListener) != null) {
            aVar.a();
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
    }

    public void onPrepareDialog(int i2, Dialog dialog) {
        "onPrepareDialog. id = " + i2;
        if (i2 == -2) {
            LoadingDialog loadingDialog = (LoadingDialog) dialog;
            loadingDialog.setCancelable(true);
            loadingDialog.setOnCancelListener(new DelegateOnCancleListener(new de(), loadingDialog));
        } else if (i2 == -1) {
            LoadingDialog loadingDialog2 = (LoadingDialog) dialog;
            loadingDialog2.setCancelable(true);
            loadingDialog2.setOnCancelListener(new DelegateOnCancleListener(new ad(), loadingDialog2));
        } else if (i2 == 0) {
            ((LoadingDialog) dialog).setCancelable(false);
        } else if (i2 == 3) {
            PromptDialog promptDialog = (PromptDialog) dialog;
            promptDialog.setMessage((CharSequence) this.mDialogMsg);
            promptDialog.setCanceledOnTouchOutside(false);
            promptDialog.hideNegativeButton();
        } else if (i2 == 11) {
            PromptDialog promptDialog2 = (PromptDialog) dialog;
            promptDialog2.setMessage((CharSequence) getString(ResUtils.string(getActivity(), "dxm_ebpay_no_network")));
            promptDialog2.setCanceledOnTouchOutside(false);
            promptDialog2.setNegativeBtn(ResUtils.string(getActivity(), "dxm_ebpay_cancel"), (View.OnClickListener) new fe());
            promptDialog2.setPositiveBtn(ResUtils.string(getActivity(), "dxm_ebpay_setting"), (View.OnClickListener) new rg());
        } else if (i2 != 52) {
            super.onPrepareDialog(i2, dialog);
        } else {
            PromptDialog promptDialog3 = (PromptDialog) dialog;
            promptDialog3.setMessage((CharSequence) this.mDialogMsg);
            promptDialog3.setCanceledOnTouchOutside(false);
            promptDialog3.setPositiveBtn(ResUtils.getString(getActivity(), "dxm_ebpay_confirm"), (View.OnClickListener) new th(promptDialog3));
            promptDialog3.setNegativeBtn(ResUtils.getString(getActivity(), "dxm_ebpay_cancel"), (View.OnClickListener) new yj(promptDialog3));
        }
    }

    public void onResume() {
        super.onResume();
        addLiveActivityNum();
        this.mIsActivityInForeground = true;
        showMultiWindowTips();
    }

    public void onSaveInstanceState(Bundle bundle) {
        NetworkBean.SessionCache instance = NetworkBean.SessionCache.getInstance();
        if (instance != null) {
            bundle.putSerializable("cashdeskcommondata", instance);
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
                window.setStatusBarColor(ResUtils.getColor(getActivity(), "dxm_ebpay_transparent"));
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
            View findViewById = findViewById(ResUtils.id(getApplicationContext(), "night_mode_view"));
            if (findViewById != null) {
                findViewById.setBackgroundColor(ResUtils.getColor(this, "dxm_ebpay_black_transparent"));
            }
        } else if (this.mNightModeView == null) {
            if (getBottomBarType() == SDKBaseActivity.BottomBarType.NONE) {
                i2 = -1;
            } else {
                i2 = DisplayUtils.getDisplayHeight(this) - DisplayUtils.dip2px(this, 42.0f);
            }
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-1, i2, 1002, 24, -2);
            layoutParams.gravity = 48;
            View view = new View(this);
            this.mNightModeView = view;
            view.setBackgroundColor(ResUtils.getColor(this, "dxm_ebpay_black_transparent"));
            getWindowManager().addView(this.mNightModeView, layoutParams);
        }
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
