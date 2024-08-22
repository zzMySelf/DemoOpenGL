package com.baidu.searchbox.multiwindow.animation;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LightingColorFilter;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Scroller;
import com.baidu.searchbox.multiwindow.R;
import com.baidu.searchbox.multiwindow.animation.WindowTab;
import com.baidu.searchbox.ng.browser.util.NgWebViewUtils;
import com.baidu.searchbox.ui.multiwindow.EdgeEffect;
import java.util.ArrayList;
import java.util.Iterator;

public class TabSwitcher extends FrameLayout {
    private static final float BASELINE_FLING_VELOCITY = 2500.0f;
    private static final boolean ENABLE_TAB_FADE = true;
    private static final float FLING_VELOCITY_INFLUENCE = 0.4f;
    public static final int INTERCEPTION_MODE_EITHER_X_Y = 0;
    public static final int INTERCEPTION_MODE_ONLY_X = 1;
    private static final int INVALID_TAB = -1;
    private static final float NANOTIME_DIV = 1.0E9f;
    private static final float SMOOTHING_CONSTANT = ((float) (0.016d / Math.log(0.75d)));
    private static final float SMOOTHING_SPEED = 0.75f;
    private static final int SNAP_VELOCITY = 400;
    private static final int SWITCH_ANIM_TIME = 300;
    public static final float TAB_SCALE_FACTOR = 0.4f;
    private static final int TOUCH_STATE_REST = 0;
    private static final int TOUCH_STATE_SCROLLING = 1;
    public static final int WINDOW_LIMIT = 8;
    private boolean isAboutToExit = false;
    /* access modifiers changed from: private */
    public boolean isInAnimation;
    /* access modifiers changed from: private */
    public BaseTabSwitcherAdapter mAdapter;
    private int mAddedTab = -1;
    private boolean mAllowLongPress;
    private int mCurrentTab;
    private EdgeEffect mEdgeGlowLeft;
    private EdgeEffect mEdgeGlowRight;
    private boolean mEnableDrawCache = false;
    private int mExitTab = -1;
    private boolean mFirstLayout = true;
    private int mInitialIndex = 0;
    private int mInterceptionMode = 0;
    private float mLastMotionX;
    private float mLastMotionY;
    private TabChangedListener mListener;
    private int mMaximumVelocity;
    private boolean mNeedAnim = true;
    private int mNextTab = -1;
    private int mOffset = 0;
    private int mRemovedTab = -1;
    /* access modifiers changed from: private */
    public Runnable mResetAction = new Runnable() {
        public void run() {
            if (TabSwitcher.this.mAdapter == null) {
                TabSwitcher.this.reset();
                ((ViewGroup) TabSwitcher.this.getParent()).setVisibility(8);
            }
        }
    };
    private Scroller mScroller;
    private float mSmoothingTime;
    private int mTabImageHeight;
    private int mTabImageWidth;
    private WindowTab.WindowTabListener mTabListener;
    private int mTabMargin;
    /* access modifiers changed from: private */
    public ArrayList<WindowTab> mTabViews = new ArrayList<>(8);
    private int mTouchSlop;
    private int mTouchState = 0;
    private float mTouchX;
    private VelocityTracker mVelocityTracker;
    private int mWindowTopMargin;

    public interface TabChangedListener {
        void onCurrentTabChanged(int i2, int i3);

        void onTabClicked(int i2, WindowTab windowTab, TabSwitcher tabSwitcher);

        void onTabCloseButtonClicked(int i2, WindowTab windowTab, TabSwitcher tabSwitcher);
    }

    public TabSwitcher(Context context) {
        super(context);
        init(context);
    }

