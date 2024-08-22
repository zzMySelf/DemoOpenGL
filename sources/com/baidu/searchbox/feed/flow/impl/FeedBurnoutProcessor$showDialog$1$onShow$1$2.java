package com.baidu.searchbox.feed.flow.impl;

import com.baidu.searchbox.exclusion.popup.ExclusionType;
import com.baidu.searchbox.exclusion.popup.PopupExclusionManagerMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: FeedBurnoutProcessor.kt */
final class FeedBurnoutProcessor$showDialog$1$onShow$1$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ FeedBurnoutProcessor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FeedBurnoutProcessor$showDialog$1$onShow$1$2(FeedBurnoutProcessor feedBurnoutProcessor) {
        super(0);
        this.this$0 = feedBurnoutProcessor;
    }

    public final void invoke() {
        if (!this.this$0.hasBreak) {
            PopupExclusionManagerMap.getInstance().unDisplay("scene_home", ExclusionType.HOME_FEED_BURNOUT_GUIDE);
        }
    }
}
