package com.baidu.searchbox.feed.model.gson.bean;

import com.baidu.searchbox.NoProGuard;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\u0007\"\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/baidu/searchbox/feed/model/gson/bean/BarrageInfoBean;", "Lcom/baidu/searchbox/NoProGuard;", "nid", "", "topicId", "(Ljava/lang/String;Ljava/lang/String;)V", "getNid", "()Ljava/lang/String;", "getTopicId", "setTopicId", "(Ljava/lang/String;)V", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "lib-feed-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BarrageInfoBean.kt */
public final class BarrageInfoBean implements NoProGuard {
    private final String nid;
    private String topicId;

    public BarrageInfoBean() {
        this((String) null, (String) null, 3, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ BarrageInfoBean copy$default(BarrageInfoBean barrageInfoBean, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = barrageInfoBean.nid;
        }
        if ((i2 & 2) != 0) {
            str2 = barrageInfoBean.topicId;
        }
        return barrageInfoBean.copy(str, str2);
    }

    public final String component1() {
        return this.nid;
    }

    public final String component2() {
        return this.topicId;
    }

    public final BarrageInfoBean copy(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "nid");
        Intrinsics.checkNotNullParameter(str2, "topicId");
        return new BarrageInfoBean(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BarrageInfoBean)) {
            return false;
        }
        BarrageInfoBean barrageInfoBean = (BarrageInfoBean) obj;
        return Intrinsics.areEqual((Object) this.nid, (Object) barrageInfoBean.nid) && Intrinsics.areEqual((Object) this.topicId, (Object) barrageInfoBean.topicId);
    }

    public int hashCode() {
        return (this.nid.hashCode() * 31) + this.topicId.hashCode();
    }

    public String toString() {
        return "BarrageInfoBean(nid=" + this.nid + ", topicId=" + this.topicId + ')';
    }

    public BarrageInfoBean(String nid2, String topicId2) {
        Intrinsics.checkNotNullParameter(nid2, "nid");
        Intrinsics.checkNotNullParameter(topicId2, "topicId");
        this.nid = nid2;
        this.topicId = topicId2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BarrageInfoBean(String str, String str2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2);
    }

    public final String getNid() {
        return this.nid;
    }

    public final String getTopicId() {
        return this.topicId;
    }

    public final void setTopicId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.topicId = str;
    }
}
