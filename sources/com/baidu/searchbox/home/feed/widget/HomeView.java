package com.baidu.searchbox.home.feed.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.core.view.MotionEventCompat;
import com.baidu.android.common.PermissionManager;
import com.baidu.apsaras.scheduler.Particle;
import com.baidu.apsaras.scheduler.ParticleDispatchers;
import com.baidu.apsaras.scheduler.ParticleGroup;
import com.baidu.apsaras.scheduler.ParticleOrder;
import com.baidu.apsaras.scheduler.ParticleScope;
import com.baidu.apsaras.scheduler.ParticleScopeKt;
import com.baidu.launch.LaunchABUtils;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.HomeViewManager;
import com.baidu.searchbox.aop.annotation.TimeSpendTrace;
import com.baidu.searchbox.appframework.MainContext;
import com.baidu.searchbox.bdeventbus.Action;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.config.QuickPersistConfig;
import com.baidu.searchbox.config.QuickPersistConfigConst;
import com.baidu.searchbox.config.eventmessage.FontSizeChangeMessage;
import com.baidu.searchbox.exclusion.popup.PopupExclusionManagerMap;
import com.baidu.searchbox.feed.FeedApi;
import com.baidu.searchbox.feed.FeedRuntime;
import com.baidu.searchbox.feed.event.BackPressedEvent;
import com.baidu.searchbox.feed.event.FeedFloatBtnRefreshEvent;
import com.baidu.searchbox.feed.event.FeedFlowRefreshEvent;
import com.baidu.searchbox.feed.event.MainFeedPreLoadEvent;
import com.baidu.searchbox.feed.event.StateChangedEvent;
import com.baidu.searchbox.feed.refreshex.RefreshRevolutionary;
import com.baidu.searchbox.feed.statistic.FeedStatisticCenter;
import com.baidu.searchbox.feed.tab.model.TabController;
import com.baidu.searchbox.feed.tab.view.FeedTabLayout;
import com.baidu.searchbox.feed.util.FeedSessionManager;
import com.baidu.searchbox.home.AbsHomeView;
import com.baidu.searchbox.home.HomeDimenManager;
import com.baidu.searchbox.home.HomeDrawerContainer;
import com.baidu.searchbox.home.container.lifecycle.IHomeBg;
import com.baidu.searchbox.home.container.lifecycle.IHomeEventListener;
import com.baidu.searchbox.home.event.UiInitialReadyEvent;
import com.baidu.searchbox.home.feed.CeilingScene;
import com.baidu.searchbox.home.feed.listener.IHomeFeedEventListener;
import com.baidu.searchbox.home.feed.widget.HomeScrollView;
import com.baidu.searchbox.home.tabs.HomeTabManager;
import com.baidu.searchbox.home.theme.NewThemeManager;
import com.baidu.searchbox.homepage.R;
import com.baidu.searchbox.homepage.extend.IHomeFun;
import com.baidu.searchbox.homepage.ioc.HomePageRuntime;
import com.baidu.searchbox.homepage.ioc.IHomeApp;
import com.baidu.searchbox.launch.restore.ColdLaunchRestoreManager;
import com.baidu.searchbox.launch.restore.ioc.LaunchRestoreUBCKt;
import com.baidu.searchbox.launch.restore.ioc.LaunchRestoreUBCRuntime;
import com.baidu.searchbox.launch.stats.SpeedStatsManager;
import com.baidu.searchbox.launch.stats.SpeedStatsStampTable;
import com.baidu.searchbox.performance.speed.SpeedStats;
import com.baidu.searchbox.video.videoplayer.invoker.PluginInvokerConstants;
import com.baidu.searchbox.widget.ImmersionHelper;
import com.baidu.ubc.UBC;
import com.facebook.drawee.drawable.FadeDrawable;
import org.json.JSONException;
import org.json.JSONObject;

