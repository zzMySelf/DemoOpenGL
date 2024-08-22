package com.baidu.searchbox.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Outline;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import com.baidu.android.util.android.FastClickUtils;
import com.baidu.android.util.devices.DeviceUtils;
import com.baidu.nadcore.business.webpanel.IPanelPopupWindowScroll;
import com.baidu.nadcore.business.webpanel.IPanelPopupWindowScrollListener;
import com.baidu.nadcore.webview.util.DebugLogger;
import com.baidu.searchbox.ad.INadTalosPop;
import com.baidu.searchbox.ad.event.AdTalosPanelCloseOuterEvent;
import com.baidu.searchbox.ad.event.AdTalosPanelPopupWindowEvent;
import com.baidu.searchbox.ad.util.EventBusHelper;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.feed.ad.runtimeAll.R;
import com.baidu.searchbox.skin.NightModeHelper;
import com.baidu.searchbox.skin.callback.NightModeChangeListener;
import com.baidu.searchbox.skin.ioc.NightRuntime;
import com.baidu.searchbox.utils.NadWebPanelHelper;
import com.baidu.talos.TalosAdapterManager;
import com.baidu.talos.TalosManager;
import com.baidu.talos.common.TalosInitParamsUtil;
import com.baidu.talos.core.data.ParamMapImpl;
import com.baidu.talos.view.Container;
import com.baidu.talos.view.TalosContainerViewInitParams;
import com.baidu.talos.view.scroll.IScroller;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

public class AdTalosPopupView extends PopupWindow implements INadTalosPop, ViewTreeObserver.OnWindowFocusChangeListener, IPanelPopupWindowScroll, View.OnLayoutChangeListener, NightModeChangeListener {
    private static final String BIZ_PARAM = "bizparams";
    private static final double DEFAULT_HEIGHT_RATIO = 0.7d;
    private static final double DEFAULT_HEIGHT_RATIO_EX = 1.95d;
    private static final int FAST_SCROLL_Y_VELOCITY = 800;
    private static final String HEIGHT_CALCULATE_MODE = "height_calculate_mode";
    private static final String HEIGHT_RATIO = "height_ratio";
    private static final String KEY_PAGE_ID = "pageId";
    private static final String KEY_ROOT_TAG = "rootTag";
    private static final String KEY_STATUS = "status";
    private static final String KEY_TALOS_PANEL_CONTROL = "panel_control";
    private static final String MAIN_BIZ_NAME = "mainBizName";
    private static final String MODULE_NAME = "moduleName";
    private static final int POPUP_DISMISS_TYPE_CLICK_ANDROID_CLOSE_BTN = 3;
    private static final int POPUP_DISMISS_TYPE_CLICK_BACKGROUND = 0;
    private static final int POPUP_DISMISS_TYPE_PULL_DOWN = 2;
    private static final int POPUP_DISMISS_TYPE_TALOS_CALLBACK = 1;
    private static final String SCENE_HIDE_NAVIGATION = "scene_hide_navigation";
    private static final String STATUS_PAUSE = "pause";
    private static final String STATUS_RESUME = "resume";
    private static final String TAG = "AdTalosPopupView";
    private static final int TALOS_DRAG_AREA_HEIGHT_DP = 43;
    private static final String TALOS_SOURCE = "AdTalosPopupView";
    /* access modifiers changed from: private */
    public static final int TALOS_VIEW_PADDING = DeviceUtils.ScreenInfo.dp2px(AppRuntime.getAppContext(), 18.0f);
    private static final int TOUCH_DOWN_BLANK_AREA = 0;
    private static final int TOUCH_DOWN_FULL_PANEL_STATUS = 2;
    private static final int TOUCH_DOWN_HALF_PANEL_STATUS = 1;
    private static final int TOUCH_DOWN_MANTLE_AREA = 1;
    private static final int TOUCH_DOWN_TALOS_AREA = 2;
    private static final int TOUCH_DOWN_UNDEFINE_PANEL_STATUS = -1;
    private static final String TYPE_SLIDE_CONTROL = "slideControl";
    private static final String TYPE_SLIDE_DOWN = "slideDown";
    private static final String VERSION = "version";
    private final WeakReference<Activity> mActivityRef;
    private int mAnimateValue = 0;
    private ObjectAnimator mAnimator;
    private String mBizparams;
    /* access modifiers changed from: private */
    public boolean mCanTalosPanelControlSlide = false;
    /* access modifiers changed from: private */
    public boolean mCanTalosPanelControlSlideDown = false;
    /* access modifiers changed from: private */
    public int mDefaultTopMargin;
    /* access modifiers changed from: private */
    public int mDismissType = 0;
    private IPanelPopupWindowScrollListener mDragListener;
    private int mHeightCalculateMode = 0;
    private double mHeightRatio = 0.7d;
    /* access modifiers changed from: private */
    public boolean mIsUpwardAnimate = false;
    private int mLastAnimateValue = 0;
    private String mMainBizName;
    private int mMantleAreaHeight = 0;
    private String mModuleName;
    private final Object mNightModeObj = new Object();
    /* access modifiers changed from: private */
    public int mParentHeight = 0;
    /* access modifiers changed from: private */
    public final RelativeLayout mRootLayout;
    private boolean mSceneHideNavigation;
    private final LinearLayout mTalosContainer;
    private final Object mTalosObject = new Object();
    /* access modifiers changed from: private */
    public Container mTalosView;
    /* access modifiers changed from: private */
    public int mTouchDownArea = 0;
    /* access modifiers changed from: private */
    public int mTouchDownPanelStatus = -1;
    private String mVersion;

