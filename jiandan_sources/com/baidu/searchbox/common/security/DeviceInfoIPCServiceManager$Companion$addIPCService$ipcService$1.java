package com.baidu.searchbox.common.security;

import com.baidu.searchbox.common.security.IDeviceInfoService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J*\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J \u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J \u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\u0015"}, d2 = {"com/baidu/searchbox/common/security/DeviceInfoIPCServiceManager$Companion$addIPCService$ipcService$1", "Lcom/baidu/searchbox/common/security/IDeviceInfoService$Stub;", "getAndroidId", "Lcom/baidu/searchbox/common/security/DeviceIdBag;", "scene", "", "purpose", "getDeviceInfos", "Lcom/baidu/searchbox/common/security/DeviceIdBagMap;", "deviceFlag", "", "forceApi", "", "getHarmonyVersion", "getIMEI", "getMacAddress", "getManufacturer", "getModel", "getOAID", "getOperator", "getOsVersion", "lib-security-framework_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DeviceInfoIPCServiceManager$Companion$addIPCService$ipcService$1 extends IDeviceInfoService.Stub {
    @NotNull
    public DeviceIdBag getAndroidId(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "scene");
        Intrinsics.checkNotNullParameter(str2, "purpose");
        DeviceInfoManager deviceInfoManager = DeviceInfoManager.qw;
        return deviceInfoManager.xxx(deviceInfoManager.nn(), str, str2);
    }

    @Nullable
    public DeviceIdBagMap getDeviceInfos(@NotNull String str, @NotNull String str2, int i2, boolean z) {
        Intrinsics.checkNotNullParameter(str, "scene");
        Intrinsics.checkNotNullParameter(str2, "purpose");
        DeviceInfoManager deviceInfoManager = DeviceInfoManager.qw;
        return deviceInfoManager.aaa(deviceInfoManager.nn(), str, str2, i2, z);
    }

    @NotNull
    public DeviceIdBag getHarmonyVersion(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "scene");
        Intrinsics.checkNotNullParameter(str2, "purpose");
        DeviceInfoManager deviceInfoManager = DeviceInfoManager.qw;
        return deviceInfoManager.eee(deviceInfoManager.nn(), str, str2);
    }

    @NotNull
    public DeviceIdBag getIMEI(@NotNull String str, @NotNull String str2, boolean z) {
        Intrinsics.checkNotNullParameter(str, "scene");
        Intrinsics.checkNotNullParameter(str2, "purpose");
        DeviceInfoManager deviceInfoManager = DeviceInfoManager.qw;
        return deviceInfoManager.rrr(deviceInfoManager.nn(), str, str2, z);
    }

    @NotNull
    public DeviceIdBag getMacAddress(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "scene");
        Intrinsics.checkNotNullParameter(str2, "purpose");
        DeviceInfoManager deviceInfoManager = DeviceInfoManager.qw;
        return deviceInfoManager.tt(deviceInfoManager.nn(), str, str2);
    }

    @NotNull
    public DeviceIdBag getManufacturer(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "scene");
        Intrinsics.checkNotNullParameter(str2, "purpose");
        return DeviceInfoManager.qw.a(str, str2);
    }

    @NotNull
    public DeviceIdBag getModel(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "scene");
        Intrinsics.checkNotNullParameter(str2, "purpose");
        return DeviceInfoManager.qw.b(str, str2);
    }

    @NotNull
    public DeviceIdBag getOAID(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "scene");
        Intrinsics.checkNotNullParameter(str2, "purpose");
        return DeviceInfoManager.qw.c(str, str2);
    }

    @NotNull
    public DeviceIdBag getOperator(@NotNull String str, @NotNull String str2, boolean z) {
        Intrinsics.checkNotNullParameter(str, "scene");
        Intrinsics.checkNotNullParameter(str2, "purpose");
        DeviceInfoManager deviceInfoManager = DeviceInfoManager.qw;
        return deviceInfoManager.e(deviceInfoManager.nn(), str, str2, z);
    }

    @NotNull
    public DeviceIdBag getOsVersion(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "scene");
        Intrinsics.checkNotNullParameter(str2, "purpose");
        return DeviceInfoManager.qw.f(str, str2);
    }
}
