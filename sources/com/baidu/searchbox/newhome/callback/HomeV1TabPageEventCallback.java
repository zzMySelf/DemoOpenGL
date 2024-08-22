package com.baidu.searchbox.newhome.callback;

import com.baidu.pyramid.annotation.tekes.StableApi;
import com.baidu.searchbox.feed.ioc.IFeedAdTrueViewController;
import com.baidu.searchbox.newhome.HomeV1TabViewRefreshType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@StableApi
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\"\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005H\u0016J \u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0005H\u0016¨\u0006\u0014"}, d2 = {"Lcom/baidu/searchbox/newhome/callback/HomeV1TabPageEventCallback;", "", "onContentPageAppear", "", "pageId", "", "onContentPageCreate", "onContentPageDestroy", "onContentPageDisappear", "onContentPagePause", "onContentPageResume", "onContentPageStop", "onContentRefresh", "refreshType", "Lcom/baidu/searchbox/newhome/HomeV1TabViewRefreshType;", "ext", "onContentScrollChange", "offsetY", "", "channelId", "lib-homepage-interface_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HomeV1TabPageEventCallback.kt */
public interface HomeV1TabPageEventCallback {
    void onContentPageAppear(String str);

    void onContentPageCreate(String str);

    void onContentPageDestroy(String str);

    void onContentPageDisappear(String str);

    void onContentPagePause(String str);

    void onContentPageResume(String str);

    void onContentPageStop(String str);

    void onContentRefresh(String str, HomeV1TabViewRefreshType homeV1TabViewRefreshType, String str2);

    void onContentScrollChange(String str, float f2, String str2);

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: HomeV1TabPageEventCallback.kt */
    public static final class DefaultImpls {
        public static void onContentScrollChange(HomeV1TabPageEventCallback homeV1TabPageEventCallback, String pageId, float offsetY, String channelId) {
            Intrinsics.checkNotNullParameter(pageId, "pageId");
            Intrinsics.checkNotNullParameter(channelId, "channelId");
        }

        public static void onContentRefresh(HomeV1TabPageEventCallback homeV1TabPageEventCallback, String pageId, HomeV1TabViewRefreshType refreshType, String ext) {
            Intrinsics.checkNotNullParameter(pageId, "pageId");
            Intrinsics.checkNotNullParameter(refreshType, IFeedAdTrueViewController.KEY_SCENE_TYPE_REFRESH);
        }

        public static void onContentPageCreate(HomeV1TabPageEventCallback homeV1TabPageEventCallback, String pageId) {
            Intrinsics.checkNotNullParameter(pageId, "pageId");
        }

        public static void onContentPageResume(HomeV1TabPageEventCallback homeV1TabPageEventCallback, String pageId) {
            Intrinsics.checkNotNullParameter(pageId, "pageId");
        }

        public static void onContentPagePause(HomeV1TabPageEventCallback homeV1TabPageEventCallback, String pageId) {
            Intrinsics.checkNotNullParameter(pageId, "pageId");
        }

        public static void onContentPageStop(HomeV1TabPageEventCallback homeV1TabPageEventCallback, String pageId) {
            Intrinsics.checkNotNullParameter(pageId, "pageId");
        }

        public static void onContentPageDestroy(HomeV1TabPageEventCallback homeV1TabPageEventCallback, String pageId) {
            Intrinsics.checkNotNullParameter(pageId, "pageId");
        }

        public static void onContentPageAppear(HomeV1TabPageEventCallback homeV1TabPageEventCallback, String pageId) {
            Intrinsics.checkNotNullParameter(pageId, "pageId");
        }

        public static void onContentPageDisappear(HomeV1TabPageEventCallback homeV1TabPageEventCallback, String pageId) {
            Intrinsics.checkNotNullParameter(pageId, "pageId");
        }
    }
}
