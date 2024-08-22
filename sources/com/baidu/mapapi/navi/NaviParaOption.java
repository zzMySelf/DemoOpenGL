package com.baidu.mapapi.navi;

import com.baidu.mapapi.model.LatLng;

public class NaviParaOption {

    /* renamed from: a  reason: collision with root package name */
    LatLng f14456a;

    /* renamed from: b  reason: collision with root package name */
    String f14457b;

    /* renamed from: c  reason: collision with root package name */
    LatLng f14458c;

    /* renamed from: d  reason: collision with root package name */
    String f14459d;

    public NaviParaOption endName(String str) {
        this.f14459d = str;
        return this;
    }

    public NaviParaOption endPoint(LatLng latLng) {
        this.f14458c = latLng;
        return this;
    }

    public String getEndName() {
        return this.f14459d;
    }

    public LatLng getEndPoint() {
        return this.f14458c;
    }

    public String getStartName() {
        return this.f14457b;
    }

    public LatLng getStartPoint() {
        return this.f14456a;
    }

    public NaviParaOption startName(String str) {
        this.f14457b = str;
        return this;
    }

    public NaviParaOption startPoint(LatLng latLng) {
        this.f14456a = latLng;
        return this;
    }
}
