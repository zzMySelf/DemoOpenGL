package com.baidu.searchbox.containers.nps.netdisk.impl;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"<anonymous>", "", "failedStage", "", "errorCode", "errorMsg", "", "invoke", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)V"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: NetdiskPluginFaceImpl.kt */
final class NetdiskPluginFaceImpl$createP2pDownloadTask$1 extends Lambda implements Function3<Integer, Integer, String, Unit> {
    final /* synthetic */ Function2<Integer, String, Unit> $onNetdiskPluginInvokeFailed;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NetdiskPluginFaceImpl$createP2pDownloadTask$1(Function2<? super Integer, ? super String, Unit> function2) {
        super(3);
        this.$onNetdiskPluginInvokeFailed = function2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3) {
        invoke((Integer) p1, (Integer) p2, (String) p3);
        return Unit.INSTANCE;
    }

    public final void invoke(Integer failedStage, Integer errorCode, String errorMsg) {
        Function2<Integer, String, Unit> function2 = this.$onNetdiskPluginInvokeFailed;
        if (function2 != null) {
            function2.invoke(errorCode, errorMsg);
        }
    }
}
