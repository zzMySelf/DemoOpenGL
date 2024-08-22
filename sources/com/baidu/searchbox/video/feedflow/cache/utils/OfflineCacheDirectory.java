package com.baidu.searchbox.video.feedflow.cache.utils;

import com.baidu.searchbox.video.feedflow.di.DIFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\u0006\u001a\u00020\u0003HÂ\u0003J\u0013\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\u001d\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00022\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u000eH\u0002J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u000e\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/cache/utils/OfflineCacheDirectory;", "Lkotlin/properties/ReadOnlyProperty;", "", "", "dirName", "(Ljava/lang/String;)V", "component1", "copy", "equals", "", "other", "getValue", "thisRef", "property", "Lkotlin/reflect/KProperty;", "hashCode", "", "toString", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FlowVideoOfflineCacheUtils.kt */
public final class OfflineCacheDirectory implements ReadOnlyProperty<Object, String> {
    private final String dirName;

    private final String component1() {
        return this.dirName;
    }

    public static /* synthetic */ OfflineCacheDirectory copy$default(OfflineCacheDirectory offlineCacheDirectory, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = offlineCacheDirectory.dirName;
        }
        return offlineCacheDirectory.copy(str);
    }

    public final OfflineCacheDirectory copy(String str) {
        Intrinsics.checkNotNullParameter(str, "dirName");
        return new OfflineCacheDirectory(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof OfflineCacheDirectory) && Intrinsics.areEqual((Object) this.dirName, (Object) ((OfflineCacheDirectory) obj).dirName);
    }

    public int hashCode() {
        return this.dirName.hashCode();
    }

    public String toString() {
        return "OfflineCacheDirectory(dirName=" + this.dirName + ')';
    }

    public OfflineCacheDirectory(String dirName2) {
        Intrinsics.checkNotNullParameter(dirName2, "dirName");
        this.dirName = dirName2;
    }

    public String getValue(Object thisRef, KProperty<?> property) {
        Intrinsics.checkNotNullParameter(thisRef, "thisRef");
        Intrinsics.checkNotNullParameter(property, "property");
        String externalCacheDirPath = DIFactory.INSTANCE.getExternalCacheDirPath();
        String str = externalCacheDirPath != null ? externalCacheDirPath + this.dirName : null;
        return str == null ? "" : str;
    }
}
