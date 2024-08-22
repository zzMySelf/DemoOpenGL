package com.baidu.searchbox.feed.model.gson.bean;

import com.baidu.searchbox.NoProGuard;
import com.baidu.searchbox.file.watcher.base.FileWatcher;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b%\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B}\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003¢\u0006\u0002\u0010\u000fJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\u0001\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u0003HÆ\u0001J\u0013\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010+HÖ\u0003J\t\u0010,\u001a\u00020-HÖ\u0001J\t\u0010.\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0011R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0011¨\u0006/"}, d2 = {"Lcom/baidu/searchbox/feed/model/gson/bean/PaymentInfoBean;", "Lcom/baidu/searchbox/NoProGuard;", "isAuthro", "", "paidSvType", "albumId", "title", "albumType", "img", "isPaid", "priceTxt", "realPriceTxt", "realPrice", "albumCmd", "previewDuration", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAlbumCmd", "()Ljava/lang/String;", "getAlbumId", "getAlbumType", "getImg", "getPaidSvType", "getPreviewDuration", "getPriceTxt", "getRealPrice", "getRealPriceTxt", "getTitle", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "", "hashCode", "", "toString", "lib-feed-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentInfoBean.kt */
public final class PaymentInfoBean implements NoProGuard {
    private final String albumCmd;
    private final String albumId;
    private final String albumType;
    private final String img;
    private final String isAuthro;
    private final String isPaid;
    private final String paidSvType;
    private final String previewDuration;
    private final String priceTxt;
    private final String realPrice;
    private final String realPriceTxt;
    private final String title;

    public PaymentInfoBean() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, FileWatcher.ALL_EVENTS, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ PaymentInfoBean copy$default(PaymentInfoBean paymentInfoBean, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, int i2, Object obj) {
        PaymentInfoBean paymentInfoBean2 = paymentInfoBean;
        int i3 = i2;
        return paymentInfoBean.copy((i3 & 1) != 0 ? paymentInfoBean2.isAuthro : str, (i3 & 2) != 0 ? paymentInfoBean2.paidSvType : str2, (i3 & 4) != 0 ? paymentInfoBean2.albumId : str3, (i3 & 8) != 0 ? paymentInfoBean2.title : str4, (i3 & 16) != 0 ? paymentInfoBean2.albumType : str5, (i3 & 32) != 0 ? paymentInfoBean2.img : str6, (i3 & 64) != 0 ? paymentInfoBean2.isPaid : str7, (i3 & 128) != 0 ? paymentInfoBean2.priceTxt : str8, (i3 & 256) != 0 ? paymentInfoBean2.realPriceTxt : str9, (i3 & 512) != 0 ? paymentInfoBean2.realPrice : str10, (i3 & 1024) != 0 ? paymentInfoBean2.albumCmd : str11, (i3 & 2048) != 0 ? paymentInfoBean2.previewDuration : str12);
    }

    public final String component1() {
        return this.isAuthro;
    }

    public final String component10() {
        return this.realPrice;
    }

    public final String component11() {
        return this.albumCmd;
    }

    public final String component12() {
        return this.previewDuration;
    }

    public final String component2() {
        return this.paidSvType;
    }

    public final String component3() {
        return this.albumId;
    }

    public final String component4() {
        return this.title;
    }

    public final String component5() {
        return this.albumType;
    }

    public final String component6() {
        return this.img;
    }

    public final String component7() {
        return this.isPaid;
    }

    public final String component8() {
        return this.priceTxt;
    }

    public final String component9() {
        return this.realPriceTxt;
    }

