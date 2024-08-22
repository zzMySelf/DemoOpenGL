package com.baidu.searchbox.video.feedflow.ad.scheduleddownload;

import com.baidu.searchbox.feed.detail.arch.anno.UnicastAction;
import com.baidu.searchbox.feed.detail.frame.Action;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/ad/scheduleddownload/NadScheduledConfirmDialogAction;", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "()V", "DialogDismiss", "DialogShow", "Lcom/baidu/searchbox/video/feedflow/ad/scheduleddownload/NadScheduledConfirmDialogAction$DialogShow;", "Lcom/baidu/searchbox/video/feedflow/ad/scheduleddownload/NadScheduledConfirmDialogAction$DialogDismiss;", "flowvideo_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NadScheduledConfirmDialogAction.kt */
public abstract class NadScheduledConfirmDialogAction implements Action {
    public /* synthetic */ NadScheduledConfirmDialogAction(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private NadScheduledConfirmDialogAction() {
    }

    @UnicastAction
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/ad/scheduleddownload/NadScheduledConfirmDialogAction$DialogShow;", "Lcom/baidu/searchbox/video/feedflow/ad/scheduleddownload/NadScheduledConfirmDialogAction;", "()V", "flowvideo_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: NadScheduledConfirmDialogAction.kt */
    public static final class DialogShow extends NadScheduledConfirmDialogAction {
        public static final DialogShow INSTANCE = new DialogShow();

        private DialogShow() {
            super((DefaultConstructorMarker) null);
        }
    }

    @UnicastAction
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/ad/scheduleddownload/NadScheduledConfirmDialogAction$DialogDismiss;", "Lcom/baidu/searchbox/video/feedflow/ad/scheduleddownload/NadScheduledConfirmDialogAction;", "()V", "flowvideo_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: NadScheduledConfirmDialogAction.kt */
    public static final class DialogDismiss extends NadScheduledConfirmDialogAction {
        public static final DialogDismiss INSTANCE = new DialogDismiss();

        private DialogDismiss() {
            super((DefaultConstructorMarker) null);
        }
    }
}
