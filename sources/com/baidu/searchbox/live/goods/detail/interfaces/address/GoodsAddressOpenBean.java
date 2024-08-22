package com.baidu.searchbox.live.goods.detail.interfaces.address;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0017\u0018\u00002\u00020\u0001B7\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0002\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\b\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0012\"\u0004\b\u0016\u0010\u0014R\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u000b\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0018\"\u0004\b\u001c\u0010\u001aR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"Lcom/baidu/searchbox/live/goods/detail/interfaces/address/GoodsAddressOpenBean;", "", "type", "Lcom/baidu/searchbox/live/goods/detail/interfaces/address/GoodsAddressType;", "openPageName", "Lcom/baidu/searchbox/live/goods/detail/interfaces/address/GoodsAddressOpenPageName;", "selectAddedAddress", "", "sweepLightLoading", "tplse", "", "tplt", "(Lcom/baidu/searchbox/live/goods/detail/interfaces/address/GoodsAddressType;Lcom/baidu/searchbox/live/goods/detail/interfaces/address/GoodsAddressOpenPageName;ZZLjava/lang/String;Ljava/lang/String;)V", "getOpenPageName", "()Lcom/baidu/searchbox/live/goods/detail/interfaces/address/GoodsAddressOpenPageName;", "setOpenPageName", "(Lcom/baidu/searchbox/live/goods/detail/interfaces/address/GoodsAddressOpenPageName;)V", "getSelectAddedAddress", "()Z", "setSelectAddedAddress", "(Z)V", "getSweepLightLoading", "setSweepLightLoading", "getTplse", "()Ljava/lang/String;", "setTplse", "(Ljava/lang/String;)V", "getTplt", "setTplt", "getType", "()Lcom/baidu/searchbox/live/goods/detail/interfaces/address/GoodsAddressType;", "setType", "(Lcom/baidu/searchbox/live/goods/detail/interfaces/address/GoodsAddressType;)V", "lib-goods-detail-interfaces_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: GoodsAddressOpenBean.kt */
public final class GoodsAddressOpenBean {
    private GoodsAddressOpenPageName openPageName;
    private boolean selectAddedAddress;
    private boolean sweepLightLoading;
    private String tplse;
    private String tplt;
    private GoodsAddressType type;

    public final GoodsAddressType getType() {
        return this.type;
    }

    public final void setType(GoodsAddressType goodsAddressType) {
        Intrinsics.checkParameterIsNotNull(goodsAddressType, "<set-?>");
        this.type = goodsAddressType;
    }

    public final GoodsAddressOpenPageName getOpenPageName() {
        return this.openPageName;
    }

    public final void setOpenPageName(GoodsAddressOpenPageName goodsAddressOpenPageName) {
        Intrinsics.checkParameterIsNotNull(goodsAddressOpenPageName, "<set-?>");
        this.openPageName = goodsAddressOpenPageName;
    }

    public final boolean getSelectAddedAddress() {
        return this.selectAddedAddress;
    }

    public final void setSelectAddedAddress(boolean z) {
        this.selectAddedAddress = z;
    }

    public final boolean getSweepLightLoading() {
        return this.sweepLightLoading;
    }

    public final void setSweepLightLoading(boolean z) {
        this.sweepLightLoading = z;
    }

    public final String getTplse() {
        return this.tplse;
    }

    public final void setTplse(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.tplse = str;
    }

    public final String getTplt() {
        return this.tplt;
    }

    public final void setTplt(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.tplt = str;
    }

    public GoodsAddressOpenBean(GoodsAddressType type2, GoodsAddressOpenPageName openPageName2, boolean selectAddedAddress2, boolean sweepLightLoading2, String tplse2, String tplt2) {
        Intrinsics.checkParameterIsNotNull(type2, "type");
        Intrinsics.checkParameterIsNotNull(openPageName2, "openPageName");
        Intrinsics.checkParameterIsNotNull(tplse2, "tplse");
        Intrinsics.checkParameterIsNotNull(tplt2, "tplt");
        this.type = type2;
        this.openPageName = openPageName2;
        this.selectAddedAddress = selectAddedAddress2;
        this.sweepLightLoading = sweepLightLoading2;
        this.tplse = tplse2;
        this.tplt = tplt2;
    }
}
