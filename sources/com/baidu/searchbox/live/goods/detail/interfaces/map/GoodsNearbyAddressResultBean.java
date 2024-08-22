package com.baidu.searchbox.live.goods.detail.interfaces.map;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0015\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\bR\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0006\"\u0004\b\u001b\u0010\bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0006\"\u0004\b\u001e\u0010\bR\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0006\"\u0004\b!\u0010\b¨\u0006\""}, d2 = {"Lcom/baidu/searchbox/live/goods/detail/interfaces/map/GoodsNearbyAddressResultBean;", "", "()V", "address", "", "getAddress", "()Ljava/lang/String;", "setAddress", "(Ljava/lang/String;)V", "cityName", "getCityName", "setCityName", "distance", "", "getDistance", "()Ljava/lang/Integer;", "setDistance", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "districtName", "getDistrictName", "setDistrictName", "name", "getName", "setName", "provinceName", "getProvinceName", "setProvinceName", "townName", "getTownName", "setTownName", "uid", "getUid", "setUid", "lib-goods-detail-interfaces_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: GoodsNearbyAddressResultBean.kt */
public final class GoodsNearbyAddressResultBean {
    private String address = "";
    private String cityName = "";
    private Integer distance = 0;
    private String districtName = "";
    private String name = "";
    private String provinceName = "";
    private String townName = "";
    private String uid = "";

    public final String getUid() {
        return this.uid;
    }

    public final void setUid(String str) {
        this.uid = str;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final String getAddress() {
        return this.address;
    }

    public final void setAddress(String str) {
        this.address = str;
    }

    public final Integer getDistance() {
        return this.distance;
    }

    public final void setDistance(Integer num) {
        this.distance = num;
    }

    public final String getProvinceName() {
        return this.provinceName;
    }

    public final void setProvinceName(String str) {
        this.provinceName = str;
    }

    public final String getCityName() {
        return this.cityName;
    }

    public final void setCityName(String str) {
        this.cityName = str;
    }

    public final String getDistrictName() {
        return this.districtName;
    }

    public final void setDistrictName(String str) {
        this.districtName = str;
    }

    public final String getTownName() {
        return this.townName;
    }

    public final void setTownName(String str) {
        this.townName = str;
    }
}
