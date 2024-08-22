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
public final class DeviceInfoManager$getDeviceInfo$result$1$1 extends Lambda implements Function1<Integer, Unit> {
    public final /* synthetic */ Context $context;
    public final /* synthetic */ int $deviceFlag;
    public final /* synthetic */ Ref.ObjectRef<DeviceIdBag> $deviceInfo;
    public final /* synthetic */ boolean $forceApi;
    public final /* synthetic */ Ref.IntRef $needSyncDeviceFlag;
    public final /* synthetic */ String $purpose;
    public final /* synthetic */ String $scene;
    public final /* synthetic */ DeviceIdBagMap $this_apply;
    public final /* synthetic */ boolean $useMapping;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeviceInfoManager$getDeviceInfo$result$1$1(int i2, Ref.ObjectRef<DeviceIdBag> objectRef, boolean z, Context context, String str, String str2, boolean z2, Ref.IntRef intRef, DeviceIdBagMap deviceIdBagMap) {
        super(1);
        this.$deviceFlag = i2;
        this.$deviceInfo = objectRef;
        this.$forceApi = z;
        this.$context = context;
        this.$scene = str;
        this.$purpose = str2;
        this.$useMapping = z2;
        this.$needSyncDeviceFlag = intRef;
        this.$this_apply = deviceIdBagMap;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Number) obj).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i2) {
        T t;
        boolean z = true;
        boolean z2 = (this.$deviceFlag & i2) != 0;
        if ((i2 & 66) == 0) {
            z = false;
        }
        if (z2 && z) {
            Ref.ObjectRef<DeviceIdBag> objectRef = this.$deviceInfo;
            if (this.$forceApi) {
                t = (DeviceIdBag) ((Function3) DeviceInfoManager.f1007ad.get(i2)).invoke(this.$context, this.$scene, this.$purpose);
            } else {
                t = (DeviceIdBag) DeviceInfoManager.f1014th.get((Object) Integer.valueOf(i2));
                if (t == null) {
                    t = (DeviceIdBag) ((Function3) DeviceInfoManager.f1007ad.get(i2)).invoke(this.$context, this.$scene, this.$purpose);
                }
                Intrinsics.checkNotNullExpressionValue(t, "{\n                      …se)\n                    }");
            }
            objectRef.element = t;
            if (this.$useMapping) {
                T t2 = this.$deviceInfo.element;
                if (((DeviceIdBag) t2).errorCode != 3 && !TextUtils.isEmpty(((DeviceIdBag) t2).deviceId)) {
                    this.$needSyncDeviceFlag.element |= i2;
                }
            }
            this.$this_apply.put(i2, (DeviceIdBag) this.$deviceInfo.element);
        } else if (z2) {
            Ref.ObjectRef<DeviceIdBag> objectRef2 = this.$deviceInfo;
            T t3 = (DeviceIdBag) DeviceInfoManager.f1014th.get((Object) Integer.valueOf(i2));
            if (t3 == null) {
                t3 = (DeviceIdBag) ((Function3) DeviceInfoManager.f1007ad.get(i2)).invoke(this.$context, this.$scene, this.$purpose);
            }
            objectRef2.element = t3;
            if (this.$useMapping) {
                T t4 = this.$deviceInfo.element;
                if (((DeviceIdBag) t4).errorCode != 3 && !TextUtils.isEmpty(((DeviceIdBag) t4).deviceId)) {
                    this.$needSyncDeviceFlag.element |= i2;
                }
            }
            this.$this_apply.put(i2, (DeviceIdBag) this.$deviceInfo.element);
        }
    }
}
