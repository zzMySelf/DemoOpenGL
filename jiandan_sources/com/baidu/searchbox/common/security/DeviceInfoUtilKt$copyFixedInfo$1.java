package com.baidu.searchbox.common.security;

import fe.fe.ddd.i.ad.ad;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "iterateDeviceFlag", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class DeviceInfoUtilKt$copyFixedInfo$1 extends Lambda implements Function1<Integer, Unit> {
    public final /* synthetic */ int $deviceFlag;
    public final /* synthetic */ ad $dst;
    public final /* synthetic */ DeviceIdBagMap $src;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeviceInfoUtilKt$copyFixedInfo$1(int i2, ad adVar, DeviceIdBagMap deviceIdBagMap) {
        super(1);
        this.$deviceFlag = i2;
        this.$dst = adVar;
        this.$src = deviceIdBagMap;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Number) obj).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i2) {
        if ((this.$deviceFlag & i2) != 0) {
            ad adVar = this.$dst;
            DeviceIdBag deviceIdBag = (DeviceIdBag) this.$src.get((Object) Integer.valueOf(i2));
            adVar.ad(deviceIdBag != null ? deviceIdBag.deviceId : null, i2);
        }
    }
}
