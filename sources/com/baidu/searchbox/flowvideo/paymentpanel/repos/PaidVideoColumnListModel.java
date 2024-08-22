package com.baidu.searchbox.flowvideo.paymentpanel.repos;

import com.baidu.searchbox.NoProGuard;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001BK\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\u001c\b\u0002\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\u000b¢\u0006\u0002\u0010\fJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J\u001d\u0010\u0019\u001a\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\u000bHÆ\u0003JO\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\u001c\b\u0002\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\u000bHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J\t\u0010 \u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R%\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000e¨\u0006!"}, d2 = {"Lcom/baidu/searchbox/flowvideo/paymentpanel/repos/PaidVideoColumnListModel;", "Lcom/baidu/searchbox/NoProGuard;", "hasMore", "", "hasAhead", "albumId", "", "seriesTxt", "paymentEpisodesItems", "Ljava/util/ArrayList;", "Lcom/baidu/searchbox/flowvideo/paymentpanel/repos/PaymentPanelEpisodesModel;", "Lkotlin/collections/ArrayList;", "(IILjava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;)V", "getAlbumId", "()Ljava/lang/String;", "getHasAhead", "()I", "getHasMore", "getPaymentEpisodesItems", "()Ljava/util/ArrayList;", "getSeriesTxt", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "toString", "lib-flow-domain_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentDetailPanelModel.kt */
public final class PaidVideoColumnListModel implements NoProGuard {
    private final String albumId;
    private final int hasAhead;
    private final int hasMore;
    private final ArrayList<PaymentPanelEpisodesModel> paymentEpisodesItems;
    private final String seriesTxt;

    public PaidVideoColumnListModel() {
        this(0, 0, (String) null, (String) null, (ArrayList) null, 31, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ PaidVideoColumnListModel copy$default(PaidVideoColumnListModel paidVideoColumnListModel, int i2, int i3, String str, String str2, ArrayList<PaymentPanelEpisodesModel> arrayList, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = paidVideoColumnListModel.hasMore;
        }
        if ((i4 & 2) != 0) {
            i3 = paidVideoColumnListModel.hasAhead;
        }
        int i5 = i3;
        if ((i4 & 4) != 0) {
            str = paidVideoColumnListModel.albumId;
        }
        String str3 = str;
        if ((i4 & 8) != 0) {
            str2 = paidVideoColumnListModel.seriesTxt;
        }
        String str4 = str2;
        if ((i4 & 16) != 0) {
            arrayList = paidVideoColumnListModel.paymentEpisodesItems;
        }
        return paidVideoColumnListModel.copy(i2, i5, str3, str4, arrayList);
    }

    public final int component1() {
        return this.hasMore;
    }

    public final int component2() {
        return this.hasAhead;
    }

    public final String component3() {
        return this.albumId;
    }

    public final String component4() {
        return this.seriesTxt;
    }

    public final ArrayList<PaymentPanelEpisodesModel> component5() {
        return this.paymentEpisodesItems;
    }

    public final PaidVideoColumnListModel copy(int i2, int i3, String str, String str2, ArrayList<PaymentPanelEpisodesModel> arrayList) {
        Intrinsics.checkNotNullParameter(str, "albumId");
        Intrinsics.checkNotNullParameter(str2, "seriesTxt");
        return new PaidVideoColumnListModel(i2, i3, str, str2, arrayList);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PaidVideoColumnListModel)) {
            return false;
        }
        PaidVideoColumnListModel paidVideoColumnListModel = (PaidVideoColumnListModel) obj;
        return this.hasMore == paidVideoColumnListModel.hasMore && this.hasAhead == paidVideoColumnListModel.hasAhead && Intrinsics.areEqual((Object) this.albumId, (Object) paidVideoColumnListModel.albumId) && Intrinsics.areEqual((Object) this.seriesTxt, (Object) paidVideoColumnListModel.seriesTxt) && Intrinsics.areEqual((Object) this.paymentEpisodesItems, (Object) paidVideoColumnListModel.paymentEpisodesItems);
    }

    public int hashCode() {
        int hashCode = ((((((Integer.hashCode(this.hasMore) * 31) + Integer.hashCode(this.hasAhead)) * 31) + this.albumId.hashCode()) * 31) + this.seriesTxt.hashCode()) * 31;
        ArrayList<PaymentPanelEpisodesModel> arrayList = this.paymentEpisodesItems;
        return hashCode + (arrayList == null ? 0 : arrayList.hashCode());
    }

    public String toString() {
        return "PaidVideoColumnListModel(hasMore=" + this.hasMore + ", hasAhead=" + this.hasAhead + ", albumId=" + this.albumId + ", seriesTxt=" + this.seriesTxt + ", paymentEpisodesItems=" + this.paymentEpisodesItems + ')';
    }

    public PaidVideoColumnListModel(int hasMore2, int hasAhead2, String albumId2, String seriesTxt2, ArrayList<PaymentPanelEpisodesModel> paymentEpisodesItems2) {
        Intrinsics.checkNotNullParameter(albumId2, "albumId");
        Intrinsics.checkNotNullParameter(seriesTxt2, "seriesTxt");
        this.hasMore = hasMore2;
        this.hasAhead = hasAhead2;
        this.albumId = albumId2;
        this.seriesTxt = seriesTxt2;
        this.paymentEpisodesItems = paymentEpisodesItems2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PaidVideoColumnListModel(int i2, int i3, String str, String str2, ArrayList arrayList, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? 0 : i2, (i4 & 2) != 0 ? 0 : i3, (i4 & 4) != 0 ? "" : str, (i4 & 8) != 0 ? "" : str2, (i4 & 16) != 0 ? null : arrayList);
    }

    public final int getHasMore() {
        return this.hasMore;
    }

    public final int getHasAhead() {
        return this.hasAhead;
    }

    public final String getAlbumId() {
        return this.albumId;
    }

    public final String getSeriesTxt() {
        return this.seriesTxt;
    }

    public final ArrayList<PaymentPanelEpisodesModel> getPaymentEpisodesItems() {
        return this.paymentEpisodesItems;
    }
}
