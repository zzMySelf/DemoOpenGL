package com.baidu.searchbox.bigimage.channel;

import com.baidu.searchbox.datachannel.NAReceiverCallback;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/baidu/searchbox/bigimage/channel/MessageCommonChannel$registerPositionUpdate$1", "Lcom/baidu/searchbox/datachannel/NAReceiverCallback;", "onReceive", "", "action", "", "data", "lib-search-bigimage_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MessageCommonChannel.kt */
public final class MessageCommonChannel$registerPositionUpdate$1 extends NAReceiverCallback {
    final /* synthetic */ MessageCommonChannel this$0;

    MessageCommonChannel$registerPositionUpdate$1(MessageCommonChannel $receiver) {
        this.this$0 = $receiver;
    }

    public void onReceive(String action, String data) {
        if (Intrinsics.areEqual((Object) "com.baidu.channel.naImageViewer.setPosition", (Object) action)) {
            CharSequence charSequence = data;
            if (!(charSequence == null || charSequence.length() == 0)) {
                this.this$0.safeRun(new MessageCommonChannel$registerPositionUpdate$1$onReceive$1(data, this.this$0));
            }
        }
    }
}
