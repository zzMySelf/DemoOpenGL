package com.baidu.searchbox.reward.widget;

import android.os.Handler;
import android.os.Message;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/baidu/searchbox/reward/widget/CustomRewardDialog$shortTextHandler$1", "Landroid/os/Handler;", "handleMessage", "", "msg", "Landroid/os/Message;", "lib-reward_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CustomRewardDialog.kt */
public final class CustomRewardDialog$shortTextHandler$1 extends Handler {
    final /* synthetic */ CustomRewardDialog this$0;

    CustomRewardDialog$shortTextHandler$1(CustomRewardDialog $receiver) {
        this.this$0 = $receiver;
    }

    public void handleMessage(Message msg) {
        TextView access$getShortText$p;
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (msg.what == 1000 && (access$getShortText$p = this.this$0.shortText) != null) {
            access$getShortText$p.setVisibility(0);
        }
    }
}
