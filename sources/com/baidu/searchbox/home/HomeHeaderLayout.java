package com.baidu.searchbox.home;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.core.view.NestedScrollingChild2;
import androidx.core.view.NestedScrollingChildHelper;
import com.baidu.common.matrixstyle.StyleMode;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.home.container.lifecycle.IHomeEventListener;
import com.baidu.searchbox.home.container.lifecycle.IHomeTouchEventListener;
import com.baidu.searchbox.home.feed.widget.HomeEventRegistry;
import com.baidu.searchbox.home.guide.HomeGuideController;
import com.baidu.searchbox.home.search.HomeSearchBoxController;
import com.baidu.searchbox.home.tips.HomeTipsController;
import com.baidu.searchbox.homepage.extend.IHomeFun;
import com.baidu.searchbox.launch.stats.SpeedStatsManager;
import com.baidu.searchbox.launch.stats.SpeedStatsStampTable;
import com.baidu.searchbox.ui.DrawerContainer;
import com.baidu.searchbox.widget.ImmersionHelper;

public class HomeHeaderLayout extends LinearLayout implements NestedScrollingChild2, IHomeEventListener, IHomeTouchEventListener {
    private static final boolean DEBUG = AppConfig.isDebug();
    private static final int INVALID_POINTER = -1;
    private final IHomeFun homeFun = ((IHomeFun) ServiceManager.getService(IHomeFun.SERVICE_REFERENCE));
    private int mActivePointerId = -1;
    private NestedScrollingChildHelper mChildHelper;
    private int mCurrentScrollY;
    private int mDrawTop;
    private int mHeaderHeight = 0;
    private HomeEventRegistry mHomeEventRegistry = new HomeEventRegistry();
    private IHomeEventListener mHomeGuideController;
    private IHomeEventListener mHomeSearchBoxViewController;
    private IHomeEventListener mHomeTipsController;
    private boolean mIsBeingDragged = false;
    private int mLastMotionY;
    private final int[] mScrollConsumed = new int[2];
    private final int[] mScrollOffset = new int[2];
    private FrameLayout mSearboxBtmMargin;
    private FrameLayout mSearboxTopMargin;
    private View mSearchBoxView;
    private int mTouchSlop;

    public HomeHeaderLayout(Context context, View feedTabContainer) {
        super(context);
        init(feedTabContainer);
    }

