package com.baidu.searchbox.video.feedflow.detail.comment;

import android.app.Activity;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.video.component.ext.StoreExtKt;
import com.baidu.searchbox.video.feedflow.detail.comment.CommentView;
import com.baidu.searchbox.video.feedflow.utils.VideoFlowPadUtilsKt;
import com.baidu.searchbox.video.feedflow.utils.VideoFlowUtilsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0016J\b\u0010\t\u001a\u00020\u0003H\u0016J\b\u0010\n\u001a\u00020\u0003H\u0016¨\u0006\u000b"}, d2 = {"com/baidu/searchbox/video/feedflow/detail/comment/CommentComponent$commentView$2$1$1", "Lcom/baidu/searchbox/video/feedflow/detail/comment/CommentView$IOnCommentViewListener;", "onClickListener", "", "commentIconShowStyle", "Lcom/baidu/searchbox/video/feedflow/detail/comment/CommentIconShowStyle;", "onLongClickListener", "onUploadNewHotStyleShow", "onUploadSofaStyleShow", "onUploadZeroAnimationShow", "onUploadZeroStyleShow", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CommentComponent.kt */
public final class CommentComponent$commentView$2$1$1 implements CommentView.IOnCommentViewListener {
    final /* synthetic */ CommentView $this_apply;
    final /* synthetic */ CommentComponent this$0;

    CommentComponent$commentView$2$1$1(CommentComponent $receiver, CommentView $receiver2) {
        this.this$0 = $receiver;
        this.$this_apply = $receiver2;
    }

    public void onClickListener(CommentIconShowStyle commentIconShowStyle) {
        Activity activity;
        Intrinsics.checkNotNullParameter(commentIconShowStyle, "commentIconShowStyle");
        this.this$0.differentiatedDisplayType(commentIconShowStyle);
        if (VideoFlowPadUtilsKt.isPadStyleAndLandScope(this.this$0.getStore()) && (activity = VideoFlowUtilsKt.getActivity(this.$this_apply.getContext())) != null) {
            VideoFlowUtilsKt.setStatusBarVisible(activity, false);
        }
        Store access$getStore = this.this$0.getStore();
        if (access$getStore != null) {
            access$getStore.dispatch(CommentIconClickAction.INSTANCE);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onLongClickListener() {
        /*
            r5 = this;
            com.baidu.searchbox.video.feedflow.detail.comment.CommentComponent r0 = r5.this$0
            com.baidu.searchbox.feed.detail.frame.Store r0 = r0.getStore()
            boolean r0 = com.baidu.searchbox.video.feedflow.flow.flowstyle.LandscapeFlowSwitchKt.isLandscapeFlowMode((com.baidu.searchbox.feed.detail.frame.Store<?>) r0)
            if (r0 != 0) goto L_0x0076
            com.baidu.searchbox.video.feedflow.detail.comment.CommentComponent r0 = r5.this$0
            com.baidu.searchbox.feed.detail.frame.Store r0 = r0.getStore()
            r1 = 0
            if (r0 == 0) goto L_0x0039
            r2 = 0
            com.baidu.searchbox.feed.detail.frame.State r3 = r0.getState()
            boolean r4 = r3 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r4 == 0) goto L_0x0021
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r3 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r3
            goto L_0x0022
        L_0x0021:
            r3 = r1
        L_0x0022:
            if (r3 == 0) goto L_0x002b
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.intercept.InterceptState> r4 = com.baidu.searchbox.video.feedflow.detail.intercept.InterceptState.class
            java.lang.Object r3 = r3.select(r4)
            goto L_0x002c
        L_0x002b:
            r3 = r1
        L_0x002c:
            com.baidu.searchbox.video.feedflow.detail.intercept.InterceptState r3 = (com.baidu.searchbox.video.feedflow.detail.intercept.InterceptState) r3
            if (r3 == 0) goto L_0x0039
            boolean r0 = r3.isInterceptAutoShowPanel()
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            goto L_0x003a
        L_0x0039:
            r0 = r1
        L_0x003a:
            boolean r0 = com.baidu.searchbox.player.utils.BdPlayerUtils.orFalse(r0)
            if (r0 != 0) goto L_0x0076
            com.baidu.searchbox.video.feedflow.detail.comment.CommentComponent r0 = r5.this$0
            com.baidu.searchbox.feed.detail.frame.Store r0 = r0.getStore()
            r2 = 1
            boolean r0 = com.baidu.searchbox.video.feedflow.detail.challenge.challengefromcomment.ChallengeUtilsKt.isFromCommentChallenge$default((com.baidu.searchbox.feed.detail.frame.Store) r0, (com.baidu.searchbox.video.feedflow.flow.list.ItemModel) r1, (int) r2, (java.lang.Object) r1)
            if (r0 != 0) goto L_0x0076
            com.baidu.searchbox.video.feedflow.detail.comment.CommentComponent r0 = r5.this$0
            com.baidu.searchbox.feed.detail.frame.Store r0 = r0.getStore()
            boolean r0 = com.baidu.searchbox.video.feedflow.common.config.BottomInteractAreaConfigHelperKt.isBottomInteractAreaStyle(r0)
            if (r0 != 0) goto L_0x0076
            com.baidu.searchbox.video.feedflow.detail.comment.CommentView r0 = r5.$this_apply
            r0.release()
            com.baidu.searchbox.video.feedflow.detail.comment.CommentComponent r0 = r5.this$0
            com.baidu.searchbox.feed.detail.frame.Store r0 = r0.getStore()
            if (r0 == 0) goto L_0x0076
            com.baidu.searchbox.video.feedflow.detail.comment.emojipanel.CommentEmojiPanelShow r1 = new com.baidu.searchbox.video.feedflow.detail.comment.emojipanel.CommentEmojiPanelShow
            com.baidu.searchbox.video.feedflow.detail.comment.CommentComponent r2 = r5.this$0
            com.baidu.searchbox.praise.emojiinterface.CommentViewPosition r2 = r2.getEmojiPanelPopPositions()
            r1.<init>(r2)
            com.baidu.searchbox.feed.detail.frame.Action r1 = (com.baidu.searchbox.feed.detail.frame.Action) r1
            r0.dispatch(r1)
        L_0x0076:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.detail.comment.CommentComponent$commentView$2$1$1.onLongClickListener():void");
    }

    public void onUploadNewHotStyleShow() {
        Store access$getStore = this.this$0.getStore();
        if (access$getStore != null) {
            access$getStore.dispatch(new CommentIconWithHotStyleClickOrShowAction(false));
        }
    }

    public void onUploadSofaStyleShow() {
        Store access$getStore = this.this$0.getStore();
        if (access$getStore != null) {
            StoreExtKt.post(access$getStore, new CommentIconWithSofaStyleClickOrShowAction(false));
        }
    }

    public void onUploadZeroStyleShow() {
        Store access$getStore = this.this$0.getStore();
        if (access$getStore != null) {
            StoreExtKt.post(access$getStore, new CommentIconWithZeroStyleClickOrShowAction(false, false, 2, (DefaultConstructorMarker) null));
        }
    }

    public void onUploadZeroAnimationShow() {
        Store access$getStore = this.this$0.getStore();
        if (access$getStore != null) {
            StoreExtKt.post(access$getStore, new CommentIconWithZeroStyleClickOrShowAction(false, true));
        }
    }
}
