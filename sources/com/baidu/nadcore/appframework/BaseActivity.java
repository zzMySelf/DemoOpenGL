package com.baidu.nadcore.appframework;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewParent;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.baidu.nadcore.HostConfig;
import com.baidu.nadcore.appframework.ext.IActionBarExtObject;
import com.baidu.nadcore.appframework.ext.ICommonMenuExtObject;
import com.baidu.nadcore.appframework.ext.IToolBarExtObject;
import com.baidu.nadcore.appframework.util.SecurityUtils;
import com.baidu.nadcore.core.MainThreadHelper;
import com.baidu.nadcore.lifecycle.AdActivityManager;
import com.baidu.nadcore.safe.CollectionUtils;
import com.baidu.nadcore.toast.ToastRuntime;
import com.baidu.nadcore.utils.DeviceUtils;
import com.baidu.nadcore.utils.ScreenOrientationCompat;
import com.baidu.nadcore.widget.OnTranslucentListener;
import com.baidu.nadcore.widget.SlideHelper;
import com.baidu.nadcore.widget.SlideInterceptor;
import com.baidu.nadcore.widget.SlideUtil;
import com.baidu.nadcore.widget.SlidingPaneLayout;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;

public class BaseActivity extends FragmentActivity implements IActionBarExtObject, IToolBarExtObject, ICommonMenuExtObject {
    private static final boolean DEBUG = false;
    protected static final int INVALID_ANIM = 0;
    public static final String KEY_WINDOWS_ANIMATING_NEED_DRAW = "winAccelerate";
    private static final String TAG = "BaseActivity";
    private static final String WINDOWS_ANIMATING_NEED_DRAW = "1";
    private static final String WINDOWS_ANIMATING_NEED_NOT_DRAW = "0";
    private static ArrayList<OnNewIntentCallback> onNewIntentCallbacks = new ArrayList<>();
    private static boolean sHasMultiWindowShow = false;
    private static int sNextEnterAnimWhenFinishing;
    private static int sNextEnterAnimWhenStarting;
    private static int sNextExitAnimWhenFinishing;
    private static int sNextExitAnimWhenStarting;
    private Object mActionBarExtObject;
    private Object mCommonMenuExtObject;
    private boolean mEnableDrawDuringWindowsAnimating = true;
    private boolean mEnableSliding = false;
    private boolean mEnableTaskRootSlide = false;
    private int mEnterAnimWhenFinishing = 0;
    private int mEnterAnimWhenStarting = 0;
    private int mExitAnimWhenFinishing = 0;
    private int mExitAnimWhenStarting = 0;
    /* access modifiers changed from: private */
    public boolean mForceActivityTransparent = false;
    /* access modifiers changed from: private */
    public boolean mSlideCancelActivityTransparent = true;
    /* access modifiers changed from: private */
    public SlideHelper mSlideHelper;
    private SlideInterceptor mSlideInterceptor;
    /* access modifiers changed from: private */
    public SlidingPaneLayout.PanelSlideListener mSlideListener;
    private Object mSuspensionBallExtObject;
    /* access modifiers changed from: private */
    public SlidingPaneLayout.PanelSlideListener mSuspensionBallSlideListener;
    private Object mToolBarExtObject;
    private WeakReference<Activity> preActivity;
    private final Object tagObject = new Object();

    public interface OnNewIntentCallback {
        void execute(Object obj);
    }

