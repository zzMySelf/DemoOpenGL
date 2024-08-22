package com.baidu.searchbox.video.search.container;

import android.content.Intent;
import com.baidu.searchbox.video.detail.core.IntextDataExtKt;
import com.baidu.searchbox.video.detail.core.model.IntentData;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/video/detail/core/model/IntentData;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: SearchFlowContainer.kt */
final class SearchFlowContainer$paramIntentData$2 extends Lambda implements Function0<IntentData> {
    final /* synthetic */ SearchFlowContainer this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SearchFlowContainer$paramIntentData$2(SearchFlowContainer searchFlowContainer) {
        super(0);
        this.this$0 = searchFlowContainer;
    }

    public final IntentData invoke() {
        Intent activityIntent = this.this$0.getActivityIntent();
        if (activityIntent != null) {
            return IntextDataExtKt.parseSearchIntentData$default(activityIntent, false, 1, (Object) null);
        }
        return null;
    }
}
