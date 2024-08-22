package com.baidu.searchbox.home.feed.listener;

import android.view.View;
import androidx.viewpager.widget.ViewPager;
import com.baidu.pyramid.annotation.tekes.StableApi;
import com.baidu.searchbox.home.container.lifecycle.IHomeEventListener;
import com.baidu.searchbox.home.container.lifecycle.IHomeFragmentEventListener;
import kotlin.Metadata;

@StableApi
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\bg\u0018\u00002\u00020\u00012\u00020\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\bH&J\n\u0010\t\u001a\u0004\u0018\u00010\nH&J\b\u0010\u000b\u001a\u00020\u0004H&J\b\u0010\f\u001a\u00020\u0004H&J\b\u0010\r\u001a\u00020\u000eH&J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000eH&J\b\u0010\u0011\u001a\u00020\u0004H&J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0014H&¨\u0006\u0015"}, d2 = {"Lcom/baidu/searchbox/home/feed/listener/IHomeFeedEventListener;", "Lcom/baidu/searchbox/home/container/lifecycle/IHomeEventListener;", "Lcom/baidu/searchbox/home/container/lifecycle/IHomeFragmentEventListener;", "forceOnHomeIfNeed", "", "getCurrentTabId", "", "getFeedTabLayout", "Landroid/view/View;", "getFeedViewPager", "Landroidx/viewpager/widget/ViewPager;", "hideFloatRefreshBtn", "initFeedView", "isCurrentTabRN", "", "isErnieShow", "isShow", "playHideManageTabBtnAnimIfNeed", "setCurrentPullState", "refreshState", "", "lib-homepage-interface_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: IHomeFeedEventListener.kt */
public interface IHomeFeedEventListener extends IHomeEventListener, IHomeFragmentEventListener {
    void forceOnHomeIfNeed();

    String getCurrentTabId();

    View getFeedTabLayout();

    ViewPager getFeedViewPager();

    void hideFloatRefreshBtn();

    void initFeedView();

    boolean isCurrentTabRN();

    void isErnieShow(boolean z);

    void playHideManageTabBtnAnimIfNeed();

    void setCurrentPullState(int i2);

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: IHomeFeedEventListener.kt */
    public static final class DefaultImpls {
        public static View getView(IHomeFeedEventListener iHomeFeedEventListener) {
            return IHomeEventListener.DefaultImpls.getView(iHomeFeedEventListener);
        }

        public static void onDestroy(IHomeFeedEventListener iHomeFeedEventListener) {
            IHomeEventListener.DefaultImpls.onDestroy(iHomeFeedEventListener);
        }

        public static void onFontSizeChanged(IHomeFeedEventListener iHomeFeedEventListener) {
            IHomeEventListener.DefaultImpls.onFontSizeChanged(iHomeFeedEventListener);
        }

        public static void onHomeHeaderVisible(IHomeFeedEventListener iHomeFeedEventListener, boolean visible) {
            IHomeEventListener.DefaultImpls.onHomeHeaderVisible(iHomeFeedEventListener, visible);
        }

        public static void onHomePageVisible(IHomeFeedEventListener iHomeFeedEventListener, boolean visible) {
            IHomeEventListener.DefaultImpls.onHomePageVisible(iHomeFeedEventListener, visible);
        }

        public static void onHomeScrollChange(IHomeFeedEventListener iHomeFeedEventListener, int curX, int curY, int oldX, int oldY, float scrollYPct, float scrollYPctFromLogoTop, float scrollYPctFromSearchBoxTop) {
            IHomeEventListener.DefaultImpls.onHomeScrollChange(iHomeFeedEventListener, curX, curY, oldX, oldY, scrollYPct, scrollYPctFromLogoTop, scrollYPctFromSearchBoxTop);
        }

        public static void onHomeScrollStateChange(IHomeFeedEventListener iHomeFeedEventListener, int oldState, int newState) {
            IHomeEventListener.DefaultImpls.onHomeScrollStateChange(iHomeFeedEventListener, oldState, newState);
        }

        public static void onHomeStateChanged(IHomeFeedEventListener iHomeFeedEventListener, int oldState, int newState, boolean byTouch) {
            IHomeEventListener.DefaultImpls.onHomeStateChanged(iHomeFeedEventListener, oldState, newState, byTouch);
        }

        public static void onLazyUiReady(IHomeFeedEventListener iHomeFeedEventListener) {
            IHomeEventListener.DefaultImpls.onLazyUiReady(iHomeFeedEventListener);
        }

        public static void onNightModeChanged(IHomeFeedEventListener iHomeFeedEventListener, boolean isNight) {
            IHomeEventListener.DefaultImpls.onNightModeChanged(iHomeFeedEventListener, isNight);
        }

        public static void onPause(IHomeFeedEventListener iHomeFeedEventListener) {
            IHomeFragmentEventListener.DefaultImpls.onPause(iHomeFeedEventListener);
        }

        public static void onResume(IHomeFeedEventListener iHomeFeedEventListener) {
            IHomeFragmentEventListener.DefaultImpls.onResume(iHomeFeedEventListener);
        }
    }
}