    private void init(View feedTabContainer) {
        if (DEBUG) {
            Log.d("HomeHeaderLayout", "——> init: ");
        }
        SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.HOME_HEADER_LAYOUT_INIT_START_STAMP_KEY);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        setOrientation(1);
        initSearchBoxTopMargin();
        initSearchBoxController();
        initSearchBoxBtmMargin();
        initOperation();
        addView(feedTabContainer);
        initScrollConfig();
        initHomeGuide();
        if (ImmersionHelper.SUPPORT_IMMERSION) {
            setPadding(0, HomeDimenManager.INSTANCE.getStatusBarHeight(), 0, 0);
        }
        SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.HOME_HEADER_LAYOUT_INIT_END_STAMP_KEY);
    }

    private void initHomeGuide() {
        if (this.mHomeGuideController == null) {
            HomeGuideController homeGuideController = new HomeGuideController(getContext());
            this.mHomeGuideController = homeGuideController;
            this.mHomeEventRegistry.addObserver(homeGuideController);
        }
    }

    private void initSearchBoxTopMargin() {
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.mSearboxTopMargin = frameLayout;
        frameLayout.setMinimumHeight(HomeDimenManager.INSTANCE.getHomeSearchBoxTopMarginNoLogo());
        addView(this.mSearboxTopMargin, new LinearLayout.LayoutParams(-1, -2));
    }

    private void initSearchBoxController() {
        if (this.mHomeSearchBoxViewController == null) {
            HomeSearchBoxController homeSearchBoxController = new HomeSearchBoxController(getContext());
            this.mHomeSearchBoxViewController = homeSearchBoxController;
            this.mSearchBoxView = homeSearchBoxController.getView();
            LinearLayout.LayoutParams sboxLp = new LinearLayout.LayoutParams(-1, HomeDimenManager.INSTANCE.getHomeSearchboxHeight());
            sboxLp.leftMargin = HomeDimenManager.INSTANCE.getHomeSearchboxLeftRightMargin();
            sboxLp.rightMargin = HomeDimenManager.INSTANCE.getHomeSearchboxLeftRightMargin();
            addView(this.mSearchBoxView, sboxLp);
            this.mHomeEventRegistry.addObserver(this.mHomeSearchBoxViewController);
        }
    }

    private void initSearchBoxBtmMargin() {
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.mSearboxBtmMargin = frameLayout;
        frameLayout.setMinimumHeight(HomeDimenManager.INSTANCE.getSearchBoxBtmMargin());
        LinearLayout.LayoutParams sbBtmMarginParams = new LinearLayout.LayoutParams(-1, -2);
        sbBtmMarginParams.bottomMargin = 0;
        addView(this.mSearboxBtmMargin, sbBtmMarginParams);
    }

    private void initScrollConfig() {
        this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.mChildHelper = new NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(true);
    }

    public void initOperation() {
        boolean z = DEBUG;
        if (z) {
            Log.d("HomeHeaderLayout", "——> initOperation: begin");
        }
        if (StyleMode.INSTANCE.isTeenagerStyle()) {
            if (z) {
                Log.d("TeenagerMode", "Home Not Show Tips");
            }
        } else if (this.mHomeTipsController == null) {
            HomeTipsController homeTipsController = new HomeTipsController(getContext(), this.mSearboxBtmMargin);
            this.mHomeTipsController = homeTipsController;
            this.mHomeEventRegistry.addObserver(homeTipsController);
        }
    }

    public void requestDisallowInterceptTouchEvent(boolean disallowIntercept) {
        super.requestDisallowInterceptTouchEvent(disallowIntercept);
        requestParentDisallowInterceptTouchEvent(disallowIntercept);
    }

    private void requestParentDisallowInterceptTouchEvent(boolean disallow) {
        ViewParent parent = getParent();
        if (parent != null) {
            while (!(parent instanceof DrawerContainer)) {
                parent = parent.getParent();
                if (parent == null) {
                    return;
                }
            }
            ((DrawerContainer) parent).superRequestDisallowInterceptTouchEvent(disallow);
        }
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    public boolean onInterceptTouchEvent(MotionEvent ev) {
        int pointerIndex;
        int action = ev.getAction();
        if (action == 2 && this.mIsBeingDragged) {
            return true;
        }
        switch (action & 255) {
            case 0:
                this.mLastMotionY = (int) ev.getY();
                this.mActivePointerId = ev.getPointerId(0);
                startNestedScroll(2, 0);
                break;
            case 1:
            case 3:
                this.mIsBeingDragged = false;
                this.mActivePointerId = -1;
                stopNestedScroll(0);
                break;
            case 2:
                int activePointerId = this.mActivePointerId;
                if (!(activePointerId == -1 || (pointerIndex = ev.findPointerIndex(activePointerId)) == -1)) {
                    int y = (int) ev.getY(pointerIndex);
                    if (Math.abs(y - this.mLastMotionY) > this.mTouchSlop) {
                        this.mIsBeingDragged = true;
                        this.mLastMotionY = y;
                        ViewParent parent = getParent();
                        if (parent != null) {
                            parent.requestDisallowInterceptTouchEvent(true);
                            break;
                        }
                    }
                }
                break;
            case 6:
                onSecondaryPointerUp(ev);
                break;
        }
        return this.mIsBeingDragged;
    }

    private void onSecondaryPointerUp(MotionEvent ev) {
        int pointerIndex = ev.getActionIndex();
        if (ev.getPointerId(pointerIndex) == this.mActivePointerId) {
            int newPointerIndex = pointerIndex == 0 ? 1 : 0;
            this.mLastMotionY = (int) ev.getY(newPointerIndex);
            this.mActivePointerId = ev.getPointerId(newPointerIndex);
        }
    }

    public boolean onTouchEvent(MotionEvent ev) {
        switch (ev.getActionMasked()) {
            case 0:
                this.mLastMotionY = (int) ev.getY();
                this.mActivePointerId = ev.getPointerId(0);
                startNestedScroll(2, 0);
                break;
            case 1:
                this.mActivePointerId = -1;
                endDrag();
                break;
            case 2:
                int activePointerIndex = ev.findPointerIndex(this.mActivePointerId);
                if (activePointerIndex != -1) {
                    int y = (int) ev.getY(activePointerIndex);
                    int deltaY = this.mLastMotionY - y;
                    if (dispatchNestedPreScroll(0, deltaY, this.mScrollConsumed, this.mScrollOffset, 0)) {
                        deltaY -= this.mScrollConsumed[1];
                    }
                    if (!this.mIsBeingDragged && Math.abs(deltaY) > this.mTouchSlop) {
                        ViewParent parent = getParent();
                        if (parent != null) {
                            parent.requestDisallowInterceptTouchEvent(true);
                        }
                        this.mIsBeingDragged = true;
                        if (deltaY > 0) {
                            deltaY -= this.mTouchSlop;
                        } else {
                            deltaY += this.mTouchSlop;
                        }
                    }
                    if (this.mIsBeingDragged) {
                        int[] iArr = this.mScrollOffset;
                        this.mLastMotionY = y - iArr[1];
                        if (dispatchNestedScroll(0, 0, 0, deltaY, iArr, 0)) {
                            this.mLastMotionY -= this.mScrollOffset[1];
                            break;
                        }
                    }
                }
                break;
            case 3:
                this.mActivePointerId = -1;
                endDrag();
                break;
            case 5:
                int index = ev.getActionIndex();
                this.mLastMotionY = (int) ev.getY(index);
                this.mActivePointerId = ev.getPointerId(index);
                break;
            case 6:
                onSecondaryPointerUp(ev);
                this.mLastMotionY = (int) ev.getY(ev.findPointerIndex(this.mActivePointerId));
                break;
        }
        return true;
    }

    private void endDrag() {
        this.mIsBeingDragged = false;
        stopNestedScroll(0);
    }

    public void setNestedScrollingEnabled(boolean enabled) {
        this.mChildHelper.setNestedScrollingEnabled(enabled);
    }

    public boolean isNestedScrollingEnabled() {
        return this.mChildHelper.isNestedScrollingEnabled();
    }

    public boolean startNestedScroll(int axes) {
        return this.mChildHelper.startNestedScroll(axes);
    }

    public boolean startNestedScroll(int axes, int type) {
        return this.mChildHelper.startNestedScroll(axes, type);
    }

    public void stopNestedScroll() {
        this.mChildHelper.stopNestedScroll();
    }

    public void stopNestedScroll(int type) {
        this.mChildHelper.stopNestedScroll(type);
    }

    public boolean hasNestedScrollingParent() {
        return this.mChildHelper.hasNestedScrollingParent();
    }

    public boolean hasNestedScrollingParent(int type) {
        return this.mChildHelper.hasNestedScrollingParent(type);
    }

    public boolean dispatchNestedScroll(int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int[] offsetInWindow) {
        return this.mChildHelper.dispatchNestedScroll(dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, offsetInWindow);
    }

    public boolean dispatchNestedScroll(int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int[] offsetInWindow, int type) {
        return this.mChildHelper.dispatchNestedScroll(dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, offsetInWindow, type);
    }

    public boolean dispatchNestedPreScroll(int dx, int dy, int[] consumed, int[] offsetInWindow) {
        return this.mChildHelper.dispatchNestedPreScroll(dx, dy, consumed, offsetInWindow);
    }

    public boolean dispatchNestedPreScroll(int dx, int dy, int[] consumed, int[] offsetInWindow, int type) {
        return this.mChildHelper.dispatchNestedPreScroll(dx, dy, consumed, offsetInWindow, type);
    }

    public boolean dispatchNestedFling(float velocityX, float velocityY, boolean consumed) {
        return this.mChildHelper.dispatchNestedFling(velocityX, velocityY, consumed);
    }

    public boolean dispatchNestedPreFling(float velocityX, float velocityY) {
        return this.mChildHelper.dispatchNestedPreFling(velocityX, velocityY);
    }

    public void onDestroy() {
        if (DEBUG) {
            Log.d("HomeHeaderLayout", "------------------>onDestroy: ");
        }
        this.mHomeEventRegistry.dispatchDestoryEvent();
    }

    public void onNightModeChanged(boolean isNightMode) {
        if (DEBUG) {
            Log.d("HomeHeaderLayout", "------------------>onNightModeChanged: " + isNightMode);
        }
        this.mHomeEventRegistry.dispatchNightModeChanged(isNightMode);
    }

    public void onHomeStateChanged(int oldState, int newState, boolean byTouch) {
        if (DEBUG) {
            Log.d("HomeHeaderLayout", "------------------>onHomeStateChanged: oldState:" + oldState + "newState" + newState);
        }
        this.mHomeEventRegistry.dispatchHomeStateChanged(oldState, newState, byTouch);
    }

    public void onLazyUiReady() {
        if (DEBUG) {
            Log.d("HomeHeaderLayout", "------------------>onLazyUiReady");
        }
        this.mHomeEventRegistry.dispatchLazyUiReady();
    }

    public void onHomeScrollChange(int curX, int curY, int oldX, int oldY, float scrollYPct, float scrollYPctFromLogoTop, float scrollYPctFromSearchBoxTop) {
        if (DEBUG) {
            Log.d("HomeHeaderLayout", "------------------>onScrollChange");
        }
        this.mCurrentScrollY = curY;
        invalidateIfNeed();
        this.mHomeEventRegistry.dispatchScrollChange(curX, curY, oldX, oldY, scrollYPct, scrollYPctFromLogoTop, scrollYPctFromSearchBoxTop);
    }

    public void onHomeHeaderVisible(boolean visible) {
        if (DEBUG) {
            Log.d("HomeHeaderLayout", "------------------>onHomeHeaderVisible：" + visible);
        }
        this.mHomeEventRegistry.dispatchHomeHeaderVisible(visible);
    }

    public void onHomePageVisible(boolean visible) {
        if (DEBUG) {
            Log.d("HomeHeaderLayout", "------------------>onHomePageVisible：" + visible);
        }
        this.mHomeEventRegistry.dispatchHomePageVisible(visible);
    }

    public void onFontSizeChanged() {
        ViewGroup.LayoutParams searchBoxViewLp;
        if (DEBUG) {
            Log.d("HomeHeaderLayout", "------------------>onFontSizeChanged");
        }
        this.mHomeEventRegistry.dispatchFontSizeChanged();
        FrameLayout frameLayout = this.mSearboxTopMargin;
        if (frameLayout != null) {
            frameLayout.setMinimumHeight(HomeDimenManager.INSTANCE.getHomeSearchBoxTopMarginNoLogo());
        }
        View view2 = this.mSearchBoxView;
        if (!(view2 == null || (searchBoxViewLp = view2.getLayoutParams()) == null)) {
            searchBoxViewLp.height = HomeDimenManager.INSTANCE.getHomeSearchboxHeight();
            this.mSearchBoxView.forceLayout();
        }
        forceLayout();
    }

    public ViewGroup getView() {
        return this;
    }

    public void onHomeScrollStateChange(int oldState, int newState) {
        if (DEBUG) {
            Log.d("HomeHeaderLayout", "------------------>onScrollStateChange：oldState：" + oldState + "newState：" + newState);
        }
        this.mHomeEventRegistry.dispatchScrollStateChange(oldState, newState);
    }

    public void onHomeTouchDown() {
        if (DEBUG) {
            Log.d("HomeHeaderLayout", "------------------>onHomeTouchDown");
        }
        this.mHomeEventRegistry.dispatchTouchDown();
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        this.mDrawTop = getTop();
        super.dispatchDraw(canvas);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean changed, int l, int t, int r, int b2) {
        super.onLayout(changed, l, t, r, b2);
        int curHeight = getMeasuredHeight();
        if (changed && this.mHeaderHeight != curHeight) {
            IHomeFun.IHomeHeaderHeightChangeListener listener = this.homeFun.getHomeHeaderHeightChangeListener();
            if (listener != null) {
                listener.onHomeHeaderHeightChanged(this.mHeaderHeight, curHeight);
            }
            this.mHeaderHeight = curHeight;
        }
    }

    private void invalidateIfNeed() {
        if (this.mDrawTop != getTop()) {
            invalidate();
        }
    }
}
