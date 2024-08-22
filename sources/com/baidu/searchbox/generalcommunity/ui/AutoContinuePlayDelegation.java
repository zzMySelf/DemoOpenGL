package com.baidu.searchbox.generalcommunity.ui;

import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.searchbox.abtest.AbTestManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.generalcommunity.injector.ConfigOptions;
import com.baidu.searchbox.generalcommunity.report.ubc.UbcReportHelper;

public class AutoContinuePlayDelegation {
    public static final String AB_KEY = "moment_auto_continue_play_abtest";
    private static final int AB_VALUE_CLOSED = 0;
    private static final int AB_VALUE_DOUBLE_OPENED = 4;
    private static final int AB_VALUE_ONLY_AUTO_OPENED = 2;
    private static final int AB_VALUE_ONLY_FLING_OPENED = 1;
    private static final String BIZ_MOMENT = "moment";
    static final int DURATION_OF_SMOOTH_SCROLL = 240;
    static final float MILLISECONDS_PER_INCH = 100.0f;
    private static int sABValue = 0;
    private static boolean sHasGetABValue = false;
    private boolean autoPlayByUserOpSwitch = true;
    private boolean autoPlayMainSwitch = true;
    /* access modifiers changed from: private */
    public final String mBusiness;
    private OrientationHelper mHorizontalHelper;
    /* access modifiers changed from: private */
    public int mLastFlingTopIndex = -1;
    /* access modifiers changed from: private */
    public RecyclerView mRecyclerView;
    private OrientationHelper mVerticalHelper;

    public AutoContinuePlayDelegation(String business) {
        this.mBusiness = business;
    }

    public void attachRecyclerView(RecyclerView recyclerView) {
        this.mRecyclerView = recyclerView;
    }

    public void detachRecyclerView() {
        this.mRecyclerView = null;
    }

