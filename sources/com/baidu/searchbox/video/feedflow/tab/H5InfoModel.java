package com.baidu.searchbox.video.feedflow.tab;

import com.baidu.searchbox.NoProGuard;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0016"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/tab/H5InfoModel;", "Lcom/baidu/searchbox/NoProGuard;", "url", "", "browserParams", "extraExt", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBrowserParams", "()Ljava/lang/String;", "getExtraExt", "getUrl", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TabInfoModel.kt */
public final class H5InfoModel implements NoProGuard {
    private final String browserParams;
    private final String extraExt;
    private final String url;

    public static /* synthetic */ H5InfoModel copy$default(H5InfoModel h5InfoModel, String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = h5InfoModel.url;
        }
        if ((i2 & 2) != 0) {
            str2 = h5InfoModel.browserParams;
        }
        if ((i2 & 4) != 0) {
            str3 = h5InfoModel.extraExt;
        }
        return h5InfoModel.copy(str, str2, str3);
    }

    public final String component1() {
        return this.url;
    }

    public final String component2() {
        return this.browserParams;
    }

    public final String component3() {
        return this.extraExt;
    }

    public final H5InfoModel copy(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "url");
        Intrinsics.checkNotNullParameter(str2, "browserParams");
        Intrinsics.checkNotNullParameter(str3, "extraExt");
        return new H5InfoModel(str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof H5InfoModel)) {
            return false;
        }
        H5InfoModel h5InfoModel = (H5InfoModel) obj;
        return Intrinsics.areEqual((Object) this.url, (Object) h5InfoModel.url) && Intrinsics.areEqual((Object) this.browserParams, (Object) h5InfoModel.browserParams) && Intrinsics.areEqual((Object) this.extraExt, (Object) h5InfoModel.extraExt);
    }

    public int hashCode() {
        return (((this.url.hashCode() * 31) + this.browserParams.hashCode()) * 31) + this.extraExt.hashCode();
    }

    public String toString() {
        return "H5InfoModel(url=" + this.url + ", browserParams=" + this.browserParams + ", extraExt=" + this.extraExt + ')';
    }

    public H5InfoModel(String url2, String browserParams2, String extraExt2) {
        Intrinsics.checkNotNullParameter(url2, "url");
        Intrinsics.checkNotNullParameter(browserParams2, "browserParams");
        Intrinsics.checkNotNullParameter(extraExt2, "extraExt");
        this.url = url2;
        this.browserParams = browserParams2;
        this.extraExt = extraExt2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ H5InfoModel(String str, String str2, String str3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? "" : str3);
    }

    public final String getUrl() {
        return this.url;
    }

    public final String getBrowserParams() {
        return this.browserParams;
    }

    public final String getExtraExt() {
        return this.extraExt;
    }
}
