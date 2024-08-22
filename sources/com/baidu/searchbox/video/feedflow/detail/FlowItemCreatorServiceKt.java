package com.baidu.searchbox.video.feedflow.detail;

import com.baidu.searchbox.video.feedflow.flow.list.ItemTypeManifestKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¨\u0006\u0004"}, d2 = {"isFeedFlowSupportLayout", "", "layout", "", "feed-flow_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: FlowItemCreatorService.kt */
public final class FlowItemCreatorServiceKt {
    public static final boolean isFeedFlowSupportLayout(String layout) {
        Intrinsics.checkNotNullParameter(layout, "layout");
        if (!ItemTypeManifestKt.isVideoItem(layout) && !ItemTypeManifestKt.isAdItem(layout) && !ItemTypeManifestKt.isLiveItem(layout) && !ItemTypeManifestKt.isAssessmentItem(layout) && !ItemTypeManifestKt.isFollowBatchItem(layout) && !ItemTypeManifestKt.isFollowGuideItem(layout) && !ItemTypeManifestKt.isDynamicItem(layout) && !ItemTypeManifestKt.isPaymentItem(layout) && !ItemTypeManifestKt.isInterestItem(layout) && !ItemTypeManifestKt.isAdLiveItem(layout) && !ItemTypeManifestKt.isGuessLikeItem(layout) && !ItemTypeManifestKt.isRealLiveRoomItem(layout) && !ItemTypeManifestKt.isTalosItem(layout) && !ItemTypeManifestKt.isAuditVideoItem(layout) && !ItemTypeManifestKt.isSoftAdLiveItem(layout) && !ItemTypeManifestKt.isLoadingItem(layout)) {
            return false;
        }
        return true;
    }
}
