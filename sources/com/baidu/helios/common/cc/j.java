package com.baidu.helios.common.cc;

import net.lingala.zip4j.util.InternalZipConstants;

final class j extends h {

    /* renamed from: g  reason: collision with root package name */
    public static final int f13109g = 0;

    public j(int i2, int i3) {
        this.f13099b = InternalZipConstants.ZIP_64_SIZE_LIMIT;
        this.f13100c = 4;
        this.f13101d = 32;
        this.f13102e = i2;
        this.f13103f = i3;
    }

    public a a(byte[] bArr, int i2, int i3) {
        k kVar = new k();
        kVar.a(bArr, i2, i3);
        return a.a(new long[]{kVar.b()});
    }
}
