package com.baidu.wallet.lightapp.base;

import com.baidu.wallet.lightapp.base.datamodel.LocationProvider;

public final class LocationCache {
    public static double a;
    public static double b;
    public static Coord c = Coord.UNKNOWN;
    public static long d = 0;
    public static LocationProvider e = LocationProvider.HOST;

    public enum Coord {
        UNKNOWN(0),
        WGS84(1),
        GCJ02(3),
        BD09LL(5),
        BD09MC(6);
        
        public int value;

        /* access modifiers changed from: public */
        Coord(int i2) {
            this.value = i2;
        }

        public int type() {
            return this.value;
        }
    }

    public static void a(double d2, double d3, Coord coord, LocationProvider locationProvider) {
        a = d2;
        b = d3;
        c = coord;
        d = System.currentTimeMillis();
        e = locationProvider;
    }

    public static double b() {
        return b;
    }

    public static Coord c() {
        return c;
    }

    public static long d() {
        return d;
    }

    public static double a() {
        return a;
    }
}
