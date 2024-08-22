package com.baidu.searchbox.containers.nps.netdisk.impl;

import com.baidu.netdisk.baidusdk.api.IYouthHomeNetDiskView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "", "<anonymous parameter 1>", "<anonymous parameter 2>", "", "invoke", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)V"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: NetdiskPluginFaceImpl.kt */
final class NetdiskPluginFaceImpl$getYouthNetDiskView$1 extends Lambda implements Function3<Integer, Integer, String, Unit> {
    final /* synthetic */ Function1<IYouthHomeNetDiskView, Unit> $callback;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NetdiskPluginFaceImpl$getYouthNetDiskView$1(Function1<? super IYouthHomeNetDiskView, Unit> function1) {
        super(3);
        this.$callback = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3) {
        invoke((Integer) p1, (Integer) p2, (String) p3);
        return Unit.INSTANCE;
    }

    public final void invoke(Integer num, Integer num2, String str) {
        this.$callback.invoke(null);
    }
}
