package com.baidu.browser.components.videotranscoding;

import android.util.Log;
import com.baidu.browser.components.videotranscoding.net.MainTransRepoKt;
import com.baidu.search.core.utils.BrowserUrlUtils;
import com.baidu.searchbox.config.AppConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoTransComponent.kt */
final class VideoTransComponent$prefetchVideo$1 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ String $pageUrl;
    final /* synthetic */ String $prefetchUrl;
    final /* synthetic */ String $source;
    final /* synthetic */ VideoTransComponent this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    VideoTransComponent$prefetchVideo$1(VideoTransComponent videoTransComponent, String str, String str2, String str3) {
        super(1);
        this.this$0 = videoTransComponent;
        this.$source = str;
        this.$prefetchUrl = str2;
        this.$pageUrl = str3;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((String) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (StringsKt.isBlank(it)) {
            if (AppConfig.isDebug()) {
                Log.d(MainTransRepoKt.VIDEO_TRANS_TAG, "预取视频Url为空");
            }
        } else if (BrowserUrlUtils.checkSearchResultUrl(this.this$0.getManager().getPageViewContext().getCurrentUrl())) {
        } else {
            if (Intrinsics.areEqual((Object) this.$source, (Object) VideoTransComponentKt.TRANS_PLAY_PREFETCH)) {
                String nextPageUrl = this.$prefetchUrl;
                if (nextPageUrl != null) {
                    this.this$0.startPrerenderVideo(nextPageUrl, it, 1);
                    return;
                }
                return;
            }
            VideoTransComponent.doPrefetchVideo$default(this.this$0, this.$pageUrl, it, this.$source, 0, 0, 24, (Object) null);
        }
    }
}
