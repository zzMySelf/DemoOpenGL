package com.baidu.searchbox.vip.utils;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "", "<anonymous parameter 1>", "<anonymous parameter 2>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: VipBuyActiveCommonUtils.kt */
final class VipBuyActiveCommonUtilsKt$commonActiveVip$1$onReceive$2 extends Lambda implements Function3<Boolean, Boolean, Integer, Unit> {
    final /* synthetic */ String $type;
    final /* synthetic */ Function1<String, Unit> $vipActiveSuccessCb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    VipBuyActiveCommonUtilsKt$commonActiveVip$1$onReceive$2(Function1<? super String, Unit> function1, String str) {
        super(3);
        this.$vipActiveSuccessCb = function1;
        this.$type = str;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3) {
        invoke(((Boolean) p1).booleanValue(), ((Boolean) p2).booleanValue(), ((Number) p3).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z, boolean z2, int i2) {
        Function1<String, Unit> function1 = this.$vipActiveSuccessCb;
        if (function1 != null) {
            String str = this.$type;
            Function1<String, Unit> function12 = function1;
            Intrinsics.checkNotNullExpressionValue(str, "type");
            function1.invoke(str);
        }
    }
}