    public final PaymentInfoBean copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12) {
        Intrinsics.checkNotNullParameter(str, "isAuthro");
        Intrinsics.checkNotNullParameter(str2, "paidSvType");
        Intrinsics.checkNotNullParameter(str3, "albumId");
        Intrinsics.checkNotNullParameter(str4, "title");
        Intrinsics.checkNotNullParameter(str5, "albumType");
        Intrinsics.checkNotNullParameter(str6, "img");
        Intrinsics.checkNotNullParameter(str7, "isPaid");
        Intrinsics.checkNotNullParameter(str8, "priceTxt");
        Intrinsics.checkNotNullParameter(str9, "realPriceTxt");
        Intrinsics.checkNotNullParameter(str10, "realPrice");
        Intrinsics.checkNotNullParameter(str11, "albumCmd");
        Intrinsics.checkNotNullParameter(str12, "previewDuration");
        return new PaymentInfoBean(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PaymentInfoBean)) {
            return false;
        }
        PaymentInfoBean paymentInfoBean = (PaymentInfoBean) obj;
        return Intrinsics.areEqual((Object) this.isAuthro, (Object) paymentInfoBean.isAuthro) && Intrinsics.areEqual((Object) this.paidSvType, (Object) paymentInfoBean.paidSvType) && Intrinsics.areEqual((Object) this.albumId, (Object) paymentInfoBean.albumId) && Intrinsics.areEqual((Object) this.title, (Object) paymentInfoBean.title) && Intrinsics.areEqual((Object) this.albumType, (Object) paymentInfoBean.albumType) && Intrinsics.areEqual((Object) this.img, (Object) paymentInfoBean.img) && Intrinsics.areEqual((Object) this.isPaid, (Object) paymentInfoBean.isPaid) && Intrinsics.areEqual((Object) this.priceTxt, (Object) paymentInfoBean.priceTxt) && Intrinsics.areEqual((Object) this.realPriceTxt, (Object) paymentInfoBean.realPriceTxt) && Intrinsics.areEqual((Object) this.realPrice, (Object) paymentInfoBean.realPrice) && Intrinsics.areEqual((Object) this.albumCmd, (Object) paymentInfoBean.albumCmd) && Intrinsics.areEqual((Object) this.previewDuration, (Object) paymentInfoBean.previewDuration);
    }

    public int hashCode() {
        return (((((((((((((((((((((this.isAuthro.hashCode() * 31) + this.paidSvType.hashCode()) * 31) + this.albumId.hashCode()) * 31) + this.title.hashCode()) * 31) + this.albumType.hashCode()) * 31) + this.img.hashCode()) * 31) + this.isPaid.hashCode()) * 31) + this.priceTxt.hashCode()) * 31) + this.realPriceTxt.hashCode()) * 31) + this.realPrice.hashCode()) * 31) + this.albumCmd.hashCode()) * 31) + this.previewDuration.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PaymentInfoBean(isAuthro=").append(this.isAuthro).append(", paidSvType=").append(this.paidSvType).append(", albumId=").append(this.albumId).append(", title=").append(this.title).append(", albumType=").append(this.albumType).append(", img=").append(this.img).append(", isPaid=").append(this.isPaid).append(", priceTxt=").append(this.priceTxt).append(", realPriceTxt=").append(this.realPriceTxt).append(", realPrice=").append(this.realPrice).append(", albumCmd=").append(this.albumCmd).append(", previewDuration=");
        sb.append(this.previewDuration).append(')');
        return sb.toString();
    }

    public PaymentInfoBean(String isAuthro2, String paidSvType2, String albumId2, String title2, String albumType2, String img2, String isPaid2, String priceTxt2, String realPriceTxt2, String realPrice2, String albumCmd2, String previewDuration2) {
        Intrinsics.checkNotNullParameter(isAuthro2, "isAuthro");
        Intrinsics.checkNotNullParameter(paidSvType2, "paidSvType");
        Intrinsics.checkNotNullParameter(albumId2, "albumId");
        Intrinsics.checkNotNullParameter(title2, "title");
        Intrinsics.checkNotNullParameter(albumType2, "albumType");
        Intrinsics.checkNotNullParameter(img2, "img");
        Intrinsics.checkNotNullParameter(isPaid2, "isPaid");
        Intrinsics.checkNotNullParameter(priceTxt2, "priceTxt");
        Intrinsics.checkNotNullParameter(realPriceTxt2, "realPriceTxt");
        Intrinsics.checkNotNullParameter(realPrice2, "realPrice");
        Intrinsics.checkNotNullParameter(albumCmd2, "albumCmd");
        Intrinsics.checkNotNullParameter(previewDuration2, "previewDuration");
        this.isAuthro = isAuthro2;
        this.paidSvType = paidSvType2;
        this.albumId = albumId2;
        this.title = title2;
        this.albumType = albumType2;
        this.img = img2;
        this.isPaid = isPaid2;
        this.priceTxt = priceTxt2;
        this.realPriceTxt = realPriceTxt2;
        this.realPrice = realPrice2;
        this.albumCmd = albumCmd2;
        this.previewDuration = previewDuration2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PaymentInfoBean(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? "" : str3, (i2 & 8) != 0 ? "" : str4, (i2 & 16) != 0 ? "" : str5, (i2 & 32) != 0 ? "" : str6, (i2 & 64) != 0 ? "" : str7, (i2 & 128) != 0 ? "" : str8, (i2 & 256) != 0 ? "" : str9, (i2 & 512) != 0 ? "" : str10, (i2 & 1024) != 0 ? "" : str11, (i2 & 2048) != 0 ? "" : str12);
    }

    public final String isAuthro() {
        return this.isAuthro;
    }

    public final String getPaidSvType() {
        return this.paidSvType;
    }

    public final String getAlbumId() {
        return this.albumId;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getAlbumType() {
        return this.albumType;
    }

    public final String getImg() {
        return this.img;
    }

    public final String isPaid() {
        return this.isPaid;
    }

    public final String getPriceTxt() {
        return this.priceTxt;
    }

    public final String getRealPriceTxt() {
        return this.realPriceTxt;
    }

    public final String getRealPrice() {
        return this.realPrice;
    }

    public final String getAlbumCmd() {
        return this.albumCmd;
    }

    public final String getPreviewDuration() {
        return this.previewDuration;
    }
}
