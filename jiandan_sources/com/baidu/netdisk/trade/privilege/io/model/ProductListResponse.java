package com.baidu.netdisk.trade.privilege.io.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0012\b\b\u0018\u00002\u00020\u0001Be\u0012\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u000f\u0012\u0010\b\u0002\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0002¢\u0006\u0004\b2\u00103J\u0018\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\u000e\u0010\rJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0005Jn\u0010\u001b\u001a\u00020\u00002\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\b\b\u0002\u0010\u0015\u001a\u00020\u00062\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u000f2\u0010\b\u0002\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u001a\u0010 \u001a\u00020\u001f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dHÖ\u0003¢\u0006\u0004\b \u0010!J\u0010\u0010#\u001a\u00020\"HÖ\u0001¢\u0006\u0004\b#\u0010$J\u0010\u0010%\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b%\u0010\u0011R\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u00038\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0017\u0010&\u001a\u0004\b'\u0010\rR$\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0014\u0010(\u001a\u0004\b)\u0010\u0005R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\t8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0016\u0010*\u001a\u0004\b+\u0010\u000bR\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u00038\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0018\u0010&\u001a\u0004\b,\u0010\rR$\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001a\u0010(\u001a\u0004\b-\u0010\u0005R\u001c\u0010\u0015\u001a\u00020\u00068\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0015\u0010.\u001a\u0004\b/\u0010\bR\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u000f8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0019\u00100\u001a\u0004\b1\u0010\u0011¨\u00064"}, d2 = {"Lcom/baidu/netdisk/trade/privilege/io/model/ProductListResponse;", "Lcom/baidu/netdisk/trade/privilege/io/model/Response;", "", "Lcom/baidu/netdisk/trade/privilege/io/model/Product;", "component1", "()Ljava/util/List;", "", "component2", "()J", "Lcom/baidu/netdisk/trade/privilege/io/model/LevelInfo;", "component3", "()Lcom/baidu/netdisk/trade/privilege/io/model/LevelInfo;", "component4", "()Lcom/baidu/netdisk/trade/privilege/io/model/Product;", "component5", "", "component6", "()Ljava/lang/String;", "Lcom/baidu/netdisk/trade/privilege/io/model/Privilege;", "component7", "infoList", "serverCurrentTime", "levelInfo", "currentProduct", "previousProduct", "userTag", "privileges", "copy", "(Ljava/util/List;JLcom/baidu/netdisk/trade/privilege/io/model/LevelInfo;Lcom/baidu/netdisk/trade/privilege/io/model/Product;Lcom/baidu/netdisk/trade/privilege/io/model/Product;Ljava/lang/String;Ljava/util/List;)Lcom/baidu/netdisk/trade/privilege/io/model/ProductListResponse;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Lcom/baidu/netdisk/trade/privilege/io/model/Product;", "getCurrentProduct", "Ljava/util/List;", "getInfoList", "Lcom/baidu/netdisk/trade/privilege/io/model/LevelInfo;", "getLevelInfo", "getPreviousProduct", "getPrivileges", "J", "getServerCurrentTime", "Ljava/lang/String;", "getUserTag", "<init>", "(Ljava/util/List;JLcom/baidu/netdisk/trade/privilege/io/model/LevelInfo;Lcom/baidu/netdisk/trade/privilege/io/model/Product;Lcom/baidu/netdisk/trade/privilege/io/model/Product;Ljava/lang/String;Ljava/util/List;)V", "TradeMemberPrivilege_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
public final class ProductListResponse extends Response {
    @SerializedName("current_product_v2")
    @Nullable
    public final Product currentProduct;
    @SerializedName("product_infos")
    @Nullable
    public final List<Product> infoList;
    @SerializedName("level_info")
    @Nullable
    public final LevelInfo levelInfo;
    @SerializedName("previous_product_v2")
    @Nullable
    public final Product previousProduct;
    @SerializedName("privilege_list")
    @Nullable
    public final List<Privilege> privileges;
    @SerializedName("currenttime")
    public final long serverCurrentTime;
    @SerializedName("user_tag")
    @Nullable
    public final String userTag;

