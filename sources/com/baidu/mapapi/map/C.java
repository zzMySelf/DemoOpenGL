package com.baidu.mapapi.map;

import android.graphics.Point;

class C {

    /* renamed from: a  reason: collision with root package name */
    public final double f14112a;

    /* renamed from: b  reason: collision with root package name */
    public final double f14113b;

    /* renamed from: c  reason: collision with root package name */
    public final double f14114c;

    /* renamed from: d  reason: collision with root package name */
    public final double f14115d;

    /* renamed from: e  reason: collision with root package name */
    public final double f14116e;

    /* renamed from: f  reason: collision with root package name */
    public final double f14117f;

    public C(double d2, double d3, double d4, double d5) {
        this.f14112a = d2;
        this.f14113b = d4;
        this.f14114c = d3;
        this.f14115d = d5;
        this.f14116e = (d2 + d3) / 2.0d;
        this.f14117f = (d4 + d5) / 2.0d;
    }

    public boolean a(double d2, double d3) {
        return this.f14112a <= d2 && d2 <= this.f14114c && this.f14113b <= d3 && d3 <= this.f14115d;
    }

    public boolean a(double d2, double d3, double d4, double d5) {
        return d2 < this.f14114c && this.f14112a < d3 && d4 < this.f14115d && this.f14113b < d5;
    }

    public boolean a(Point point) {
        return a((double) point.x, (double) point.y);
    }

    public boolean a(C c2) {
        return a(c2.f14112a, c2.f14114c, c2.f14113b, c2.f14115d);
    }

    public boolean b(C c2) {
        return c2.f14112a >= this.f14112a && c2.f14114c <= this.f14114c && c2.f14113b >= this.f14113b && c2.f14115d <= this.f14115d;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("minX: " + this.f14112a);
        sb.append(" minY: " + this.f14113b);
        sb.append(" maxX: " + this.f14114c);
        sb.append(" maxY: " + this.f14115d);
        sb.append(" midX: " + this.f14116e);
        sb.append(" midY: " + this.f14117f);
        return sb.toString();
    }
}
