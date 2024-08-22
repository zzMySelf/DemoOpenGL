package com.baidu.searchbox.video.feedflow.cache.utils;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0002\u001a\u00020\u0003*\u00020\u0004\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"OFFLINE_CACHE_HELPER_TAG", "", "isSecondInsertType", "", "Lcom/baidu/searchbox/video/feedflow/cache/utils/InsertType;", "lib-flow-component_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: FlowVideoOfflineInsertCacheHelper.kt */
public final class FlowVideoOfflineInsertCacheHelperKt {
    public static final String OFFLINE_CACHE_HELPER_TAG = "FlowVideoOfflineInsertCacheHelper";

    public static final boolean isSecondInsertType(InsertType $this$isSecondInsertType) {
        Intrinsics.checkNotNullParameter($this$isSecondInsertType, "<this>");
        return $this$isSecondInsertType == InsertType.SECOND_WITHOUT_NET || $this$isSecondInsertType == InsertType.SECOND_BAD_NET || $this$isSecondInsertType == InsertType.SECOND_LAST_ONE || $this$isSecondInsertType == InsertType.SCROLL_NO_DATA;
    }
}