    public ProductListResponse() {
        this((List) null, 0, (LevelInfo) null, (Product) null, (Product) null, (String) null, (List) null, 127, (DefaultConstructorMarker) null);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ProductListResponse(java.util.List r10, long r11, com.baidu.netdisk.trade.privilege.io.model.LevelInfo r13, com.baidu.netdisk.trade.privilege.io.model.Product r14, com.baidu.netdisk.trade.privilege.io.model.Product r15, java.lang.String r16, java.util.List r17, int r18, kotlin.jvm.internal.DefaultConstructorMarker r19) {
        /*
            r9 = this;
            r0 = r18 & 1
            r1 = 0
            if (r0 == 0) goto L_0x0007
            r0 = r1
            goto L_0x0008
        L_0x0007:
            r0 = r10
        L_0x0008:
            r2 = r18 & 2
            if (r2 == 0) goto L_0x000f
            r2 = 0
            goto L_0x0010
        L_0x000f:
            r2 = r11
        L_0x0010:
            r4 = r18 & 4
            if (r4 == 0) goto L_0x0016
            r4 = r1
            goto L_0x0017
        L_0x0016:
            r4 = r13
        L_0x0017:
            r5 = r18 & 8
            if (r5 == 0) goto L_0x001d
            r5 = r1
            goto L_0x001e
        L_0x001d:
            r5 = r14
        L_0x001e:
            r6 = r18 & 16
            if (r6 == 0) goto L_0x0024
            r6 = r1
            goto L_0x0025
        L_0x0024:
            r6 = r15
        L_0x0025:
            r7 = r18 & 32
            if (r7 == 0) goto L_0x002b
            r7 = r1
            goto L_0x002d
        L_0x002b:
            r7 = r16
        L_0x002d:
            r8 = r18 & 64
            if (r8 == 0) goto L_0x0032
            goto L_0x0034
        L_0x0032:
            r1 = r17
        L_0x0034:
            r10 = r9
            r11 = r0
            r12 = r2
            r14 = r4
            r15 = r5
            r16 = r6
            r17 = r7
            r18 = r1
            r10.<init>(r11, r12, r14, r15, r16, r17, r18)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.netdisk.trade.privilege.io.model.ProductListResponse.<init>(java.util.List, long, com.baidu.netdisk.trade.privilege.io.model.LevelInfo, com.baidu.netdisk.trade.privilege.io.model.Product, com.baidu.netdisk.trade.privilege.io.model.Product, java.lang.String, java.util.List, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public static /* synthetic */ ProductListResponse copy$default(ProductListResponse productListResponse, List list, long j, LevelInfo levelInfo2, Product product, Product product2, String str, List list2, int i2, Object obj) {
        ProductListResponse productListResponse2 = productListResponse;
        return productListResponse.copy((i2 & 1) != 0 ? productListResponse2.infoList : list, (i2 & 2) != 0 ? productListResponse2.serverCurrentTime : j, (i2 & 4) != 0 ? productListResponse2.levelInfo : levelInfo2, (i2 & 8) != 0 ? productListResponse2.currentProduct : product, (i2 & 16) != 0 ? productListResponse2.previousProduct : product2, (i2 & 32) != 0 ? productListResponse2.userTag : str, (i2 & 64) != 0 ? productListResponse2.privileges : list2);
    }

    @Nullable
    public final List<Product> component1() {
        return this.infoList;
    }

    public final long component2() {
        return this.serverCurrentTime;
    }

    @Nullable
    public final LevelInfo component3() {
        return this.levelInfo;
    }

    @Nullable
    public final Product component4() {
        return this.currentProduct;
    }

    @Nullable
    public final Product component5() {
        return this.previousProduct;
    }

    @Nullable
    public final String component6() {
        return this.userTag;
    }

    @Nullable
    public final List<Privilege> component7() {
        return this.privileges;
    }

    @NotNull
    public final ProductListResponse copy(@Nullable List<Product> list, long j, @Nullable LevelInfo levelInfo2, @Nullable Product product, @Nullable Product product2, @Nullable String str, @Nullable List<Privilege> list2) {
        return new ProductListResponse(list, j, levelInfo2, product, product2, str, list2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProductListResponse)) {
            return false;
        }
        ProductListResponse productListResponse = (ProductListResponse) obj;
        return Intrinsics.areEqual((Object) this.infoList, (Object) productListResponse.infoList) && this.serverCurrentTime == productListResponse.serverCurrentTime && Intrinsics.areEqual((Object) this.levelInfo, (Object) productListResponse.levelInfo) && Intrinsics.areEqual((Object) this.currentProduct, (Object) productListResponse.currentProduct) && Intrinsics.areEqual((Object) this.previousProduct, (Object) productListResponse.previousProduct) && Intrinsics.areEqual((Object) this.userTag, (Object) productListResponse.userTag) && Intrinsics.areEqual((Object) this.privileges, (Object) productListResponse.privileges);
    }

    @Nullable
    public final Product getCurrentProduct() {
        return this.currentProduct;
    }

    @Nullable
    public final List<Product> getInfoList() {
        return this.infoList;
    }

    @Nullable
    public final LevelInfo getLevelInfo() {
        return this.levelInfo;
    }

    @Nullable
    public final Product getPreviousProduct() {
        return this.previousProduct;
    }

    @Nullable
    public final List<Privilege> getPrivileges() {
        return this.privileges;
    }

    public final long getServerCurrentTime() {
        return this.serverCurrentTime;
    }

    @Nullable
    public final String getUserTag() {
        return this.userTag;
    }

    public int hashCode() {
        List<Product> list = this.infoList;
        int i2 = 0;
        int hashCode = (((list != null ? list.hashCode() : 0) * 31) + qw.qw(this.serverCurrentTime)) * 31;
        LevelInfo levelInfo2 = this.levelInfo;
        int hashCode2 = (hashCode + (levelInfo2 != null ? levelInfo2.hashCode() : 0)) * 31;
        Product product = this.currentProduct;
        int hashCode3 = (hashCode2 + (product != null ? product.hashCode() : 0)) * 31;
        Product product2 = this.previousProduct;
        int hashCode4 = (hashCode3 + (product2 != null ? product2.hashCode() : 0)) * 31;
        String str = this.userTag;
        int hashCode5 = (hashCode4 + (str != null ? str.hashCode() : 0)) * 31;
        List<Privilege> list2 = this.privileges;
        if (list2 != null) {
            i2 = list2.hashCode();
        }
        return hashCode5 + i2;
    }

    @NotNull
    public String toString() {
        return "ProductListResponse(infoList=" + this.infoList + ", serverCurrentTime=" + this.serverCurrentTime + ", levelInfo=" + this.levelInfo + ", currentProduct=" + this.currentProduct + ", previousProduct=" + this.previousProduct + ", userTag=" + this.userTag + ", privileges=" + this.privileges + ")";
    }

    public ProductListResponse(@Nullable List<Product> list, long j, @Nullable LevelInfo levelInfo2, @Nullable Product product, @Nullable Product product2, @Nullable String str, @Nullable List<Privilege> list2) {
        this.infoList = list;
        this.serverCurrentTime = j;
        this.levelInfo = levelInfo2;
        this.currentProduct = product;
        this.previousProduct = product2;
        this.userTag = str;
        this.privileges = list2;
    }
}
