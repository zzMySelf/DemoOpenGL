package com.baidu.searchbox.common.security;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "iterateDeviceFlag", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class DeviceInfoManager$readMappingCache$1 extends Lambda implements Function1<Integer, Unit> {
    public static final DeviceInfoManager$readMappingCache$1 INSTANCE = new DeviceInfoManager$readMappingCache$1();

    public DeviceInfoManager$readMappingCache$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Number) obj).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i2) {
        DeviceIdBag deviceIdBag = (DeviceIdBag) DeviceInfoManager.f1014th.get((Object) Integer.valueOf(i2));
        if (deviceIdBag != null && DeviceInfoUtilKt.rg(DeviceInfoManager.f1009fe, i2, deviceIdBag.deviceId)) {
            deviceIdBag.errorCode = 3;
        }
    }
}