public class HomeView extends AbsHomeView {
    /* access modifiers changed from: private */
    public static final boolean DEBUG = AppConfig.isDebug();
    public static final int GO_TO_FEED_DURATION = 500;
    private static final int GO_TO_HOME_DURATION = 200;
    public static final String HOME_DISPLAY_FEEDTYPE = "feed";
    public static final String HOME_DISPLAY_HOMETYPE = "home";
    public static final String HOME_DISPLAY_ID = "105";
    public static final String HOME_DISPLAY_KEY = "type";
    private static final String KEY_HOME_TOP_STATE = "home_top_state";
    private static final String TAG = "HomeView";
    private static boolean mHasConfirmUseMobileData;
    private boolean isColdStart = true;
    private boolean mCleanPreloadActionCalled = false;
    private int mDrawCount = -1;
    private boolean mHasDrawed = false;
    private boolean mHasInitCommonEventListenerList = false;
    /* access modifiers changed from: private */
    public boolean mHasPaused;
    private boolean mHasUiReady = false;
    private boolean mHeaderVisible = false;
    /* access modifiers changed from: private */
    public IHomeBg mHomeBackground;
    private HomeContainer mHomeContainer;
    private HomeDrawerContainer mHomeDrawerContainer;
    /* access modifiers changed from: private */
    public HomeEventRegistry mHomeEventRegistry = new HomeEventRegistry();
    /* access modifiers changed from: private */
    public IHomeFeedEventListener mHomeFeedContainer;
    private IHomeFun mHomeFun = ((IHomeFun) ServiceManager.getService(IHomeFun.SERVICE_REFERENCE));
    /* access modifiers changed from: private */
    public IHomeEventListener mHomeHeaderContainer;
    /* access modifiers changed from: private */
    public HomeScrollView mHomeScrollView;
    public int mHomeState = 0;
    /* access modifiers changed from: private */
    public IHomeEventListener mHomeTopContainer;
    private boolean mHomepageVisible = false;
    private boolean mIsFeedsInited = false;
    /* access modifiers changed from: private */
    public boolean mIsGoingHome = false;
    /* access modifiers changed from: private */
    public MainContext mMainFragment;
    private boolean mVisibleToUser = true;

    public HomeView(Context context) {
        super(context);
    }

