package com.baidu.searchbox.imchathn.activity;

import com.baidu.searchbox.bdeventbus.Action;
import com.baidu.searchbox.imchathn.event.DialogAlertEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, d2 = {"com/baidu/searchbox/imchathn/activity/ImChatTalosActivity$registerDialogAlertEvent$1", "Lcom/baidu/searchbox/bdeventbus/Action;", "Lcom/baidu/searchbox/imchathn/event/DialogAlertEvent;", "call", "", "type", "lib-im-chat-hn_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ImChatTalosActivity.kt */
public final class ImChatTalosActivity$registerDialogAlertEvent$1 implements Action<DialogAlertEvent> {
    final /* synthetic */ ImChatTalosActivity this$0;

    ImChatTalosActivity$registerDialogAlertEvent$1(ImChatTalosActivity $receiver) {
        this.this$0 = $receiver;
    }

    public void call(DialogAlertEvent type) {
        Intrinsics.checkNotNullParameter(type, "type");
        boolean hasMessages = this.this$0.mBackHandler.hasMessages(1);
        type.getTimeoutListener().onAlertShow(!hasMessages);
        if (hasMessages) {
            this.this$0.mBackHandler.removeMessages(1);
            if (!type.isSuccess()) {
                this.this$0.finish();
            }
        }
    }
}
