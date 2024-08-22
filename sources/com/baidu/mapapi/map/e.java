package com.baidu.mapapi.map;

import android.content.Context;
import android.os.Bundle;
import com.baidu.mapsdkplatform.comapi.map.C0317h;

class e implements C0317h {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ BaiduMap f14404a;

    e(BaiduMap baiduMap) {
        this.f14404a = baiduMap;
    }

    public Bundle a(int i2, int i3, int i4, Context context) {
        Tile a2;
        this.f14404a.F.lock();
        try {
            if (this.f14404a.C != null && (a2 = this.f14404a.C.a(i2, i3, i4)) != null) {
                return a2.toBundle();
            }
            this.f14404a.F.unlock();
            return null;
        } finally {
            this.f14404a.F.unlock();
        }
    }
}
