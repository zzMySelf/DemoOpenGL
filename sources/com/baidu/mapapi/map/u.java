package com.baidu.mapapi.map;

import android.view.View;
import com.baidu.mapsdkplatform.comapi.map.C0310a;

class u implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TextureMapView f14431a;

    u(TextureMapView textureMapView) {
        this.f14431a = textureMapView;
    }

    public void onClick(View view2) {
        float f2 = this.f14431a.f14359e.b().f15019h;
        C0310a e2 = this.f14431a.f14359e.b().e();
        e2.f14965a -= 1.0f;
        float f3 = e2.f14965a;
        if (f3 >= f2) {
            f2 = f3;
        }
        e2.f14965a = f2;
        BaiduMap.mapStatusReason |= 16;
        this.f14431a.f14359e.b().a(e2, 300);
    }
}
