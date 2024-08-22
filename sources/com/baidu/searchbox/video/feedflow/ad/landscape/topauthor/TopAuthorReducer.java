package com.baidu.searchbox.video.feedflow.ad.landscape.topauthor;

import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.frame.Reducer;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/ad/landscape/topauthor/TopAuthorReducer;", "Lcom/baidu/searchbox/feed/detail/frame/Reducer;", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "()V", "reduce", "state", "action", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "flowvideo_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TopAuthorReducer.kt */
public final class TopAuthorReducer implements Reducer<CommonState> {
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0017, code lost:
        r0 = r0.getUpdateVHStyle();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.baidu.searchbox.feed.detail.arch.ext.CommonState reduce(com.baidu.searchbox.feed.detail.arch.ext.CommonState r7, com.baidu.searchbox.feed.detail.frame.Action r8) {
        /*
            r6 = this;
            java.lang.String r0 = "state"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "action"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.author.AuthorState> r0 = com.baidu.searchbox.video.feedflow.detail.author.AuthorState.class
            java.lang.Object r0 = r7.select(r0)
            com.baidu.searchbox.video.feedflow.detail.author.AuthorState r0 = (com.baidu.searchbox.video.feedflow.detail.author.AuthorState) r0
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x002a
            androidx.lifecycle.MutableLiveData r0 = r0.getUpdateVHStyle()
            if (r0 == 0) goto L_0x002a
            java.lang.Object r0 = r0.getValue()
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r1)
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r3)
            goto L_0x002b
        L_0x002a:
            r0 = r2
        L_0x002b:
            if (r0 == 0) goto L_0x0084
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.author.AuthorState> r0 = com.baidu.searchbox.video.feedflow.detail.author.AuthorState.class
            java.lang.Object r0 = r7.select(r0)
            com.baidu.searchbox.video.feedflow.detail.author.AuthorState r0 = (com.baidu.searchbox.video.feedflow.detail.author.AuthorState) r0
            if (r0 == 0) goto L_0x003e
            boolean r0 = r0.isVisible()
            if (r0 != r1) goto L_0x003e
            goto L_0x003f
        L_0x003e:
            r1 = r2
        L_0x003f:
            if (r1 == 0) goto L_0x0084
            r0 = r7
            r1 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.ad.detail.AdDataState> r3 = com.baidu.searchbox.video.feedflow.ad.detail.AdDataState.class
            java.lang.Object r0 = r0.select(r3)
            com.baidu.searchbox.video.feedflow.ad.detail.AdDataState r0 = (com.baidu.searchbox.video.feedflow.ad.detail.AdDataState) r0
            if (r0 == 0) goto L_0x0084
            androidx.lifecycle.MutableLiveData r0 = r0.getData()
            if (r0 == 0) goto L_0x0084
            java.lang.Object r0 = r0.getValue()
            com.baidu.searchbox.video.feedflow.ad.detail.AdData r0 = (com.baidu.searchbox.video.feedflow.ad.detail.AdData) r0
            if (r0 == 0) goto L_0x0084
            r1 = 0
            com.baidu.searchbox.video.feedflow.ad.componenttypeswitch.ComponentTypeSwitchModel r3 = r0.getComponentTypeSwitch()
            r4 = 0
            if (r3 == 0) goto L_0x0068
            java.lang.String r3 = r3.getAvatarActionType()
            goto L_0x0069
        L_0x0068:
            r3 = r4
        L_0x0069:
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            java.lang.String r5 = "follow"
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            boolean r3 = android.text.TextUtils.equals(r3, r5)
            if (r3 != 0) goto L_0x0083
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.author.AuthorState> r3 = com.baidu.searchbox.video.feedflow.detail.author.AuthorState.class
            java.lang.Object r3 = r7.select(r3)
            com.baidu.searchbox.video.feedflow.detail.author.AuthorState r3 = (com.baidu.searchbox.video.feedflow.detail.author.AuthorState) r3
            if (r3 == 0) goto L_0x0083
            r5 = 2
            com.baidu.searchbox.video.feedflow.detail.author.AuthorState.changeVisible$default(r3, r2, r2, r5, r4)
        L_0x0083:
        L_0x0084:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.ad.landscape.topauthor.TopAuthorReducer.reduce(com.baidu.searchbox.feed.detail.arch.ext.CommonState, com.baidu.searchbox.feed.detail.frame.Action):com.baidu.searchbox.feed.detail.arch.ext.CommonState");
    }
}
