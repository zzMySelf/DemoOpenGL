package com.baidu.searchbox.search.video.plugin;

import android.text.TextUtils;
import com.baidu.searchbox.interfaces.IAdSuffixLayerProxy;
import com.baidu.searchbox.player.ShortVideoPlayer;
import com.baidu.searchbox.video.detail.plugin.component.gaplessplay.GaplessPlayPlugin;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0014J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0014J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0006H\u0016J\b\u0010\r\u001a\u00020\bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/baidu/searchbox/search/video/plugin/SearchVideoGaplessPlayPlugin;", "Lcom/baidu/searchbox/video/detail/plugin/component/gaplessplay/GaplessPlayPlugin;", "()V", "getNextPlayType", "", "playType", "", "isNextPlayTipsCanShow", "", "reportFeedDisplay", "", "reportGaplessDataDisplay", "clkType", "willShowAd", "lib-feed-video_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SearchVideoGaplessPlayPlugin.kt */
public final class SearchVideoGaplessPlayPlugin extends GaplessPlayPlugin {
    /* access modifiers changed from: protected */
    public void reportFeedDisplay() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0005, code lost:
        r0 = r0.currentModel;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void reportGaplessDataDisplay(int r6) {
        /*
            r5 = this;
            com.baidu.searchbox.video.detail.core.ComponentManager r0 = r5.mComponentManager
            r1 = 0
            if (r0 == 0) goto L_0x000c
            com.baidu.searchbox.video.detail.core.model.VideoDetailModel r0 = r0.currentModel
            if (r0 == 0) goto L_0x000c
            java.lang.String r0 = r0.ext
            goto L_0x000d
        L_0x000c:
            r0 = r1
        L_0x000d:
            com.baidu.searchbox.video.detail.core.ComponentManager r2 = r5.mComponentManager
            if (r2 == 0) goto L_0x001c
            com.baidu.searchbox.video.detail.core.model.VideoDetailModel r2 = r2.currentModel
            if (r2 == 0) goto L_0x001c
            com.baidu.searchbox.video.detail.core.model.IntentData r2 = r2.intentData
            if (r2 == 0) goto L_0x001c
            org.json.JSONObject r2 = r2.extRequest
            goto L_0x001d
        L_0x001c:
            r2 = r1
        L_0x001d:
            java.lang.String r3 = r5.getNextPlayType(r6)
            com.baidu.searchbox.video.detail.core.ComponentManager r4 = r5.mComponentManager
            if (r4 == 0) goto L_0x002f
            com.baidu.searchbox.video.detail.core.model.VideoDetailModel r4 = r4.currentModel
            if (r4 == 0) goto L_0x002f
            com.baidu.searchbox.video.detail.core.model.IntentData r4 = r4.intentData
            if (r4 == 0) goto L_0x002f
            java.lang.String r1 = r4.collectionMode
        L_0x002f:
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            r1 = r1 ^ 1
            com.baidu.searchbox.search.video.statistic.SearchVideoTcUtils.uploadNextPlayTcLog(r0, r2, r3, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.search.video.plugin.SearchVideoGaplessPlayPlugin.reportGaplessDataDisplay(int):void");
    }

    public boolean willShowAd() {
        IAdSuffixLayerProxy adLayerProxy;
        ShortVideoPlayer player = getPlayer();
        if (player == null || (adLayerProxy = player.getAdLayerProxy()) == null) {
            return false;
        }
        return adLayerProxy.shouldShowSuffixAd();
    }

    /* access modifiers changed from: protected */
    public String getNextPlayType(int playType) {
        if (!TextUtils.isEmpty(this.mComponentManager.currentModel.intentData.collectionMode)) {
            return this.mComponentManager.currentModel.intentData.collectionMode;
        }
        return playType == 0 ? "streamless_auto" : "streamless_drive";
    }

    public boolean isNextPlayTipsCanShow() {
        return false;
    }
}
