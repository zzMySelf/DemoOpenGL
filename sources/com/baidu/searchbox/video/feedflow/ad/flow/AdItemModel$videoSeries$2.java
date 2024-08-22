package com.baidu.searchbox.video.feedflow.ad.flow;

import com.baidu.searchbox.video.plugin.videoplayer.model.BdVideoSeries;
import com.baidu.searchbox.video.videoplayer.util.VideoInfoParser;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/video/plugin/videoplayer/model/BdVideoSeries;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: AdItemModel.kt */
final class AdItemModel$videoSeries$2 extends Lambda implements Function0<BdVideoSeries> {
    final /* synthetic */ AdItemModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AdItemModel$videoSeries$2(AdItemModel adItemModel) {
        super(0);
        this.this$0 = adItemModel;
    }

    public final BdVideoSeries invoke() {
        return VideoInfoParser.parseVideoInfo(this.this$0.getVideoInfo());
    }
}
