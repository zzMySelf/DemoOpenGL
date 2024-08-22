package com.baidu.searchbox.video.feedflow.detail.commentbubble;

import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.video.detail.utils.DateUtilsKt;
import java.util.Date;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u001c\u0010\t\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\b¨\u0006\f"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/commentbubble/CommentBubbleHelper;", "", "()V", "isAbSwitchOnAndShowTimesValid", "", "state", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "nid", "", "isSwitchOnAndShowTimesValid", "recordCommentBubbleShown", "", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CommentBubbleHelper.kt */
public final class CommentBubbleHelper {
    public static final CommentBubbleHelper INSTANCE = new CommentBubbleHelper();

    private CommentBubbleHelper() {
    }

    public static /* synthetic */ boolean isSwitchOnAndShowTimesValid$default(CommentBubbleHelper commentBubbleHelper, CommonState commonState, String str, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str = null;
        }
        return commentBubbleHelper.isSwitchOnAndShowTimesValid(commonState, str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0010, code lost:
        r2 = (r2 = (com.baidu.searchbox.video.feedflow.detail.commentbubble.CommentBubbleState) r6.select(com.baidu.searchbox.video.feedflow.detail.commentbubble.CommentBubbleState.class)).getRequestModel();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean isSwitchOnAndShowTimesValid(com.baidu.searchbox.feed.detail.arch.ext.CommonState r6, java.lang.String r7) {
        /*
            r5 = this;
            r0 = 1
            r1 = 0
            if (r6 == 0) goto L_0x001e
            r2 = r6
            r3 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.commentbubble.CommentBubbleState> r4 = com.baidu.searchbox.video.feedflow.detail.commentbubble.CommentBubbleState.class
            java.lang.Object r2 = r2.select(r4)
            com.baidu.searchbox.video.feedflow.detail.commentbubble.CommentBubbleState r2 = (com.baidu.searchbox.video.feedflow.detail.commentbubble.CommentBubbleState) r2
            if (r2 == 0) goto L_0x001e
            com.baidu.searchbox.video.feedflow.detail.commentbubble.CommentBubbleRequestModel r2 = r2.getRequestModel()
            if (r2 == 0) goto L_0x001e
            boolean r2 = r2.getCommentConfBubbleSwitch()
            if (r2 != r0) goto L_0x001e
            r2 = r0
            goto L_0x001f
        L_0x001e:
            r2 = r1
        L_0x001f:
            if (r2 == 0) goto L_0x0028
            boolean r3 = r5.isAbSwitchOnAndShowTimesValid(r6, r7)
            if (r3 == 0) goto L_0x0028
            goto L_0x0029
        L_0x0028:
            r0 = r1
        L_0x0029:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.detail.commentbubble.CommentBubbleHelper.isSwitchOnAndShowTimesValid(com.baidu.searchbox.feed.detail.arch.ext.CommonState, java.lang.String):boolean");
    }

    public static /* synthetic */ boolean isAbSwitchOnAndShowTimesValid$default(CommentBubbleHelper commentBubbleHelper, CommonState commonState, String str, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str = null;
        }
        return commentBubbleHelper.isAbSwitchOnAndShowTimesValid(commonState, str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0005, code lost:
        r1 = (com.baidu.searchbox.video.feedflow.flow.list.ItemModel) r8.select(com.baidu.searchbox.video.feedflow.flow.list.ItemModel.class);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean isAbSwitchOnAndShowTimesValid(com.baidu.searchbox.feed.detail.arch.ext.CommonState r8, java.lang.String r9) {
        /*
            r7 = this;
            r0 = 0
            if (r9 != 0) goto L_0x001c
            if (r8 == 0) goto L_0x0016
            r1 = r8
            r2 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.list.ItemModel> r3 = com.baidu.searchbox.video.feedflow.flow.list.ItemModel.class
            java.lang.Object r1 = r1.select(r3)
            com.baidu.searchbox.video.feedflow.flow.list.ItemModel r1 = (com.baidu.searchbox.video.feedflow.flow.list.ItemModel) r1
            if (r1 == 0) goto L_0x0016
            java.lang.String r1 = r1.getNid()
            goto L_0x0017
        L_0x0016:
            r1 = r0
        L_0x0017:
            if (r1 != 0) goto L_0x001d
            java.lang.String r1 = ""
            goto L_0x001d
        L_0x001c:
            r1 = r9
        L_0x001d:
            com.baidu.searchbox.video.feedflow.common.FlowSwitchState r2 = com.baidu.searchbox.video.feedflow.common.FlowSwitchStateKt.flowSwitchState((com.baidu.searchbox.feed.detail.arch.ext.CommonState) r8)
            com.baidu.searchbox.video.feedflow.detail.commentbubble.CommentBubbleConf r2 = r2.getCommentBubbleConfig()
            if (r2 == 0) goto L_0x0030
            boolean r2 = r2.getAbSwitch()
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            goto L_0x0031
        L_0x0030:
            r2 = r0
        L_0x0031:
            boolean r2 = com.baidu.searchbox.player.utils.BdPlayerUtils.orFalse(r2)
            com.baidu.searchbox.video.feedflow.common.FlowSwitchState r3 = com.baidu.searchbox.video.feedflow.common.FlowSwitchStateKt.flowSwitchState((com.baidu.searchbox.feed.detail.arch.ext.CommonState) r8)
            com.baidu.searchbox.video.feedflow.detail.commentbubble.CommentBubbleConf r3 = r3.getCommentBubbleConfig()
            if (r3 == 0) goto L_0x0047
            int r0 = r3.getMaxShowNid()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
        L_0x0047:
            int r0 = com.baidu.searchbox.player.utils.BdPlayerUtils.orZero((java.lang.Integer) r0)
            r3 = 0
            if (r0 > 0) goto L_0x004f
            return r3
        L_0x004f:
            r4 = 100
            if (r0 <= r4) goto L_0x0055
            r0 = 100
        L_0x0055:
            r4 = 1
            if (r2 == 0) goto L_0x0090
            java.lang.String r5 = com.baidu.searchbox.video.feedflow.detail.commentbubble.CommentBubbleHelperKt.getCommentBubbleLastShowDate()
            java.util.Date r6 = new java.util.Date
            r6.<init>()
            java.lang.String r6 = com.baidu.searchbox.video.detail.utils.DateUtilsKt.toStringFormatDate(r6)
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r6)
            if (r5 == 0) goto L_0x0084
            java.util.Set r5 = com.baidu.searchbox.video.feedflow.detail.commentbubble.CommentBubbleHelperKt.getCommentBubbleShownNidSet()
            int r5 = r5.size()
            if (r5 < r0) goto L_0x0082
            java.util.Set r5 = com.baidu.searchbox.video.feedflow.detail.commentbubble.CommentBubbleHelperKt.getCommentBubbleShownNidSet()
            boolean r5 = r5.contains(r1)
            if (r5 == 0) goto L_0x0080
            goto L_0x0082
        L_0x0080:
            r5 = r3
            goto L_0x008c
        L_0x0082:
            r5 = r4
            goto L_0x008c
        L_0x0084:
            java.util.Set r5 = kotlin.collections.SetsKt.emptySet()
            com.baidu.searchbox.video.feedflow.detail.commentbubble.CommentBubbleHelperKt.setCommentBubbleShownNidSet(r5)
            r5 = r4
        L_0x008c:
            if (r5 == 0) goto L_0x0090
            r3 = r4
            goto L_0x0091
        L_0x0090:
        L_0x0091:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.detail.commentbubble.CommentBubbleHelper.isAbSwitchOnAndShowTimesValid(com.baidu.searchbox.feed.detail.arch.ext.CommonState, java.lang.String):boolean");
    }

    public final void recordCommentBubbleShown(String nid) {
        Intrinsics.checkNotNullParameter(nid, "nid");
        if (!Intrinsics.areEqual((Object) CommentBubbleHelperKt.getCommentBubbleLastShowDate(), (Object) DateUtilsKt.toStringFormatDate(new Date()))) {
            CommentBubbleHelperKt.setCommentBubbleLastShowDate(DateUtilsKt.toStringFormatDate(new Date()));
            CommentBubbleHelperKt.setCommentBubbleShownNidSet(SetsKt.emptySet());
        }
        Set $this$recordCommentBubbleShown_u24lambda_u2d0 = CollectionsKt.toMutableSet(CommentBubbleHelperKt.getCommentBubbleShownNidSet());
        $this$recordCommentBubbleShown_u24lambda_u2d0.add(nid);
        CommentBubbleHelperKt.setCommentBubbleShownNidSet($this$recordCommentBubbleShown_u24lambda_u2d0);
    }
}
