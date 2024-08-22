package com.baidu.searchbox.newhome.content.widget.scroll;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.core.view.NestedScrollingChild3;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.common.ui.style.R;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.briefhome.IBriefHomeApi;
import com.baidu.searchbox.home.feed.NewHomeFeedController;
import com.baidu.searchbox.home.tips.HomeTipsStatusManager;
import com.baidu.searchbox.newhome.content.tips.HomeViewToolsKt;
import com.baidu.searchbox.newhome.content.tips.NewHomeTipsController;
import com.baidu.searchbox.newhome.extend.INewHomeApi;
import com.baidu.searchbox.newhome.tab.IHomeV1TabApi;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B%\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0018\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\t2\u0006\u0010)\u001a\u00020\tH\u0002J\u0018\u0010*\u001a\u00020\u001b2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020,H\u0016J4\u0010.\u001a\u00020\u001b2\u0006\u0010/\u001a\u00020\t2\u0006\u00100\u001a\u00020\t2\b\u00101\u001a\u0004\u0018\u00010\u00102\b\u00102\u001a\u0004\u0018\u00010\u00102\u0006\u00103\u001a\u00020\tH\u0016J:\u00104\u001a\u00020\u001b2\u0006\u00105\u001a\u00020\t2\u0006\u00106\u001a\u00020\t2\u0006\u00107\u001a\u00020\t2\u0006\u00108\u001a\u00020\t2\b\u00102\u001a\u0004\u0018\u00010\u00102\u0006\u00103\u001a\u00020\tH\u0016JB\u00104\u001a\u00020'2\u0006\u00105\u001a\u00020\t2\u0006\u00106\u001a\u00020\t2\u0006\u00107\u001a\u00020\t2\u0006\u00108\u001a\u00020\t2\b\u00102\u001a\u0004\u0018\u00010\u00102\u0006\u00103\u001a\u00020\t2\u0006\u00101\u001a\u00020\u0010H\u0016J\u0006\u00109\u001a\u00020\tJ\u0006\u0010:\u001a\u00020\u0016J\b\u0010;\u001a\u00020\tH\u0016J\u0006\u0010<\u001a\u00020\tJ\u0006\u0010=\u001a\u00020\u0016J\u0010\u0010>\u001a\u00020\u001b2\u0006\u00103\u001a\u00020\tH\u0016J\u0006\u0010?\u001a\u00020'J\u0006\u0010@\u001a\u00020\u001bJ\b\u0010A\u001a\u00020\u001bH\u0002J\u0006\u0010B\u001a\u00020\u001bJ \u0010C\u001a\u00020'2\u0006\u00100\u001a\u00020\t2\u0006\u0010D\u001a\u00020\t2\u0006\u0010E\u001a\u00020\tH\u0002J\u0018\u0010F\u001a\u00020'2\u0006\u0010G\u001a\u00020\t2\u0006\u0010H\u001a\u00020\tH\u0014J(\u0010I\u001a\u00020\u001b2\u0006\u0010J\u001a\u00020K2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020,2\u0006\u00101\u001a\u00020\u001bH\u0016J \u0010L\u001a\u00020\u001b2\u0006\u0010J\u001a\u00020K2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020,H\u0016J0\u0010M\u001a\u00020'2\u0006\u0010J\u001a\u00020K2\u0006\u0010/\u001a\u00020\t2\u0006\u00100\u001a\u00020\t2\u0006\u00101\u001a\u00020\u00102\u0006\u00103\u001a\u00020\tH\u0016J8\u0010N\u001a\u00020'2\u0006\u0010J\u001a\u00020K2\u0006\u00105\u001a\u00020\t2\u0006\u00106\u001a\u00020\t2\u0006\u00107\u001a\u00020\t2\u0006\u00108\u001a\u00020\t2\u0006\u00103\u001a\u00020\tH\u0016J@\u0010N\u001a\u00020'2\u0006\u0010J\u001a\u00020K2\u0006\u00105\u001a\u00020\t2\u0006\u00106\u001a\u00020\t2\u0006\u00107\u001a\u00020\t2\u0006\u00108\u001a\u00020\t2\u0006\u00103\u001a\u00020\t2\u0006\u00101\u001a\u00020\u0010H\u0016J(\u0010O\u001a\u00020'2\u0006\u0010P\u001a\u00020K2\u0006\u0010J\u001a\u00020K2\u0006\u0010Q\u001a\u00020\t2\u0006\u00103\u001a\u00020\tH\u0016J(\u0010R\u001a\u00020\u001b2\u0006\u0010P\u001a\u00020K2\u0006\u0010J\u001a\u00020K2\u0006\u0010Q\u001a\u00020\t2\u0006\u00103\u001a\u00020\tH\u0016J\u0018\u0010S\u001a\u00020'2\u0006\u0010J\u001a\u00020K2\u0006\u00103\u001a\u00020\tH\u0016J\u0012\u0010T\u001a\u00020\u001b2\b\u0010U\u001a\u0004\u0018\u00010VH\u0016J\u0006\u0010W\u001a\u00020'J\u0018\u0010X\u001a\u00020'2\u0006\u0010Y\u001a\u00020\t2\u0006\u0010Z\u001a\u00020\tH\u0016J\u000e\u0010[\u001a\u00020'2\u0006\u0010\\\u001a\u00020\u0014J\u000e\u0010]\u001a\u00020'2\u0006\u0010^\u001a\u00020\"J\u0010\u0010_\u001a\u00020\u001b2\u0006\u0010-\u001a\u00020,H\u0002J\u0006\u0010`\u001a\u00020'J\u0010\u0010a\u001a\u00020\u001b2\u0006\u0010Q\u001a\u00020\tH\u0016J\u0018\u0010a\u001a\u00020\u001b2\u0006\u0010Q\u001a\u00020\t2\u0006\u00103\u001a\u00020\tH\u0016J\b\u0010b\u001a\u00020'H\u0002J\b\u0010c\u001a\u00020'H\u0016J\u0010\u0010c\u001a\u00020'2\u0006\u00103\u001a\u00020\tH\u0016R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0004¢\u0006\u0002\n\u0000¨\u0006d"}, d2 = {"Lcom/baidu/searchbox/newhome/content/widget/scroll/NewHomeScrollContainer;", "Landroid/widget/LinearLayout;", "Landroidx/core/view/NestedScrollingParent3;", "Landroidx/core/view/NestedScrollingChild3;", "context", "Landroid/content/Context;", "attr", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mAutoScrollAnimator", "Landroid/animation/ValueAnimator;", "mChildHelper", "Landroidx/core/view/NestedScrollingChildHelper;", "mConsumed", "", "mCurrentState", "mCurrentY", "mFeedController", "Lcom/baidu/searchbox/home/feed/NewHomeFeedController;", "mFeedView", "Landroid/widget/FrameLayout;", "mHeight", "mHomeV1TabFun", "Lcom/baidu/searchbox/newhome/tab/IHomeV1TabApi;", "mIsFlingScroll", "", "mLastState", "mLastY", "mOffset", "mParentHelper", "Landroidx/core/view/NestedScrollingParentHelper;", "mTipsController", "Lcom/baidu/searchbox/newhome/content/tips/NewHomeTipsController;", "mTipsLayoutHeight", "mTipsView", "Lcom/baidu/searchbox/newhome/content/widget/scroll/NewHomeChildContainer;", "animateScrollWithDuration", "", "fromPos", "toPos", "dispatchNestedPreFling", "velocityX", "", "velocityY", "dispatchNestedPreScroll", "dx", "dy", "consumed", "offsetInWindow", "type", "dispatchNestedScroll", "dxConsumed", "dyConsumed", "dxUnconsumed", "dyUnconsumed", "getFeedContentCurrentState", "getFeedView", "getNestedScrollAxes", "getTipsHeight", "getTipsView", "hasNestedScrollingParent", "hideTips", "isFeedScrollTop", "isFeedWillScrollTop", "isScrollTop", "onContentScrolled", "currentY", "height", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onNestedFling", "target", "Landroid/view/View;", "onNestedPreFling", "onNestedPreScroll", "onNestedScroll", "onNestedScrollAccepted", "child", "axes", "onStartNestedScroll", "onStopNestedScroll", "onTouchEvent", "e", "Landroid/view/MotionEvent;", "removeTips", "scrollTo", "x", "y", "setFeedController", "feedController", "setTipsController", "tipsController", "shouldConsumeFling", "showTips", "startNestedScroll", "stopAutoScrollAnim", "stopNestedScroll", "new-home-content_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NewHomeScrollContainer.kt */
public class NewHomeScrollContainer extends LinearLayout implements NestedScrollingParent3, NestedScrollingChild3 {
    public Map<Integer, View> _$_findViewCache;
    private ValueAnimator mAutoScrollAnimator;
    private NestedScrollingChildHelper mChildHelper;
    private final int[] mConsumed;
    private int mCurrentState;
    private int mCurrentY;
    private NewHomeFeedController mFeedController;
    private final FrameLayout mFeedView;
    private int mHeight;
    private final IHomeV1TabApi mHomeV1TabFun;
    private boolean mIsFlingScroll;
    private int mLastState;
    private int mLastY;
    private final int[] mOffset;
    private NestedScrollingParentHelper mParentHelper;
    private NewHomeTipsController mTipsController;
    private final int mTipsLayoutHeight;
    private final NewHomeChildContainer mTipsView;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public NewHomeScrollContainer(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public NewHomeScrollContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
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
    public NewHomeScrollContainer(Context context, AttributeSet attr, int defStyleAttr) {
        super(context, attr, defStyleAttr);
        Intrinsics.checkNotNullParameter(context, "context");
        this._$_findViewCache = new LinkedHashMap();
        this.mChildHelper = new NestedScrollingChildHelper(this);
        this.mParentHelper = new NestedScrollingParentHelper(this);
        this.mOffset = new int[2];
        this.mConsumed = new int[2];
        this.mHeight = -1;
        this.mTipsLayoutHeight = context.getResources().getDimensionPixelSize(R.dimen.dimen_ui_42);
        FrameLayout $this$mFeedView_u24lambda_u2d0 = new FrameLayout(context, attr, defStyleAttr);
        $this$mFeedView_u24lambda_u2d0.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.mFeedView = $this$mFeedView_u24lambda_u2d0;
        NewHomeChildContainer newHomeChildContainer = new NewHomeChildContainer(context, this, attr, defStyleAttr);
        this.mTipsView = newHomeChildContainer;
        this.mHomeV1TabFun = (IHomeV1TabApi) ServiceManager.getService(IHomeV1TabApi.Companion.getSERVICE_REFERENCE());
        setOrientation(1);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.mChildHelper.setNestedScrollingEnabled(true);
        addView(newHomeChildContainer);
        addView($this$mFeedView_u24lambda_u2d0);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ NewHomeScrollContainer(Context context, AttributeSet attributeSet, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int mHeightTemp;
        super.onMeasure(widthMeasureSpec, getTipsHeight() + heightMeasureSpec);
        if (getChildCount() > 1 && (mHeightTemp = View.MeasureSpec.getSize(heightMeasureSpec) + getTipsHeight()) != -1 && mHeightTemp != this.mHeight) {
            this.mHeight = mHeightTemp;
            setMeasuredDimension(View.MeasureSpec.getSize(widthMeasureSpec), this.mHeight);
        }
    }

    public boolean onTouchEvent(MotionEvent e2) {
        Integer valueOf = e2 != null ? Integer.valueOf(e2.getAction()) : null;
        if (valueOf != null && valueOf.intValue() == 0) {
            this.mLastY = (int) e2.getRawY();
        } else if (valueOf != null && valueOf.intValue() == 2) {
            int y = (int) e2.getRawY();
            int dy = y - this.mLastY;
            this.mLastY = y;
            if (!startNestedScroll(2) || !dispatchNestedPreScroll(0, dy, this.mConsumed, this.mOffset)) {
                scrollBy(0, -dy);
            } else {
                int remain = dy - this.mConsumed[1];
                if (remain != 0) {
                    scrollBy(0, -remain);
                }
            }
        }
        NewHomeTipsController newHomeTipsController = this.mTipsController;
        if (newHomeTipsController != null) {
            newHomeTipsController.onTouchEvent(e2);
        }
        return true;
    }

    public void onNestedPreScroll(View target, int dx, int dy, int[] consumed, int type) {
        int scrollHeight;
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(consumed, "consumed");
        this.mIsFlingScroll = false;
        dispatchNestedPreScroll(dx, dy, consumed, (int[]) null, type);
        if (getTipsHeight() != 0) {
            int useAbleDy = dy - consumed[1];
            if (useAbleDy < 0) {
                int i2 = this.mCurrentY;
                if (i2 <= 0) {
                    return;
                }
                if (i2 < getTipsHeight()) {
                    scrollBy(0, useAbleDy);
                    consumed[1] = consumed[1] + useAbleDy;
                } else if (isFeedScrollTop() && HomeViewToolsKt.isFeedMain()) {
                    scrollBy(0, useAbleDy);
                    consumed[1] = consumed[1] + useAbleDy;
                }
            } else if (useAbleDy <= 0) {
                INewHomeApi $this$onNestedPreScroll_u24lambda_u2d1 = HomeViewToolsKt.getMNewHomeApi();
                if ($this$onNestedPreScroll_u24lambda_u2d1 != null && (scrollHeight = $this$onNestedPreScroll_u24lambda_u2d1.getScrollableHeight()) != 0) {
                    float radio = (((float) getTipsHeight()) * 1.0f) / ((float) scrollHeight);
                    if (dy > 0 && this.mCurrentY < getTipsHeight()) {
                        scrollBy(0, Math.min(((int) (((float) dy) * radio)) + 1, getTipsHeight()));
                    }
                }
            } else if (this.mCurrentY < getTipsHeight()) {
                int con = Math.min(useAbleDy, getTipsHeight());
                scrollBy(0, con);
                consumed[1] = consumed[1] + con;
            }
        }
    }

    public boolean startNestedScroll(int axes) {
        return this.mChildHelper.startNestedScroll(axes);
    }

    public void stopNestedScroll() {
        this.mChildHelper.stopNestedScroll();
        if (!this.mIsFlingScroll) {
            this.mIsFlingScroll = true;
            INewHomeApi $this$stopNestedScroll_u24lambda_u2d3 = HomeViewToolsKt.getMNewHomeApi();
            INewHomeApi iNewHomeApi = null;
            if ($this$stopNestedScroll_u24lambda_u2d3 != null) {
                if (!$this$stopNestedScroll_u24lambda_u2d3.isHideV1TabWhenScroll()) {
                    $this$stopNestedScroll_u24lambda_u2d3 = null;
                }
                if ($this$stopNestedScroll_u24lambda_u2d3 != null) {
                    int willState = $this$stopNestedScroll_u24lambda_u2d3.getWillScrollState();
                    int currentState = $this$stopNestedScroll_u24lambda_u2d3.getNewHomeScrollState();
                    switch (willState) {
                        case -1:
                            switch (currentState) {
                                case 0:
                                    int i2 = this.mCurrentY;
                                    if (i2 > 0 && i2 < getTipsHeight()) {
                                        showTips();
                                        break;
                                    }
                                case 1:
                                    if (!IBriefHomeApi.Companion.getBriefHomeApi().isNoHeaderBriefHomeStyle()) {
                                        hideTips();
                                        break;
                                    } else {
                                        int i3 = this.mCurrentY;
                                        if (i3 > 0 && i3 < getTipsHeight()) {
                                            if (this.mLastState != 0) {
                                                showTips();
                                                break;
                                            } else {
                                                hideTips();
                                                break;
                                            }
                                        }
                                    }
                            }
                            break;
                        case 0:
                            int i4 = this.mCurrentY;
                            if (i4 > 0 && i4 < getTipsHeight()) {
                                showTips();
                                break;
                            }
                        case 1:
                            hideTips();
                            break;
                    }
                }
            }
            INewHomeApi it = HomeViewToolsKt.getMNewHomeApi();
            if (it != null) {
                if (!it.isHideV1TabWhenScroll()) {
                    iNewHomeApi = it;
                }
                if (iNewHomeApi != null) {
                    INewHomeApi iNewHomeApi2 = iNewHomeApi;
                    if (this.mCurrentState == 2) {
                        int i5 = this.mLastState;
                        if (i5 == 0) {
                            hideTips();
                        } else if (i5 == 1) {
                            showTips();
                        }
                    }
                }
            }
        }
    }

    public void scrollTo(int x, int y) {
        NewHomeTipsController newHomeTipsController;
        int tempCurrentY = this.mCurrentY;
        this.mCurrentY = HomeViewToolsKt.toPositive(Math.min(y, getTipsHeight()));
        int scrollAbleHeight = getTipsHeight();
        int i2 = this.mCurrentY;
        if (i2 <= 0) {
            if (this.mCurrentState != 0) {
                this.mCurrentState = 0;
                if (this.mLastState == 1 && (newHomeTipsController = this.mTipsController) != null) {
                    newHomeTipsController.ubcEventIfNeed();
                }
                this.mLastState = this.mCurrentState;
            }
        } else if (i2 < scrollAbleHeight) {
            this.mCurrentState = 2;
        } else if (this.mCurrentState != 1) {
            this.mCurrentState = 1;
            this.mLastState = 1;
        }
        super.scrollTo(x, this.mCurrentY);
        int i3 = this.mCurrentY;
        onContentScrolled(i3 - tempCurrentY, i3, getTipsHeight());
    }

    public boolean startNestedScroll(int axes, int type) {
        return startNestedScroll(axes);
    }

    public void stopNestedScroll(int type) {
        stopNestedScroll();
    }

    public boolean hasNestedScrollingParent(int type) {
        return this.mChildHelper.hasNestedScrollingParent();
    }

    public void dispatchNestedScroll(int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int[] offsetInWindow, int type, int[] consumed) {
        Intrinsics.checkNotNullParameter(consumed, "consumed");
        this.mChildHelper.dispatchNestedScroll(dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, offsetInWindow);
    }

    public boolean dispatchNestedScroll(int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int[] offsetInWindow, int type) {
        return this.mChildHelper.dispatchNestedScroll(dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, offsetInWindow);
    }

    public boolean dispatchNestedPreScroll(int dx, int dy, int[] consumed, int[] offsetInWindow, int type) {
        return this.mChildHelper.dispatchNestedPreScroll(dx, dy, consumed, offsetInWindow);
    }

    public boolean dispatchNestedPreFling(float velocityX, float velocityY) {
        return this.mChildHelper.dispatchNestedPreFling(velocityX, velocityY);
    }

    public boolean onStartNestedScroll(View child, View target, int axes, int type) {
        Intrinsics.checkNotNullParameter(child, "child");
        Intrinsics.checkNotNullParameter(target, "target");
        return true;
    }

    public void onNestedScrollAccepted(View child, View target, int axes, int type) {
        Intrinsics.checkNotNullParameter(child, "child");
        Intrinsics.checkNotNullParameter(target, "target");
        this.mParentHelper.onNestedScrollAccepted(child, target, axes);
        startNestedScroll(2);
    }

    public void onStopNestedScroll(View target, int type) {
        Intrinsics.checkNotNullParameter(target, "target");
        if (target instanceof RecyclerView) {
            IHomeV1TabApi iHomeV1TabApi = this.mHomeV1TabFun;
            boolean z = true;
            if (iHomeV1TabApi == null || !iHomeV1TabApi.isCurrentRecommendTab()) {
                z = false;
            }
            if (z) {
                return;
            }
        }
        this.mParentHelper.onStopNestedScroll(target);
        stopNestedScroll();
    }

    public int getNestedScrollAxes() {
        return this.mParentHelper.getNestedScrollAxes();
    }

    public void onNestedScroll(View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int type, int[] consumed) {
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(consumed, "consumed");
        super.onNestedScroll(target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed);
    }

    public void onNestedScroll(View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int type) {
        Intrinsics.checkNotNullParameter(target, "target");
        super.onNestedScroll(target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed);
    }

    public boolean onNestedFling(View target, float velocityX, float velocityY, boolean consumed) {
        Intrinsics.checkNotNullParameter(target, "target");
        return super.onNestedFling(target, velocityX, velocityY, consumed);
    }

    public boolean onNestedPreFling(View target, float velocityX, float velocityY) {
        Intrinsics.checkNotNullParameter(target, "target");
        if (velocityY > 0.0f && shouldConsumeFling(velocityY)) {
            this.mIsFlingScroll = true;
            hideTips();
        }
        if (velocityY < 0.0f && isFeedWillScrollTop() && shouldConsumeFling(velocityY) && HomeViewToolsKt.isFeedMain()) {
            INewHomeApi mNewHomeApi = HomeViewToolsKt.getMNewHomeApi();
            if (mNewHomeApi != null && mNewHomeApi.getNewHomeScrollState() == 0) {
                this.mIsFlingScroll = true;
                showTips();
            }
        }
        return false;
    }

    private final boolean shouldConsumeFling(float velocityY) {
        return Math.abs(velocityY) > 600.0f;
    }

    private final void animateScrollWithDuration(int fromPos, int toPos) {
        if (this.mAutoScrollAnimator != null) {
            stopAutoScrollAnim();
        } else {
            ValueAnimator $this$animateScrollWithDuration_u24lambda_u2d6 = new ValueAnimator();
            $this$animateScrollWithDuration_u24lambda_u2d6.setInterpolator(new DecelerateInterpolator());
            this.mAutoScrollAnimator = $this$animateScrollWithDuration_u24lambda_u2d6;
        }
        ValueAnimator $this$animateScrollWithDuration_u24lambda_u2d8 = this.mAutoScrollAnimator;
        if ($this$animateScrollWithDuration_u24lambda_u2d8 != null) {
            $this$animateScrollWithDuration_u24lambda_u2d8.setDuration(300);
            $this$animateScrollWithDuration_u24lambda_u2d8.setIntValues(new int[]{fromPos, toPos});
            $this$animateScrollWithDuration_u24lambda_u2d8.addUpdateListener(new NewHomeScrollContainer$$ExternalSyntheticLambda0(this));
            $this$animateScrollWithDuration_u24lambda_u2d8.start();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: animateScrollWithDuration$lambda-8$lambda-7  reason: not valid java name */
    public static final void m1597animateScrollWithDuration$lambda8$lambda7(NewHomeScrollContainer this$0, ValueAnimator updater) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(updater, "updater");
        Object animatedValue = updater.getAnimatedValue();
        if (animatedValue != null) {
            this$0.scrollTo(0, ((Integer) animatedValue).intValue());
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }

    private final void stopAutoScrollAnim() {
        ValueAnimator $this$stopAutoScrollAnim_u24lambda_u2d9 = this.mAutoScrollAnimator;
        if ($this$stopAutoScrollAnim_u24lambda_u2d9 != null) {
            $this$stopAutoScrollAnim_u24lambda_u2d9.cancel();
            $this$stopAutoScrollAnim_u24lambda_u2d9.removeAllUpdateListeners();
        }
    }

    public final int getTipsHeight() {
        if (HomeTipsStatusManager.INSTANCE.isTipsShowing()) {
            return this.mTipsLayoutHeight;
        }
        return 0;
    }

    public final FrameLayout getTipsView() {
        return this.mTipsView;
    }

    public final FrameLayout getFeedView() {
        return this.mFeedView;
    }

    public final void hideTips() {
        stopNestedScroll();
        animateScrollWithDuration(this.mCurrentY, getTipsHeight());
    }

    public final void showTips() {
        stopNestedScroll();
        animateScrollWithDuration(this.mCurrentY, -getTipsHeight());
    }

    public final void removeTips() {
        stopNestedScroll();
        scrollTo(0, 0);
    }

    public final void setTipsController(NewHomeTipsController tipsController) {
        Intrinsics.checkNotNullParameter(tipsController, "tipsController");
        this.mTipsController = tipsController;
    }

    public final void setFeedController(NewHomeFeedController feedController) {
        Intrinsics.checkNotNullParameter(feedController, "feedController");
        this.mFeedController = feedController;
    }

    public final boolean isFeedScrollTop() {
        NewHomeFeedController newHomeFeedController = this.mFeedController;
        return Intrinsics.areEqual(newHomeFeedController != null ? Float.valueOf(newHomeFeedController.getTotalScrollY()) : null, 0.0f);
    }

    public final int getFeedContentCurrentState() {
        return this.mCurrentState;
    }

    private final void onContentScrolled(int dy, int currentY, int height) {
        NewHomeTipsController newHomeTipsController = this.mTipsController;
        if (newHomeTipsController != null) {
            newHomeTipsController.onContentScrolled(dy, currentY, height);
        }
    }

    private final boolean isFeedWillScrollTop() {
        NewHomeFeedController newHomeFeedController = this.mFeedController;
        if (newHomeFeedController == null || newHomeFeedController.getTotalScrollY() >= 150.0f) {
            return false;
        }
        return true;
    }

    public final boolean isScrollTop() {
        if (this.mCurrentState == 0) {
            return true;
        }
        return false;
    }
}
