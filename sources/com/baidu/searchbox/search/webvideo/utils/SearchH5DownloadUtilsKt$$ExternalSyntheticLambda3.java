package com.baidu.searchbox.search.webvideo.utils;

import androidx.core.util.Supplier;
import com.baidu.searchbox.video.plugin.videoplayer.model.BdVideoSeries;
import java.util.Map;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class SearchH5DownloadUtilsKt$$ExternalSyntheticLambda3 implements Supplier {
    public final /* synthetic */ BdVideoSeries f$0;
    public final /* synthetic */ Map f$1;
    public final /* synthetic */ String f$2;

    public /* synthetic */ SearchH5DownloadUtilsKt$$ExternalSyntheticLambda3(BdVideoSeries bdVideoSeries, Map map, String str) {
        this.f$0 = bdVideoSeries;
        this.f$1 = map;
        this.f$2 = str;
    }

    public final Object get() {
        return SearchH5DownloadUtilsKt.m2982getCurrentVideoInfo$lambda8$lambda7$lambda6(this.f$0, this.f$1, this.f$2);
    }
}
