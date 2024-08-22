package com.baidu.searchbox.feed.news.flowlinkage.linkage;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.searchbox.feed.news.leftslide.LeftSlidePersonalPageController;
import com.baidu.searchbox.lightbrowser.container.base.IFrameContext;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0003H&J\b\u0010\t\u001a\u00020\u0003H&J\b\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\u000bH&J\b\u0010\r\u001a\u00020\u0003H&J\b\u0010\u000e\u001a\u00020\u0003H&J\n\u0010\u000f\u001a\u0004\u0018\u00010\u0010H&J\b\u0010\u0011\u001a\u00020\u0003H&J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u000bH&J\u0012\u0010\u0014\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0010H&¨\u0006\u0016"}, d2 = {"Lcom/baidu/searchbox/feed/news/flowlinkage/linkage/INewsFlowAdapter;", "Lcom/baidu/searchbox/lightbrowser/container/base/IFrameContext;", "addLeftSlideDrawerContent", "", "view", "Landroid/view/View;", "layoutParams", "Landroid/view/ViewGroup$LayoutParams;", "closeLeftSlideDrawer", "hasShowPrevGuide", "isDrawerClosed", "", "isShowPrevGuide", "notifyLinkageReachBottom", "notifyPageFinished", "obtainPersonalPageController", "Lcom/baidu/searchbox/feed/news/leftslide/LeftSlidePersonalPageController;", "requestScrollToNext", "setLeftSlideEnabled", "canSlide", "setPersonalPageController", "personalPageController", "lib-feed-news_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: INewsFlowAdapter.kt */
public interface INewsFlowAdapter extends IFrameContext {
    void addLeftSlideDrawerContent(View view2, ViewGroup.LayoutParams layoutParams);

    void closeLeftSlideDrawer();

    void hasShowPrevGuide();

    boolean isDrawerClosed();

    boolean isShowPrevGuide();

    void notifyLinkageReachBottom();

    void notifyPageFinished();

    LeftSlidePersonalPageController obtainPersonalPageController();

    void requestScrollToNext();

    void setLeftSlideEnabled(boolean z);

    void setPersonalPageController(LeftSlidePersonalPageController leftSlidePersonalPageController);
}
