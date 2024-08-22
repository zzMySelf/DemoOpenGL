package com.tera.scan.vip.util;

import com.mars.kotlin.extension.LoggerKt;
import fe.mmm.qw.yj.th;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.RangesKt___RangesKt;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "success", "", "freeCount", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class VipRightsManager$consumeOnceUsePrivilege$1$1 extends Lambda implements Function2<Boolean, Integer, Unit> {
    public final /* synthetic */ String $it;
    public final /* synthetic */ Function2<Boolean, Integer, Unit> $onResult;
    public final /* synthetic */ String $type;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VipRightsManager$consumeOnceUsePrivilege$1$1(Function2<? super Boolean, ? super Integer, Unit> function2, String str, String str2) {
        super(2);
        this.$onResult = function2;
        this.$type = str;
        this.$it = str2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke(((Boolean) obj).booleanValue(), ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z, int i2) {
        Function2<Boolean, Integer, Unit> function2 = this.$onResult;
        if (function2 != null) {
            function2.invoke(Boolean.valueOf(z), Integer.valueOf(i2));
        }
        LoggerKt.d$default(this.$type + " 权益消费结果返回 success=" + z + " freeCount=" + i2, (Object) null, 1, (Object) null);
        th.ppp().pf(VipRightsManager.qw.fe(this.$it), RangesKt___RangesKt.coerceAtLeast(0, i2));
    }
}