    public RecyclerView.SmoothScroller getSmoothScroller() {
        if (isFlingScrollerOpened() || isAutoScrollerOpened()) {
            return new LinearSmoothScroller(this.mRecyclerView.getContext()) {
                /* access modifiers changed from: protected */
                public void onTargetFound(View targetView, RecyclerView.State state, RecyclerView.SmoothScroller.Action action) {
                    if (AutoContinuePlayDelegation.this.mRecyclerView != null) {
                        int[] snapDistances = calculateDistanceToFinalSnap(AutoContinuePlayDelegation.this.mRecyclerView.getLayoutManager(), targetView);
                        action.update(snapDistances[0], snapDistances[1], 240, this.mDecelerateInterpolator);
                    }
                }

                private int[] calculateDistanceToFinalSnap(RecyclerView.LayoutManager layoutManager, View targetView) {
                    int[] out = new int[2];
                    if (layoutManager.canScrollVertically()) {
                        out[1] = distanceToTop(layoutManager, targetView, AutoContinuePlayDelegation.this.getVerticalHelper(layoutManager));
                    }
                    return out;
                }

                private int distanceToTop(RecyclerView.LayoutManager layoutManager, View targetView, OrientationHelper helper) {
                    int containerTop;
                    int childTop = helper.getDecoratedStart(targetView);
                    if (layoutManager.getClipToPadding()) {
                        containerTop = helper.getStartAfterPadding();
                    } else {
                        containerTop = 0;
                    }
                    return childTop - containerTop;
                }

                /* access modifiers changed from: protected */
                public float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
                    return 100.0f / ((float) displayMetrics.densityDpi);
                }
            };
        }
        return null;
    }

    public boolean isAutoScrollerOpened() {
        return (getAutoContinuePlayABValue() == 2 || getAutoContinuePlayABValue() == 4) && TextUtils.equals(this.mBusiness, "moment") && this.autoPlayByUserOpSwitch && this.autoPlayMainSwitch;
    }

    public void setAutoPlayMainSwitch(boolean isOpen) {
        this.autoPlayMainSwitch = isOpen;
    }

    public boolean isFlingScrollerOpened() {
        if ((getAutoContinuePlayABValue() == 1 || getAutoContinuePlayABValue() == 4) && TextUtils.equals(this.mBusiness, "moment")) {
            return true;
        }
        return false;
    }

    private int getAutoContinuePlayABValue() {
        if (!sHasGetABValue) {
            if (PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getBoolean(AB_KEY, false)) {
                sABValue = 4;
            } else {
                sABValue = AbTestManager.getInstance().getSwitch(AB_KEY, 0);
            }
            sHasGetABValue = true;
        }
        return sABValue;
    }

    public void setOnFlingListener() {
        if (isFlingScrollerOpened()) {
            this.mRecyclerView.setOnFlingListener(new RecyclerView.OnFlingListener() {
                public boolean onFling(int velocityX, int velocityY) {
                    RecyclerView.LayoutManager layoutManager = AutoContinuePlayDelegation.this.mRecyclerView.getLayoutManager();
                    if (layoutManager == null || AutoContinuePlayDelegation.this.mRecyclerView.getAdapter() == null) {
                        return false;
                    }
                    ConfigOptions configOptions = ConfigOptions.obtainConfigOptions(AutoContinuePlayDelegation.this.mBusiness);
                    if (configOptions != null && configOptions.mNeedScrollReport) {
                        UbcReportHelper.reportTplScrollAction(UbcReportHelper.VALUE_MANUAL_FLING);
                    }
                    if (Math.abs(velocityY) <= AutoContinuePlayDelegation.this.mRecyclerView.getMinFlingVelocity() || !snapFromFling(layoutManager, velocityX, velocityY)) {
                        return false;
                    }
                    return true;
                }

                private boolean snapFromFling(RecyclerView.LayoutManager layoutManager, int velocityX, int velocityY) {
                    RecyclerView.SmoothScroller smoothScroller;
                    int targetPosition;
                    if (!(layoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) || (smoothScroller = AutoContinuePlayDelegation.this.getSmoothScroller()) == null || (targetPosition = findTargetSnapPosition(layoutManager, velocityX, velocityY)) == -1) {
                        return false;
                    }
                    smoothScroller.setTargetPosition(targetPosition);
                    layoutManager.startSmoothScroll(smoothScroller);
                    return true;
                }

                /* JADX WARNING: Removed duplicated region for block: B:39:0x0076  */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                private int findTargetSnapPosition(androidx.recyclerview.widget.RecyclerView.LayoutManager r12, int r13, int r14) {
                    /*
                        r11 = this;
                        int r0 = r12.getItemCount()
                        r1 = -1
                        if (r0 != 0) goto L_0x0008
                        return r1
                    L_0x0008:
                        r2 = 0
                        boolean r3 = r12.canScrollVertically()
                        if (r3 == 0) goto L_0x001a
                        com.baidu.searchbox.generalcommunity.ui.AutoContinuePlayDelegation r3 = com.baidu.searchbox.generalcommunity.ui.AutoContinuePlayDelegation.this
                        androidx.recyclerview.widget.OrientationHelper r3 = r3.getVerticalHelper(r12)
                        android.view.View r2 = r11.findStartView(r12, r3)
                        goto L_0x002a
                    L_0x001a:
                        boolean r3 = r12.canScrollHorizontally()
                        if (r3 == 0) goto L_0x002a
                        com.baidu.searchbox.generalcommunity.ui.AutoContinuePlayDelegation r3 = com.baidu.searchbox.generalcommunity.ui.AutoContinuePlayDelegation.this
                        androidx.recyclerview.widget.OrientationHelper r3 = r3.getHorizontalHelper(r12)
                        android.view.View r2 = r11.findStartView(r12, r3)
                    L_0x002a:
                        if (r2 != 0) goto L_0x002d
                        return r1
                    L_0x002d:
                        int r3 = r12.getPosition(r2)
                        if (r3 != r1) goto L_0x0034
                        return r1
                    L_0x0034:
                        boolean r1 = r12.canScrollHorizontally()
                        r4 = 0
                        r5 = 1
                        if (r1 == 0) goto L_0x0042
                        if (r13 <= 0) goto L_0x0040
                        r1 = r5
                        goto L_0x0041
                    L_0x0040:
                        r1 = r4
                    L_0x0041:
                        goto L_0x0047
                    L_0x0042:
                        if (r14 <= 0) goto L_0x0046
                        r1 = r5
                        goto L_0x0047
                    L_0x0046:
                        r1 = r4
                    L_0x0047:
                        r6 = 0
                        boolean r7 = r12 instanceof androidx.recyclerview.widget.RecyclerView.SmoothScroller.ScrollVectorProvider
                        if (r7 == 0) goto L_0x0066
                        r7 = r12
                        androidx.recyclerview.widget.RecyclerView$SmoothScroller$ScrollVectorProvider r7 = (androidx.recyclerview.widget.RecyclerView.SmoothScroller.ScrollVectorProvider) r7
                        int r8 = r0 + -1
                        android.graphics.PointF r8 = r7.computeScrollVectorForPosition(r8)
                        if (r8 == 0) goto L_0x0066
                        float r9 = r8.x
                        r10 = 0
                        int r9 = (r9 > r10 ? 1 : (r9 == r10 ? 0 : -1))
                        if (r9 < 0) goto L_0x0064
                        float r9 = r8.y
                        int r9 = (r9 > r10 ? 1 : (r9 == r10 ? 0 : -1))
                        if (r9 >= 0) goto L_0x0065
                    L_0x0064:
                        r4 = r5
                    L_0x0065:
                        r6 = r4
                    L_0x0066:
                        if (r6 == 0) goto L_0x006d
                        if (r1 == 0) goto L_0x0072
                        int r4 = r3 + -1
                        goto L_0x0073
                    L_0x006d:
                        if (r1 == 0) goto L_0x0072
                        int r4 = r3 + 1
                        goto L_0x0073
                    L_0x0072:
                        r4 = r3
                    L_0x0073:
                        if (r4 <= r3) goto L_0x007b
                        com.baidu.searchbox.generalcommunity.ui.AutoContinuePlayDelegation r5 = com.baidu.searchbox.generalcommunity.ui.AutoContinuePlayDelegation.this
                        int unused = r5.mLastFlingTopIndex = r4
                    L_0x007b:
                        return r4
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.generalcommunity.ui.AutoContinuePlayDelegation.AnonymousClass2.findTargetSnapPosition(androidx.recyclerview.widget.RecyclerView$LayoutManager, int, int):int");
                }

                private View findStartView(RecyclerView.LayoutManager layoutManager, OrientationHelper helper) {
                    int childCount = layoutManager.getChildCount();
                    if (childCount == 0) {
                        return null;
                    }
                    View closestChild = null;
                    int startest = Integer.MAX_VALUE;
                    for (int i2 = 0; i2 < childCount; i2++) {
                        View child = layoutManager.getChildAt(i2);
                        int childStart = helper.getDecoratedStart(child);
                        if (childStart < startest) {
                            startest = childStart;
                            closestChild = child;
                        }
                    }
                    return closestChild;
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public OrientationHelper getHorizontalHelper(RecyclerView.LayoutManager layoutManager) {
        if (this.mHorizontalHelper == null) {
            this.mHorizontalHelper = OrientationHelper.createHorizontalHelper(layoutManager);
        }
        return this.mHorizontalHelper;
    }

    /* access modifiers changed from: private */
    public OrientationHelper getVerticalHelper(RecyclerView.LayoutManager layoutManager) {
        if (this.mVerticalHelper == null) {
            this.mVerticalHelper = OrientationHelper.createVerticalHelper(layoutManager);
        }
        return this.mVerticalHelper;
    }

    public void tryToScrollToNextPlayedTpl(int nowTplPos) {
        RecyclerView.SmoothScroller smoothScroller;
        if (isAutoScrollerOpened() && (smoothScroller = getSmoothScroller()) != null && nowTplPos != -1) {
            int targetPosition = nowTplPos + 1;
            int count = this.mRecyclerView.getAdapter().getItemCount();
            if (targetPosition >= 0 && targetPosition < count) {
                this.mLastFlingTopIndex = -1;
                smoothScroller.setTargetPosition(targetPosition);
                this.mRecyclerView.getLayoutManager().startSmoothScroll(smoothScroller);
                ConfigOptions configOptions = ConfigOptions.obtainConfigOptions(this.mBusiness);
                if (configOptions != null && configOptions.mNeedScrollReport) {
                    UbcReportHelper.reportTplScrollAction(UbcReportHelper.VALUE_AUTO_FLING);
                }
            }
        }
    }

    public boolean onUserOperating(int opType) {
        if (!this.autoPlayByUserOpSwitch) {
            return false;
        }
        this.autoPlayByUserOpSwitch = false;
        return true;
    }

    public boolean onUserOperatingFinish(int opType) {
        if (this.autoPlayByUserOpSwitch) {
            return false;
        }
        this.autoPlayByUserOpSwitch = true;
        return true;
    }

    public int getLastFlingTopIndex() {
        return this.mLastFlingTopIndex;
    }
}
