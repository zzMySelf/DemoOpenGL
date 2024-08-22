package com.baidu.searchbox.padhome;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.baidu.android.common.PermissionManager;
import com.baidu.apsaras.scheduler.EmptyParticleContext;
import com.baidu.apsaras.scheduler.ParticleDispatchers;
import com.baidu.apsaras.scheduler.ParticleGroup;
import com.baidu.apsaras.scheduler.ParticleOrder;
import com.baidu.apsaras.scheduler.ParticleScope;
import com.baidu.apsaras.scheduler.ParticleScopeKt;
import com.baidu.launch.LaunchABUtils;
import com.baidu.pyramid.annotation.tekes.StableApi;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.appframework.BaseActivity;
import com.baidu.searchbox.appframework.MainContext;
import com.baidu.searchbox.appframework.pad.PadUtilsKt;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.config.eventmessage.FontSizeChangeMessage;
import com.baidu.searchbox.config.eventmessage.HomeTabClickEvent;
import com.baidu.searchbox.feed.FeedApi;
import com.baidu.searchbox.feed.event.BackPressedEvent;
import com.baidu.searchbox.feed.event.FeedFloatBtnRefreshEvent;
import com.baidu.searchbox.feed.event.FeedFlowRefreshEvent;
import com.baidu.searchbox.feed.event.MainFeedPreLoadEvent;
import com.baidu.searchbox.feed.tab.model.TabController;
import com.baidu.searchbox.feed.util.FeedSessionManager;
import com.baidu.searchbox.home.AbsHomeView;
import com.baidu.searchbox.home.event.UiInitialReadyEvent;
import com.baidu.searchbox.home.ioc.HomeRuntime;
import com.baidu.searchbox.home.util.ViewToolsKt;
import com.baidu.searchbox.kmm.home.pad.PadHomeUbcKt;
import com.baidu.searchbox.newhomepage.R;
import com.baidu.searchbox.padhome.event.PadHomeSizeChangeEvent;
import com.baidu.searchbox.padhome.impl.FeedViewImpl;
import com.baidu.searchbox.padhome.impl.SearchViewImpl;
import com.baidu.searchbox.padhome.ioc.IPadHomeApp;
import com.baidu.searchbox.padhome.ioc.PadHomeRuntime;
import com.baidu.searchbox.padhome.listener.PadHomeBusinessListener;
import com.baidu.searchbox.padhome.utils.PadViewUtilsKt;
import com.baidu.searchbox.padhome.yalog.PadHomeYaLog;
import com.baidu.searchbox.performance.speed.SpeedStats;
import com.baidu.searchbox.security.WarmTipsManager;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0019\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0002J\u000e\u0010&\u001a\u00020#2\u0006\u0010'\u001a\u00020(J\u0012\u0010)\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0002J\b\u0010*\u001a\u00020#H\u0002J\b\u0010+\u001a\u00020#H\u0002J\b\u0010,\u001a\u00020#H\u0002J\u0010\u0010-\u001a\u00020#2\u0006\u0010.\u001a\u00020/H\u0014J\b\u00100\u001a\u00020#H\u0002J\"\u00101\u001a\u00020#2\u0006\u00102\u001a\u00020\f2\u0006\u00103\u001a\u00020\f2\b\b\u0002\u00104\u001a\u00020\nH\u0002J\b\u00105\u001a\u00020\nH\u0002J\b\u00106\u001a\u00020\fH\u0016J\b\u00107\u001a\u00020#H\u0007J\u0012\u00108\u001a\u00020#2\b\u00109\u001a\u0004\u0018\u00010:H\u0002J\u0012\u0010;\u001a\u00020#2\b\u00109\u001a\u0004\u0018\u00010<H\u0002J\b\u0010=\u001a\u00020#H\u0002J\b\u0010>\u001a\u00020\nH\u0002J\u0006\u0010?\u001a\u00020\nJ\u0006\u0010@\u001a\u00020\nJ\u0006\u0010A\u001a\u00020\nJ\u001a\u0010B\u001a\u00020\n2\u0006\u0010C\u001a\u00020\f2\b\u00109\u001a\u0004\u0018\u00010DH\u0016J\u001a\u0010E\u001a\u00020\n2\u0006\u0010C\u001a\u00020\f2\b\u00109\u001a\u0004\u0018\u00010DH\u0016J\b\u0010F\u001a\u00020#H\u0002J\u0012\u0010G\u001a\u00020#2\b\u0010H\u001a\u0004\u0018\u00010IH\u0014J\b\u0010J\u001a\u00020#H\u0016J\b\u0010K\u001a\u00020#H\u0014J\b\u0010L\u001a\u00020#H\u0002J\u0010\u0010M\u001a\u00020#2\u0006\u0010N\u001a\u00020\nH\u0016J\b\u0010O\u001a\u00020#H\u0016J\b\u0010P\u001a\u00020#H\u0016J\b\u0010Q\u001a\u00020#H\u0002J(\u0010R\u001a\u00020#2\u0006\u0010S\u001a\u00020\f2\u0006\u0010T\u001a\u00020\f2\u0006\u0010U\u001a\u00020\f2\u0006\u0010V\u001a\u00020\fH\u0014J\u0006\u0010W\u001a\u00020#J\b\u0010X\u001a\u00020#H\u0002J\b\u0010Y\u001a\u00020#H\u0002J\u000e\u0010Z\u001a\u00020#2\u0006\u0010[\u001a\u00020\fJ\u001e\u0010\\\u001a\u00020#2\u0014\u0010]\u001a\u0010\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u001eH\u0016J\u0010\u0010^\u001a\u00020#2\u0006\u0010_\u001a\u00020\nH\u0016J\b\u0010`\u001a\u00020#H\u0002J\b\u0010a\u001a\u00020#H\u0002R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001d\u001a\u0010\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u001eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000¨\u0006b"}, d2 = {"Lcom/baidu/searchbox/padhome/PadHomeView;", "Lcom/baidu/searchbox/home/AbsHomeView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mActivity", "Lcom/baidu/searchbox/appframework/BaseActivity;", "mCleanPreloadActionCalled", "", "mDrawCount", "", "mFeedViewContainer", "Landroid/view/View;", "mFeedViewExt", "Lcom/baidu/searchbox/padhome/IPadHomeEventExt;", "mHasDraw", "mHasNoticeUiReady", "mHasPaused", "mHasUiReady", "mHomeContainer", "Lcom/baidu/searchbox/padhome/PadHomeMainContainer;", "mHomeEventRegistry", "Lcom/baidu/searchbox/padhome/PadHomeEventRegistry;", "mHomePageVisible", "mHomeState", "mIsFeedsInit", "mIsPadHorizontal", "mMainFragment", "Lcom/baidu/searchbox/appframework/MainContext;", "mSearchViewContainer", "mSearchViewExt", "mVisibleToUser", "addFeedView", "", "childFragmentManager", "Landroidx/fragment/app/FragmentManager;", "addPadHomeEventListener", "listener", "Lcom/baidu/searchbox/padhome/IPadHomeEventListener;", "addSearchContainer", "apsarasOnSecondDrawDispatch", "checkIfFeedFlowReady", "cleanPreloadResources", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", "dispatchHomeVisibility", "dispatchStateChanged", "oldState", "newState", "byTouch", "getCurrHomeVisibility", "getHomeState", "goToTop", "handleFeedFlowRefreshEvent", "event", "Lcom/baidu/searchbox/feed/event/FeedFlowRefreshEvent;", "handleMainFeedPreLoadEvent", "Lcom/baidu/searchbox/feed/event/MainFeedPreLoadEvent;", "initView", "isHomePageVisibleChanged", "isHomeTabShow", "isHomepageVisible", "isUIReady", "keyDown", "keyCode", "Landroid/view/KeyEvent;", "keyUp", "noticeUiReady", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onDestroy", "onFinishInflate", "onFirstDrawDispatched", "onNightModeChanged", "isNightMode", "onPause", "onResume", "onSecondDrawDispatched", "onSizeChanged", "width", "height", "oldw", "oldh", "onWarmPermissionDialogConfirm", "registerListeners", "resetDrawCount", "setHomeState", "homeState", "setMainFragment", "main", "setUserVisibleHint", "isVisibleToUser", "tryToNoticeUiReady", "ubcHomeShowEvent", "pad-home-page_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PadHomeView.kt */
public final class PadHomeView extends AbsHomeView {
    public Map<Integer, View> _$_findViewCache;
    private BaseActivity mActivity;
    private boolean mCleanPreloadActionCalled;
    private int mDrawCount;
    private View mFeedViewContainer;
    private IPadHomeEventExt mFeedViewExt;
    private boolean mHasDraw;
    private boolean mHasNoticeUiReady;
    private boolean mHasPaused;
    private boolean mHasUiReady;
    private PadHomeMainContainer mHomeContainer;
    private final PadHomeEventRegistry mHomeEventRegistry;
    private boolean mHomePageVisible;
    private int mHomeState;
    private boolean mIsFeedsInit;
    private boolean mIsPadHorizontal;
    private MainContext<?, ?, ?> mMainFragment;
    private View mSearchViewContainer;
    private IPadHomeEventExt mSearchViewExt;
    private boolean mVisibleToUser;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public PadHomeView(Context context) {
        this(context, (AttributeSet) null, 2, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    public View _$_findCachedViewById(int i2) {
        Map<Integer, View> map = this._$_findViewCache;
        View view2 = map.get(Integer.valueOf(i2));
        if (view2 != null) {
            return view2;
        }
        View findViewById = findViewById(i2);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PadHomeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.checkNotNullParameter(context, "context");
        this._$_findViewCache = new LinkedHashMap();
        this.mVisibleToUser = true;
        this.mDrawCount = -1;
        this.mHomeEventRegistry = new PadHomeEventRegistry();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PadHomeView(Context context, AttributeSet attributeSet, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        PadHomeYaLog.INSTANCE.log("onFinishInflate");
        this.mHomeContainer = (PadHomeMainContainer) findViewById(R.id.home_container);
        this.mHomeEventRegistry.clear();
        setPadding(0, PadViewUtilsKt.getStatusBarHeight() + PadViewUtilsKt.getPadTopMargin(), 0, 0);
        setBackgroundColor(getContext().getResources().getColor(com.baidu.android.common.ui.style.R.color.GC86));
        initView();
        registerListeners();
    }

    private final void initView() {
        if (getChildCount() == 1) {
            PadHomeMainContainer padHomeMainContainer = this.mHomeContainer;
            if (padHomeMainContainer != null) {
                padHomeMainContainer.removeAllViews();
            }
        } else {
            removeAllViews();
            addView(ViewToolsKt.removeParentIfNeed(this.mHomeContainer));
        }
        Context context = getContext();
        if (context != null) {
            BaseActivity baseActivity = (BaseActivity) context;
            this.mActivity = baseActivity;
            FragmentManager childFragmentManager = null;
            FragmentManager fragmentManager = baseActivity != null ? baseActivity.getSupportFragmentManager() : null;
            Fragment homeFragment = fragmentManager != null ? fragmentManager.findFragmentByTag("Feed") : null;
            if (homeFragment != null) {
                childFragmentManager = homeFragment.getChildFragmentManager();
            }
            this.mIsPadHorizontal = PadUtilsKt.isPadHorizontal(this.mActivity);
            addFeedView(childFragmentManager);
            addSearchContainer(childFragmentManager);
            setPadding(PadViewUtilsKt.getPadTabWidth(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.baidu.searchbox.appframework.BaseActivity");
    }

    private final void addFeedView(FragmentManager childFragmentManager) {
        IPadHomeEventExt feedViewImpl = new FeedViewImpl();
        this.mFeedViewExt = feedViewImpl;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        View view2 = feedViewImpl.getView(this, context, childFragmentManager, this.mIsPadHorizontal);
        if (view2 != null) {
            View $this$addFeedView_u24lambda_u2d0 = view2;
            PadHomeMainContainer padHomeMainContainer = this.mHomeContainer;
            if (padHomeMainContainer != null) {
                padHomeMainContainer.addView($this$addFeedView_u24lambda_u2d0);
            }
        } else {
            view2 = null;
        }
        this.mFeedViewContainer = view2;
    }

    private final void addSearchContainer(FragmentManager childFragmentManager) {
        PadHomeMainContainer padHomeMainContainer;
        IPadHomeEventExt searchViewImpl = new SearchViewImpl();
        this.mSearchViewExt = searchViewImpl;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        View $this$addSearchContainer_u24lambda_u2d1 = searchViewImpl.getView(this, context, childFragmentManager, this.mIsPadHorizontal);
        this.mSearchViewContainer = $this$addSearchContainer_u24lambda_u2d1;
        if ($this$addSearchContainer_u24lambda_u2d1 != null && (padHomeMainContainer = this.mHomeContainer) != null) {
            padHomeMainContainer.addView($this$addSearchContainer_u24lambda_u2d1);
        }
    }

    private final void tryToNoticeUiReady() {
        if (!this.mHasNoticeUiReady && WarmTipsManager.isPermissionGrantedForProcess()) {
            noticeUiReady();
        }
    }

    private final void noticeUiReady() {
        if (isHomepageVisible()) {
            this.mHasNoticeUiReady = true;
            this.mHomeEventRegistry.dispatchLazyUiReady();
            PadHomeYaLog.INSTANCE.log("noticeUiReady");
        }
    }

    public final boolean isHomepageVisible() {
        return this.mHomePageVisible;
    }

    public void onResume() {
        this.mHasPaused = false;
        if (!this.mIsFeedsInit || !this.mHasDraw) {
            resetDrawCount();
        } else if (!PermissionManager.isPermissionDialogShowing()) {
            this.mHomeEventRegistry.dispatchResumeEvent();
            dispatchHomeVisibility();
        }
    }

    public void onPause() {
        this.mHasPaused = true;
        if (!PermissionManager.isPermissionDialogShowing()) {
            this.mHomeEventRegistry.dispatchPauseEvent();
            dispatchHomeVisibility();
            ubcHomeShowEvent();
        }
    }

    public void onDestroy() {
        BdEventBus.Companion.getDefault().unregister(this);
        this.mHomeEventRegistry.dispatchDestroyEvent();
        this.mHomeEventRegistry.clear();
        PadHomeMgr padHomeMgr = PadHomeMgr.INSTANCE;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        padHomeMgr.releaseInstanceWithSameContext(context);
    }

    public void setMainFragment(MainContext<?, ?, ?> main) {
        this.mMainFragment = main;
    }

    public final boolean isUIReady() {
        return this.mHasUiReady || HomeRuntime.INSTANCE.getHomeSupportContext().isMainActivityInitialUIReady();
    }

    private final void handleFeedFlowRefreshEvent(FeedFlowRefreshEvent event) {
        if (event != null && event.state == 0 && event.refreshCount <= 0) {
            SpeedStats.getInstance().setFeedDataType(-1);
        }
        checkIfFeedFlowReady();
    }

    private final void handleMainFeedPreLoadEvent(MainFeedPreLoadEvent event) {
        boolean hasFeedData = false;
        if ((event != null ? event.historyFeeds : null) != null) {
            hasFeedData = event.historyFeeds.size() > 0;
        }
        if (hasFeedData) {
            checkIfFeedFlowReady();
        }
    }

    private final void checkIfFeedFlowReady() {
        if (!this.mIsFeedsInit && FeedApi.getColdBooter().isFlowCachesReady()) {
            this.mIsFeedsInit = true;
            resetDrawCount();
        }
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.dispatchDraw(canvas);
        if (this.mDrawCount == 0) {
            if (!this.mHasDraw) {
                this.mHasDraw = true;
                if (LaunchABUtils.getApsarasFeedFixEnable() || FeedApi.getColdBooter().isIgnoreLoadDb()) {
                    this.mIsFeedsInit = FeedApi.getColdBooter().isFlowCachesReady();
                }
                if (PadViewUtilsKt.getPAD_DEBUG()) {
                    Log.d(PadHomeMgrKt.PAD_TAG, "first frame ready:" + this.mIsFeedsInit);
                }
            }
            if (this.mIsFeedsInit) {
                SpeedStats.getInstance().onMainPageStatsEnd(getContext());
                if (LaunchABUtils.getApsarasUIReadySwitch()) {
                    apsarasOnSecondDrawDispatch();
                } else {
                    post(new PadHomeView$$ExternalSyntheticLambda10(this));
                }
            } else {
                post(new PadHomeView$$ExternalSyntheticLambda1(this));
            }
            this.mDrawCount++;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: dispatchDraw$lambda-2  reason: not valid java name */
    public static final void m1854dispatchDraw$lambda2(PadHomeView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onSecondDrawDispatched();
    }

    /* access modifiers changed from: private */
    /* renamed from: dispatchDraw$lambda-3  reason: not valid java name */
    public static final void m1855dispatchDraw$lambda3(PadHomeView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onFirstDrawDispatched();
    }

    private final void onFirstDrawDispatched() {
        checkIfFeedFlowReady();
        if (PadViewUtilsKt.getPAD_DEBUG()) {
            Log.d(PadHomeMgrKt.PAD_TAG, "onFirstDrawDispatched");
        }
        PadHomeYaLog.INSTANCE.log("onFirstDrawDispatched");
    }

    private final void onSecondDrawDispatched() {
        if (PadViewUtilsKt.getPAD_DEBUG()) {
            Log.d(PadHomeMgrKt.PAD_TAG, "onSecondDrawDispatched");
        }
        if (this.mIsFeedsInit && !PermissionManager.isPermissionDialogShowing()) {
            MainContext<?, ?, ?> mainContext = this.mMainFragment;
            if (mainContext != null) {
                mainContext.notifyInitialUIReady();
            }
            if (!this.mHasNoticeUiReady) {
                this.mHasNoticeUiReady = true;
                this.mHomeEventRegistry.dispatchLazyUiReady();
            }
            this.mHasUiReady = true;
            if (!this.mHasPaused) {
                onResume();
            }
            PadHomeYaLog.INSTANCE.log("onSecondDrawDispatched");
        }
    }

    private final void apsarasOnSecondDrawDispatch() {
        if (PadViewUtilsKt.getPAD_DEBUG()) {
            Log.d(PadHomeMgrKt.PAD_TAG, "apsarasOnSecondDrawDispatch");
        }
        if (this.mIsFeedsInit) {
            ParticleScope particleScope = ParticleScopeKt.contextScope(ParticleDispatchers.Main.plus(ParticleGroup.Key.fromUriPath("/home/uiready")).plus(ParticleOrder.Key.ofScopeOrder()));
            particleScope.launch(EmptyParticleContext.INSTANCE, new PadHomeView$$ExternalSyntheticLambda8(this));
            particleScope.launch(EmptyParticleContext.INSTANCE, new PadHomeView$$ExternalSyntheticLambda9(this));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: apsarasOnSecondDrawDispatch$lambda-4  reason: not valid java name */
    public static final void m1852apsarasOnSecondDrawDispatch$lambda4(PadHomeView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!PermissionManager.isPermissionDialogShowing()) {
            MainContext<?, ?, ?> mainContext = this$0.mMainFragment;
            if (mainContext != null) {
                mainContext.notifyInitialUIReady();
            }
            this$0.mHasUiReady = true;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: apsarasOnSecondDrawDispatch$lambda-5  reason: not valid java name */
    public static final void m1853apsarasOnSecondDrawDispatch$lambda5(PadHomeView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!this$0.mHasPaused) {
            this$0.onResume();
        }
    }

    private final void resetDrawCount() {
        this.mDrawCount = 0;
        invalidate();
    }

    public void onNightModeChanged(boolean isNightMode) {
        cleanPreloadResources();
        setBackgroundColor(getContext().getResources().getColor(com.baidu.android.common.ui.style.R.color.GC86));
        this.mHomeEventRegistry.dispatchNightModeChanged(isNightMode);
    }

    public boolean keyUp(int keyCode, KeyEvent event) {
        return this.mHomeEventRegistry.dispatchKeyUpEvent(keyCode, event);
    }

    public boolean keyDown(int keyCode, KeyEvent event) {
        return this.mHomeEventRegistry.dispatchKeyDownEvent(keyCode, event);
    }

    public void setUserVisibleHint(boolean isVisibleToUser) {
        this.mVisibleToUser = isVisibleToUser;
        if (!PermissionManager.isPermissionDialogShowing()) {
            dispatchHomeVisibility();
        }
    }

    public final void setHomeState(int homeState) {
        if (this.mHomeState != homeState) {
            int oldState = this.mHomeState;
            this.mHomeState = homeState;
            dispatchStateChanged$default(this, oldState, homeState, false, 4, (Object) null);
            PadHomeYaLog.INSTANCE.log("setHomeState: " + this.mHomeState);
            if (PadViewUtilsKt.getPAD_DEBUG()) {
                Log.d(PadHomeMgrKt.PAD_TAG, "PadHomeState(0: Home, 2: Feed): " + this.mHomeState);
            }
        }
    }

    static /* synthetic */ void dispatchStateChanged$default(PadHomeView padHomeView, int i2, int i3, boolean z, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            z = false;
        }
        padHomeView.dispatchStateChanged(i2, i3, z);
    }

    private final void dispatchStateChanged(int oldState, int newState, boolean byTouch) {
        this.mHomeEventRegistry.dispatchHomeStateChanged(oldState, newState, byTouch);
    }

    private final void dispatchHomeVisibility() {
        if (isHomePageVisibleChanged()) {
            if (this.mHomePageVisible) {
                tryToNoticeUiReady();
            }
            this.mHomeEventRegistry.dispatchHomePageVisible(this.mHomePageVisible);
        }
    }

    private final boolean isHomePageVisibleChanged() {
        boolean isCurrHomeVisibility = getCurrHomeVisibility();
        if (this.mHomePageVisible == isCurrHomeVisibility) {
            return false;
        }
        this.mHomePageVisible = isCurrHomeVisibility;
        return true;
    }

    private final boolean getCurrHomeVisibility() {
        return this.mVisibleToUser && !this.mHasPaused && isHomeTabShow();
    }

    public final boolean isHomeTabShow() {
        MainContext<?, ?, ?> mainContext = this.mMainFragment;
        if (mainContext != null) {
            return mainContext.isHome();
        }
        return false;
    }

    public final void onWarmPermissionDialogConfirm() {
        if (this.mIsFeedsInit) {
            MainContext<?, ?, ?> mainContext = this.mMainFragment;
            if (mainContext != null) {
                mainContext.notifyInitialUIReady();
            }
            this.mHasUiReady = true;
            if (!this.mHasPaused) {
                onResume();
            }
        }
    }

    private final void registerListeners() {
        IPadHomeEventListener it;
        IPadHomeEventExt it2 = this.mFeedViewExt;
        if (it2 != null) {
            this.mHomeEventRegistry.addObserver(it2);
        }
        IPadHomeEventExt it3 = this.mSearchViewExt;
        if (it3 != null) {
            this.mHomeEventRegistry.addObserver(it3);
        }
        this.mHomeEventRegistry.addObserver(new PadHomeBusinessListener());
        IPadHomeWeatherApi iPadHomeWeatherApi = (IPadHomeWeatherApi) ServiceManager.getService(IPadHomeWeatherApi.Companion.getSERVICE_REFERENCE());
        if (!(iPadHomeWeatherApi == null || (it = iPadHomeWeatherApi.getHomeEventObserver()) == null)) {
            this.mHomeEventRegistry.addOutObserver(it);
        }
        IPadHomeApp homeAppContext = PadHomeRuntime.INSTANCE.getHomeAppContext();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        for (IPadHomeEventListener it4 : homeAppContext.getListeners(context)) {
            this.mHomeEventRegistry.addOutObserver(it4);
        }
        BdEventBus.Companion.getDefault().register(this, FeedFlowRefreshEvent.class, 1, new PadHomeView$$ExternalSyntheticLambda0(this));
        BdEventBus.Companion.getDefault().register(this, MainFeedPreLoadEvent.class, 1, new PadHomeView$$ExternalSyntheticLambda2(this));
        BdEventBus.Companion.getDefault().register(this, BackPressedEvent.class, 1, new PadHomeView$$ExternalSyntheticLambda3());
        BdEventBus.Companion.getDefault().register(this, UiInitialReadyEvent.class, 1, new PadHomeView$$ExternalSyntheticLambda4(this));
        BdEventBus.Companion.getDefault().register(this, FeedFloatBtnRefreshEvent.class, 1, new PadHomeView$$ExternalSyntheticLambda5());
        BdEventBus.Companion.getDefault().register(this, FontSizeChangeMessage.class, 1, new PadHomeView$$ExternalSyntheticLambda6(this));
        BdEventBus.Companion.getDefault().register(this, HomeTabClickEvent.class, 1, new PadHomeView$$ExternalSyntheticLambda7(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: registerListeners$lambda-10  reason: not valid java name */
    public static final void m1856registerListeners$lambda10(PadHomeView this$0, FeedFlowRefreshEvent it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        this$0.handleFeedFlowRefreshEvent(it);
    }

    /* access modifiers changed from: private */
    /* renamed from: registerListeners$lambda-11  reason: not valid java name */
    public static final void m1857registerListeners$lambda11(PadHomeView this$0, MainFeedPreLoadEvent it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        this$0.handleMainFeedPreLoadEvent(it);
    }

    /* access modifiers changed from: private */
    /* renamed from: registerListeners$lambda-12  reason: not valid java name */
    public static final void m1858registerListeners$lambda12(BackPressedEvent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        PadHomeMgr.INSTANCE.goToHome();
    }

    /* access modifiers changed from: private */
    /* renamed from: registerListeners$lambda-13  reason: not valid java name */
    public static final void m1859registerListeners$lambda13(PadHomeView this$0, UiInitialReadyEvent it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        if (PadViewUtilsKt.getPAD_DEBUG()) {
            Log.d(PadHomeMgrKt.PAD_TAG, "UiInitialReadyEvent");
        }
        if (!this$0.mHasNoticeUiReady) {
            this$0.mHasNoticeUiReady = true;
            this$0.mHomeEventRegistry.dispatchLazyUiReady();
        }
        PadHomeYaLog.INSTANCE.log("Receive UiInitialReadyEvent");
    }

    /* access modifiers changed from: private */
    /* renamed from: registerListeners$lambda-14  reason: not valid java name */
    public static final void m1860registerListeners$lambda14(FeedFloatBtnRefreshEvent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        PadHomeMgr.INSTANCE.goToFeed();
    }

    /* access modifiers changed from: private */
    /* renamed from: registerListeners$lambda-15  reason: not valid java name */
    public static final void m1861registerListeners$lambda15(PadHomeView this$0, FontSizeChangeMessage it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        this$0.mHomeEventRegistry.dispatchFontSizeChanged();
        this$0.requestLayout();
    }

    /* access modifiers changed from: private */
    /* renamed from: registerListeners$lambda-16  reason: not valid java name */
    public static final void m1862registerListeners$lambda16(PadHomeView this$0, HomeTabClickEvent it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        if (Intrinsics.areEqual((Object) it.mClickTabTag, (Object) "Feed") && Intrinsics.areEqual((Object) it.mClickTabTag, (Object) it.mCurrentTabTag)) {
            this$0.goToTop();
        }
    }

    @StableApi
    public final void goToTop() {
        if (!HomeRuntime.INSTANCE.getHomeSupportContext().enterSugAnimRunning()) {
            TabController.INSTANCE.setHomeState(0);
        }
    }

    public int getHomeState() {
        return this.mHomeState;
    }

    public final void addPadHomeEventListener(IPadHomeEventListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mHomeEventRegistry.addOutObserver(listener);
    }

    private final void ubcHomeShowEvent() {
        String clickId;
        String sessionId = FeedSessionManager.getInstance().getSessionId();
        if (sessionId != null && (clickId = FeedSessionManager.getInstance().getClickId()) != null) {
            PadHomeUbcKt.onPadHomePageShow(this.mIsPadHorizontal ? "landscapemode" : "portrait", "pad_mode", sessionId, clickId);
        }
    }

    private final void cleanPreloadResources() {
        if (!this.mCleanPreloadActionCalled) {
            this.mCleanPreloadActionCalled = true;
            HomeRuntime.INSTANCE.getHomeSupportContext().clearPreloadResourcesIfReady();
        }
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        boolean isPadHorizontal = PadUtilsKt.isPadHorizontal(this.mActivity);
        this.mHomeEventRegistry.dispatchConfigurationChanged(isPadHorizontal, getWidth(), getHeight());
        PadHomeYaLog.INSTANCE.log("onConfigurationChanged, isPadHorizontal: " + isPadHorizontal);
        setPadding(PadViewUtilsKt.getPadTabWidth(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
        if (PadViewUtilsKt.getPAD_DEBUG()) {
            Log.d(PadHomeMgrKt.PAD_TAG, "Configuration: isPadHorizontal: " + isPadHorizontal + ", Width: " + getWidth() + ", Height: " + getHeight());
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int width, int height, int oldw, int oldh) {
        if (width != 0 && height != 0) {
            boolean isPadHorizontal = PadUtilsKt.isPadHorizontal(this.mActivity);
            if (this.mIsPadHorizontal != isPadHorizontal) {
                PadHomeUbcKt.onPadHomePageChange(isPadHorizontal ? "landscapemode" : "portrait", "home");
            }
            BdEventBus.Companion.getDefault().post(new PadHomeSizeChangeEvent(isPadHorizontal, this.mIsPadHorizontal));
            this.mIsPadHorizontal = isPadHorizontal;
            this.mHomeEventRegistry.dispatchSizeChanged(isPadHorizontal, width, height, oldw, oldh);
            PadHomeYaLog.INSTANCE.log("onSizeChanged, isPadHorizontal: " + isPadHorizontal);
            if (PadViewUtilsKt.getPAD_DEBUG()) {
                Log.d(PadHomeMgrKt.PAD_TAG, "SizeChanged: isPadHorizontal: " + isPadHorizontal + ", Width: " + width + ", Height: " + height);
            }
        }
    }
}
