package com.baidu.searchbox.flowvideo.detail.api;

import com.baidu.searchbox.NoProGuard;
import com.baidu.searchbox.video.detail.message.MessageManifest;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/baidu/searchbox/flowvideo/detail/api/PublishInfoBean;", "Lcom/baidu/searchbox/NoProGuard;", "time", "", "area", "(Ljava/lang/String;Ljava/lang/String;)V", "getArea", "()Ljava/lang/String;", "getTime", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "lib-flow-domain_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FlowDetailBean.kt */
public final class PublishInfoBean implements NoProGuard {
    private final String area;
    private final String time;

    public PublishInfoBean() {
        this((String) null, (String) null, 3, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ PublishInfoBean copy$default(PublishInfoBean publishInfoBean, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = publishInfoBean.time;
        }
        if ((i2 & 2) != 0) {
            str2 = publishInfoBean.area;
        }
        return publishInfoBean.copy(str, str2);
    }

    public final String component1() {
        return this.time;
    }

    public final String component2() {
        return this.area;
    }

    public final PublishInfoBean copy(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "time");
        Intrinsics.checkNotNullParameter(str2, MessageManifest.Advert.Key.AREA);
        return new PublishInfoBean(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PublishInfoBean)) {
            return false;
        }
        PublishInfoBean publishInfoBean = (PublishInfoBean) obj;
        return Intrinsics.areEqual((Object) this.time, (Object) publishInfoBean.time) && Intrinsics.areEqual((Object) this.area, (Object) publishInfoBean.area);
    }

    public int hashCode() {
        return (this.time.hashCode() * 31) + this.area.hashCode();
    }

    public String toString() {
        return "PublishInfoBean(time=" + this.time + ", area=" + this.area + ')';
    }

    public PublishInfoBean(String time2, String area2) {
        Intrinsics.checkNotNullParameter(time2, "time");
        Intrinsics.checkNotNullParameter(area2, MessageManifest.Advert.Key.AREA);
        this.time = time2;
        this.area = area2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PublishInfoBean(String str, String str2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2);
    }

    public final String getTime() {
        return this.time;
    }

    public final String getArea() {
        return this.area;
    }
}
