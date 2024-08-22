package com.baidu.searchbox.flowvideo.paymentsubscribe.repos;

import com.baidu.searchbox.feed.detail.ext.common.RequestParam;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J;\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\u0006\u0010\u0019\u001a\u00020\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001f"}, d2 = {"Lcom/baidu/searchbox/flowvideo/paymentsubscribe/repos/FollowPaymentSubscribeParam;", "Lcom/baidu/searchbox/feed/detail/ext/common/RequestParam;", "uk", "", "vid", "nid", "resourceType", "thirdId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getNid", "()Ljava/lang/String;", "getResourceType", "getThirdId", "getUk", "getVid", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "getKey", "hashCode", "", "toJson", "Lorg/json/JSONObject;", "toString", "lib-flow-domain_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FollowPaymentSubscribeParam.kt */
public final class FollowPaymentSubscribeParam extends RequestParam {
    private final String nid;
    private final String resourceType;
    private final String thirdId;
    private final String uk;
    private final String vid;

    public static /* synthetic */ FollowPaymentSubscribeParam copy$default(FollowPaymentSubscribeParam followPaymentSubscribeParam, String str, String str2, String str3, String str4, String str5, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = followPaymentSubscribeParam.uk;
        }
        if ((i2 & 2) != 0) {
            str2 = followPaymentSubscribeParam.vid;
        }
        String str6 = str2;
        if ((i2 & 4) != 0) {
            str3 = followPaymentSubscribeParam.nid;
        }
        String str7 = str3;
        if ((i2 & 8) != 0) {
            str4 = followPaymentSubscribeParam.resourceType;
        }
        String str8 = str4;
        if ((i2 & 16) != 0) {
            str5 = followPaymentSubscribeParam.thirdId;
        }
        return followPaymentSubscribeParam.copy(str, str6, str7, str8, str5);
    }

    public final String component1() {
        return this.uk;
    }

    public final String component2() {
        return this.vid;
    }

    public final String component3() {
        return this.nid;
    }

    public final String component4() {
        return this.resourceType;
    }

    public final String component5() {
        return this.thirdId;
    }

    public final FollowPaymentSubscribeParam copy(String str, String str2, String str3, String str4, String str5) {
        Intrinsics.checkNotNullParameter(str, "uk");
        Intrinsics.checkNotNullParameter(str2, "vid");
        Intrinsics.checkNotNullParameter(str3, "nid");
        Intrinsics.checkNotNullParameter(str4, "resourceType");
        Intrinsics.checkNotNullParameter(str5, "thirdId");
        return new FollowPaymentSubscribeParam(str, str2, str3, str4, str5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FollowPaymentSubscribeParam)) {
            return false;
        }
        FollowPaymentSubscribeParam followPaymentSubscribeParam = (FollowPaymentSubscribeParam) obj;
        return Intrinsics.areEqual((Object) this.uk, (Object) followPaymentSubscribeParam.uk) && Intrinsics.areEqual((Object) this.vid, (Object) followPaymentSubscribeParam.vid) && Intrinsics.areEqual((Object) this.nid, (Object) followPaymentSubscribeParam.nid) && Intrinsics.areEqual((Object) this.resourceType, (Object) followPaymentSubscribeParam.resourceType) && Intrinsics.areEqual((Object) this.thirdId, (Object) followPaymentSubscribeParam.thirdId);
    }

    public int hashCode() {
        return (((((((this.uk.hashCode() * 31) + this.vid.hashCode()) * 31) + this.nid.hashCode()) * 31) + this.resourceType.hashCode()) * 31) + this.thirdId.hashCode();
    }

    public String toString() {
        return "FollowPaymentSubscribeParam(uk=" + this.uk + ", vid=" + this.vid + ", nid=" + this.nid + ", resourceType=" + this.resourceType + ", thirdId=" + this.thirdId + ')';
    }

    public final String getUk() {
        return this.uk;
    }

    public final String getVid() {
        return this.vid;
    }

    public final String getNid() {
        return this.nid;
    }

    public final String getResourceType() {
        return this.resourceType;
    }

    public final String getThirdId() {
        return this.thirdId;
    }

    public FollowPaymentSubscribeParam(String uk2, String vid2, String nid2, String resourceType2, String thirdId2) {
        Intrinsics.checkNotNullParameter(uk2, "uk");
        Intrinsics.checkNotNullParameter(vid2, "vid");
        Intrinsics.checkNotNullParameter(nid2, "nid");
        Intrinsics.checkNotNullParameter(resourceType2, "resourceType");
        Intrinsics.checkNotNullParameter(thirdId2, "thirdId");
        this.uk = uk2;
        this.vid = vid2;
        this.nid = nid2;
        this.resourceType = resourceType2;
        this.thirdId = thirdId2;
    }

    public JSONObject toJson() {
        addExtParams("followUk", this.uk);
        addExtParams("vid", this.vid);
        addExtParams("nid", this.nid);
        addExtParams("resourceType", this.resourceType);
        addExtParams("thirdId", this.thirdId);
        return super.toJson();
    }

    public final String getKey() {
        String str = this.uk + this.vid;
        Intrinsics.checkNotNullExpressionValue(str, "StringBuilder().append(uk).append(vid).toString()");
        return str;
    }
}
