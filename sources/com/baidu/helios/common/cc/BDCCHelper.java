package com.baidu.helios.common.cc;

import java.util.Arrays;

public class BDCCHelper {

    /* renamed from: b  reason: collision with root package name */
    private static final boolean f13065b = false;

    /* renamed from: c  reason: collision with root package name */
    private static final boolean f13066c = false;

    /* renamed from: a  reason: collision with root package name */
    h[] f13067a = {new i(8, 0), new j(0, 1), new j(1, 1), new i(7, 1)};

    public byte[] calculate(byte[] bArr) {
        g gVar = new g();
        byte[] a2 = d.a(bArr, bArr.length + ((this.f13067a.length + 1) * g.f13093c));
        d.a(a2, gVar.b(), bArr.length);
        int i2 = 0;
        while (true) {
            h[] hVarArr = this.f13067a;
            if (i2 >= hVarArr.length) {
                return Arrays.copyOf(gVar.b(), g.f13093c);
            }
            h hVar = hVarArr[i2];
            i2++;
            int length = bArr.length + (g.f13093c * i2);
            gVar.a(hVar.a(a2, 0, length), hVar.a(), hVar.b(), hVar.c());
            d.a(a2, gVar.b(), length);
        }
    }
}
