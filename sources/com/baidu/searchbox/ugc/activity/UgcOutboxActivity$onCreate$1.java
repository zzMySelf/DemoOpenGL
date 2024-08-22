package com.baidu.searchbox.ugc.activity;

import com.baidu.searchbox.ugc.view.UgcOutboxView;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/baidu/searchbox/ugc/activity/UgcOutboxActivity$onCreate$1", "Lcom/baidu/searchbox/ugc/view/UgcOutboxView$IUgcOutboxViewListener;", "onDismiss", "", "lib-ugc-core_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: UgcOutboxActivity.kt */
public final class UgcOutboxActivity$onCreate$1 implements UgcOutboxView.IUgcOutboxViewListener {
    final /* synthetic */ UgcOutboxActivity this$0;

    UgcOutboxActivity$onCreate$1(UgcOutboxActivity $receiver) {
        this.this$0 = $receiver;
    }

    public void onDismiss() {
        this.this$0.finish();
    }
}
