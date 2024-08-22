package com.baidu.mapapi.favorite;

import com.baidu.mapapi.model.LatLng;

public class FavoritePoiInfo {

    /* renamed from: a  reason: collision with root package name */
    String f14051a;

    /* renamed from: b  reason: collision with root package name */
    String f14052b;

    /* renamed from: c  reason: collision with root package name */
    LatLng f14053c;

    /* renamed from: d  reason: collision with root package name */
    String f14054d;

    /* renamed from: e  reason: collision with root package name */
    String f14055e;

    /* renamed from: f  reason: collision with root package name */
    String f14056f;

    /* renamed from: g  reason: collision with root package name */
    long f14057g;

    public FavoritePoiInfo addr(String str) {
        this.f14054d = str;
        return this;
    }

    public FavoritePoiInfo cityName(String str) {
        this.f14055e = str;
        return this;
    }

    public String getAddr() {
        return this.f14054d;
    }

    public String getCityName() {
        return this.f14055e;
    }

    public String getID() {
        return this.f14051a;
    }

    public String getPoiName() {
        return this.f14052b;
    }

    public LatLng getPt() {
        return this.f14053c;
    }

    public long getTimeStamp() {
        return this.f14057g;
    }

    public String getUid() {
        return this.f14056f;
    }

    public FavoritePoiInfo poiName(String str) {
        this.f14052b = str;
        return this;
    }

    public FavoritePoiInfo pt(LatLng latLng) {
        this.f14053c = latLng;
        return this;
    }

    public FavoritePoiInfo uid(String str) {
        this.f14056f = str;
        return this;
    }
}
