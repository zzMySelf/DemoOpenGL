package com.baidu.searchbox.thirdparty.alipay;

import com.baidu.searchbox.thirdparty.base.IResultListener;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "errNo", "", "errMsg", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: AliPaySdkManager.kt */
final class AliPaySdkManager$requestAuthCode$2 extends Lambda implements Function2<Integer, String, Unit> {
    final /* synthetic */ IResultListener $callback;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AliPaySdkManager$requestAuthCode$2(IResultListener iResultListener) {
        super(2);
        this.$callback = iResultListener;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        invoke(((Number) p1).intValue(), (String) p2);
        return Unit.INSTANCE;
    }

    public final void invoke(int errNo, String errMsg) {
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        IResultListener iResultListener = this.$callback;
        if (iResultListener != null) {
            iResultListener.onFail(errNo, errMsg);
        }
    }
}
