package com.baidu.searchbox.containers.nps.netdisk.impl;

import com.baidu.searchbox.containers.nps.netdisk.face.NetdiskInvokeExtInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\n¢\u0006\u0004\b\t\u0010\n"}, d2 = {"<anonymous>", "", "isSuccess", "", "failedStage", "", "errorCode", "errorMsg", "", "invoke", "(ZLjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)V"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: NetdiskPluginFaceImpl.kt */
final class NetdiskPluginFaceImpl$openFolderWithPath$1 extends Lambda implements Function4<Boolean, Integer, Integer, String, Unit> {
    final /* synthetic */ NetdiskInvokeExtInfo $extInfo;
    final /* synthetic */ Function3<Boolean, Integer, String, Unit> $onCompletionCallback;
    final /* synthetic */ NetdiskPluginFaceImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NetdiskPluginFaceImpl$openFolderWithPath$1(NetdiskPluginFaceImpl netdiskPluginFaceImpl, NetdiskInvokeExtInfo netdiskInvokeExtInfo, Function3<? super Boolean, ? super Integer, ? super String, Unit> function3) {
        super(4);
        this.this$0 = netdiskPluginFaceImpl;
        this.$extInfo = netdiskInvokeExtInfo;
        this.$onCompletionCallback = function3;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3, Object p4) {
        invoke(((Boolean) p1).booleanValue(), (Integer) p2, (Integer) p3, (String) p4);
        return Unit.INSTANCE;
    }

    public final void invoke(boolean isSuccess, Integer failedStage, Integer errorCode, String errorMsg) {
        this.this$0.doNetdiskInvokeUbc(this.$extInfo.getUbcSource(), isSuccess, failedStage, errorCode, errorMsg);
        Function3<Boolean, Integer, String, Unit> function3 = this.$onCompletionCallback;
        if (function3 != null) {
            function3.invoke(Boolean.valueOf(isSuccess), errorCode, errorMsg);
        }
    }
}
