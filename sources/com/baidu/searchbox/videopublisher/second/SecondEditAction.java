package com.baidu.searchbox.videopublisher.second;

import com.baidu.searchbox.feed.detail.frame.Action;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/videopublisher/second/SecondEditAction;", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "()V", "CancelClick", "PublishClick", "Lcom/baidu/searchbox/videopublisher/second/SecondEditAction$CancelClick;", "Lcom/baidu/searchbox/videopublisher/second/SecondEditAction$PublishClick;", "lib-publisher-video_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SecondEditAction.kt */
public abstract class SecondEditAction implements Action {
    public /* synthetic */ SecondEditAction(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private SecondEditAction() {
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/baidu/searchbox/videopublisher/second/SecondEditAction$CancelClick;", "Lcom/baidu/searchbox/videopublisher/second/SecondEditAction;", "()V", "lib-publisher-video_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SecondEditAction.kt */
    public static final class CancelClick extends SecondEditAction {
        public static final CancelClick INSTANCE = new CancelClick();

        private CancelClick() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/baidu/searchbox/videopublisher/second/SecondEditAction$PublishClick;", "Lcom/baidu/searchbox/videopublisher/second/SecondEditAction;", "()V", "lib-publisher-video_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SecondEditAction.kt */
    public static final class PublishClick extends SecondEditAction {
        public static final PublishClick INSTANCE = new PublishClick();

        private PublishClick() {
            super((DefaultConstructorMarker) null);
        }
    }
}
