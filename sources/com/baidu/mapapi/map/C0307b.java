package com.baidu.mapapi.map;

import com.baidu.mapapi.map.InfoWindow;

/* renamed from: com.baidu.mapapi.map.b  reason: case insensitive filesystem */
class C0307b implements InfoWindow.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ BaiduMap f14401a;

    C0307b(BaiduMap baiduMap) {
        this.f14401a = baiduMap;
    }

    public void a(InfoWindow infoWindow) {
        this.f14401a.hideInfoWindow(infoWindow);
    }

    public void b(InfoWindow infoWindow) {
        this.f14401a.a(infoWindow);
    }
}