    public HomeView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public HomeView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        init();
        registerBusEvent();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        SpeedStatsManager.getInstance().addStatsTimeStamp(5000);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        SpeedStatsManager.getInstance().addStatsTimeStamp(5007);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        SpeedStatsManager.getInstance().addStatsTimeStamp(5008);
        super.onLayout(changed, left, top, right, bottom);
        SpeedStatsManager.getInstance().addStatsTimeStamp(5015);
    }

    private void registerBusEvent() {
        if (DEBUG) {
            Log.d(TAG, "——> registerBusEvent: ");
        }
        BdEventBus.Companion.getDefault().register(this, FeedFlowRefreshEvent.class, 1, new HomeView$$ExternalSyntheticLambda3(this));
        BdEventBus.Companion.getDefault().register(this, MainFeedPreLoadEvent.class, 1, new HomeView$$ExternalSyntheticLambda4(this));
        BdEventBus.Companion.getDefault().register(this, BackPressedEvent.class, 1, new HomeView$$ExternalSyntheticLambda5(this));
        BdEventBus.Companion.getDefault().lazyRegister(this, UiInitialReadyEvent.class, 1, new HomeView$$ExternalSyntheticLambda6(this));
        BdEventBus.Companion.getDefault().register(this, FeedFloatBtnRefreshEvent.class, 1, new HomeView$$ExternalSyntheticLambda7(this));
        BdEventBus.Companion.getDefault().register(this, FontSizeChangeMessage.class, 1, new Action<FontSizeChangeMessage>() {
            public void call(FontSizeChangeMessage fontSizeChangeMessage) {
                if (HomeView.this.mHomeTopContainer != null) {
                    HomeView.this.mHomeTopContainer.onFontSizeChanged();
                }
                if (HomeView.this.mHomeHeaderContainer != null) {
                    HomeView.this.mHomeHeaderContainer.onFontSizeChanged();
                }
                if (HomeView.this.mHomeFeedContainer != null) {
                    HomeView.this.mHomeFeedContainer.onFontSizeChanged();
                }
                if (HomeView.this.mHomeBackground != null) {
                    HomeView.this.mHomeBackground.onFontSizeChanged();
                }
                HomeView.this.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                    public void onGlobalLayout() {
                        HomeView.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                        if (HomeView.this.mHomeScrollView != null) {
                            HomeView.this.mHomeScrollView.onFontSizeChanged();
                        }
                    }
                });
                HomeView.this.requestLayout();
            }
        });
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$registerBusEvent$0$com-baidu-searchbox-home-feed-widget-HomeView  reason: not valid java name */
    public /* synthetic */ void m20134lambda$registerBusEvent$0$combaidusearchboxhomefeedwidgetHomeView(UiInitialReadyEvent uiInitialReadyEvent) {
        if (DEBUG) {
            Log.d(TAG, "——> call: Ui Initial Ready");
        }
        this.mHomeEventRegistry.dispatchLazyUiReady();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$registerBusEvent$1$com-baidu-searchbox-home-feed-widget-HomeView  reason: not valid java name */
    public /* synthetic */ void m20135lambda$registerBusEvent$1$combaidusearchboxhomefeedwidgetHomeView(FeedFloatBtnRefreshEvent feedFloatBtnRefreshEvent) {
        goToFeedFromImmersionWithAnimation();
    }

    public boolean isHomepageVisible() {
        return this.mHomepageVisible;
    }

    public boolean isHeaderVisible() {
        return this.mHeaderVisible;
    }

    public boolean isUiReady() {
        return this.mHasUiReady || IHomeApp.Impl.get().isMainActivityInitialUIReady();
    }

    public void notifyUiReady() {
        this.mHasUiReady = true;
    }

    public int getScrollState() {
        HomeScrollView homeScrollView = this.mHomeScrollView;
        if (homeScrollView == null) {
            return 0;
        }
        return homeScrollView.getScrollState();
    }

    @TimeSpendTrace
    private void init() {
        FadeDrawable.setGlobalFadingEnable(false);
        FeedSessionManager.getInstance().updateSessionIdInterval();
        SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.INIT_FEED_LIST_START_STAMP_KEY);
        IHomeFeedEventListener createHomeFeedContainer = HomePageRuntime.getHomeChildImpl().createHomeFeedContainer(this, getContext());
        this.mHomeFeedContainer = createHomeFeedContainer;
        this.mHomeEventRegistry.addObserver(createHomeFeedContainer);
        SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.INIT_FEED_LIST_END_STAMP_KEY);
        SpeedStatsManager.getInstance().addStatsTimeStamp(4003);
        IHomeEventListener createHomeHeaderContainer = HomePageRuntime.getHomeChildImpl().createHomeHeaderContainer(getContext(), this.mHomeFeedContainer.getFeedTabLayout());
        this.mHomeHeaderContainer = createHomeHeaderContainer;
        this.mHomeEventRegistry.addObserver(createHomeHeaderContainer);
        SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.HOME_VIEW_INIT_HEADER_END_STAMP_KEY);
        HomeScrollView homeScrollView = (HomeScrollView) findViewById(R.id.home_scrollview);
        this.mHomeScrollView = homeScrollView;
        homeScrollView.setHomeHeaderLayout(this.mHomeHeaderContainer.getView());
        this.mHomeScrollView.setOnStateChangeListener(new HomeView$$ExternalSyntheticLambda0(this));
        this.mHomeScrollView.setNestedScrollingEnabled(true);
        this.mHomeScrollView.setOnScrollChangeListener(new HomeScrollView.OnScrollChangeListener() {
            public void onScrollChange(int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                HomeView.this.mHomeEventRegistry.dispatchScrollChange(scrollX, scrollY, oldScrollX, oldScrollY, HomeView.this.mHomeScrollView.getYScrollPct((float) scrollY), HomeView.this.mHomeScrollView.getYScrollPctFromLogoTop((float) scrollY), HomeView.this.mHomeScrollView.getYScrollPctFromSearchBoxTop((float) scrollY));
                if (!HomeView.this.mIsGoingHome && HomeView.this.mHomeScrollView.isLaidOut() && !HomeView.this.mHomeScrollView.canScrollVertically(1) && HomeView.this.mHomeFeedContainer != null) {
                    HomeView.this.mHomeFeedContainer.setCurrentPullState(2);
                }
            }

            public void onScrollStateChange(int oldState, int newState) {
                if (newState == 0) {
                    HomeView.this.mHomeScrollView.autoScrollIfNeed();
                }
                HomeView.this.mHomeEventRegistry.dispatchScrollStateChange(oldState, newState);
            }
        });
        HomeContainer homeContainer = (HomeContainer) findViewById(R.id.home_container);
        this.mHomeContainer = homeContainer;
        homeContainer.addView(this.mHomeHeaderContainer.getView());
        this.mHomeContainer.addView(this.mHomeFeedContainer.getView(), new LinearLayout.LayoutParams(-1, -1));
        IHomeBg createHomeBackground = HomePageRuntime.getHomeChildImpl().createHomeBackground(getContext());
        this.mHomeBackground = createHomeBackground;
        this.mHomeEventRegistry.addObserver(createHomeBackground);
        addView(this.mHomeBackground.getView(), 0, new ViewGroup.LayoutParams(-1, -1));
        this.mHomeHeaderContainer.getView().addOnLayoutChangeListener(new HomeView$$ExternalSyntheticLambda1(this));
        HomeDrawerContainer homeDrawerContainer = (HomeDrawerContainer) findViewById(R.id.home_drawer);
        this.mHomeDrawerContainer = homeDrawerContainer;
        homeDrawerContainer.setOnScrollChangeListener(new HomeView$$ExternalSyntheticLambda2(this));
        if (PermissionManager.isPermissionDialogShowing()) {
            initHomeTopContainer();
        }
        initCommonEventListenerList();
        HomeTabManager tabManager = HomeTabManager.getInstance();
        if (tabManager != null) {
            boolean isRestoreHome = "Feed".equals(tabManager.getRestoreLaunchTag());
            boolean coldStart = this.isColdStart;
            boolean isRestoreFeedTop = checkNeedRestoreFeedTop(isRestoreHome);
            if (coldStart && isRestoreHome) {
                homeRestoreUbcEvent(isRestoreFeedTop);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$init$2$com-baidu-searchbox-home-feed-widget-HomeView  reason: not valid java name */
    public /* synthetic */ void m20131lambda$init$2$combaidusearchboxhomefeedwidgetHomeView(int state, boolean byTouch) {
        if (DEBUG) {
            Log.d(TAG, "——> onStateChange: " + state + "（0默认态1吸顶态）");
        }
        int i2 = this.mHomeState;
        if (i2 != state) {
            onHomeStateChanged(i2, state, byTouch);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$init$3$com-baidu-searchbox-home-feed-widget-HomeView  reason: not valid java name */
    public /* synthetic */ void m20132lambda$init$3$combaidusearchboxhomefeedwidgetHomeView(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
        this.mHomeBackground.invalidateIfNeed();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$init$4$com-baidu-searchbox-home-feed-widget-HomeView  reason: not valid java name */
    public /* synthetic */ void m20133lambda$init$4$combaidusearchboxhomefeedwidgetHomeView(int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
        IHomeBg iHomeBg = this.mHomeBackground;
        if (iHomeBg != null) {
            iHomeBg.invalidateIfNeed();
        }
    }

    private boolean checkNeedRestoreFeedTop(boolean isRestoreHome) {
        if (!this.isColdStart) {
            return false;
        }
        this.isColdStart = false;
        boolean ceilingSwitch = false;
        if (QuickPersistConfig.getInstance().getBoolean(QuickPersistConfigConst.KEY_LAUNCH_RESTORE_SWITCHER, false)) {
            ceilingSwitch = ColdLaunchRestoreManager.INSTANCE.getCeilingResumeSwitch();
        }
        if (AppConfig.isDebug()) {
            Log.d(TAG, "restore home: " + isRestoreHome + ", ceilingSwitch: " + ceilingSwitch);
        }
        if (!isRestoreHome || !ceilingSwitch) {
            boolean isReformOpen = RefreshRevolutionary.isReformOpen();
            boolean isForceHome = RefreshRevolutionary.isForceHome();
            if (!isReformOpen || isForceHome) {
                return false;
            }
        }
        if (QuickPersistConfig.getInstance().getInt(KEY_HOME_TOP_STATE, 0) != 2) {
            return false;
        }
        goToFeedWithoutAnim(new CeilingScene("silence_ceiling"));
        return true;
    }

    /* access modifiers changed from: private */
    public void initHomeTopContainer() {
        if (this.mHomeTopContainer == null && this.mHomeState == 0) {
            IHomeEventListener createHomeTopContainer = HomePageRuntime.getHomeChildImpl().createHomeTopContainer(getContext());
            this.mHomeTopContainer = createHomeTopContainer;
            this.mHomeEventRegistry.addObserver(createHomeTopContainer);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            if (ImmersionHelper.SUPPORT_IMMERSION) {
                layoutParams.topMargin = HomeDimenManager.INSTANCE.getStatusBarHeight();
            }
            addView(this.mHomeTopContainer.getView(), layoutParams);
        }
    }

    @TimeSpendTrace
    public void onResume() {
        if (DEBUG) {
            Log.d(TAG, PluginInvokerConstants.METHOD_ACTIVITY_ONRESUME);
        }
        this.mHasPaused = false;
        if (!this.mIsFeedsInited || !this.mHasDrawed) {
            resetDrawCount();
        } else if (!PermissionManager.isPermissionDialogShowing()) {
            homeShowUbcEvent();
            this.mHomeEventRegistry.dispatchResumeEvent();
            dispatchHomeVisibility();
        }
    }

    private void initCommonEventListenerList() {
        if (!this.mHasInitCommonEventListenerList && this.mHomeEventRegistry != null) {
            for (IHomeEventListener listener : HomePageRuntime.getHomeChildImpl().createCommonHomeEventListenerList(getContext())) {
                this.mHomeEventRegistry.addObserver(listener);
            }
            this.mHasInitCommonEventListenerList = true;
        }
    }

    private void homeShowUbcEvent() {
        String type = "home";
        HomeScrollView homeScrollView = this.mHomeScrollView;
        if (homeScrollView != null && 2 == homeScrollView.getCurrentState()) {
            type = "feed";
        }
        ubcHomeDisplay(type);
    }

    public void setUserVisibleHint(boolean isVisibleToUser) {
        boolean z = DEBUG;
        if (z) {
            Log.d(TAG, "setUserVisibleHint : " + isVisibleToUser);
        }
        this.mVisibleToUser = isVisibleToUser;
        if (!PermissionManager.isPermissionDialogShowing()) {
            this.mHomeEventRegistry.dispatchUserVisibleHintEvent(isVisibleToUser);
            if (z) {
                Log.d(TAG, "------------------>setUserVisibleHint: " + isVisibleToUser + " mHasPaused " + this.mHasPaused + ", mHomeState " + this.mHomeState);
            }
            dispatchHomeVisibility();
        }
    }

    public void onPause() {
        this.mHasPaused = true;
        if (DEBUG) {
            Log.d(TAG, "onPause");
        }
        FadeDrawable.setGlobalFadingEnable(true);
        cleanPreloadResources();
        if (!PermissionManager.isPermissionDialogShowing()) {
            this.mHomeEventRegistry.dispatchPauseEvent();
            dispatchHomeVisibility();
        }
    }

    public boolean isHomeTabShow() {
        MainContext mainContext = this.mMainFragment;
        if (mainContext == null || !mainContext.isHome()) {
            return false;
        }
        return true;
    }

    public boolean gotoHome() {
        if (this.mHomeScrollView != null && !IHomeApp.Impl.get().enterSugAnimRunning()) {
            if (!this.mHomeScrollView.isTop()) {
                if (DEBUG) {
                    Log.d(TAG, "mHomdScrollView.getScrollY = " + this.mHomeScrollView.getScrollY());
                }
                ValueAnimator animator = ValueAnimator.ofInt(new int[]{this.mHomeScrollView.getScrollY(), 0});
                animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator animation) {
                        int scrollY = ((Integer) animation.getAnimatedValue()).intValue();
                        if (HomeView.DEBUG) {
                            Log.d(HomeView.TAG, "scrollY = " + scrollY);
                        }
                        HomeView.this.mHomeScrollView.setScrollState(2);
                        HomeView.this.mHomeScrollView.scrollTo(0, scrollY);
                    }
                });
                animator.setDuration(200);
                animator.addListener(new Animator.AnimatorListener() {
                    public void onAnimationStart(Animator animation) {
                        boolean unused = HomeView.this.mIsGoingHome = true;
                        if (HomeView.this.mHomeFeedContainer != null) {
                            HomeView.this.mHomeFeedContainer.forceOnHomeIfNeed();
                        }
                    }

                    public void onAnimationEnd(Animator animation) {
                        boolean unused = HomeView.this.mIsGoingHome = false;
                        HomeView.this.mHomeScrollView.setScrollState(0);
                        HomeView.this.mHomeScrollView.changeState(0, false);
                    }

                    public void onAnimationCancel(Animator animation) {
                    }

                    public void onAnimationRepeat(Animator animation) {
                    }
                });
                animator.start();
                this.mHomeFeedContainer.playHideManageTabBtnAnimIfNeed();
                this.mHomeFeedContainer.hideFloatRefreshBtn();
                return true;
            }
            IHomeFeedEventListener iHomeFeedEventListener = this.mHomeFeedContainer;
            if (!(iHomeFeedEventListener == null || iHomeFeedEventListener.getFeedViewPager() == null)) {
                TabController.INSTANCE.setHomeState(0);
                IHomeFeedEventListener iHomeFeedEventListener2 = this.mHomeFeedContainer;
                if (iHomeFeedEventListener2 != null) {
                    iHomeFeedEventListener2.forceOnHomeIfNeed();
                }
                this.mHomeFeedContainer.getFeedViewPager().setCurrentItem(TabController.INSTANCE.getDefaultTabPos());
            }
        }
        return false;
    }

    public void goToFeedWithAnim(CeilingScene ceilingScene) {
        FeedStatisticCenter.ubcGotoFeedCall(ceilingScene.getSource());
        if (this.mHomeState != 2 && this.mHomeScrollView.getScrollRange() != 0) {
            IHomeFeedEventListener iHomeFeedEventListener = this.mHomeFeedContainer;
            if (iHomeFeedEventListener != null) {
                iHomeFeedEventListener.setCurrentPullState(2);
            }
            this.mHomeScrollView.setCeilingSource(ceilingScene);
            ValueAnimator animator = ValueAnimator.ofInt(new int[]{0, this.mHomeScrollView.getScrollRangeHomeToFeedUndifferentiated()});
            animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator animation) {
                    int scrollY = ((Integer) animation.getAnimatedValue()).intValue();
                    HomeView.this.mHomeScrollView.setScrollState(2);
                    HomeView.this.mHomeScrollView.scrollTo(0, scrollY);
                }
            });
            animator.setDuration(500);
            animator.setInterpolator(new AccelerateDecelerateInterpolator());
            animator.addListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animation) {
                    HomeView.this.mHomeScrollView.setScrollState(0);
                }
            });
            animator.start();
        }
    }

    private void goToFeedFromImmersionWithAnimation() {
        if (this.mHomeState == 3) {
            ValueAnimator valueAnimator = ValueAnimator.ofInt(new int[]{this.mHomeScrollView.getScrollY(), this.mHomeScrollView.getScrollRangeHomeToFeed()});
            valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator animation) {
                    int scrollY = ((Integer) animation.getAnimatedValue()).intValue();
                    HomeView.this.mHomeScrollView.setScrollState(2);
                    HomeView.this.mHomeScrollView.scrollTo(0, scrollY);
                }
            });
            valueAnimator.setDuration(200);
            valueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
            valueAnimator.addListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animation) {
                    HomeView.this.mHomeScrollView.setScrollState(0);
                }
            });
            valueAnimator.start();
        }
    }

    public boolean gotoTopWithoutAnim() {
        this.mHomeFeedContainer.playHideManageTabBtnAnimIfNeed();
        IHomeFeedEventListener iHomeFeedEventListener = this.mHomeFeedContainer;
        if (iHomeFeedEventListener != null) {
            iHomeFeedEventListener.forceOnHomeIfNeed();
        }
        HomeScrollView homeScrollView = this.mHomeScrollView;
        if (homeScrollView != null) {
            return homeScrollView.goTopNoAnim();
        }
        return false;
    }

    public void goToFeedWithoutAnim(CeilingScene ceilingScene) {
        FeedStatisticCenter.ubcGotoFeedCall(ceilingScene.getSource());
        if (this.mHomeState != 2) {
            this.mHomeScrollView.setCeilingSource(ceilingScene);
            this.mHomeScrollView.goFeedNoAnim();
        }
    }

    public void goToFeedWithoutAnimOnlyInHome(CeilingScene ceilingSource) {
        if (this.mHomeState == 0) {
            goToFeedWithoutAnim(ceilingSource);
        }
    }

    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (MotionEventCompat.getActionMasked(ev) == 0) {
            this.mHomeEventRegistry.dispatchTouchDown();
        }
        return super.dispatchTouchEvent(ev);
    }

    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if (this.mIsGoingHome || !this.mVisibleToUser) {
            return true;
        }
        return super.onInterceptTouchEvent(ev);
    }

    public boolean keyUp(int keyCode, KeyEvent event) {
        return this.mHomeEventRegistry.dispatchKeyUpEvent(keyCode, event);
    }

    public boolean keyDown(int keyCode, KeyEvent event) {
        return this.mHomeEventRegistry.dispatchKeyDownEvent(keyCode, event);
    }

    private void cleanPreloadResources() {
        if (!this.mCleanPreloadActionCalled) {
            this.mCleanPreloadActionCalled = true;
            IHomeApp.Impl.get().clearPreloadResourcesIfReady();
        }
    }

    public void onDestroy() {
        this.mHomeEventRegistry.dispatchDestoryEvent();
        BdEventBus.Companion.getDefault().unregister(this);
        HomeViewManager.releaseInstanceWithSameContext(getContext());
        PopupExclusionManagerMap.getInstance().removeAll();
    }

    public void setMainFragment(MainContext main) {
        this.mMainFragment = main;
    }

    public void resetDrawCount() {
        this.mDrawCount = 0;
        invalidate();
    }

    /* access modifiers changed from: private */
    public void onFirstDrawDispatched() {
        SpeedStatsManager.getInstance().addStatsTimeStamp(5018);
        if (DEBUG) {
            Log.d(TAG, "onFirstDrawDispatched");
        }
        checkIfFeedFlowReady();
        SpeedStatsManager.getInstance().addStatsTimeStamp(5019);
    }

    /* access modifiers changed from: private */
    @TimeSpendTrace
    public void onSecondDrawDispatched() {
        if (this.mIsFeedsInited) {
            initHomeTopContainer();
            if (!PermissionManager.isPermissionDialogShowing()) {
                this.mMainFragment.notifyInitialUIReady();
                notifyUiReady();
                if (!this.mHasPaused) {
                    onResume();
                }
            }
        }
    }

    private void apsarasOnSecondDrawDisaptch() {
        if (DEBUG) {
            Log.d(TAG, "apsarasOnSecondDrawDisaptch");
        }
        if (this.mIsFeedsInited) {
            ParticleScope particleScope = ParticleScopeKt.contextScope(ParticleDispatchers.Main.plus(ParticleGroup.fromUriPath("/home/uiready")).plus(ParticleOrder.ofScopeOrder()));
            particleScope.launch(new Particle() {
                public void invoke() {
                    HomeView.this.initHomeTopContainer();
                    if (!PermissionManager.isPermissionDialogShowing()) {
                        HomeView.this.mMainFragment.notifyInitialUIReady();
                        HomeView.this.notifyUiReady();
                    }
                }
            });
            particleScope.launch(new Particle() {
                public void invoke() {
                    if (!HomeView.this.mHasPaused) {
                        HomeView.this.onResume();
                    }
                }
            });
        }
    }

    private void checkIfFeedFlowReady() {
        if (!this.mIsFeedsInited && FeedApi.getColdBooter().isFlowCachesReady()) {
            this.mIsFeedsInited = true;
            resetDrawCount();
        }
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        SpeedStatsManager.getInstance().addStatsTimeStamp(5016);
        super.dispatchDraw(canvas);
        SpeedStatsManager.getInstance().addStatsTimeStamp(5017);
        if (this.mDrawCount == 0) {
            if (!this.mHasDrawed) {
                this.mHasDrawed = true;
                if (LaunchABUtils.getApsarasFeedFixEnable() || FeedApi.getColdBooter().isIgnoreLoadDb()) {
                    this.mIsFeedsInited = FeedApi.getColdBooter().isFlowCachesReady();
                }
                if (DEBUG) {
                    Log.d(TAG, "first frame ready:" + this.mIsFeedsInited);
                }
            }
            if (this.mIsFeedsInited) {
                SpeedStats.getInstance().onMainPageStatsEnd(getContext());
                if (LaunchABUtils.getApsarasUIReadySwitch()) {
                    apsarasOnSecondDrawDisaptch();
                } else {
                    post(new Runnable() {
                        public void run() {
                            HomeView.this.onSecondDrawDispatched();
                        }
                    });
                }
            } else {
                post(new Runnable() {
                    public void run() {
                        HomeView.this.onFirstDrawDispatched();
                    }
                });
            }
            this.mDrawCount++;
        }
    }

    public void handleMainFeedPreLoadEvent(MainFeedPreLoadEvent event) {
        boolean hasFeedData = false;
        if (!(event == null || event.historyFeeds == null)) {
            hasFeedData = event.historyFeeds.size() > 0;
        }
        IHomeFeedEventListener iHomeFeedEventListener = this.mHomeFeedContainer;
        if (iHomeFeedEventListener != null && iHomeFeedEventListener.getFeedViewPager() != null && hasFeedData) {
            checkIfFeedFlowReady();
        }
    }

    public void handleBackPressedEvent(BackPressedEvent backPressedEvent) {
        gotoHome();
    }

    public void handleFeedFlowRefreshEvent(FeedFlowRefreshEvent event) {
        if (event != null && event.state == 0) {
            int refreshCount = event.refreshCount;
            if (refreshCount <= 0 || this.mHomeDrawerContainer != null) {
                SpeedStats.getInstance().setFeedDataType(refreshCount > 0 ? 1 : -1);
            } else {
                return;
            }
        }
        checkIfFeedFlowReady();
    }

    private void onHomeStateChanged(int oldState, int newState, boolean byTouch) {
        if (DEBUG) {
            Log.d(TAG, "onHomeStateChanged oldState: " + oldState + ", newState: " + newState + ", byTouch: " + byTouch);
        }
        String statType = null;
        int stateFlag = 0;
        if (newState == 2) {
            if (oldState == 0) {
                stateFlag = 2;
                statType = "feed";
                FadeDrawable.setGlobalFadingEnable(true);
            }
        } else if (newState == 0) {
            statType = "home";
            stateFlag = 1;
        }
        this.mHomeState = newState;
        QuickPersistConfig.getInstance().putInt(KEY_HOME_TOP_STATE, newState);
        initHomeTopContainer();
        this.mHomeEventRegistry.dispatchHomeStateChanged(oldState, newState, byTouch);
        BdEventBus.Companion.getDefault().post(new StateChangedEvent(stateFlag));
        if (!TextUtils.isEmpty(statType)) {
            ubcHomeDisplay(statType);
        }
        if (updateHeaderVisibility()) {
            this.mHomeEventRegistry.dispatchHomeHeaderVisible(this.mHeaderVisible);
        }
        TabController.INSTANCE.setHomeState(newState);
    }

    public static boolean hasConfirmUseMobileData() {
        return mHasConfirmUseMobileData;
    }

    public static void setHasConfirmUseMobileData(boolean hasConfirmUseMobileData) {
        mHasConfirmUseMobileData = hasConfirmUseMobileData;
    }

    private void ubcHomeDisplay(String statType) {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("type", statType);
            jsonObject.put("session_id", FeedSessionManager.getInstance().getSessionId());
            jsonObject.put("click_id", FeedSessionManager.getInstance().getClickId());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        UBC.onEvent("105", jsonObject.toString());
    }

    private void homeRestoreUbcEvent(boolean isRestoreFeedTop) {
        LaunchRestoreUBCRuntime.INSTANCE.getLaunchRestoreUBC().onPageStart(1, (JSONObject) null);
        String extValue = "no";
        if (isRestoreFeedTop) {
            extValue = "yes";
        }
        JSONObject ext = new JSONObject();
        try {
            ext.put(LaunchRestoreUBCKt.EXT_XIDING, extValue);
        } catch (JSONException e2) {
            if (AppConfig.isDebug()) {
                e2.printStackTrace();
            }
        }
        LaunchRestoreUBCRuntime.INSTANCE.getLaunchRestoreUBC().onPageShow(1, ext);
    }

    public int getHomeState() {
        return this.mHomeState;
    }

    public View getHomeContainer() {
        return this.mHomeContainer;
    }

    public IHomeBg getHomeBackground() {
        return this.mHomeBackground;
    }

    public IHomeFeedEventListener getHomeFeedContainer() {
        return this.mHomeFeedContainer;
    }

    private void dispatchHomeVisibility() {
        boolean needUpdatePageVisibility = updateHomePageVisibility();
        boolean needUpdateHeaderVisibility = updateHeaderVisibility();
        if (needUpdatePageVisibility) {
            this.mHomeEventRegistry.dispatchHomePageVisible(this.mHomepageVisible);
        }
        if (needUpdateHeaderVisibility) {
            this.mHomeEventRegistry.dispatchHomeHeaderVisible(this.mHeaderVisible);
        }
    }

    private boolean updateHomePageVisibility() {
        if (this.mHomepageVisible == getCurrHomeVisibility()) {
            return false;
        }
        this.mHomepageVisible = getCurrHomeVisibility();
        NewThemeManager.getInstance().onHomePageVisible(this.mHomepageVisible);
        return true;
    }

    private boolean getCurrHomeVisibility() {
        return this.mVisibleToUser && !this.mHasPaused && isHomeTabShow();
    }

    private boolean updateHeaderVisibility() {
        boolean z = this.mHeaderVisible;
        boolean z2 = this.mHomepageVisible;
        boolean z3 = false;
        if (z == (z2 && this.mHomeState == 0)) {
            return false;
        }
        if (z2 && this.mHomeState == 0) {
            z3 = true;
        }
        this.mHeaderVisible = z3;
        return true;
    }

    public void onNightModeChanged(boolean isNightMode) {
        if (DEBUG) {
            Log.d("HomeFeedView", "——> onNightModeChanged: " + isNightMode);
        }
        cleanPreloadResources();
        NewThemeManager.getInstance().onNightModeChanged();
        this.mHomeEventRegistry.dispatchNightModeChanged(isNightMode);
    }

    public HomeDrawerContainer getHomeDrawerContainer() {
        return this.mHomeDrawerContainer;
    }

    public HomeScrollView getHomeScrollView() {
        return this.mHomeScrollView;
    }

    public int getHomeHeaderHeight() {
        IHomeEventListener iHomeEventListener = this.mHomeHeaderContainer;
        if (iHomeEventListener == null || iHomeEventListener.getView() == null) {
            return 0;
        }
        return this.mHomeHeaderContainer.getView().getMeasuredHeight();
    }

    public int getFeedTabHeight() {
        IHomeFeedEventListener iHomeFeedEventListener = this.mHomeFeedContainer;
        if (iHomeFeedEventListener == null || !(iHomeFeedEventListener.getFeedTabLayout() instanceof FeedTabLayout)) {
            return FeedRuntime.getFeedContext().getFeedTabHeight();
        }
        return ((FeedTabLayout) this.mHomeFeedContainer.getFeedTabLayout()).getCurFeedTabHeight();
    }

    public void onWarmPermissionDialogConfirm() {
        if (this.mIsFeedsInited) {
            this.mMainFragment.notifyInitialUIReady();
            notifyUiReady();
            if (!this.mHasPaused) {
                onResume();
            }
        }
        this.mHomeEventRegistry.dispatchPermissionDialogConfirmEvent();
    }

    public boolean dispatchStatusBarTap() {
        return false;
    }

    public boolean tryScrollFromImmersionToFeed(int scrollState, float scrollProgress) {
        if (this.mHomeState != 3) {
            return false;
        }
        int scrollRange = this.mHomeScrollView.getScrollRange();
        this.mHomeScrollView.setScrollState(scrollState);
        this.mHomeScrollView.scrollTo(0, scrollRange - ((int) (((float) HomeDimenManager.INSTANCE.getImmersionScrollHeight()) * scrollProgress)));
        return true;
    }
}
