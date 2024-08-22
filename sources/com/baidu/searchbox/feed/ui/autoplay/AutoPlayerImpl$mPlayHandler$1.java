package com.baidu.searchbox.feed.ui.autoplay;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/baidu/searchbox/feed/ui/autoplay/AutoPlayerImpl$mPlayHandler$1", "Landroid/os/Handler;", "handleMessage", "", "msg", "Landroid/os/Message;", "lib-feed-autoplay_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AutoPlayerImpl.kt */
public final class AutoPlayerImpl$mPlayHandler$1 extends Handler {
    final /* synthetic */ AutoPlayerImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AutoPlayerImpl$mPlayHandler$1(AutoPlayerImpl $receiver, Looper $super_call_param$1) {
        super($super_call_param$1);
        this.this$0 = $receiver;
    }

    public void handleMessage(Message msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        super.handleMessage(msg);
        if (msg.what == this.this$0.MSG_PLAY) {
            this.this$0.handlePlay(msg.getData().getBundle(this.this$0.PARAMS_PLAY));
        }
    }
}
