package com.baidu.searchbox.kmm.services.datachannel;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.datachannel.DataChannel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a$\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00012\u0014\u0010\u0006\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00020\u00040\u0007\u001a\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00012\b\u0010\t\u001a\u0004\u0018\u00010\u0001\u001a\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"DATA_CHANNEL_HOST", "", "DATA_CHANNEL_PAGE", "registerDataChannelReceiver", "", "action", "callback", "Lkotlin/Function1;", "sendDataChannelBroadcast", "msg", "unregisterDataChannelReceiver", "com.baidu.searchbox.kmm.services.datachannel"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: DataChannel.kt */
public final class DataChannelKt {
    private static final String DATA_CHANNEL_HOST = "medalDismissHost";
    private static final String DATA_CHANNEL_PAGE = "medalDismissPage";

    public static final void registerDataChannelReceiver(String action, Function1<? super String, Unit> callback) {
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(callback, "callback");
        DataChannel.Registry.registerNAReceiver(DATA_CHANNEL_HOST, DATA_CHANNEL_PAGE, action, new DataChannelKt$registerDataChannelReceiver$1(action, callback));
    }

    public static final void sendDataChannelBroadcast(String action, String msg) {
        Intrinsics.checkNotNullParameter(action, "action");
        DataChannel.Sender.sendBroadcast(AppRuntime.getAppContext(), action, msg);
    }

    public static final void unregisterDataChannelReceiver(String action) {
        Intrinsics.checkNotNullParameter(action, "action");
        DataChannel.Registry.unregisterReceiver(DATA_CHANNEL_HOST, DATA_CHANNEL_PAGE, action);
    }
}
