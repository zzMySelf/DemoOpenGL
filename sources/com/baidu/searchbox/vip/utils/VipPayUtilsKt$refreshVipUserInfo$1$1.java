package com.baidu.searchbox.vip.utils;

import android.util.Log;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: VipPayUtils.kt */
final class VipPayUtilsKt$refreshVipUserInfo$1$1 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ Function1<Boolean, Unit> $callback;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    VipPayUtilsKt$refreshVipUserInfo$1$1(Function1<? super Boolean, Unit> function1) {
        super(1);
        this.$callback = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke(((Boolean) p1).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean it) {
        if (it) {
            if (AppConfig.isDebug()) {
                Log.i("VIP_PAY", "the first user info request is successful");
            }
            VipAccountUtilsKt.requestUserInfo(AnonymousClass1.INSTANCE);
            this.$callback.invoke(true);
            return;
        }
        ExecutorUtilsExt.delayPostOnElastic(new VipPayUtilsKt$refreshVipUserInfo$1$1$$ExternalSyntheticLambda0(this.$callback), "SyncVipUserInfo", 1, 3000);
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-0  reason: not valid java name */
    public static final void m7376invoke$lambda0(Function1 $callback2) {
        Intrinsics.checkNotNullParameter($callback2, "$callback");
        if (AppConfig.isDebug()) {
            Log.i("VIP_PAY", "the purchase is successful, send the second request");
        }
        VipPayUtilsKt.doSyncUserInfo(true, new VipPayUtilsKt$refreshVipUserInfo$1$1$2$1($callback2));
    }
}
