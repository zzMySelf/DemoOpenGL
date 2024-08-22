package com.baidu.searchbox.account.medal;

import com.baidu.searchbox.datachannel.DataChannel;
import com.baidu.searchbox.datachannel.NAReceiverCallback;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/baidu/searchbox/account/medal/BoxAccountMedalService$showMedalDetailDialogData$1", "Lcom/baidu/searchbox/datachannel/NAReceiverCallback;", "onReceive", "", "callbackAction", "", "msg", "lib-account-medal_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BoxAccountMedalService.kt */
public final class BoxAccountMedalService$showMedalDetailDialogData$1 extends NAReceiverCallback {
    final /* synthetic */ Function0<Unit> $dismissCallback;

    BoxAccountMedalService$showMedalDetailDialogData$1(Function0<Unit> $dismissCallback2) {
        this.$dismissCallback = $dismissCallback2;
    }

    public void onReceive(String callbackAction, String msg) {
        if (Intrinsics.areEqual((Object) callbackAction, (Object) BoxAccountMedalServiceKt.ACTION_DIALOG_DISMISS)) {
            this.$dismissCallback.invoke();
            DataChannel.Registry.unregisterReceiver((String) null, (String) null, BoxAccountMedalServiceKt.ACTION_DIALOG_DISMISS);
        }
    }
}
