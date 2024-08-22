package com.baidu.searchbox.common.security;

import android.content.Context;
import android.text.TextUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "iterateDeviceFlag", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class DeviceInfoManager$init$1$1 extends Lambda implements Function1<Integer, Unit> {
    public final /* synthetic */ Ref.IntRef $diffFlag;
    public final /* synthetic */ Ref.IntRef $finalDeviceFlag;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeviceInfoManager$init$1$1(Ref.IntRef intRef, Ref.IntRef intRef2) {
        super(1);
        this.$finalDeviceFlag = intRef;
        this.$diffFlag = intRef2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Number) obj).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i2) {
        if ((this.$finalDeviceFlag.element & i2) != 0) {
            DeviceIdBag deviceIdBag = (DeviceIdBag) DeviceInfoManager.f1014th.get((Object) Integer.valueOf(i2));
            if (deviceIdBag == null) {
                Function3 function3 = (Function3) DeviceInfoManager.f1007ad.get(i2);
                Context ad2 = DeviceInfoManager.f1012pf;
                if (ad2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mContext");
                    ad2 = null;
                }
                function3.invoke(ad2, "launch", "launch_sync");
                deviceIdBag = (DeviceIdBag) DeviceInfoManager.f1014th.get((Object) Integer.valueOf(i2));
            } else if (DeviceInfoUtilKt.rg(DeviceInfoManager.f1009fe, i2, deviceIdBag.deviceId)) {
                deviceIdBag.errorCode = 3;
            }
            if (deviceIdBag != null && deviceIdBag.errorCode != 3 && !TextUtils.isEmpty(deviceIdBag.deviceId)) {
                Ref.IntRef intRef = this.$diffFlag;
                intRef.element = i2 | intRef.element;
            }
        }
    }
}
