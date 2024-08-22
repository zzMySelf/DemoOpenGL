package com.baidu.searchbox.feed.widget.tabsortpopwindow;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.baidu.searchbox.exclusion.popup.ExclusionType;
import com.baidu.searchbox.exclusion.popup.PopupExclusionManagerMap;
import com.baidu.searchbox.exclusion.popup.ShowStatus;
import com.baidu.searchbox.exclusion.popup.ShowStatusCallback;
import com.baidu.searchbox.feed.FeedPreferenceUtils;
import com.baidu.searchbox.feed.home.NewHomeFun;
import com.baidu.searchbox.feed.tab.SlidingTabLayout;
import com.baidu.searchbox.feed.tab.TabViewPager;
import com.baidu.searchbox.feed.tab.navigation.utils.FeedTabSortFloatManager;
import com.baidu.searchbox.feed.util.FeedTabStateDelegate;
import com.baidu.searchbox.feed.util.FeedUtil;
import com.baidu.searchbox.feed.widget.feedflow.IPagerView;
import com.baidu.searchbox.feed.widget.floatingwindow.IFloatingWidget;
import com.baidu.searchbox.feed.widget.floatingwindow.IFloatingWindowPolicy;
import java.lang.ref.WeakReference;

public class TabSortFloatWindowManager implements IFloatingWindowPolicy {
    private static final String CAN_SHOW_FLOAT = "canShowSortFloat";
    private static final int SHOW_POSITION = 7;
    private static final String TAG = "TabSortFloatWindowManager";
    public boolean hasShown = false;
    /* access modifiers changed from: private */
    public boolean isInterrupt = false;
    private WeakReference<Context> mContext;
    /* access modifiers changed from: private */
    public IFloatingWidget mFloatingWidget;
    private WeakReference<IPagerView> mPageView;
    private AnimatorSet mSortTabAnimSet;
    private View mTabView;

    public TabSortFloatWindowManager(Context context, IPagerView pagerView) {
        this.mContext = new WeakReference<>(context);
        this.mPageView = new WeakReference<>(pagerView);
    }

    public void setInterrupt(boolean interrupt) {
        this.isInterrupt = interrupt;
    }

    public void dismissByAnimation(float curY, float oldY, float rate) {
        boolean isScrollToUP = curY - oldY > 0.0f;
        this.isInterrupt = isScrollToUP;
        if (isShowing() && isScrollToUP && ((double) rate) > 0.9d) {
            hide();
        }
    }

    private boolean isShowing() {
        IFloatingWidget iFloatingWidget = this.mFloatingWidget;
        return iFloatingWidget != null && iFloatingWidget.isShowing();
    }

    private boolean isShouldShowing() {
        return loadData() && FeedPreferenceUtils.getBoolean(CAN_SHOW_FLOAT, false);
    }

    public void startShowGuide(SlidingTabLayout slidingTabLayout, TabViewPager viewPager) {
        FeedTabSortFloatManager.TabSortFloatModel model;
        if (slidingTabLayout != null && viewPager != null && (model = FeedTabSortFloatManager.getInstance().getTabSortFloatModel()) != null && !TextUtils.isEmpty(model.mTabAniId) && slidingTabLayout.getTabIndexByTabId(model.mTabAniId) < 7) {
            this.mTabView = slidingTabLayout.getTabViewByTabId(model.mTabAniId);
            show(viewPager);
        }
    }

    public void startFloatAnim(final View view2) {
        if (this.mSortTabAnimSet == null) {
            this.mSortTabAnimSet = new AnimatorSet();
            ObjectAnimator scaleInX = ObjectAnimator.ofFloat(this.mTabView, "scaleX", new float[]{1.0f, 1.2f, 1.0f, 1.2f, 1.0f});
            scaleInX.setDuration(1520);
            ObjectAnimator scaleInY = ObjectAnimator.ofFloat(this.mTabView, "scaleY", new float[]{1.0f, 1.2f, 1.0f, 1.2f, 1.0f});
            scaleInY.setDuration(1520);
            this.mSortTabAnimSet.play(scaleInX).with(scaleInY);
            this.mSortTabAnimSet.setInterpolator(new LinearInterpolator());
            this.mSortTabAnimSet.addListener(new Animator.AnimatorListener() {
                public void onAnimationStart(Animator animation) {
                }

                public void onAnimationEnd(Animator animation) {
                    TabSortFloatWindowManager.this.mFloatingWidget.show(view2);
                }

                public void onAnimationCancel(Animator animation) {
                }

                public void onAnimationRepeat(Animator animation) {
                }
            });
        }
        if (!this.mSortTabAnimSet.isStarted()) {
            this.mSortTabAnimSet.start();
        }
    }

