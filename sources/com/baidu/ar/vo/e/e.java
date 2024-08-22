package com.baidu.ar.vo.e;

import com.baidu.ar.vo.c.b;

public class e extends a implements c {

    /* renamed from: e  reason: collision with root package name */
    private b f10573e;

    public e(d dVar, b bVar, int i2, int i3) {
        super(dVar, i2, i3);
        this.f10573e = bVar;
    }

    public boolean a(float[] fArr) {
        int i2;
        int i3;
        String[] split = this.f10573e.e().split(",");
        String a2 = this.f10565a.a(this.f10573e);
        int i4 = this.f10566b / 2;
        int i5 = this.f10567c / 2;
        try {
            int[] a3 = this.f10565a.a(Float.parseFloat(split[0].trim()), Float.parseFloat(split[1].trim()));
            i4 = a3[0];
            i2 = a3[1];
            i3 = i4;
        } catch (NumberFormatException e2) {
            com.baidu.ar.p.b.b("model position is not number !!!");
            i3 = i4;
            i2 = i5;
        }
        this.f10565a.a(a2, i3, i2, a.f10564d, (float) this.f10573e.a());
        return true;
    }
}
