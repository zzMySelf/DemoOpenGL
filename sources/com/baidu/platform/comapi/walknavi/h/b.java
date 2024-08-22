package com.baidu.platform.comapi.walknavi.h;

import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapBaseIndoorMapInfo;

/* compiled from: WalkUIController */
class b implements BaiduMap.OnBaseIndoorMapListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ u f16450a;

    b(u uVar) {
        this.f16450a = uVar;
    }

    public void onBaseIndoorMapMode(boolean z, MapBaseIndoorMapInfo mapBaseIndoorMapInfo) {
        if (!z || mapBaseIndoorMapInfo == null) {
            this.f16450a.C.a();
        } else if (b.a.a.a.c.b.b().f()) {
            this.f16450a.C.a(mapBaseIndoorMapInfo);
        }
    }
}
