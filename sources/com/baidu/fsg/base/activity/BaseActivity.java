package com.baidu.fsg.base.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import com.baidu.fsg.base.NoProguard;
import com.baidu.fsg.base.activity.a.a;
import com.baidu.fsg.base.restnet.beans.business.BeanConstants;
import com.baidu.fsg.base.statistics.RimStatisticsUtil;
import com.baidu.fsg.base.utils.LogUtil;
import com.baidu.fsg.base.utils.ResUtils;
import com.baidu.fsg.base.utils.RimAnimUtils;
import com.baidu.fsg.base.utils.RimGlobalUtils;
import com.baidu.fsg.base.widget.SafeScrollView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class BaseActivity extends Activity implements NoProguard {
    public static final int DIALOG_LOADING = 242;
    public static final int DIALOG_PROMPT = 241;
    protected static final int FLAG_PAY_SKD = 1;
    public static final String MULTI_WINDOW_TIPS = ResUtils.string("multi_window_tips");
    public static final String MULTI_WINDOW_TIPS_CLOSE = ResUtils.string("multi_window_tips_close");
    public static final String WITH_ANIM = "with_anim";

    /* renamed from: a  reason: collision with root package name */
    private static final String f11569a = "BaseActivity";

    /* renamed from: b  reason: collision with root package name */
    private static final boolean f11570b = false;
    public static LinkedList<BaseActivity> mActivityStack = new LinkedList<>();
    public static int mLiveActivityNum = 0;

    /* renamed from: c  reason: collision with root package name */
    private boolean f11571c = false;

    /* renamed from: d  reason: collision with root package name */
    private boolean f11572d = true;

    /* renamed from: e  reason: collision with root package name */
    private String f11573e = MULTI_WINDOW_TIPS;

    /* renamed from: f  reason: collision with root package name */
    private SafeScrollView f11574f = null;

    /* renamed from: g  reason: collision with root package name */
    private boolean f11575g = false;

    /* renamed from: h  reason: collision with root package name */
    private long f11576h;
    public int mFlag = -1;
    protected RimStatisticsUtil mStatUtil;

    private void a() {
        if (Build.VERSION.SDK_INT >= 24 && isInMultiWindowMode()) {
            if (this.f11571c) {
                RimGlobalUtils.toastWithText(getActivity(), this.f11573e, 1);
            }
            if (!this.f11572d) {
                finish();
            }
        }
    }

    protected static void addLiveActivityNum() {
        mLiveActivityNum++;
    }

    protected static synchronized void addToTask(BaseActivity baseActivity) {
        synchronized (BaseActivity.class) {
            mActivityStack.remove(baseActivity);
            mActivityStack.add(baseActivity);
        }
    }

    protected static synchronized void clearTask() {
        synchronized (BaseActivity.class) {
            Iterator it = mActivityStack.iterator();
            while (it.hasNext()) {
                ((BaseActivity) it.next()).finish();
            }
        }
    }

    protected static synchronized void clearTaskExcept(BaseActivity baseActivity) {
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

    protected static synchronized void clearTasksTopOf(BaseActivity baseActivity) {
        synchronized (BaseActivity.class) {
            LogUtil.d(f11569a, "clearTasksTopOf. stack size = " + mActivityStack.size());
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

    protected static synchronized void clearTasksWithFlag(int i2) {
        synchronized (BaseActivity.class) {
            LogUtil.d(f11569a, "clearTasksWithFlag. stack size = " + mActivityStack.size());
            Iterator it = mActivityStack.iterator();
            while (it.hasNext()) {
                BaseActivity baseActivity = (BaseActivity) it.next();
                if (baseActivity.mFlag == i2) {
                    baseActivity.finish();
                    baseActivity.overridePendingTransition(0, 0);
                }
            }
        }
    }

    protected static void decLiveActivityNum() {
        mLiveActivityNum--;
    }

    protected static BaseActivity getTopActivity() throws Throwable {
        return mActivityStack.getLast();
    }

    public static boolean isAppInForeground() {
        return mLiveActivityNum > 0;
    }

    protected static synchronized void removeFromTask(BaseActivity baseActivity) {
        synchronized (BaseActivity.class) {
            mActivityStack.remove(baseActivity);
        }
    }

    public void finish() {
        super.finish();
        if ("1".equals(BeanConstants.ANIMSTYLE)) {
            RimAnimUtils.finishActivityAnim(getActivity());
        }
    }

    public void finishWithoutAnim() {
        super.finish();
    }

    public Activity getActivity() {
        return this;
    }

    /* access modifiers changed from: protected */
    public ArrayList<String> getHandlerFailureData(int i2, int i3, String str) {
        String str2;
        String str3 = "";
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            str2 = String.valueOf(i2);
            try {
                str3 = String.valueOf(i3);
            } catch (Exception e2) {
            }
        } catch (Exception e3) {
            str2 = str3;
        }
        arrayList.add(str2);
        arrayList.add(str3);
        arrayList.add(str);
        return arrayList;
    }

    public boolean isActivityInForeground() {
        return this.f11575g;
    }

    /* access modifiers changed from: protected */
    public boolean isRequestedOrientation() {
        return true;
    }

    public void onBackPressed() {
        super.onBackPressed();
        if ("1".equals(BeanConstants.ANIMSTYLE)) {
            RimAnimUtils.finishActivityAnim(getActivity());
        }
    }

    public void onBackPressedWithoutAnim() {
        super.onBackPressed();
        overridePendingTransition(0, 0);
    }

    public void onCreate(Bundle bundle) {
        this.f11576h = System.currentTimeMillis();
        this.mStatUtil = RimStatisticsUtil.getInstance();
        RimStatisticsUtil.onPush(getClass().getSimpleName());
        if (isRequestedOrientation()) {
            setRequestedOrientation(1);
        }
        super.onCreate(bundle);
        LogUtil.e("debug_msg", "onCreate-----" + getClass().getName(), (Throwable) null);
        addToTask(this);
    }

    /* access modifiers changed from: protected */
    public Dialog onCreateDialog(int i2) {
        switch (i2) {
            case 242:
                return new a(this);
            default:
                return super.onCreateDialog(i2);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        removeFromTask(this);
        RimStatisticsUtil.onBack(getClass().getSimpleName());
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 != 82 || !keyEvent.isLongPress()) {
            return super.onKeyDown(i2, keyEvent);
        }
        return true;
    }

    public void onMultiWindowModeChanged(boolean z) {
        if (Build.VERSION.SDK_INT >= 24) {
            super.onMultiWindowModeChanged(z);
            SafeScrollView safeScrollView = this.f11574f;
            if (safeScrollView != null) {
                safeScrollView.dismissKeyBoard();
            }
            if (z && isActivityInForeground()) {
                if (this.f11571c) {
                    RimGlobalUtils.toastWithText(getActivity(), this.f11573e, 1);
                }
                if (!this.f11572d) {
                    finish();
                }
            }
        }
    }

    public void onPause() {
        super.onPause();
        decLiveActivityNum();
        this.f11575g = false;
        RimStatisticsUtil.onOut(getClass().getSimpleName());
    }

    public void onResume() {
        super.onResume();
        addLiveActivityNum();
        this.f11575g = true;
        if (0 != this.f11576h) {
            RimStatisticsUtil.onIn(getClass().getSimpleName(), System.currentTimeMillis() - this.f11576h);
            this.f11576h = 0;
        } else {
            RimStatisticsUtil.onIn(getClass().getSimpleName(), 0);
        }
        a();
    }

    public void setFlagPaySdk() {
        this.mFlag = 1;
    }

    /* access modifiers changed from: protected */
    public void setIsMultiWindowAvailable(boolean z) {
        if (z != this.f11572d) {
            this.f11572d = z;
        }
    }

    /* access modifiers changed from: protected */
    public void setIsShowMultiWindowTips(boolean z) {
        if (z != this.f11571c) {
            this.f11571c = z;
        }
    }

    /* access modifiers changed from: protected */
    public void setMultiWindowTipsId(String str) {
        this.f11573e = str;
    }

    /* access modifiers changed from: protected */
    public void setSafeScrollView(SafeScrollView safeScrollView) {
        this.f11574f = safeScrollView;
    }

    public void startActivity(Intent intent) {
        startActivityForResult(intent, -1);
    }

    public void startActivity(Class<?> cls) {
        startActivityForResult(new Intent(getActivity(), cls), -1);
    }

    public void startActivityForResult(Intent intent, int i2) {
        super.startActivityForResult(intent, i2);
        if ("1".equals(BeanConstants.ANIMSTYLE)) {
            RimAnimUtils.startActivityAnim(getActivity());
        }
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

    public void startActivityWithExtras(Bundle bundle, Class<?> cls, boolean z) {
        if (bundle == null) {
            bundle = getIntent().getExtras();
        }
        Intent intent = new Intent(getActivity(), cls);
        intent.putExtras(bundle);
        if (z) {
            startActivity(intent);
        } else {
            startActivityWithoutAnim(intent);
        }
    }

    public void startActivityWithoutAnim(Intent intent) {
        super.startActivityForResult(intent, -1);
    }
}
