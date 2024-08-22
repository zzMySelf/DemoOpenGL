package com.baidu.live.framework.plugin;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\b\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J3\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001J\b\u0010\u0019\u001a\u00020\u0003H\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001a"}, d2 = {"Lcom/baidu/live/framework/plugin/YYPluginBundleInfo;", "", "packageName", "", "versionCode", "", "needUpdate", "", "ext", "(Ljava/lang/String;IZLjava/lang/String;)V", "getExt", "()Ljava/lang/String;", "getNeedUpdate", "()Z", "getPackageName", "getVersionCode", "()I", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "lib-live-feed-page_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: YYPluginBundleInfo.kt */
public final class YYPluginBundleInfo {
    private final String ext;
    private final boolean needUpdate;
    private final String packageName;
    private final int versionCode;

    public static /* synthetic */ YYPluginBundleInfo copy$default(YYPluginBundleInfo yYPluginBundleInfo, String str, int i2, boolean z, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = yYPluginBundleInfo.packageName;
        }
        if ((i3 & 2) != 0) {
            i2 = yYPluginBundleInfo.versionCode;
        }
        if ((i3 & 4) != 0) {
            z = yYPluginBundleInfo.needUpdate;
        }
        if ((i3 & 8) != 0) {
            str2 = yYPluginBundleInfo.ext;
        }
        return yYPluginBundleInfo.copy(str, i2, z, str2);
    }

    public final String component1() {
        return this.packageName;
    }

    public final int component2() {
        return this.versionCode;
    }

    public final boolean component3() {
        return this.needUpdate;
    }

    public final String component4() {
        return this.ext;
    }

    public final YYPluginBundleInfo copy(String str, int i2, boolean z, String str2) {
        Intrinsics.checkNotNullParameter(str, "packageName");
        return new YYPluginBundleInfo(str, i2, z, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof YYPluginBundleInfo)) {
            return false;
        }
        YYPluginBundleInfo yYPluginBundleInfo = (YYPluginBundleInfo) obj;
        return Intrinsics.areEqual((Object) this.packageName, (Object) yYPluginBundleInfo.packageName) && this.versionCode == yYPluginBundleInfo.versionCode && this.needUpdate == yYPluginBundleInfo.needUpdate && Intrinsics.areEqual((Object) this.ext, (Object) yYPluginBundleInfo.ext);
    }

    public int hashCode() {
        int hashCode = ((this.packageName.hashCode() * 31) + Integer.hashCode(this.versionCode)) * 31;
        boolean z = this.needUpdate;
        if (z) {
            z = true;
        }
        int i2 = (hashCode + (z ? 1 : 0)) * 31;
        String str = this.ext;
        return i2 + (str == null ? 0 : str.hashCode());
    }

    public YYPluginBundleInfo(String packageName2, int versionCode2, boolean needUpdate2, String ext2) {
        Intrinsics.checkNotNullParameter(packageName2, "packageName");
        this.packageName = packageName2;
        this.versionCode = versionCode2;
        this.needUpdate = needUpdate2;
        this.ext = ext2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ YYPluginBundleInfo(String str, int i2, boolean z, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i3 & 2) != 0 ? 0 : i2, (i3 & 4) != 0 ? false : z, str2);
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final int getVersionCode() {
        return this.versionCode;
    }

    public final boolean getNeedUpdate() {
        return this.needUpdate;
    }

    public final String getExt() {
        return this.ext;
    }

    public String toString() {
        return "YYPluginBundleInfo { packageName=" + this.packageName + " versionCode=" + this.versionCode + " needUpdate=" + this.needUpdate + " ext=" + this.ext + " }";
    }
}
