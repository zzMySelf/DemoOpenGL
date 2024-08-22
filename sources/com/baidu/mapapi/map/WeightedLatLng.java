package com.baidu.mapapi.map;

import android.graphics.Point;
import com.baidu.mapapi.map.D;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.inner.GeoPoint;

public class WeightedLatLng extends D.a {
    public static final double DEFAULT_INTENSITY = 1.0d;

    /* renamed from: a  reason: collision with root package name */
    private Point f14399a;
    public final double intensity;
    public final LatLng latLng;

    public WeightedLatLng(LatLng latLng2) {
        this(latLng2, 1.0d);
    }

    public WeightedLatLng(LatLng latLng2, double d2) {
        if (latLng2 != null) {
            this.latLng = latLng2;
            GeoPoint ll2mc = CoordUtil.ll2mc(latLng2);
            this.f14399a = new Point((int) ll2mc.getLongitudeE6(), (int) ll2mc.getLatitudeE6());
            if (d2 > 0.0d) {
                this.intensity = d2;
            } else {
                this.intensity = 1.0d;
            }
        } else {
            throw new IllegalArgumentException("BDMapSDKException: latLng can not be null");
        }
    }

    /* access modifiers changed from: package-private */
    public Point a() {
        return this.f14399a;
    }
}