    public AdTalosPopupView(Activity activity) {
        this.mActivityRef = new WeakReference<>(activity);
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(activity).inflate(R.layout.ad_talos_panel_pop_view, (ViewGroup) null);
        this.mRootLayout = relativeLayout;
        this.mTalosContainer = (LinearLayout) relativeLayout.findViewById(R.id.ad_talos_panel_pop_container);
        setFocusable(true);
        setBackgroundDrawable(new ColorDrawable(0));
        setAnimationStyle(R.style.ad_commerce_pop_anim);
        setClippingEnabled(true);
        setWidth(-1);
        setHeight(-1);
        setContentView(createContentView(activity));
        registerEventBus(activity);
        registerTalosAdapters();
    }

    private void registerTalosAdapters() {
        TalosAdapterManager.registerCustomView("AdTalosPopupView", new NadTalosCustomViewAdapter());
    }

    private void unRegisterTalosAdapters() {
        TalosAdapterManager.unregisterCustomView("AdTalosPopupView");
    }

    private void registerEventBus(Activity activity) {
        EventBusHelper.INSTANCE.register(activity, this.mTalosObject, AdTalosPanelCloseOuterEvent.class, 0, new AdTalosPopupView$$ExternalSyntheticLambda0(this));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$registerEventBus$0$com-baidu-searchbox-view-AdTalosPopupView  reason: not valid java name */
    public /* synthetic */ void m7349lambda$registerEventBus$0$combaidusearchboxviewAdTalosPopupView(AdTalosPanelCloseOuterEvent adTalosPanelCloseOuterEvent) {
        if (adTalosPanelCloseOuterEvent != null) {
            this.mDismissType = adTalosPanelCloseOuterEvent.dismissType;
            realDismiss();
        }
    }

    private View createContentView(final Context context) {
        this.mRootLayout.getViewTreeObserver().addOnWindowFocusChangeListener(this);
        this.mRootLayout.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            public boolean onPreDraw() {
                AdTalosPopupView adTalosPopupView = AdTalosPopupView.this;
                int unused = adTalosPopupView.mParentHeight = adTalosPopupView.mRootLayout.getMeasuredHeight();
                AdTalosPopupView.this.setPopupWindowParams(context);
                ViewTreeObserver v = AdTalosPopupView.this.mRootLayout.getViewTreeObserver();
                if (v == null || !v.isAlive()) {
                    return true;
                }
                v.removeOnPreDrawListener(this);
                return true;
            }
        });
        this.mMantleAreaHeight = DeviceUtils.ScreenInfo.dp2px(context, 43.0f);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mTalosContainer.getLayoutParams();
        layoutParams.bottomMargin = -TALOS_VIEW_PADDING;
        this.mTalosContainer.setLayoutParams(layoutParams);
        return this.mRootLayout;
    }

    /* access modifiers changed from: private */
    public void realDismiss() {
        ObjectAnimator objectAnimator = this.mAnimator;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.mAnimator.cancel();
        }
        Container container = this.mTalosView;
        if (container != null) {
            container.removeOnLayoutChangeListener(this);
        }
        this.mRootLayout.getViewTreeObserver().removeOnWindowFocusChangeListener(this);
        super.dismiss();
        unsubscribeNightModeChangedEvent();
        BdEventBus.Companion.getDefault().post(new AdTalosPanelPopupWindowEvent(1, String.valueOf(this.mDismissType)));
        Container container2 = this.mTalosView;
        if (container2 != null) {
            this.mTalosView.onPause(createParamsBundle(container2.getId(), "pause"));
            this.mTalosView.destroy();
        }
        unRegisterTalosAdapters();
    }

    public void onWindowFocusChanged(boolean hasFocus) {
        if (this.mSceneHideNavigation && hasFocus) {
            followHostSystemUiVisibility();
            judgeTopMarginSetStatusBar();
        }
    }

    public boolean showPop(String data) {
        Activity activity;
        if (FastClickUtils.isFastDoubleClick() || (activity = (Activity) this.mActivityRef.get()) == null || !parseJsonParam(data)) {
            return false;
        }
        createTalosView(setPanelData(), activity);
        setPopupWindowParams(activity);
        BdEventBus.Companion.getDefault().post(new AdTalosPanelPopupWindowEvent(3, (IPanelPopupWindowScroll) this));
        setTouchEventHandler();
        if (this.mTalosView == null) {
            return false;
        }
        showPopAtLocation(this.mRootLayout.getContext(), ((Activity) this.mRootLayout.getContext()).getWindow().getDecorView(), 80, 0, 0);
        if (this.mSceneHideNavigation) {
            followHostSystemUiVisibility();
        }
        subscribeNightModeChangedEvent();
        return true;
    }

    private void followHostSystemUiVisibility() {
        Activity activity = (Activity) this.mActivityRef.get();
        if (activity != null) {
            getContentView().setSystemUiVisibility(activity.getWindow().getDecorView().getSystemUiVisibility() | 512 | 2);
        }
    }

    /* access modifiers changed from: private */
    public void setPopupWindowParams(Context context) {
        if (this.mHeightCalculateMode == 0) {
            this.mDefaultTopMargin = (int) (((double) this.mParentHeight) * (1.0d - this.mHeightRatio));
        } else {
            this.mDefaultTopMargin = (int) (((double) DeviceUtils.ScreenInfo.getDisplayWidth(context)) / this.mHeightRatio);
        }
        LinearLayout.LayoutParams params = getTalosViewLayoutParams();
        if (params != null) {
            params.height = (this.mParentHeight - this.mDefaultTopMargin) + TALOS_VIEW_PADDING;
            params.topMargin = this.mDefaultTopMargin;
            setTalosViewLayoutParams(params);
        }
    }

    private void setTalosViewLayoutParams(LinearLayout.LayoutParams layoutParams) {
        Container container = this.mTalosView;
        if (container != null) {
            container.setLayoutParams(layoutParams);
        }
    }

    private void createTalosView(Bundle bundleData, Activity activity) {
        Container createTalosContainer = TalosManager.getTalosContainerViewManager().createTalosContainer(activity, new TalosContainerViewInitParams.Builder().packageName(this.mMainBizName).moudleName(this.mModuleName).source("AdTalosPopupView").minMoudleVersion(this.mVersion).build(), bundleData);
        this.mTalosView = createTalosContainer;
        if (createTalosContainer != null) {
            createTalosContainer.addOnLayoutChangeListener(this);
            this.mTalosView.setClipToOutline(true);
            this.mTalosView.setOutlineProvider(new ViewOutlineProvider() {
                public void getOutline(View view2, Outline outline) {
                    outline.setRoundRect(new Rect(0, 0, AdTalosPopupView.this.mTalosView.getMeasuredWidth(), AdTalosPopupView.this.mTalosView.getMeasuredHeight()), (float) AdTalosPopupView.TALOS_VIEW_PADDING);
                }
            });
            this.mTalosView.setPadding(0, 0, 0, TALOS_VIEW_PADDING);
            this.mTalosView.setBackgroundResource(R.drawable.ad_ecommerce_pop_shape);
            this.mTalosContainer.removeAllViews();
            this.mTalosContainer.addView(this.mTalosView);
            this.mTalosView.onResume(activity, createParamsBundle(this.mTalosView.getId(), "resume"));
        }
    }

    private void showPopAtLocation(Context context, View parent, int gravity, int x, int y) {
        Activity activity = null;
        if (context instanceof Activity) {
            activity = (Activity) context;
        }
        if (activity != null && !activity.isFinishing() && !activity.isDestroyed()) {
            try {
                showAtLocation(parent, gravity, x, y);
                BdEventBus.Companion.getDefault().post(new AdTalosPanelPopupWindowEvent(0, ""));
            } catch (Exception e2) {
                DebugLogger.throwException(e2);
            }
        }
    }

    private Bundle setPanelData() {
        if (this.mMainBizName.isEmpty() || this.mModuleName.isEmpty()) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putString("bizparams", this.mBizparams);
        TalosInitParamsUtil.addBaseInitParams(bundle);
        return bundle;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0028, code lost:
        if (r1.equals("slideControl") != false) goto L_0x0037;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void parsePanelControl(java.lang.String r8) {
        /*
            r7 = this;
            org.json.JSONObject r0 = com.baidu.nadcore.safe.JSONUtils.newJSONObject(r8)
            java.lang.String r1 = "type"
            java.lang.String r1 = r0.optString(r1)
            java.lang.String r2 = "disable"
            r3 = 0
            int r2 = r0.optInt(r2, r3)
            r4 = 1
            if (r2 != r4) goto L_0x0017
            r2 = r4
            goto L_0x0018
        L_0x0017:
            r2 = r3
        L_0x0018:
            r5 = -1
            int r6 = r1.hashCode()
            switch(r6) {
                case -796944909: goto L_0x002b;
                case -102095252: goto L_0x0021;
                default: goto L_0x0020;
            }
        L_0x0020:
            goto L_0x0036
        L_0x0021:
            java.lang.String r4 = "slideControl"
            boolean r4 = r1.equals(r4)
            if (r4 == 0) goto L_0x0020
            goto L_0x0037
        L_0x002b:
            java.lang.String r3 = "slideDown"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x0020
            r3 = r4
            goto L_0x0037
        L_0x0036:
            r3 = r5
        L_0x0037:
            switch(r3) {
                case 0: goto L_0x003e;
                case 1: goto L_0x003b;
                default: goto L_0x003a;
            }
        L_0x003a:
            goto L_0x0041
        L_0x003b:
            r7.mCanTalosPanelControlSlideDown = r2
            goto L_0x0041
        L_0x003e:
            r7.mCanTalosPanelControlSlide = r2
        L_0x0041:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.view.AdTalosPopupView.parsePanelControl(java.lang.String):void");
    }

    private boolean parseJsonParam(String data) {
        if (TextUtils.isEmpty(data)) {
            return false;
        }
        try {
            JSONObject jsonObject = new JSONObject(data);
            this.mMainBizName = jsonObject.optString("mainBizName");
            this.mModuleName = jsonObject.optString("moduleName");
            this.mHeightCalculateMode = jsonObject.optInt("height_calculate_mode");
            this.mVersion = jsonObject.optString("version");
            this.mBizparams = jsonObject.optString("bizparams");
            this.mSceneHideNavigation = jsonObject.optInt(SCENE_HIDE_NAVIGATION, 0) == 1;
            if (this.mHeightCalculateMode == 0) {
                double optDouble = jsonObject.optDouble("height_ratio", 0.7d);
                this.mHeightRatio = optDouble;
                if (optDouble < 0.0d || optDouble > 1.0d) {
                    this.mHeightRatio = 0.7d;
                }
            } else {
                double optDouble2 = jsonObject.optDouble("height_ratio", DEFAULT_HEIGHT_RATIO_EX);
                this.mHeightRatio = optDouble2;
                if (optDouble2 <= 0.0d) {
                    this.mHeightRatio = DEFAULT_HEIGHT_RATIO_EX;
                }
            }
            String panelControlParams = jsonObject.optString(KEY_TALOS_PANEL_CONTROL);
            if (!TextUtils.isEmpty(panelControlParams)) {
                parsePanelControl(panelControlParams);
            }
            return true;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public void setAnimateValue(int animateValue) {
        this.mAnimateValue = animateValue;
        updatePopupWindowViewWithAnimate(animateValue - this.mLastAnimateValue);
        this.mLastAnimateValue = animateValue;
    }

    /* access modifiers changed from: package-private */
    public int getAnimateValue() {
        return this.mAnimateValue;
    }

    private void updatePopupWindowViewWithAnimate(int offsetY) {
        LinearLayout.LayoutParams params = getTalosViewLayoutParams();
        if (params != null) {
            if (this.mIsUpwardAnimate) {
                params.topMargin -= offsetY;
                if (params.topMargin < 0) {
                    params.topMargin = 0;
                }
            } else {
                params.topMargin += offsetY;
                int i2 = params.topMargin;
                int i3 = this.mDefaultTopMargin;
                if (i2 > i3) {
                    params.topMargin = i3;
                }
            }
            setTalosViewLayoutParams(params);
            judgeTopMarginSetStatusBar();
        }
    }

    private void setTouchEventHandler() {
        setTouchInterceptor(new View.OnTouchListener() {
            boolean mIsScrollY = false;
            int mOffsetX = 0;
            int mOffsetY = 0;
            int mRawX = 0;
            int mRawY = 0;
            long mTouchDownTime = 0;
            VelocityTracker mVelocityTracker = null;

            public boolean onTouch(View v, MotionEvent event) {
                if (this.mVelocityTracker == null) {
                    this.mVelocityTracker = VelocityTracker.obtain();
                }
                switch (event.getAction()) {
                    case 0:
                        this.mOffsetX = 0;
                        this.mOffsetY = 0;
                        this.mTouchDownTime = System.currentTimeMillis();
                        AdTalosPopupView adTalosPopupView = AdTalosPopupView.this;
                        int unused = adTalosPopupView.mTouchDownArea = adTalosPopupView.judgeTouchDownArea((int) event.getY());
                        AdTalosPopupView adTalosPopupView2 = AdTalosPopupView.this;
                        int unused2 = adTalosPopupView2.mTouchDownPanelStatus = adTalosPopupView2.judgeTouchDownStatus();
                        this.mRawY = (int) event.getRawY();
                        AdTalosPopupView.this.setTalosLongPressEnable(false);
                        this.mVelocityTracker.clear();
                        this.mVelocityTracker.addMovement(event);
                        this.mIsScrollY = false;
                        return false;
                    case 1:
                        if (AdTalosPopupView.this.mTouchDownArea != 0) {
                            if (AdTalosPopupView.this.mTouchDownArea == 1 || AdTalosPopupView.this.mTouchDownArea == 2) {
                                if (!AdTalosPopupView.this.mCanTalosPanelControlSlide && AdTalosPopupView.this.mTouchDownPanelStatus == 1 && this.mIsScrollY && this.mVelocityTracker.getYVelocity() > 800.0f && !AdTalosPopupView.this.mCanTalosPanelControlSlideDown) {
                                    int unused3 = AdTalosPopupView.this.mDismissType = 2;
                                    this.mIsScrollY = false;
                                    AdTalosPopupView.this.realDismiss();
                                    return false;
                                } else if (this.mIsScrollY) {
                                    LinearLayout.LayoutParams params = AdTalosPopupView.this.getTalosViewLayoutParams();
                                    if (params == null) {
                                        this.mIsScrollY = false;
                                        return false;
                                    }
                                    int topMargin = params.topMargin;
                                    if (topMargin > AdTalosPopupView.this.mDefaultTopMargin + ((AdTalosPopupView.this.mParentHeight - AdTalosPopupView.this.mDefaultTopMargin) / 4)) {
                                        int unused4 = AdTalosPopupView.this.mDismissType = 2;
                                        this.mIsScrollY = false;
                                        AdTalosPopupView.this.realDismiss();
                                    }
                                    if (topMargin > AdTalosPopupView.this.mDefaultTopMargin && topMargin < AdTalosPopupView.this.mDefaultTopMargin + ((AdTalosPopupView.this.mParentHeight - AdTalosPopupView.this.mDefaultTopMargin) / 4)) {
                                        boolean unused5 = AdTalosPopupView.this.mIsUpwardAnimate = true;
                                        AdTalosPopupView adTalosPopupView3 = AdTalosPopupView.this;
                                        adTalosPopupView3.startAnimator(160, topMargin - adTalosPopupView3.mDefaultTopMargin);
                                    }
                                }
                            }
                            this.mIsScrollY = false;
                            return false;
                        } else if (this.mOffsetY >= 20) {
                            return false;
                        } else {
                            if (System.currentTimeMillis() - this.mTouchDownTime < ((long) ViewConfiguration.getLongPressTimeout())) {
                                int unused6 = AdTalosPopupView.this.mDismissType = 0;
                                AdTalosPopupView.this.dismiss();
                            }
                            return true;
                        }
                    case 2:
                        this.mVelocityTracker.addMovement(event);
                        this.mVelocityTracker.computeCurrentVelocity(1000);
                        this.mOffsetX = ((int) event.getRawX()) - this.mRawX;
                        this.mOffsetY = ((int) event.getRawY()) - this.mRawY;
                        this.mRawX = (int) event.getRawX();
                        this.mRawY = (int) event.getRawY();
                        if (Math.abs(this.mOffsetX) >= Math.abs(this.mOffsetY)) {
                            return false;
                        }
                        if (AdTalosPopupView.this.mTouchDownArea == 2) {
                            boolean flag = AdTalosPopupView.this.updatePopupWindowView(true, this.mOffsetY);
                            if (flag && !this.mIsScrollY) {
                                AdTalosPopupView.this.setTalosLongPressEnable(true);
                                this.mIsScrollY = true;
                            }
                            return flag;
                        } else if (AdTalosPopupView.this.mTouchDownArea != 1) {
                            return true;
                        } else {
                            boolean flag2 = AdTalosPopupView.this.updatePopupWindowView(false, this.mOffsetY);
                            if (flag2 && !this.mIsScrollY) {
                                AdTalosPopupView.this.setTalosLongPressEnable(true);
                                this.mIsScrollY = true;
                            }
                            return flag2;
                        }
                    case 3:
                        this.mIsScrollY = false;
                        boolean unused7 = AdTalosPopupView.this.mIsUpwardAnimate = false;
                        return false;
                    default:
                        return false;
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void startAnimator(int duration, int distanceY) {
        ObjectAnimator ofInt = ObjectAnimator.ofInt(this, "animateValue", new int[]{0, distanceY});
        this.mAnimator = ofInt;
        ofInt.setDuration((long) duration);
        this.mAnimator.start();
        this.mAnimator.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animation) {
                LinearLayout.LayoutParams params;
                super.onAnimationEnd(animation);
                if (AdTalosPopupView.this.mTalosView != null && (params = AdTalosPopupView.this.getTalosViewLayoutParams()) != null) {
                    params.height = (AdTalosPopupView.this.mParentHeight - params.topMargin) + AdTalosPopupView.TALOS_VIEW_PADDING;
                    AdTalosPopupView.this.mTalosView.setLayoutParams(params);
                }
            }

            public void onAnimationCancel(Animator animation) {
                super.onAnimationCancel(animation);
            }
        });
    }

    /* access modifiers changed from: private */
    public LinearLayout.LayoutParams getTalosViewLayoutParams() {
        Container container = this.mTalosView;
        if (container == null) {
            return null;
        }
        ViewGroup.LayoutParams params = container.getLayoutParams();
        if (params instanceof LinearLayout.LayoutParams) {
            return (LinearLayout.LayoutParams) params;
        }
        return null;
    }

    /* access modifiers changed from: private */
    public boolean updatePopupWindowView(boolean isTalosArea, int offsetY) {
        if (this.mCanTalosPanelControlSlide) {
            return false;
        }
        ObjectAnimator objectAnimator = this.mAnimator;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.mAnimator.cancel();
        }
        LinearLayout.LayoutParams layoutParams = getTalosViewLayoutParams();
        if (this.mTalosView == null || layoutParams == null) {
            return false;
        }
        if (layoutParams.topMargin + offsetY < this.mDefaultTopMargin || layoutParams.topMargin + offsetY >= this.mParentHeight) {
            if (offsetY >= 0) {
                return false;
            }
            int i2 = layoutParams.topMargin;
            return false;
        } else if (this.mCanTalosPanelControlSlide) {
            return false;
        } else {
            if (isTalosArea && !isReadyForPullDown()) {
                return false;
            }
            layoutParams.topMargin += offsetY;
            this.mTalosView.setLayoutParams(layoutParams);
            int i3 = this.mParentHeight;
            if (i3 <= 0) {
                return true;
            }
            float progress = ((float) (getPanelHeight() - (i3 - layoutParams.topMargin))) / (((float) getPanelHeight()) * 1.0f);
            IPanelPopupWindowScrollListener iPanelPopupWindowScrollListener = this.mDragListener;
            if (iPanelPopupWindowScrollListener == null) {
                return true;
            }
            iPanelPopupWindowScrollListener.onVerticalScrollProgressChanged(progress);
            return true;
        }
    }

    public boolean isReadyForPullDown() {
        View refreshableView;
        try {
            Container container = this.mTalosView;
            if (container == null || (refreshableView = container.findViewWithTag("FeedNadPanelViewTag")) == null) {
                return false;
            }
            if (!(refreshableView instanceof IScroller)) {
                return !refreshableView.canScrollVertically(-1);
            }
            if (((IScroller) refreshableView).getScrollerY() <= 0) {
                return true;
            }
            return false;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    private void judgeTopMarginSetStatusBar() {
        LinearLayout.LayoutParams params;
        Activity activity = (Activity) this.mActivityRef.get();
        if (activity != null && this.mTalosView != null && (params = getTalosViewLayoutParams()) != null) {
            if (params.topMargin == 0) {
                NadWebPanelHelper.setStatusBarColorWhiteMode(activity);
                if (!NightRuntime.getNightContext().getNightModeSwitcherState() && Build.VERSION.SDK_INT >= 23) {
                    activity.getWindow().getDecorView().setSystemUiVisibility(activity.getWindow().getDecorView().getSystemUiVisibility() | 8192);
                }
                this.mTalosView.setOutlineProvider(new ViewOutlineProvider() {
                    public void getOutline(View view2, Outline outline) {
                        outline.setRoundRect(new Rect(0, 0, AdTalosPopupView.this.mTalosView.getMeasuredWidth(), AdTalosPopupView.this.mTalosView.getMeasuredHeight()), (float) DeviceUtils.ScreenInfo.dp2px(AppRuntime.getAppContext(), 0.0f));
                    }
                });
                return;
            }
            NadWebPanelHelper.setStatusBarColorTranslucentMode(activity);
            if (Build.VERSION.SDK_INT >= 23) {
                activity.getWindow().getDecorView().setSystemUiVisibility(activity.getWindow().getDecorView().getSystemUiVisibility() & -8193);
            }
            this.mTalosView.setOutlineProvider(new ViewOutlineProvider() {
                public void getOutline(View view2, Outline outline) {
                    outline.setRoundRect(new Rect(0, 0, AdTalosPopupView.this.mTalosView.getMeasuredWidth(), AdTalosPopupView.this.mTalosView.getMeasuredHeight()), (float) AdTalosPopupView.TALOS_VIEW_PADDING);
                }
            });
        }
    }

    private void judgeTopMarginSetTalosViewBackground() {
        LinearLayout.LayoutParams params = getTalosViewLayoutParams();
        if (params != null && this.mTalosView != null) {
            if (params.topMargin == 0) {
                this.mTalosView.setBackgroundResource(R.color.ad_white);
            } else {
                this.mTalosView.setBackgroundResource(R.drawable.ad_ecommerce_pop_shape);
            }
        }
    }

    /* access modifiers changed from: private */
    public int judgeTouchDownArea(int y) {
        int topMargin;
        LinearLayout.LayoutParams layoutParams = getTalosViewLayoutParams();
        if (layoutParams == null || y < (topMargin = layoutParams.topMargin)) {
            return 0;
        }
        if (y < this.mMantleAreaHeight + topMargin) {
            return 1;
        }
        return 2;
    }

    /* access modifiers changed from: private */
    public int judgeTouchDownStatus() {
        LinearLayout.LayoutParams layoutParams = getTalosViewLayoutParams();
        if (layoutParams == null) {
            return -1;
        }
        if (layoutParams.topMargin == 0) {
            return 2;
        }
        if (layoutParams.topMargin == this.mDefaultTopMargin) {
            return 1;
        }
        return -1;
    }

    /* access modifiers changed from: private */
    public void setTalosLongPressEnable(final boolean longPressDisable) {
        Container container = this.mTalosView;
        if (container != null) {
            container.setOnLongClickListener(new View.OnLongClickListener() {
                public boolean onLongClick(View view2) {
                    return longPressDisable;
                }
            });
        }
    }

    private ParamMapImpl createParamsBundle(int talosViewId, String status) {
        ParamMapImpl paramsBundle = new ParamMapImpl();
        paramsBundle.putString("status", status);
        paramsBundle.putString("pageId", talosViewId + "");
        paramsBundle.putString("rootTag", talosViewId + "");
        return paramsBundle;
    }

    private void subscribeNightModeChangedEvent() {
        NightModeHelper.subscribeNightModeChangeEvent(this.mNightModeObj, this);
    }

    private void unsubscribeNightModeChangedEvent() {
        NightModeHelper.unsubscribeNightModeChangedEvent(this.mNightModeObj);
    }

    public int getPanelHeight() {
        return this.mParentHeight - this.mDefaultTopMargin;
    }

    public void setScrollListener(IPanelPopupWindowScrollListener listener) {
        this.mDragListener = listener;
    }

    public void onNightModeChanged(boolean isNightMode) {
    }

    public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
        judgeTopMarginSetTalosViewBackground();
    }

    public void dismiss() {
        this.mDismissType = 0;
        realDismiss();
    }
}