    /* Debug info: failed to restart local var, previous not found, register: 5 */
    /* access modifiers changed from: protected */
    public final void onCreate(Bundle savedInstanceState) {
        boolean z;
        String sb;
        if (!SecurityUtils.checkActivityRefuseServiceAndFinish(this)) {
            try {
                if (preCreate(savedInstanceState)) {
                    int orientation = ScreenOrientationCompat.releaseFixedOrientation(this);
                    super.onCreate(savedInstanceState);
                    ScreenOrientationCompat.fixedOrientation(this, orientation);
                    resetActivityAnim();
                    try {
                        onCreateEx(savedInstanceState);
                    } catch (Throwable ex) {
                        if (!HostConfig.GLOBAL_DEBUG) {
                            finish();
                            return;
                        }
                        throw new RuntimeException(ex);
                    }
                } else if (z) {
                    throw new RuntimeException(sb);
                }
            } finally {
                if (!HostConfig.GLOBAL_DEBUG) {
                    finish();
                } else {
                    RuntimeException runtimeException = new RuntimeException("Class " + getClass() + " failed at preCreate");
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean preCreate(Bundle savedInstanceState) {
        return true;
    }

    /* access modifiers changed from: protected */
    public void onCreateEx(Bundle savedInstanceState) {
    }

    /* access modifiers changed from: protected */
    public final void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        applySliding();
        onPostCreateEx(savedInstanceState);
    }

    /* access modifiers changed from: protected */
    public void onPostCreateEx(Bundle savedInstanceState) {
    }

    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
    }

    /* access modifiers changed from: protected */
    public final void onStart() {
        super.onStart();
        onStartEx();
    }

    /* access modifiers changed from: protected */
    public void onStartEx() {
    }

    /* access modifiers changed from: protected */
    public final void onResume() {
        super.onResume();
        onResumeEx();
    }

    /* access modifiers changed from: protected */
    public void onResumeEx() {
    }

    /* access modifiers changed from: protected */
    public final void onNewIntent(Intent intent) {
        ArrayList<OnNewIntentCallback> localCallbacks;
        super.onNewIntent(intent);
        resetActivityAnim();
        startEnterActivityAnim();
        ArrayList<OnNewIntentCallback> arrayList = onNewIntentCallbacks;
        if (arrayList != null) {
            synchronized (arrayList) {
                localCallbacks = new ArrayList<>(onNewIntentCallbacks);
            }
            Iterator<OnNewIntentCallback> it = localCallbacks.iterator();
            while (it.hasNext()) {
                it.next().execute(intent);
            }
        }
        try {
            onNewIntentEx(intent);
        } catch (Throwable ex) {
            if (!HostConfig.GLOBAL_DEBUG) {
                finish();
                return;
            }
            throw new RuntimeException(ex);
        }
    }

    /* access modifiers changed from: protected */
    public void onNewIntentEx(Intent intent) {
    }

    /* access modifiers changed from: protected */
    public final void onPostResume() {
        super.onPostResume();
        onPostResumeEx();
    }

    /* access modifiers changed from: protected */
    public void onPostResumeEx() {
    }

    public void onAttachFragment(Fragment fragment) {
        super.onAttachFragment(fragment);
    }

    public void onBackPressed() {
        super.onBackPressed();
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        startEnterActivityAnim();
        handleDrawDuringWindowsAnimating();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        SlideHelper slideHelper = this.mSlideHelper;
        if (slideHelper != null) {
            slideHelper.setCanSlide(newConfig.orientation != 2);
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    /* access modifiers changed from: protected */
    public final void onPause() {
        super.onPause();
        onPauseEx();
    }

    /* access modifiers changed from: protected */
    public void onPauseEx() {
    }

    /* access modifiers changed from: protected */
    public final void onStop() {
        super.onStop();
        onStopEx();
    }

    /* access modifiers changed from: protected */
    public void onStopEx() {
    }

    /* access modifiers changed from: protected */
    public final void onDestroy() {
        super.onDestroy();
        onDestroyEx();
    }

    /* access modifiers changed from: protected */
    public void onDestroyEx() {
    }

    public void finish() {
        super.finish();
        startExitActivityAnim();
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode != 82 || !event.isLongPress()) {
            return super.onKeyDown(keyCode, event);
        }
        return true;
    }

    public Resources getResources() {
        return super.getResources();
    }

    public void setEnableTaskRootSlide(boolean enableTaskRootSlide) {
        this.mEnableTaskRootSlide = enableTaskRootSlide;
    }

    public void setEnableSliding(boolean enableSliding) {
        this.mEnableSliding = enableSliding;
    }

    public void setEnableSliding(boolean enableSliding, SlideInterceptor interceptor) {
        this.mEnableSliding = enableSliding;
        this.mSlideInterceptor = interceptor;
    }

    public void setSlideCancelActivityTransparent(boolean transparent) {
        this.mSlideCancelActivityTransparent = transparent;
    }

    public void forceActivityTransparent(boolean transparent) {
        this.mForceActivityTransparent = transparent;
    }

    public void setSlideExtraListener(SlidingPaneLayout.PanelSlideListener listener) {
        this.mSlideListener = listener;
    }

    public void setCurrentActivityNoTransparent() {
        SlideUtil.convertFromTranslucent(this, new OnTranslucentListener() {
            public void onTranslucent(boolean translucent) {
            }
        });
    }

    private void applySliding() {
        if (this.mEnableSliding) {
            boolean flag = true;
            if (getResources().getConfiguration().orientation == 2) {
                flag = false;
            }
            if (!this.mEnableTaskRootSlide && isTaskRoot()) {
                flag = false;
            }
            final int screenWidth = DeviceUtils.ScreenInfo.getDisplayWidth(this);
            SlideHelper slideHelper = new SlideHelper();
            this.mSlideHelper = slideHelper;
            slideHelper.attachSlideView(this, findViewById(16908290));
            this.mSlideHelper.setCanSlide(flag);
            this.mSlideHelper.forceActivityTransparent(this.mForceActivityTransparent);
            this.mSlideHelper.attachActivity(this);
            this.mSlideHelper.setSlideInterceptor(this.mSlideInterceptor);
            this.mSlideHelper.setSlideListener(new SlidingPaneLayout.PanelSlideListener() {
                private boolean translucent = true;

                public void onPanelSlide(View panel, float slideOffset) {
                    View maskView = BaseActivity.this.mSlideHelper.getMaskView();
                    if (maskView != null) {
                        float f2 = 0.0f;
                        if (1.0f - slideOffset >= 0.0f) {
                            f2 = 1.0f - slideOffset;
                        }
                        maskView.setAlpha(f2);
                    }
                    if (BaseActivity.this.mSuspensionBallSlideListener != null) {
                        BaseActivity.this.mSuspensionBallSlideListener.onPanelSlide(panel, slideOffset);
                    }
                    if (BaseActivity.this.mSlideListener != null) {
                        BaseActivity.this.mSlideListener.onPanelSlide(panel, slideOffset);
                    }
                    if (!BaseActivity.this.mSlideCancelActivityTransparent && !BaseActivity.this.mForceActivityTransparent && !this.translucent) {
                        this.translucent = true;
                        SlideUtil.convertToTranslucent(BaseActivity.this, (OnTranslucentListener) null);
                    }
                    float width = (float) (screenWidth >> 2);
                    BaseActivity.this.setPreDecorPosition((slideOffset * width) - width);
                }

                public void onPanelOpened(View panel) {
                    if (BaseActivity.this.mSuspensionBallSlideListener != null) {
                        BaseActivity.this.mSuspensionBallSlideListener.onPanelOpened(panel);
                    }
                    if (BaseActivity.this.mSlideListener != null) {
                        BaseActivity.this.mSlideListener.onPanelOpened(panel);
                    }
                    BaseActivity.this.setPreDecorPosition(0.0f);
                    BaseActivity.this.mSlideHelper.setShadowDrawable((Drawable) null);
                    BaseActivity.this.finish();
                    BaseActivity.this.overridePendingTransition(0, 0);
                }

                public void onPanelClosed(View panel) {
                    if (BaseActivity.this.mSuspensionBallSlideListener != null) {
                        BaseActivity.this.mSuspensionBallSlideListener.onPanelClosed(panel);
                    }
                    if (BaseActivity.this.mSlideListener != null) {
                        BaseActivity.this.mSlideListener.onPanelClosed(panel);
                    }
                    if (!BaseActivity.this.mSlideCancelActivityTransparent && !BaseActivity.this.mForceActivityTransparent && this.translucent) {
                        this.translucent = false;
                        SlideUtil.convertFromTranslucent(BaseActivity.this, (OnTranslucentListener) null);
                    }
                    BaseActivity.this.setPreDecorPosition(0.0f);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void setPreDecorPosition(float position) {
        try {
            WeakReference<Activity> weakReference = this.preActivity;
            if (weakReference == null || weakReference.get() == null) {
                this.preActivity = new WeakReference<>(AdActivityManager.getPenultimateActivity());
            }
            if (this.preActivity.get() != null) {
                Activity realTopActivity = AdActivityManager.getRealTopActivity();
                Activity realPreActivity = (Activity) this.preActivity.get();
                if (realTopActivity == null || realPreActivity == null || !realTopActivity.getLocalClassName().equals(realPreActivity.getLocalClassName())) {
                    setPreActivityPosition(realPreActivity, position);
                } else {
                    setPreActivityPosition(realPreActivity, 0.0f);
                }
            }
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    private void setPreActivityPosition(Activity realPreActivity, float position) {
        View preContentView;
        if (realPreActivity != null && realPreActivity.getWindow() != null && (preContentView = realPreActivity.getWindow().getDecorView()) != null) {
            preContentView.setX(position);
        }
    }

    public static void setNextPendingTransition(int enterAnimWhenStarting, int exitAnimWhenStarting, int enterAnimWhenFinishing, int exitAnimWhenFinishing) {
        sNextEnterAnimWhenStarting = enterAnimWhenStarting;
        sNextExitAnimWhenStarting = exitAnimWhenStarting;
        sNextEnterAnimWhenFinishing = enterAnimWhenFinishing;
        sNextExitAnimWhenFinishing = exitAnimWhenFinishing;
    }

    public void setPendingTransition(int enterAnimWhenStarting, int exitAnimWhenStarting, int enterAnimWhenFinishing, int exitAnimWhenFinishing) {
        this.mEnterAnimWhenStarting = enterAnimWhenStarting;
        this.mExitAnimWhenStarting = exitAnimWhenStarting;
        this.mEnterAnimWhenFinishing = enterAnimWhenFinishing;
        this.mExitAnimWhenFinishing = exitAnimWhenFinishing;
    }

    public int checkSelfPermission(String permission) {
        if (DeviceUtils.OSInfo.hasMarshMallow()) {
            return super.checkSelfPermission(permission);
        }
        return 0;
    }

    public void requestPermission(String[] permissions, int requestCode) {
        if (DeviceUtils.OSInfo.hasMarshMallow()) {
            super.requestPermissions(permissions, requestCode);
        }
    }

    public boolean shouldShowRequestPermissionRationale(String permission) {
        return DeviceUtils.OSInfo.hasMarshMallow() && super.shouldShowRequestPermissionRationale(permission);
    }

    public static void setHasMultiWindowShow(boolean hasMultiWindowShow) {
        sHasMultiWindowShow = hasMultiWindowShow;
    }

    public void onMultiWindowModeChanged(boolean isInMultiWindowMode) {
        super.onMultiWindowModeChanged(isInMultiWindowMode);
        if (isInMultiWindowMode && !sHasMultiWindowShow) {
            ToastRuntime.impl().showToast(getApplicationContext(), R.string.nad_androidn_multiwindow_user_toast, 1);
            setHasMultiWindowShow(true);
        } else if (!isInMultiWindowMode && !DeviceUtils.isMateX()) {
            setHasMultiWindowShow(false);
        }
    }

    public void enableDrawDuringWindowsAnimating(boolean enableDrawDuringWindowsAnimating) {
        this.mEnableDrawDuringWindowsAnimating = enableDrawDuringWindowsAnimating;
    }

    public SlideHelper getSlideHelper() {
        return this.mSlideHelper;
    }

    private void handleDrawDuringWindowsAnimating() {
        String windowsAnimatingDrawFromIntent = "0";
        if (getIntent() != null && getIntent().hasExtra("winAccelerate")) {
            windowsAnimatingDrawFromIntent = getIntent().getStringExtra("winAccelerate");
        }
        if ((this.mEnableDrawDuringWindowsAnimating || TextUtils.equals("1", windowsAnimatingDrawFromIntent)) && findViewById(16908290) != null) {
            MainThreadHelper.post(new Runnable() {
                public void run() {
                    BaseActivity baseActivity = BaseActivity.this;
                    baseActivity.setDrawDuringWindowsAnimating(baseActivity.getWindow().getDecorView());
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void setDrawDuringWindowsAnimating(View view2) {
        if (Build.VERSION.SDK_INT <= 23) {
            try {
                ViewParent rootParent = view2.getRootView().getParent();
                Method method = rootParent.getClass().getDeclaredMethod("setDrawDuringWindowsAnimating", new Class[]{Boolean.TYPE});
                method.setAccessible(true);
                method.invoke(rootParent, new Object[]{true});
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private void handleDispatchDoneAnimating(View paramView) {
        try {
            ViewParent localViewParent = paramView.getRootView().getParent();
            Method localMethod = localViewParent.getClass().getDeclaredMethod("handleDispatchDoneAnimating", new Class[0]);
            localMethod.setAccessible(true);
            localMethod.invoke(localViewParent, new Object[0]);
        } catch (Exception localException) {
            localException.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public void resetActivityAnim() {
        int i2 = sNextEnterAnimWhenStarting;
        if (!(i2 == 0 && sNextExitAnimWhenStarting == 0)) {
            this.mEnterAnimWhenStarting = i2;
            this.mExitAnimWhenStarting = sNextExitAnimWhenStarting;
        }
        int i3 = sNextEnterAnimWhenFinishing;
        if (!(i3 == 0 && sNextExitAnimWhenFinishing == 0)) {
            this.mEnterAnimWhenFinishing = i3;
            this.mExitAnimWhenFinishing = sNextExitAnimWhenFinishing;
        }
        setNextPendingTransition(0, 0, 0, 0);
    }

    private void startEnterActivityAnim() {
        int i2 = this.mEnterAnimWhenStarting;
        if (i2 != 0 || this.mExitAnimWhenStarting != 0) {
            overridePendingTransition(i2, this.mExitAnimWhenStarting);
            this.mEnterAnimWhenStarting = 0;
            this.mExitAnimWhenStarting = 0;
        }
    }

    private void startExitActivityAnim() {
        int i2 = this.mEnterAnimWhenFinishing;
        if (i2 != 0 || this.mExitAnimWhenFinishing != 0) {
            overridePendingTransition(i2, this.mExitAnimWhenFinishing);
            this.mEnterAnimWhenFinishing = 0;
            this.mExitAnimWhenFinishing = 0;
        }
    }

    public static void addOnNewIntentCallback(OnNewIntentCallback callback) {
        ArrayList<OnNewIntentCallback> arrayList = onNewIntentCallbacks;
        if (arrayList != null && callback != null) {
            synchronized (arrayList) {
                Iterator<OnNewIntentCallback> it = onNewIntentCallbacks.iterator();
                while (it.hasNext()) {
                    if (callback.equals(it.next())) {
                        return;
                    }
                }
                CollectionUtils.add(onNewIntentCallbacks, callback);
            }
        }
    }

    public static void deleteOnNewIntentCallback(OnNewIntentCallback callback) {
        ArrayList<OnNewIntentCallback> arrayList = onNewIntentCallbacks;
        if (arrayList != null && callback != null) {
            synchronized (arrayList) {
                onNewIntentCallbacks.remove(callback);
            }
        }
    }

    public Object getActionBarExtObject() {
        return this.mActionBarExtObject;
    }

    public Object setActionBarExtObject(Object actionBarExtObject) {
        this.mActionBarExtObject = actionBarExtObject;
        return actionBarExtObject;
    }

    public Object getToolBarExtObject() {
        return this.mToolBarExtObject;
    }

    public Object setToolBarExtObject(Object toolBarExtObject) {
        this.mToolBarExtObject = toolBarExtObject;
        return toolBarExtObject;
    }

    public Object getCommonMenuExtObject() {
        return this.mCommonMenuExtObject;
    }

    public Object setCommonMenuExtObject(Object toolBarExtObject) {
        this.mCommonMenuExtObject = toolBarExtObject;
        return toolBarExtObject;
    }

    public Context getExtContext() {
        return this;
    }

    public Object getSuspensionBallExtObject() {
        return this.mSuspensionBallExtObject;
    }

    public void setSuspensionBallExtObject(Object o) {
        this.mSuspensionBallExtObject = o;
    }

    public void setSuspensionBallSlideListener(SlidingPaneLayout.PanelSlideListener mSuspensionBallSlideListener2) {
        this.mSuspensionBallSlideListener = mSuspensionBallSlideListener2;
    }

    public SlidingPaneLayout.PanelSlideListener getSuspensionBallSlideListener() {
        return this.mSuspensionBallSlideListener;
    }
}
