package com.baidu.searchbox.search.service;

import android.view.MotionEvent;
import android.view.View;
import com.baidu.searchbox.search.component.VideoTabSubTabViewComponent;
import com.baidu.searchbox.search.tab.implement.service.ISubTabViewService;
import com.baidu.searchbox.search.tab.subTab.VideoCommonSubTabListView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/baidu/searchbox/search/service/SubTabViewService;", "Lcom/baidu/searchbox/search/tab/implement/service/ISubTabViewService;", "component", "Lcom/baidu/searchbox/search/component/VideoTabSubTabViewComponent;", "(Lcom/baidu/searchbox/search/component/VideoTabSubTabViewComponent;)V", "getTabSearchView", "Lcom/baidu/searchbox/search/tab/subTab/VideoCommonSubTabListView;", "isSlidAble", "", "motionEvent", "Landroid/view/MotionEvent;", "lib_search_video_tab_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SubTabViewService.kt */
public final class SubTabViewService implements ISubTabViewService {
    private VideoTabSubTabViewComponent component;

    public SubTabViewService(VideoTabSubTabViewComponent component2) {
        Intrinsics.checkNotNullParameter(component2, "component");
        this.component = component2;
    }

    public VideoCommonSubTabListView getTabSearchView() {
        VideoTabSubTabViewComponent videoTabSubTabViewComponent = this.component;
        View contentView = videoTabSubTabViewComponent != null ? videoTabSubTabViewComponent.getContentView() : null;
        if (contentView != null) {
            return (VideoCommonSubTabListView) contentView;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.baidu.searchbox.search.tab.subTab.VideoCommonSubTabListView");
    }

    public boolean isSlidAble(MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, "motionEvent");
        VideoTabSubTabViewComponent videoTabSubTabViewComponent = this.component;
        if (videoTabSubTabViewComponent != null) {
            return videoTabSubTabViewComponent.isSlidAble(motionEvent);
        }
        return false;
    }
}
