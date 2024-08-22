package com.baidu.searchbox.video.feedflow.cache;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/cache/UseCacheScene;", "", "from", "", "page", "pd", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getFrom", "()Ljava/lang/String;", "getPage", "getPd", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FlowVideoCacheConfig.kt */
public final class UseCacheScene {
    private final String from;
    private final String page;
    private final String pd;

    public UseCacheScene() {
        this((String) null, (String) null, (String) null, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ UseCacheScene copy$default(UseCacheScene useCacheScene, String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = useCacheScene.from;
        }
        if ((i2 & 2) != 0) {
            str2 = useCacheScene.page;
        }
        if ((i2 & 4) != 0) {
            str3 = useCacheScene.pd;
        }
        return useCacheScene.copy(str, str2, str3);
    }

    public final String component1() {
        return this.from;
    }

    public final String component2() {
        return this.page;
    }

    public final String component3() {
        return this.pd;
    }

    public final UseCacheScene copy(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "from");
        Intrinsics.checkNotNullParameter(str2, "page");
        Intrinsics.checkNotNullParameter(str3, "pd");
        return new UseCacheScene(str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UseCacheScene)) {
            return false;
        }
        UseCacheScene useCacheScene = (UseCacheScene) obj;
        return Intrinsics.areEqual((Object) this.from, (Object) useCacheScene.from) && Intrinsics.areEqual((Object) this.page, (Object) useCacheScene.page) && Intrinsics.areEqual((Object) this.pd, (Object) useCacheScene.pd);
    }

    public int hashCode() {
        return (((this.from.hashCode() * 31) + this.page.hashCode()) * 31) + this.pd.hashCode();
    }

    public String toString() {
        return "UseCacheScene(from=" + this.from + ", page=" + this.page + ", pd=" + this.pd + ')';
    }

    public UseCacheScene(String from2, String page2, String pd2) {
        Intrinsics.checkNotNullParameter(from2, "from");
        Intrinsics.checkNotNullParameter(page2, "page");
        Intrinsics.checkNotNullParameter(pd2, "pd");
        this.from = from2;
        this.page = page2;
        this.pd = pd2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ UseCacheScene(String str, String str2, String str3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? "" : str3);
    }

    public final String getFrom() {
        return this.from;
    }

    public final String getPage() {
        return this.page;
    }

    public final String getPd() {
        return this.pd;
    }
}