    public TabSwitcher(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public TabSwitcher(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
    }

    private void init(Context context) {
        this.mScroller = new Scroller(context, new TabSwitcherOvershootInterpolator());
        this.mCurrentTab = 0;
        ViewConfiguration configuration = ViewConfiguration.get(getContext());
        this.mTouchSlop = configuration.getScaledTouchSlop();
        this.mMaximumVelocity = configuration.getScaledMaximumFlingVelocity();
        this.mEdgeGlowLeft = new EdgeEffect(context);
        this.mEdgeGlowRight = new EdgeEffect(context);
        this.mOffset = context.getResources().getDimensionPixelSize(R.dimen.multiwindow_tab_ani_offset);
    }

    public void reset() {
        int count = getChildCount();
        for (int i2 = 0; i2 < count; i2++) {
            View childView = getChildAt(i2);
            if (childView != null) {
                childView.clearAnimation();
            }
        }
        this.mTabViews.clear();
        this.mCurrentTab = 0;
        this.mTabViews.clear();
        this.mFirstLayout = true;
        this.mNextTab = -1;
        this.mRemovedTab = -1;
        this.mExitTab = -1;
        this.mListener = null;
        this.isInAnimation = false;
        this.isAboutToExit = false;
        this.mTabImageWidth = 0;
        this.mTabImageHeight = 0;
        this.mTouchState = 0;
        Scroller scroller = this.mScroller;
        if (scroller != null) {
            scroller.abortAnimation();
        }
        this.mTabListener = null;
    }

    public void setInitialTabIndex(int initialIndex) {
        this.mInitialIndex = initialIndex;
    }

    public void setAdapter(BaseTabSwitcherAdapter adapter, int tabImageWidth, int tabImageHeight) {
        reset();
        removeCallbacks(this.mResetAction);
        this.mAdapter = adapter;
        setTabImageSize(tabImageWidth, tabImageHeight);
        this.mTabViews.clear();
        this.mTabListener = new WindowTab.WindowTabListener() {
            public void onTabShowed(WindowTab tab) {
                if (TabSwitcher.this.mAdapter != null) {
                    TabSwitcher.this.mAdapter.onAddTabFinish(TabSwitcher.this.mTabViews.indexOf(tab));
                }
            }

            public void onTabDissmissed(WindowTab tab) {
                if (TabSwitcher.this.mTabViews.contains(tab)) {
                    TabSwitcher.this.mTabViews.remove(tab);
                    if (TabSwitcher.this.mAdapter != null) {
                        TabSwitcher.this.mAdapter.onRemoveTabFinish(tab, TabSwitcher.this.mTabViews.size());
                    }
                }
            }

            public void onTabClicked(WindowTab tab) {
                TabSwitcher.this.onTabClicked(tab);
            }

            public void onTabCloseButtonClicked(WindowTab tab) {
                TabSwitcher.this.onCloseButtonClicked(tab);
            }
        };
        int count = adapter.getInitialTabsCount();
        LayoutInflater inflater = LayoutInflater.from(getContext());
        for (int i2 = 0; i2 < count; i2++) {
            addTab(i2, inflater);
        }
        if (count == 0) {
            addInitialTab();
        }
        this.mCurrentTab = Math.max(0, Math.min(this.mInitialIndex, getChildCount() - 1));
        this.mInitialIndex = 0;
    }

    private void setTabImageSize(int width, int height) {
        this.mTabImageWidth = width;
        this.mTabImageHeight = height;
    }

    private WindowTab addTab(int index, LayoutInflater inflater) {
        if (this.mAdapter == null || index < 0 || index > getChildCount()) {
            return null;
        }
        WindowTab tab = (WindowTab) inflater.inflate(R.layout.multiwindow_windowtab, this, false);
        Bitmap tabImage = this.mAdapter.getTabImage(index, tab, this);
        if (tabImage != null) {
            tab.setTabImage(tabImage);
        }
        tab.setVisibility(4);
        tab.setWindowTabListerner(this.mTabListener);
        addView(tab, index);
        this.mTabViews.add(index, tab);
        return tab;
    }

    public void addInitialTab() {
        if (!this.isInAnimation || getChildCount() <= 0) {
            this.isInAnimation = true;
            if (this.mAdapter != null) {
                this.mAddedTab = getTabIndex(addInitialTab(LayoutInflater.from(getContext())));
            }
        }
    }

    private WindowTab addInitialTab(LayoutInflater inflater) {
        if (this.mAdapter == null || getChildCount() > 0) {
            return null;
        }
        WindowTab tab = (WindowTab) inflater.inflate(R.layout.multiwindow_windowtab, this, false);
        tab.setCloseButtonVisibility(8);
        tab.setTabImageBg(R.drawable.multiwindow_emptytab_bg);
        tab.setTabImageSize(this.mTabImageWidth, this.mTabImageHeight);
        tab.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                View snapView = (ImageView) TabSwitcher.this.findViewById(R.id.window_thumb_snapshot);
                LightingColorFilter dark = new LightingColorFilter(-6710887, 0);
                switch (event.getAction()) {
                    case 0:
                        snapView.getBackground().setColorFilter(dark);
                        break;
                    case 1:
                    case 3:
                        snapView.getBackground().setColorFilter((ColorFilter) null);
                        break;
                }
                return false;
            }
        });
        tab.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (TabSwitcher.this.mAdapter != null) {
                    TabSwitcher.this.mAdapter.onExitPrepared(0);
                }
            }
        });
        addView(tab);
        return tab;
    }

    public void setTabChangedListener(TabChangedListener l) {
        this.mListener = l;
        if (l != null) {
            l.onCurrentTabChanged(-1, this.mCurrentTab);
        }
    }

    public void setTabMargin(int tabMargin) {
        this.mTabMargin = tabMargin;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.mEdgeGlowLeft != null) {
            int scrollX = getScrollX();
            if (!this.mEdgeGlowLeft.isFinished()) {
                int restoreCount = canvas.save();
                int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(270.0f);
                canvas.translate((float) ((-height) + getPaddingTop()), (float) Math.min(0, scrollX));
                this.mEdgeGlowLeft.setSize(height, getWidth());
                if (this.mEdgeGlowLeft.draw(canvas)) {
                    postInvalidate();
                }
                canvas.restoreToCount(restoreCount);
            }
            if (!this.mEdgeGlowRight.isFinished()) {
                int restoreCount2 = canvas.save();
                int width = getWidth();
                int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate((float) (-getPaddingTop()), (float) (-(Math.max(getScrollRange(), scrollX) + width)));
                this.mEdgeGlowRight.setSize(height2, width);
                if (this.mEdgeGlowRight.draw(canvas)) {
                    postInvalidate();
                }
                canvas.restoreToCount(restoreCount2);
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean drawChild(Canvas canvas, View child, long drawingTime) {
        return super.drawChild(canvas, child, drawingTime);
    }

    /* access modifiers changed from: protected */
    public void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        setTabCloseButtonAlpha();
    }

    private void setTabCloseButtonAlpha() {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View child = getChildAt(i2);
            if (child instanceof WindowTab) {
                WindowTab tab = (WindowTab) child;
                tab.setCloseButtonAlpha(tab.getTabAlpha(this));
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        int xCenter = (right - left) / 2;
        int i2 = this.mWindowTopMargin;
        int yCenter = (((bottom - top) - i2) / 2) + i2;
        int count = getChildCount();
        if (count != 0) {
            for (int i3 = 0; i3 < count; i3++) {
                View child = getChildAt(i3);
                if (child.getVisibility() != 8) {
                    if ((child instanceof WindowTab) && !((WindowTab) child).isBlockingClearAnimation) {
                        child.clearAnimation();
                    }
                    int childWidth = child.getMeasuredWidth();
                    int childLeft = xCenter - (childWidth / 2);
                    int childHeight = child.getMeasuredHeight();
                    int childTop = yCenter - (childHeight / 2);
                    child.layout(childLeft, childTop, childLeft + childWidth, childTop + childHeight);
                    xCenter += this.mTabMargin + childWidth;
                }
            }
            if (this.mFirstLayout != 0) {
                this.mFirstLayout = false;
                startEnterAnimation();
            }
            int i4 = this.mRemovedTab;
            if (i4 != -1) {
                TabChangedListener tabChangedListener = this.mListener;
                if (tabChangedListener != null) {
                    tabChangedListener.onCurrentTabChanged(i4, this.mCurrentTab);
                }
                this.mRemovedTab = -1;
            }
            View currentTab = getChildAt(this.mCurrentTab);
            scrollTo((currentTab.getLeft() + (currentTab.getMeasuredWidth() / 2)) - ((right - left) / 2), 0);
            int i5 = this.mAddedTab;
            if (i5 != -1) {
                snapToTab(i5, 0);
                this.mAddedTab = -1;
            }
            if (this.isInAnimation && !this.isAboutToExit) {
                this.isInAnimation = false;
            }
            setTabCloseButtonAlpha();
        }
    }

    private void startEnterAnimation() {
        if (this.mTabViews.size() == 0 || !this.mNeedAnim) {
            setChildVisibilityForAnimation(0);
            return;
        }
        this.isInAnimation = true;
        setChildVisibilityForAnimation(4);
        WindowTab currentTab = this.mTabViews.get(this.mCurrentTab);
        AnimationSet anim = new AnimationSet(false);
        ScaleAnimation scaleAnim = new ScaleAnimation(2.5f, 1.0f, 2.5f, 1.0f, 1, 0.5f, 1, 0.5f);
        int offsetX = this.mOffset;
        int offsetY = this.mOffset;
        if (NgWebViewUtils.useEmbededTitleBarApi()) {
            offsetY = ((-this.mWindowTopMargin) / 2) + this.mOffset;
        }
        TranslateAnimation trans = new TranslateAnimation(0, (float) offsetX, 0, 0.0f, 0, (float) offsetY, 0, 0.0f);
        anim.addAnimation(scaleAnim);
        anim.addAnimation(trans);
        anim.setDuration(300);
        anim.setZAdjustment(1);
        anim.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationStart(Animation animation) {
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationEnd(Animation animation) {
                TabSwitcher.this.setChildVisibilityForAnimation(0);
                TabSwitcher.this.startEdgeChildFadeAnimation(true);
                boolean unused = TabSwitcher.this.isInAnimation = false;
            }
        });
        currentTab.startAnimation(anim);
    }

    public void startExitAnimation(Runnable animationEndAction) {
        if (!this.mNeedAnim) {
            this.mAdapter = null;
            animationEndAction.run();
            post(this.mResetAction);
            return;
        }
        this.isInAnimation = true;
        this.mAdapter = null;
        setChildVisibilityForAnimation(4);
        WindowTab currentTab = this.mTabViews.get(this.mCurrentTab);
        currentTab.setVisibility(0);
        currentTab.clearAnimation();
        AnimationSet anim = new AnimationSet(false);
        ScaleAnimation scaleAnim = new ScaleAnimation(1.0f, 2.5f, 1.0f, 2.5f, 1, 0.5f, 1, 0.5f);
        int offsetX = this.mOffset;
        int offsetY = this.mOffset;
        if (NgWebViewUtils.useEmbededTitleBarApi()) {
            offsetY = ((-this.mWindowTopMargin) / 2) + this.mOffset;
        }
        TranslateAnimation trans = new TranslateAnimation(0, 0.0f, 0, (float) offsetX, 0, 0.0f, 0, (float) offsetY);
        anim.addAnimation(scaleAnim);
        anim.addAnimation(trans);
        anim.setDuration(300);
        anim.setFillAfter(true);
        final Runnable runnable = animationEndAction;
        anim.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationStart(Animation animation) {
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationEnd(Animation animation) {
                runnable.run();
                TabSwitcher tabSwitcher = TabSwitcher.this;
                tabSwitcher.post(tabSwitcher.mResetAction);
            }
        });
        currentTab.startAnimation(anim);
        currentTab.isBlockingClearAnimation = true;
    }

    public void exitAtTab(int exitTabIndex) {
        this.isInAnimation = true;
        snapToTab(exitTabIndex, 0);
        this.mExitTab = exitTabIndex;
    }

    /* access modifiers changed from: private */
    public void setChildVisibilityForAnimation(int visibility) {
        int count = getChildCount();
        for (int i2 = 0; i2 < count; i2++) {
            View childView = getChildAt(i2);
            if (childView.getVisibility() != 8) {
                childView.setVisibility(visibility);
            }
        }
    }

    /* access modifiers changed from: private */
    public void startEdgeChildFadeAnimation(boolean fadeIn) {
        int count = getChildCount();
        for (int i2 = 0; i2 < count; i2++) {
            if (Math.abs(i2 - this.mCurrentTab) == 1) {
                View childView = getChildAt(i2);
                if (fadeIn) {
                    AlphaAnimation fade = new AlphaAnimation(0.0f, 1.0f);
                    fade.setDuration(300);
                    childView.startAnimation(fade);
                } else {
                    AlphaAnimation fade2 = new AlphaAnimation(1.0f, 0.0f);
                    fade2.setDuration(300);
                    childView.startAnimation(fade2);
                }
            }
        }
    }

    public boolean onTouchEvent(MotionEvent ev) {
        int bound;
        if (this.isInAnimation || getChildCount() <= 0) {
            return true;
        }
        acquireVelocityTrackerAndAddMovement(ev);
        switch (ev.getAction() & 255) {
            case 0:
                if (!this.mScroller.isFinished()) {
                    this.mScroller.abortAnimation();
                }
                this.mLastMotionX = ev.getX();
                if (this.mTouchState == 1) {
                    int i2 = this.mCurrentTab;
                    enableChildrenCache(i2 - 1, i2 + 1);
                }
                this.mTouchState = 1;
                break;
            case 1:
                if (this.mTouchState == 1) {
                    VelocityTracker velocityTracker = this.mVelocityTracker;
                    velocityTracker.computeCurrentVelocity(1000, (float) this.mMaximumVelocity);
                    int velocityX = (int) velocityTracker.getXVelocity();
                    int whichScreen = whichScreenToSnapTo(getScrollX());
                    View child = getChildAt(0);
                    if (!(child == null || child.getWidth() == 0)) {
                        float scrolledPos = ((float) getScrollX()) / ((float) (child.getWidth() + this.mTabMargin));
                        if (velocityX > 400 && (bound = this.mCurrentTab) > 0) {
                            if (scrolledPos <= ((float) whichScreen)) {
                                bound--;
                            }
                            snapToTab(Math.min(whichScreen, bound), velocityX);
                        } else if (velocityX >= -400 || this.mCurrentTab >= getChildCount() - 1) {
                            snapToTab(whichScreen, 0);
                        } else {
                            snapToTab(Math.max(whichScreen, scrolledPos >= ((float) whichScreen) ? this.mCurrentTab + 1 : this.mCurrentTab), velocityX);
                        }
                    }
                }
                this.mTouchState = 0;
                EdgeEffect edgeEffect = this.mEdgeGlowLeft;
                if (edgeEffect != null) {
                    edgeEffect.onRelease();
                    this.mEdgeGlowRight.onRelease();
                }
                releaseVelocityTracker();
                break;
            case 2:
                if (this.mTouchState == 1) {
                    float x = ev.getX();
                    float deltaX = this.mLastMotionX - x;
                    int oldX = getScrollX();
                    this.mLastMotionX = x;
                    if (deltaX < 0.0f) {
                        float f2 = this.mTouchX;
                        if (f2 > 0.0f) {
                            this.mTouchX = f2 + Math.max(-f2, deltaX);
                            this.mSmoothingTime = ((float) System.nanoTime()) / NANOTIME_DIV;
                            invalidate();
                        }
                    } else if (deltaX > 0.0f) {
                        float f3 = this.mTouchX;
                        float availableToScroll = ((float) getScrollRange()) - f3;
                        if (availableToScroll > 0.0f) {
                            this.mTouchX = f3 + Math.min(availableToScroll, deltaX);
                            this.mSmoothingTime = ((float) System.nanoTime()) / NANOTIME_DIV;
                            invalidate();
                        }
                    }
                    int range = getScrollRange();
                    int pulledToX = ((int) deltaX) + oldX;
                    if (pulledToX < 0) {
                        this.mEdgeGlowLeft.onPull(deltaX / ((float) getWidth()));
                        if (!this.mEdgeGlowRight.isFinished()) {
                            this.mEdgeGlowRight.onRelease();
                        }
                    } else if (pulledToX > range) {
                        this.mEdgeGlowRight.onPull(deltaX / ((float) getWidth()));
                        if (!this.mEdgeGlowLeft.isFinished()) {
                            this.mEdgeGlowLeft.onRelease();
                        }
                    }
                    EdgeEffect edgeEffect2 = this.mEdgeGlowLeft;
                    if (edgeEffect2 != null && (!edgeEffect2.isFinished() || !this.mEdgeGlowRight.isFinished())) {
                        postInvalidate();
                        break;
                    }
                }
                break;
            case 3:
                if (this.mTouchState == 1) {
                    int screenWidth = getWidth();
                    snapToTab((getScrollX() + (screenWidth / 2)) / screenWidth, 0);
                }
                this.mTouchState = 0;
                releaseVelocityTracker();
                EdgeEffect edgeEffect3 = this.mEdgeGlowLeft;
                if (edgeEffect3 != null) {
                    edgeEffect3.onRelease();
                    this.mEdgeGlowRight.onRelease();
                    break;
                }
                break;
        }
        return true;
    }

    public void computeScroll() {
        BaseTabSwitcherAdapter baseTabSwitcherAdapter;
        if (this.mScroller.computeScrollOffset()) {
            this.mTouchX = (float) this.mScroller.getCurrX();
            this.mSmoothingTime = ((float) System.nanoTime()) / NANOTIME_DIV;
            scrollTo(this.mScroller.getCurrX(), this.mScroller.getCurrY());
            postInvalidate();
            return;
        }
        int i2 = this.mNextTab;
        if (i2 != -1) {
            if (i2 >= 0 && i2 < this.mTabViews.size()) {
                WindowTab tab = this.mTabViews.get(this.mNextTab);
                if (tab.getVisibility() != 0) {
                    tab.show();
                }
                Iterator<WindowTab> it = this.mTabViews.iterator();
                while (it.hasNext()) {
                    WindowTab otherTab = it.next();
                    if (!(otherTab == tab || otherTab.getVisibility() == 0)) {
                        otherTab.show();
                    }
                }
            }
            this.mNextTab = -1;
            int i3 = this.mExitTab;
            if (!(i3 == -1 || i3 != this.mCurrentTab || (baseTabSwitcherAdapter = this.mAdapter) == null)) {
                baseTabSwitcherAdapter.onExitPrepared(i3);
            }
            clearChildrenCache();
        } else if (this.mTouchState == 1) {
            float now = ((float) System.nanoTime()) / NANOTIME_DIV;
            float dx = this.mTouchX - ((float) getScrollX());
            scrollTo(getScrollX() + ((int) (dx * ((float) Math.exp((double) ((now - this.mSmoothingTime) / SMOOTHING_CONSTANT))))), getScrollY());
            this.mSmoothingTime = now;
            if (dx > 1.0f || dx < -1.0f) {
                postInvalidate();
            }
        }
    }

    private int whichScreenToSnapTo(int scrollX) {
        int xCenter = (getWidth() / 2) + scrollX;
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View child = getChildAt(i2);
            int margin = this.mTabMargin / 2;
            if (xCenter >= child.getLeft() - margin && xCenter < child.getRight() + margin) {
                return i2;
            }
        }
        return 0;
    }

    public boolean onInterceptTouchEvent(MotionEvent ev) {
        int action = ev.getAction();
        if (action == 2 && this.mTouchState != 0) {
            return true;
        }
        acquireVelocityTrackerAndAddMovement(ev);
        switch (action & 255) {
            case 0:
                float x = ev.getX();
                float y = ev.getY();
                this.mLastMotionX = x;
                this.mLastMotionY = y;
                this.mAllowLongPress = true;
                this.mTouchX = (float) getScrollX();
                this.mTouchState = this.mScroller.isFinished() ^ true ? 1 : 0;
                break;
            case 1:
            case 3:
                clearChildrenCache();
                this.mTouchState = 0;
                this.mAllowLongPress = false;
                releaseVelocityTracker();
                break;
            case 2:
                float x2 = ev.getX();
                if (isNeedInterceptTouchEvent((float) ((int) Math.abs(x2 - this.mLastMotionX)), (float) ((int) Math.abs(ev.getY() - this.mLastMotionY)))) {
                    this.mTouchState = 1;
                    this.mLastMotionX = x2;
                    this.mTouchX = (float) getScrollX();
                    this.mSmoothingTime = ((float) System.nanoTime()) / NANOTIME_DIV;
                    int i2 = this.mCurrentTab;
                    enableChildrenCache(i2 - 1, i2 + 1);
                    if (this.mAllowLongPress) {
                        this.mAllowLongPress = false;
                        cancelLongPress();
                        break;
                    }
                }
                break;
        }
        if (this.mTouchState != 0) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean isNeedInterceptTouchEvent(float xMovedDistance, float yMovedDistance) {
        int touchSlop = this.mTouchSlop;
        int i2 = this.mInterceptionMode;
        if (i2 != 0) {
            return i2 == 1 && xMovedDistance > ((float) touchSlop) && yMovedDistance <= ((float) touchSlop);
        }
        boolean xMoved = xMovedDistance > ((float) touchSlop);
        boolean yMoved = yMovedDistance > ((float) touchSlop);
        if (xMoved || yMoved) {
            return true;
        }
        return false;
    }

    public void smoothScrollToTab(int tabIndex) {
        snapToTab(tabIndex, 0);
    }

    private void snapToTab(int whichTab, int velocity) {
        int duration;
        TabChangedListener tabChangedListener;
        int i2;
        int whichTab2 = Math.max(0, Math.min(whichTab, getChildCount() - 1));
        enableChildrenCache(this.mCurrentTab, whichTab2);
        this.mNextTab = whichTab2;
        View focusedChild = getFocusedChild();
        if (!(focusedChild == null || whichTab2 == (i2 = this.mCurrentTab) || focusedChild != getChildAt(i2))) {
            focusedChild.clearFocus();
        }
        int screenDelta = Math.max(1, Math.abs(whichTab2 - this.mCurrentTab));
        View nextChild = getChildAt(whichTab2);
        int delta = (((nextChild.getRight() + nextChild.getLeft()) / 2) - (getWidth() / 2)) - getScrollX();
        int duration2 = (screenDelta + 1) * 100;
        if (!this.mScroller.isFinished()) {
            this.mScroller.abortAnimation();
        }
        int velocity2 = Math.abs(velocity);
        if (velocity2 > 0) {
            duration = (int) (((float) duration2) + ((((float) duration2) / (((float) velocity2) / BASELINE_FLING_VELOCITY)) * 0.4f));
        } else {
            duration = duration2 + 60;
        }
        if (Math.abs(delta) > 1) {
            this.mScroller.startScroll(getScrollX(), 0, delta, 0, duration);
        }
        int toWhich = Math.max(0, Math.min(this.mNextTab, getChildCount() - 1));
        int i3 = this.mCurrentTab;
        if (!(toWhich == i3 || (tabChangedListener = this.mListener) == null)) {
            tabChangedListener.onCurrentTabChanged(i3, toWhich);
        }
        this.mCurrentTab = toWhich;
        invalidate();
    }

    private void enableChildrenCache(int fromScreen, int toScreen) {
        if (this.mEnableDrawCache) {
            if (fromScreen > toScreen) {
                int temp = fromScreen;
                fromScreen = toScreen;
                toScreen = temp;
            }
            int temp2 = getChildCount();
            int fromScreen2 = Math.max(fromScreen, 0);
            int toScreen2 = Math.min(toScreen, temp2 - 1);
            for (int i2 = fromScreen2; i2 <= toScreen2; i2++) {
                getChildAt(i2).setDrawingCacheEnabled(true);
            }
            setChildrenDrawnWithCacheEnabled(true);
        }
    }

    private void clearChildrenCache() {
        if (this.mEnableDrawCache) {
            int count = getChildCount();
            for (int i2 = 0; i2 < count; i2++) {
                getChildAt(i2).setDrawingCacheEnabled(false);
            }
            setChildrenDrawingCacheEnabled(false);
        }
    }

    private void acquireVelocityTrackerAndAddMovement(MotionEvent ev) {
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(ev);
    }

    private void releaseVelocityTracker() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    private static class TabSwitcherOvershootInterpolator implements Interpolator {
        private static final float DEFAULT_TENSION = 0.0f;
        private float mTension = 0.0f;

        public float getInterpolation(float t) {
            float t2 = t - 1.0f;
            float f2 = this.mTension;
            return (t2 * t2 * (((f2 + 1.0f) * t2) + f2)) + 1.0f;
        }
    }

    /* access modifiers changed from: private */
    public void onTabClicked(WindowTab tab) {
        if (!this.isInAnimation && this.mListener != null) {
            this.mListener.onTabClicked(getTabIndex(tab), tab, this);
        }
    }

    private WindowTab getWindowTab(int index) {
        return this.mTabViews.get(index);
    }

    public int getCurrentTabIndex() {
        return this.mCurrentTab;
    }

    public void removeTab(int index) {
        WindowTab toRemove = getWindowTab(index);
        if (index >= 0 && index < this.mTabViews.size()) {
            BaseTabSwitcherAdapter baseTabSwitcherAdapter = this.mAdapter;
            if (baseTabSwitcherAdapter != null) {
                baseTabSwitcherAdapter.onRemoveTabStart(index);
            }
            int count = this.mTabViews.size();
            if (index > 0) {
                for (int i2 = 0; i2 < index; i2++) {
                    View next = this.mTabViews.get(i2 + 1);
                    this.mTabViews.get(i2).startTranslateAnimation(next.getLeft(), next.getTop());
                }
            } else {
                for (int i3 = index + 1; i3 < count; i3++) {
                    View prev = this.mTabViews.get(i3 - 1);
                    this.mTabViews.get(i3).startTranslateAnimation(prev.getLeft(), prev.getTop());
                }
            }
            toRemove.setVisibility(4);
            toRemove.clearAnimation();
            toRemove.dismiss();
            this.mRemovedTab = index;
            int i4 = this.mCurrentTab;
            if (index == i4 && i4 > 0) {
                this.mCurrentTab = i4 - 1;
            }
            this.isInAnimation = true;
        }
    }

    public void addNewTab(int index) {
        if (!this.isInAnimation || getChildCount() <= 0) {
            this.isInAnimation = true;
            if (this.mAdapter != null) {
                ArrayList<WindowTab> arrayList = this.mTabViews;
                if (arrayList == null || arrayList.size() == 0) {
                    this.mAdapter.onExitPrepared(0);
                    return;
                }
                this.mAdapter.onAddTabStart(index, true);
                this.mAddedTab = getTabIndex(addTab(index, LayoutInflater.from(getContext())));
                if (index == 0) {
                    this.isAboutToExit = true;
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void onCloseButtonClicked(WindowTab tab) {
        if (!this.isInAnimation && this.mListener != null) {
            int index = getTabIndex(tab);
            if (index != this.mCurrentTab) {
                this.mListener.onTabClicked(index, tab, this);
            } else {
                this.mListener.onTabCloseButtonClicked(index, tab, this);
            }
        }
    }

    private int getTabIndex(WindowTab tab) {
        return this.mTabViews.indexOf(tab);
    }

    private int getScrollRange() {
        int childCount = getChildCount();
        if (childCount == 0) {
            return 0;
        }
        View rightChild = getChildAt(childCount - 1);
        return (rightChild.getLeft() + (rightChild.getMeasuredWidth() / 2)) - ((getRight() - getLeft()) / 2);
    }

    public void setWindowTopMargin(int margin) {
        this.mWindowTopMargin = margin;
    }

    public void setNeedAnim(boolean needAnim) {
        this.mNeedAnim = needAnim;
    }
}
