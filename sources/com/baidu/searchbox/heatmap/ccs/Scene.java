package com.baidu.searchbox.heatmap.ccs;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J$\u0010\u0014\u001a\u00020\u00102\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0016"}, d2 = {"Lcom/baidu/searchbox/heatmap/ccs/Scene;", "", "from", "", "page", "source", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getFrom", "()Ljava/lang/String;", "getPage", "getSource", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "isMatch", "toString", "bdheatmap-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HeatMapConfigManager.kt */
public final class Scene {
    private final String from;
    private final String page;
    private final String source;

    public Scene() {
        this((String) null, (String) null, (String) null, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ Scene copy$default(Scene scene, String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = scene.from;
        }
        if ((i2 & 2) != 0) {
            str2 = scene.page;
        }
        if ((i2 & 4) != 0) {
            str3 = scene.source;
        }
        return scene.copy(str, str2, str3);
    }

    public final String component1() {
        return this.from;
    }

    public final String component2() {
        return this.page;
    }

    public final String component3() {
        return this.source;
    }

    public final Scene copy(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "from");
        Intrinsics.checkNotNullParameter(str2, "page");
        Intrinsics.checkNotNullParameter(str3, "source");
        return new Scene(str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Scene)) {
            return false;
        }
        Scene scene = (Scene) obj;
        return Intrinsics.areEqual((Object) this.from, (Object) scene.from) && Intrinsics.areEqual((Object) this.page, (Object) scene.page) && Intrinsics.areEqual((Object) this.source, (Object) scene.source);
    }

    public int hashCode() {
        return (((this.from.hashCode() * 31) + this.page.hashCode()) * 31) + this.source.hashCode();
    }

    public String toString() {
        return "Scene(from=" + this.from + ", page=" + this.page + ", source=" + this.source + ')';
    }

    public Scene(String from2, String page2, String source2) {
        Intrinsics.checkNotNullParameter(from2, "from");
        Intrinsics.checkNotNullParameter(page2, "page");
        Intrinsics.checkNotNullParameter(source2, "source");
        this.from = from2;
        this.page = page2;
        this.source = source2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Scene(String str, String str2, String str3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? "" : str3);
    }

    public final String getFrom() {
        return this.from;
    }

    public final String getPage() {
        return this.page;
    }

    public final String getSource() {
        return this.source;
    }

    public final boolean isMatch(String from2, String page2, String source2) {
        if ((!StringsKt.isBlank(this.from)) && !Intrinsics.areEqual((Object) from2, (Object) this.from)) {
            return false;
        }
        if (!(!StringsKt.isBlank(this.page)) || Intrinsics.areEqual((Object) page2, (Object) this.page)) {
            return !(StringsKt.isBlank(this.source) ^ true) || Intrinsics.areEqual((Object) source2, (Object) this.source);
        }
        return false;
    }
}
