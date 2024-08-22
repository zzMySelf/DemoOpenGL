package com.baidu.searchbox.common.security;

import android.content.Context;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "iterateDeviceFlag", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class DeviceInfoManager$getDeviceInfo$1$1 extends Lambda implements Function1<Integer, Unit> {
    public final /* synthetic */ Context $context;
    public final /* synthetic */ int $deviceFlag;
    public final /* synthetic */ boolean $forceApi;
    public final /* synthetic */ String $purpose;
    public final /* synthetic */ String $scene;
    public final /* synthetic */ DeviceIdBagMap $this_apply;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeviceInfoManager$getDeviceInfo$1$1(int i2, boolean z, DeviceIdBagMap deviceIdBagMap, Context context, String str, String str2) {
        super(1);
        this.$deviceFlag = i2;
        this.$forceApi = z;
        this.$this_apply = deviceIdBagMap;
        this.$context = context;
        this.$scene = str;
        this.$purpose = str2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Number) obj).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i2) {
        boolean z = true;
        boolean z2 = (this.$deviceFlag & i2) != 0;
        if ((i2 & 66) == 0) {
            z = false;
        }
        if (!z2 || !z) {
            if (z2) {
                DeviceIdBagMap deviceIdBagMap = this.$this_apply;
                DeviceIdBag deviceIdBag = (DeviceIdBag) DeviceInfoManager.f1014th.get((Object) Integer.valueOf(i2));
                if (deviceIdBag == null) {
                    deviceIdBag = (DeviceIdBag) ((Function3) DeviceInfoManager.f1007ad.get(i2)).invoke(this.$context, this.$scene, this.$purpose);
                }
                Intrinsics.checkNotNullExpressionValue(deviceIdBag, "mDeviceInfoMap[iterateDe…(context, scene, purpose)");
                deviceIdBagMap.put(i2, deviceIdBag);
            }
        } else if (this.$forceApi) {
            this.$this_apply.put(i2, (DeviceIdBag) ((Function3) DeviceInfoManager.f1007ad.get(i2)).invoke(this.$context, this.$scene, this.$purpose));
        } else {
            DeviceIdBagMap deviceIdBagMap2 = this.$this_apply;
            DeviceIdBag deviceIdBag2 = (DeviceIdBag) DeviceInfoManager.f1014th.get((Object) Integer.valueOf(i2));
            if (deviceIdBag2 == null) {
                deviceIdBag2 = (DeviceIdBag) ((Function3) DeviceInfoManager.f1007ad.get(i2)).invoke(this.$context, this.$scene, this.$purpose);
            }
            Intrinsics.checkNotNullExpressionValue(deviceIdBag2, "mDeviceInfoMap[iterateDe…(context, scene, purpose)");
            deviceIdBagMap2.put(i2, deviceIdBag2);
        }
    }
}
