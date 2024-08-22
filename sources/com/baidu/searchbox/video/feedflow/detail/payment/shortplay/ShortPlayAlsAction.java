package com.baidu.searchbox.video.feedflow.detail.payment.shortplay;

import com.baidu.searchbox.feed.detail.frame.Action;
import com.baidu.searchbox.video.detail.core.model.IntentData;
import com.baidu.swan.apps.statistic.SwanAppUBCStatistic;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003JO\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\u0003HÖ\u0001J\t\u0010\"\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\r¨\u0006#"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/payment/shortplay/ShortPlayAlsAction;", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "logType", "", "adExt", "", "collId", "nid", "authorId", "orderId", "payPrice", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAdExt", "()Ljava/lang/String;", "getAuthorId", "getCollId", "getLogType", "()I", "getNid", "getOrderId", "getPayPrice", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "", "hashCode", "toString", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ShortPlayPaymentGuideActionManifest.kt */
public final class ShortPlayAlsAction implements Action {
    private final String adExt;
    private final String authorId;
    private final String collId;
    private final int logType;
    private final String nid;
    private final String orderId;
    private final String payPrice;

    public static /* synthetic */ ShortPlayAlsAction copy$default(ShortPlayAlsAction shortPlayAlsAction, int i2, String str, String str2, String str3, String str4, String str5, String str6, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = shortPlayAlsAction.logType;
        }
        if ((i3 & 2) != 0) {
            str = shortPlayAlsAction.adExt;
        }
        String str7 = str;
        if ((i3 & 4) != 0) {
            str2 = shortPlayAlsAction.collId;
        }
        String str8 = str2;
        if ((i3 & 8) != 0) {
            str3 = shortPlayAlsAction.nid;
        }
        String str9 = str3;
        if ((i3 & 16) != 0) {
            str4 = shortPlayAlsAction.authorId;
        }
        String str10 = str4;
        if ((i3 & 32) != 0) {
            str5 = shortPlayAlsAction.orderId;
        }
        String str11 = str5;
        if ((i3 & 64) != 0) {
            str6 = shortPlayAlsAction.payPrice;
        }
        return shortPlayAlsAction.copy(i2, str7, str8, str9, str10, str11, str6);
    }

    public final int component1() {
        return this.logType;
    }

    public final String component2() {
        return this.adExt;
    }

    public final String component3() {
        return this.collId;
    }

    public final String component4() {
        return this.nid;
    }

    public final String component5() {
        return this.authorId;
    }

    public final String component6() {
        return this.orderId;
    }

    public final String component7() {
        return this.payPrice;
    }

    public final ShortPlayAlsAction copy(int i2, String str, String str2, String str3, String str4, String str5, String str6) {
        Intrinsics.checkNotNullParameter(str, IntentData.KEY_AD_EXT);
        Intrinsics.checkNotNullParameter(str2, "collId");
        Intrinsics.checkNotNullParameter(str3, "nid");
        Intrinsics.checkNotNullParameter(str4, "authorId");
        Intrinsics.checkNotNullParameter(str5, SwanAppUBCStatistic.EXT_ORDERID);
        Intrinsics.checkNotNullParameter(str6, "payPrice");
        return new ShortPlayAlsAction(i2, str, str2, str3, str4, str5, str6);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShortPlayAlsAction)) {
            return false;
        }
        ShortPlayAlsAction shortPlayAlsAction = (ShortPlayAlsAction) obj;
        return this.logType == shortPlayAlsAction.logType && Intrinsics.areEqual((Object) this.adExt, (Object) shortPlayAlsAction.adExt) && Intrinsics.areEqual((Object) this.collId, (Object) shortPlayAlsAction.collId) && Intrinsics.areEqual((Object) this.nid, (Object) shortPlayAlsAction.nid) && Intrinsics.areEqual((Object) this.authorId, (Object) shortPlayAlsAction.authorId) && Intrinsics.areEqual((Object) this.orderId, (Object) shortPlayAlsAction.orderId) && Intrinsics.areEqual((Object) this.payPrice, (Object) shortPlayAlsAction.payPrice);
    }

    public int hashCode() {
        return (((((((((((Integer.hashCode(this.logType) * 31) + this.adExt.hashCode()) * 31) + this.collId.hashCode()) * 31) + this.nid.hashCode()) * 31) + this.authorId.hashCode()) * 31) + this.orderId.hashCode()) * 31) + this.payPrice.hashCode();
    }

    public String toString() {
        return "ShortPlayAlsAction(logType=" + this.logType + ", adExt=" + this.adExt + ", collId=" + this.collId + ", nid=" + this.nid + ", authorId=" + this.authorId + ", orderId=" + this.orderId + ", payPrice=" + this.payPrice + ')';
    }

    public ShortPlayAlsAction(int logType2, String adExt2, String collId2, String nid2, String authorId2, String orderId2, String payPrice2) {
        Intrinsics.checkNotNullParameter(adExt2, IntentData.KEY_AD_EXT);
        Intrinsics.checkNotNullParameter(collId2, "collId");
        Intrinsics.checkNotNullParameter(nid2, "nid");
        Intrinsics.checkNotNullParameter(authorId2, "authorId");
        Intrinsics.checkNotNullParameter(orderId2, SwanAppUBCStatistic.EXT_ORDERID);
        Intrinsics.checkNotNullParameter(payPrice2, "payPrice");
        this.logType = logType2;
        this.adExt = adExt2;
        this.collId = collId2;
        this.nid = nid2;
        this.authorId = authorId2;
        this.orderId = orderId2;
        this.payPrice = payPrice2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ShortPlayAlsAction(int r8, java.lang.String r9, java.lang.String r10, java.lang.String r11, java.lang.String r12, java.lang.String r13, java.lang.String r14, int r15, kotlin.jvm.internal.DefaultConstructorMarker r16) {
        /*
            r7 = this;
            r0 = r15 & 2
            java.lang.String r1 = ""
            if (r0 == 0) goto L_0x0008
            r0 = r1
            goto L_0x0009
        L_0x0008:
            r0 = r9
        L_0x0009:
            r2 = r15 & 4
            if (r2 == 0) goto L_0x000f
            r2 = r1
            goto L_0x0010
        L_0x000f:
            r2 = r10
        L_0x0010:
            r3 = r15 & 8
            if (r3 == 0) goto L_0x0016
            r3 = r1
            goto L_0x0017
        L_0x0016:
            r3 = r11
        L_0x0017:
            r4 = r15 & 16
            if (r4 == 0) goto L_0x001d
            r4 = r1
            goto L_0x001e
        L_0x001d:
            r4 = r12
        L_0x001e:
            r5 = r15 & 32
            if (r5 == 0) goto L_0x0024
            r5 = r1
            goto L_0x0025
        L_0x0024:
            r5 = r13
        L_0x0025:
            r6 = r15 & 64
            if (r6 == 0) goto L_0x002a
            goto L_0x002b
        L_0x002a:
            r1 = r14
        L_0x002b:
            r9 = r7
            r10 = r8
            r11 = r0
            r12 = r2
            r13 = r3
            r14 = r4
            r15 = r5
            r16 = r1
            r9.<init>(r10, r11, r12, r13, r14, r15, r16)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.detail.payment.shortplay.ShortPlayAlsAction.<init>(int, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final int getLogType() {
        return this.logType;
    }

    public final String getAdExt() {
        return this.adExt;
    }

    public final String getCollId() {
        return this.collId;
    }

    public final String getNid() {
        return this.nid;
    }

    public final String getAuthorId() {
        return this.authorId;
    }

    public final String getOrderId() {
        return this.orderId;
    }

    public final String getPayPrice() {
        return this.payPrice;
    }
}
