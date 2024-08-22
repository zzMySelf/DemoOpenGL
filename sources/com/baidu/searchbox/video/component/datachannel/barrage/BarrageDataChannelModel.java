package com.baidu.searchbox.video.component.datachannel.barrage;

import com.baidu.searchbox.NoProGuard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0016"}, d2 = {"Lcom/baidu/searchbox/video/component/datachannel/barrage/BarrageDataChannelModel;", "Lcom/baidu/searchbox/NoProGuard;", "type", "", "nid", "pageId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getNid", "()Ljava/lang/String;", "getPageId", "getType", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "lib-video-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BarrageDataChannelModel.kt */
public final class BarrageDataChannelModel implements NoProGuard {
    private final String nid;
    private final String pageId;
    private final String type;

    public static /* synthetic */ BarrageDataChannelModel copy$default(BarrageDataChannelModel barrageDataChannelModel, String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = barrageDataChannelModel.type;
        }
        if ((i2 & 2) != 0) {
            str2 = barrageDataChannelModel.nid;
        }
        if ((i2 & 4) != 0) {
            str3 = barrageDataChannelModel.pageId;
        }
        return barrageDataChannelModel.copy(str, str2, str3);
    }

    public final String component1() {
        return this.type;
    }

    public final String component2() {
        return this.nid;
    }

    public final String component3() {
        return this.pageId;
    }

    public final BarrageDataChannelModel copy(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "type");
        Intrinsics.checkNotNullParameter(str2, "nid");
        Intrinsics.checkNotNullParameter(str3, "pageId");
        return new BarrageDataChannelModel(str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BarrageDataChannelModel)) {
            return false;
        }
        BarrageDataChannelModel barrageDataChannelModel = (BarrageDataChannelModel) obj;
        return Intrinsics.areEqual((Object) this.type, (Object) barrageDataChannelModel.type) && Intrinsics.areEqual((Object) this.nid, (Object) barrageDataChannelModel.nid) && Intrinsics.areEqual((Object) this.pageId, (Object) barrageDataChannelModel.pageId);
    }

    public int hashCode() {
        return (((this.type.hashCode() * 31) + this.nid.hashCode()) * 31) + this.pageId.hashCode();
    }

    public String toString() {
        return "BarrageDataChannelModel(type=" + this.type + ", nid=" + this.nid + ", pageId=" + this.pageId + ')';
    }

    public BarrageDataChannelModel(String type2, String nid2, String pageId2) {
        Intrinsics.checkNotNullParameter(type2, "type");
        Intrinsics.checkNotNullParameter(nid2, "nid");
        Intrinsics.checkNotNullParameter(pageId2, "pageId");
        this.type = type2;
        this.nid = nid2;
        this.pageId = pageId2;
    }

    public final String getNid() {
        return this.nid;
    }

    public final String getPageId() {
        return this.pageId;
    }

    public final String getType() {
        return this.type;
    }
}
