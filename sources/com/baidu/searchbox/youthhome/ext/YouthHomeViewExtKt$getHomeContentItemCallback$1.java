package com.baidu.searchbox.youthhome.ext;

import com.baidu.searchbox.feed.ioc.IFeedAdTrueViewController;
import com.baidu.searchbox.newhome.HomeV1TabViewRefreshType;
import com.baidu.searchbox.youthhome.YouthHomeView;
import com.baidu.searchbox.youthhome.callback.YouthHomeContentFragmentCallback;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\"\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\r"}, d2 = {"com/baidu/searchbox/youthhome/ext/YouthHomeViewExtKt$getHomeContentItemCallback$1", "Lcom/baidu/searchbox/youthhome/callback/YouthHomeContentFragmentCallback;", "onContentPageSelected", "", "from", "", "to", "onContentRefresh", "pageId", "", "refreshType", "Lcom/baidu/searchbox/newhome/HomeV1TabViewRefreshType;", "ext", "youth-home-page_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: YouthHomeViewExt.kt */
public final class YouthHomeViewExtKt$getHomeContentItemCallback$1 implements YouthHomeContentFragmentCallback {
    final /* synthetic */ YouthHomeView $this_getHomeContentItemCallback;

    YouthHomeViewExtKt$getHomeContentItemCallback$1(YouthHomeView $receiver) {
        this.$this_getHomeContentItemCallback = $receiver;
    }

    public boolean isReceiveAllContentEvent() {
        return YouthHomeContentFragmentCallback.DefaultImpls.isReceiveAllContentEvent(this);
    }

    public void onContentRefresh(String pageId, HomeV1TabViewRefreshType refreshType, String ext) {
        Intrinsics.checkNotNullParameter(pageId, "pageId");
        Intrinsics.checkNotNullParameter(refreshType, IFeedAdTrueViewController.KEY_SCENE_TYPE_REFRESH);
        this.$this_getHomeContentItemCallback.getHomeEventRegistry$youth_home_page_release().dispatchContentRefreshEvent$youth_home_page_release(pageId, refreshType, ext);
    }

    public void onContentPageSelected(int from, int to) {
        this.$this_getHomeContentItemCallback.getHomeEventRegistry$youth_home_page_release().dispatchContentPageSelected(from, to);
    }
}
