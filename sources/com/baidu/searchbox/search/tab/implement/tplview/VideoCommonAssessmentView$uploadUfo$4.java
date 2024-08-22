package com.baidu.searchbox.search.tab.implement.tplview;

import com.baidu.searchbox.search.tab.utils.OnDataLoaded;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, d2 = {"com/baidu/searchbox/search/tab/implement/tplview/VideoCommonAssessmentView$uploadUfo$4", "Lcom/baidu/searchbox/search/tab/utils/OnDataLoaded;", "", "onDataLoaded", "", "data", "search_video_business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoCommonAssessmentView.kt */
public final class VideoCommonAssessmentView$uploadUfo$4 implements OnDataLoaded<String> {
    final /* synthetic */ VideoCommonAssessmentView this$0;

    VideoCommonAssessmentView$uploadUfo$4(VideoCommonAssessmentView $receiver) {
        this.this$0 = $receiver;
    }

    public void onDataLoaded(String data) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (!StringsKt.isBlank(data)) {
            this.this$0.firstSubmitId = new JSONObject(data).optString("id");
        }
    }
}