    public void show(View view2) {
        if (view2 != null) {
            if (NewHomeFun.INSTANCE.isNewHome() && !FeedTabStateDelegate.getInstance().isTabVisible()) {
                FeedUtil.newHomeLog(TAG, "[show]: 新首页且FeedTab隐藏时 不应该显示");
            } else if ((NewHomeFun.INSTANCE.isNewHome() || !FeedTabStateDelegate.getInstance().isOldHomeTabHide()) && isShouldShowing()) {
                final View view3 = view2;
                PopupExclusionManagerMap.getInstance().display("scene_home", new PopupExclusionManagerMap.Operation(ExclusionType.HOME_TAB_SORT_GUIDE, 5.9f, false, true) {
                    public void onShow(ShowStatusCallback callback) {
                        if (TabSortFloatWindowManager.this.shouldInterrupt(view3)) {
                            boolean unused = TabSortFloatWindowManager.this.isInterrupt = true;
                            callback.callback(ShowStatus.NOT_SHOW);
                            PopupExclusionManagerMap.getInstance().unDisplay("scene_home", ExclusionType.HOME_TAB_SORT_GUIDE, true);
                            return;
                        }
                        TabSortFloatWindowManager.this.startFloatAnim(view3);
                        if (TabSortFloatWindowManager.this.mFloatingWidget.isShowing()) {
                            callback.callback(ShowStatus.REAL_SHOW);
                            TabSortFloatWindowManager.this.hasShown = true;
                            return;
                        }
                        callback.callback(ShowStatus.NOT_SHOW);
                        PopupExclusionManagerMap.getInstance().unDisplay("scene_home", ExclusionType.HOME_TAB_SORT_GUIDE, true);
                    }

                    public void onBreaked() {
                        TabSortFloatWindowManager.this.hide();
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    public boolean shouldInterrupt(View view2) {
        if (this.isInterrupt || !isActivityRunning(view2) || this.mFloatingWidget == null) {
            return true;
        }
        return false;
    }

    private boolean isActivityRunning(View anchorView) {
        if (anchorView == null) {
            return false;
        }
        Context context = anchorView.getContext();
        if (context instanceof Activity) {
            return !((Activity) context).isFinishing();
        }
        return false;
    }

    public void hide() {
        stopAnim();
        this.isInterrupt = true;
        this.mTabView = null;
        IFloatingWidget iFloatingWidget = this.mFloatingWidget;
        if (iFloatingWidget != null) {
            iFloatingWidget.hide();
        }
    }

    private void stopAnim() {
        AnimatorSet animatorSet = this.mSortTabAnimSet;
        if (animatorSet != null) {
            animatorSet.cancel();
            this.mSortTabAnimSet.removeAllListeners();
        }
        View view2 = this.mTabView;
        if (view2 != null) {
            view2.setScaleX(1.0f);
            this.mTabView.setScaleY(1.0f);
            this.mTabView.setAlpha(1.0f);
        }
    }

    private boolean loadData() {
        FeedTabSortFloatManager.TabSortFloatModel model = FeedTabSortFloatManager.getInstance().getTabSortFloatModel();
        if (model == null) {
            return false;
        }
        dispatchFloatingInfo(model);
        return true;
    }

    private void dispatchFloatingInfo(FeedTabSortFloatManager.TabSortFloatModel model) {
        Context context = getContext();
        IPagerView pageView = getPageView();
        if (context != null && pageView != null && this.mFloatingWidget == null) {
            this.mFloatingWidget = new TabSortPopupWindow(context, pageView);
        }
    }

    private Context getContext() {
        WeakReference<Context> weakReference = this.mContext;
        if (weakReference != null) {
            return (Context) weakReference.get();
        }
        return null;
    }

    private IPagerView getPageView() {
        WeakReference<IPagerView> weakReference = this.mPageView;
        if (weakReference != null) {
            return (IPagerView) weakReference.get();
        }
        return null;
    }
}
