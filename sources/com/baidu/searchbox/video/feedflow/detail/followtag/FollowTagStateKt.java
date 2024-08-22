package com.baidu.searchbox.video.feedflow.detail.followtag;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0010\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u001a\n\u0010\u0006\u001a\u00020\u0003*\u00020\u0007\u001a\n\u0010\b\u001a\u00020\u0003*\u00020\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"FAVORITE_PD", "", "checkFromPage", "", "state", "Lcom/baidu/searchbox/feed/detail/frame/AbsState;", "canShowFollowGuideTag", "Lcom/baidu/searchbox/video/feedflow/detail/followtag/FollowTagState;", "isShowingTag", "lib-flow-component_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: FollowTagState.kt */
public final class FollowTagStateKt {
    private static final String FAVORITE_PD = "favorite";

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0003, code lost:
        r1 = (com.baidu.searchbox.video.detail.core.model.IntentData) r4.select(com.baidu.searchbox.video.detail.core.model.IntentData.class);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean checkFromPage(com.baidu.searchbox.feed.detail.frame.AbsState r4) {
        /*
            r0 = 0
            if (r4 == 0) goto L_0x0010
            java.lang.Class<com.baidu.searchbox.video.detail.core.model.IntentData> r1 = com.baidu.searchbox.video.detail.core.model.IntentData.class
            java.lang.Object r1 = r4.select(r1)
            com.baidu.searchbox.video.detail.core.model.IntentData r1 = (com.baidu.searchbox.video.detail.core.model.IntentData) r1
            if (r1 == 0) goto L_0x0010
            java.lang.String r1 = r1.page
            goto L_0x0011
        L_0x0010:
            r1 = r0
        L_0x0011:
            java.lang.String r2 = ""
            if (r1 != 0) goto L_0x0016
            r1 = r2
        L_0x0016:
            if (r4 == 0) goto L_0x0024
            java.lang.Class<com.baidu.searchbox.video.detail.core.model.IntentData> r3 = com.baidu.searchbox.video.detail.core.model.IntentData.class
            java.lang.Object r3 = r4.select(r3)
            com.baidu.searchbox.video.detail.core.model.IntentData r3 = (com.baidu.searchbox.video.detail.core.model.IntentData) r3
            if (r3 == 0) goto L_0x0024
            java.lang.String r0 = r3.pd
        L_0x0024:
            if (r0 != 0) goto L_0x0027
            goto L_0x0028
        L_0x0027:
            r2 = r0
        L_0x0028:
            r0 = r2
            java.lang.String r2 = "favorite"
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r0)
            if (r2 != 0) goto L_0x003f
            boolean r2 = com.baidu.searchbox.video.detail.business.VideoBizUtilsKt.isFromUserHomePage(r1)
            if (r2 != 0) goto L_0x003d
            boolean r2 = com.baidu.searchbox.video.detail.business.VideoBizUtilsKt.isFromCollection(r1)
            if (r2 == 0) goto L_0x003f
        L_0x003d:
            r2 = 1
            goto L_0x0040
        L_0x003f:
            r2 = 0
        L_0x0040:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.detail.followtag.FollowTagStateKt.checkFromPage(com.baidu.searchbox.feed.detail.frame.AbsState):boolean");
    }

    public static final boolean isShowingTag(FollowTagState $this$isShowingTag) {
        Intrinsics.checkNotNullParameter($this$isShowingTag, "<this>");
        return (Intrinsics.areEqual((Object) $this$isShowingTag.getShowFollowedTag().getValue(), (Object) true) && !$this$isShowingTag.isDisableFollowedTag()) || $this$isShowingTag.isShowingRecommend() || $this$isShowingTag.isShowingRecommendReasonTag() || $this$isShowingTag.isBottomBarGuideLinkTagShowing() || $this$isShowingTag.isRelatedTagShowing() || $this$isShowingTag.isCommonTagShowing();
    }

    public static final boolean canShowFollowGuideTag(FollowTagState $this$canShowFollowGuideTag) {
        Intrinsics.checkNotNullParameter($this$canShowFollowGuideTag, "<this>");
        return !$this$canShowFollowGuideTag.isDisableFollowGuideTag() && !$this$canShowFollowGuideTag.isBottomBarGuideLinkTagShowing() && !$this$canShowFollowGuideTag.isExclusiveTagShowing() && !$this$canShowFollowGuideTag.isRelatedTagShowing() && Intrinsics.areEqual((Object) $this$canShowFollowGuideTag.getShowFollowedTag().getValue(), (Object) false) && $this$canShowFollowGuideTag.getGuideModel() != null && !$this$canShowFollowGuideTag.isCommonTagShowing();
    }
}
