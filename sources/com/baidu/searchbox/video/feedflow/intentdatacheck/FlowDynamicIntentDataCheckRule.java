package com.baidu.searchbox.video.feedflow.intentdatacheck;

import com.baidu.searchbox.video.detail.core.exception.IntentDataCheckCondition;
import com.baidu.searchbox.video.detail.core.exception.IntentDataCheckRule;
import com.baidu.searchbox.video.detail.core.model.IntentData;
import com.baidu.searchbox.video.feedflow.flow.list.ItemTypeManifestKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001a\u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n0\t0\bH\u0016¨\u0006\u000b"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/intentdatacheck/FlowDynamicIntentDataCheckRule;", "Lcom/baidu/searchbox/video/detail/core/exception/IntentDataCheckRule;", "()V", "canCheckCondition", "", "intentData", "Lcom/baidu/searchbox/video/detail/core/model/IntentData;", "collectCondition", "", "Lkotlin/Function1;", "", "feed-flow_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FlowDynamicIntentDataCheckRule.kt */
public final class FlowDynamicIntentDataCheckRule implements IntentDataCheckRule {
    public boolean canCheckCondition(IntentData intentData) {
        Intrinsics.checkNotNullParameter(intentData, "intentData");
        if (Intrinsics.areEqual((Object) intentData.defaultTpl, (Object) "flowfeed")) {
            String str = intentData.layout;
            if (str == null) {
                str = "";
            }
            if (ItemTypeManifestKt.isDynamicItem(str)) {
                return true;
            }
        }
        return false;
    }

    public List<Function1<IntentData, Unit>> collectCondition() {
        return CollectionsKt.mutableListOf(new FlowDynamicIntentDataCheckRule$collectCondition$1(IntentDataCheckCondition.INSTANCE), new FlowDynamicIntentDataCheckRule$collectCondition$2(IntentDataCheckCondition.INSTANCE));
    }
}
