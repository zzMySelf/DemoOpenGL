package com.baidu.searchbox.common.security;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "iterateDevice", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class DeviceIdBagMap$isSync$1 extends Lambda implements Function1<Integer, Unit> {
    public final /* synthetic */ int $deviceFlag;
    public final /* synthetic */ Ref.BooleanRef $isSync;
    public final /* synthetic */ DeviceIdBagMap this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeviceIdBagMap$isSync$1(int i2, DeviceIdBagMap deviceIdBagMap, Ref.BooleanRef booleanRef) {
        super(1);
        this.$deviceFlag = i2;
        this.this$0 = deviceIdBagMap;
        this.$isSync = booleanRef;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Number) obj).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i2) {
        if ((this.$deviceFlag & i2) != 0) {
            DeviceIdBag deviceIdBag = (DeviceIdBag) this.this$0.get((Object) Integer.valueOf(i2));
            if (deviceIdBag == null || deviceIdBag.errorCode != 3) {
                this.$isSync.element = false;
            }
        }
    }
}
