package com.baidu.mapapi.map;

import com.baidu.mapsdkplatform.comapi.map.o;

public final class UiSettings {

    /* renamed from: a  reason: collision with root package name */
    private o f14384a;

    UiSettings(o oVar) {
        this.f14384a = oVar;
    }

    public boolean isCompassEnabled() {
        return this.f14384a.I();
    }

    public boolean isOverlookingGesturesEnabled() {
        return this.f14384a.Q();
    }

    public boolean isRotateGesturesEnabled() {
        return this.f14384a.P();
    }

    public boolean isScrollGesturesEnabled() {
        return this.f14384a.N();
    }

    public boolean isZoomGesturesEnabled() {
        return this.f14384a.O();
    }

    public void setAllGesturesEnabled(boolean z) {
        setRotateGesturesEnabled(z);
        setScrollGesturesEnabled(z);
        setOverlookingGesturesEnabled(z);
        setZoomGesturesEnabled(z);
    }

    public void setCompassEnabled(boolean z) {
        this.f14384a.k(z);
    }

    public void setEnlargeCenterWithDoubleClickEnable(boolean z) {
        this.f14384a.s(z);
    }

    public void setOverlookingGesturesEnabled(boolean z) {
        this.f14384a.u(z);
    }

    public void setRotateGesturesEnabled(boolean z) {
        this.f14384a.t(z);
    }

    public void setScrollGesturesEnabled(boolean z) {
        this.f14384a.q(z);
    }

    public void setZoomGesturesEnabled(boolean z) {
        this.f14384a.r(z);
    }
}
