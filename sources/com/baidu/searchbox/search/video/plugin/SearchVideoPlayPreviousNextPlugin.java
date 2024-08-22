package com.baidu.searchbox.search.video.plugin;

import com.baidu.searchbox.video.detail.plugin.component.previousnextplay.PlayPreviousNextPlugin;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0014J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lcom/baidu/searchbox/search/video/plugin/SearchVideoPlayPreviousNextPlugin;", "Lcom/baidu/searchbox/video/detail/plugin/component/previousnextplay/PlayPreviousNextPlugin;", "()V", "reportFeedDisplay", "", "reportNextVideo", "videoInfo", "", "isPrevious", "", "lib-feed-video_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SearchVideoPlayPreviousNextPlugin.kt */
public final class SearchVideoPlayPreviousNextPlugin extends PlayPreviousNextPlugin {
    /* access modifiers changed from: protected */
    public void reportFeedDisplay() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000f, code lost:
        r0 = (r0 = r0.currentModel).intentData;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void reportNextVideo(java.lang.String r6, boolean r7) {
        /*
            r5 = this;
            java.lang.String r0 = "videoInfo"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            com.baidu.searchbox.video.detail.core.ComponentManager r0 = r5.mComponentManager
            r1 = 0
            if (r0 == 0) goto L_0x0016
            com.baidu.searchbox.video.detail.core.model.VideoDetailModel r0 = r0.currentModel
            if (r0 == 0) goto L_0x0016
            com.baidu.searchbox.video.detail.core.model.IntentData r0 = r0.intentData
            if (r0 == 0) goto L_0x0016
            java.lang.String r0 = r0.collectionMode
            goto L_0x0017
        L_0x0016:
            r0 = r1
        L_0x0017:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            r0 = r0 ^ 1
            com.baidu.searchbox.video.detail.core.ComponentManager r2 = r5.mComponentManager
            if (r2 == 0) goto L_0x002a
            com.baidu.searchbox.video.detail.core.model.VideoDetailModel r2 = r2.currentModel
            if (r2 == 0) goto L_0x002a
            java.lang.String r2 = r2.ext
            goto L_0x002b
        L_0x002a:
            r2 = r1
        L_0x002b:
            com.baidu.searchbox.video.detail.core.ComponentManager r3 = r5.mComponentManager
            if (r3 == 0) goto L_0x003a
            com.baidu.searchbox.video.detail.core.model.VideoDetailModel r3 = r3.currentModel
            if (r3 == 0) goto L_0x003a
            com.baidu.searchbox.video.detail.core.model.IntentData r3 = r3.intentData
            if (r3 == 0) goto L_0x003a
            org.json.JSONObject r3 = r3.extRequest
            goto L_0x003b
        L_0x003a:
            r3 = r1
        L_0x003b:
            if (r0 == 0) goto L_0x004c
            com.baidu.searchbox.video.detail.core.ComponentManager r4 = r5.mComponentManager
            if (r4 == 0) goto L_0x0055
            com.baidu.searchbox.video.detail.core.model.VideoDetailModel r4 = r4.currentModel
            if (r4 == 0) goto L_0x0055
            com.baidu.searchbox.video.detail.core.model.IntentData r4 = r4.intentData
            if (r4 == 0) goto L_0x0055
            java.lang.String r1 = r4.collectionMode
            goto L_0x0055
        L_0x004c:
            if (r7 == 0) goto L_0x0052
            java.lang.String r1 = "player_left"
            goto L_0x0055
        L_0x0052:
            java.lang.String r1 = "player_right"
        L_0x0055:
            com.baidu.searchbox.search.video.statistic.SearchVideoTcUtils.uploadNextPlayTcLog(r2, r3, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.search.video.plugin.SearchVideoPlayPreviousNextPlugin.reportNextVideo(java.lang.String, boolean):void");
    }
}
