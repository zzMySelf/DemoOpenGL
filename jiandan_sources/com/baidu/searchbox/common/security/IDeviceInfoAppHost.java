package com.baidu.searchbox.common.security;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\fJ\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\u0003H\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/baidu/searchbox/common/security/IDeviceInfoAppHost;", "", "getAppName", "", "getEnUid", "getForceMappingCacheInterval", "", "getOAID", "Lcom/baidu/searchbox/common/security/IDeviceInfoAppHost$OAIDResult;", "getUA", "useMapping", "", "OAIDResult", "lib-security-framework_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface IDeviceInfoAppHost {

    public static final class ad {
        @Nullable

        /* renamed from: ad  reason: collision with root package name */
        public final String f1018ad;
        @Nullable

        /* renamed from: de  reason: collision with root package name */
        public final String f1019de;
        public final boolean qw;

        public ad(boolean z, @Nullable String str, @Nullable String str2) {
            this.qw = z;
            this.f1018ad = str;
            this.f1019de = str2;
        }

        public final boolean ad() {
            return this.qw;
        }

        @Nullable
        public final String de() {
            return this.f1018ad;
        }

        @Nullable
        public final String qw() {
            return this.f1019de;
        }
    }

    public static final class qw {
        @NotNull
        public static String ad(@NotNull IDeviceInfoAppHost iDeviceInfoAppHost) {
            return "";
        }

        @NotNull
        public static ad de(@NotNull IDeviceInfoAppHost iDeviceInfoAppHost) {
            return new ad(false, (String) null, (String) null);
        }

        @NotNull
        public static String fe(@NotNull IDeviceInfoAppHost iDeviceInfoAppHost) {
            return "";
        }

        @NotNull
        public static String qw(@NotNull IDeviceInfoAppHost iDeviceInfoAppHost) {
            return "";
        }

        public static boolean rg(@NotNull IDeviceInfoAppHost iDeviceInfoAppHost) {
            return false;
        }
    }

    boolean ad();

    @NotNull
    String de();

    @NotNull
    String getAppName();

    @NotNull
    ad getOAID();

    @NotNull
    String qw();
}
