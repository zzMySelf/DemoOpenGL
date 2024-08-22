package com.baidu.mapapi.walknavi.controllers.a;

import b.a.a.a.c.k.c;
import com.baidu.mapapi.walknavi.adapter.IWRoutePlanListener;
import com.baidu.mapapi.walknavi.model.WalkRoutePlanError;

/* compiled from: WalkNaviManager */
class b implements c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ IWRoutePlanListener f14746a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ e f14747b;

    b(e eVar, IWRoutePlanListener iWRoutePlanListener) {
        this.f14747b = eVar;
        this.f14746a = iWRoutePlanListener;
    }

    public void a(int i2) {
        if (i2 == 16777214) {
            this.f14746a.onRoutePlanFail(WalkRoutePlanError.FORWARD_AK_ERROR);
        } else if (i2 == 16777216) {
            this.f14746a.onRoutePlanFail(WalkRoutePlanError.SERVER_UNUSUAL);
        } else if (i2 != 805306368) {
            this.f14746a.onRoutePlanFail(WalkRoutePlanError.PARSE_FAIL);
        } else {
            this.f14746a.onRoutePlanFail(WalkRoutePlanError.NET_ERR);
        }
    }

    public void onRoutePlanStart() {
        this.f14746a.onRoutePlanStart();
    }

    public void onRoutePlanSuccess() {
        this.f14746a.onRoutePlanSuccess();
    }
}
