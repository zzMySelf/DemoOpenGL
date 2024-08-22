package com.itextpdf.text.pdf;

import com.itextpdf.text.exceptions.UnsupportedPdfException;
import fe.when.ad.f.l;
import fe.when.ad.f.m1;
import fe.when.ad.f.s0;
import fe.when.ad.f.v0;
import fe.when.ad.f.x;
import fe.when.ad.f.y0;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class FilterHandlers {
    public static final Map<s0, FilterHandler> qw;

    public interface FilterHandler {
        byte[] qw(byte[] bArr, s0 s0Var, y0 y0Var, x xVar) throws IOException;
    }

    public static class ad implements FilterHandler {
        public ad() {
        }

        public byte[] qw(byte[] bArr, s0 s0Var, y0 y0Var, x xVar) throws IOException {
            return m1.qw(bArr);
        }
    }

    public static class de implements FilterHandler {
        public de() {
        }

        public byte[] qw(byte[] bArr, s0 s0Var, y0 y0Var, x xVar) throws IOException {
            return m1.ad(bArr);
        }
    }

    public static class fe implements FilterHandler {
        public fe() {
        }

        public byte[] qw(byte[] bArr, s0 s0Var, y0 y0Var, x xVar) throws IOException {
            int i2;
            boolean z;
            boolean z2;
            v0 v0Var = (v0) m1.ddd(xVar.qqq(s0.l6));
            v0 v0Var2 = (v0) m1.ddd(xVar.qqq(s0.Q1));
            if (v0Var == null || v0Var2 == null) {
                throw new UnsupportedPdfException(fe.when.ad.c.qw.ad("filter.ccittfaxdecode.is.only.supported.for.images", new Object[0]));
            }
            int eee = v0Var.eee();
            int eee2 = v0Var2.eee();
            x xVar2 = y0Var instanceof x ? (x) y0Var : null;
            if (xVar2 != null) {
                v0 b = xVar2.b(s0.s2);
                i2 = b != null ? b.eee() : 0;
                l rrr = xVar2.rrr(s0.r);
                boolean aaa = rrr != null ? rrr.aaa() : false;
                l rrr2 = xVar2.rrr(s0.O0);
                if (rrr2 != null) {
                    z = rrr2.aaa();
                    z2 = aaa;
                } else {
                    z2 = aaa;
                    z = false;
                }
            } else {
                z = false;
                i2 = 0;
                z2 = false;
            }
            int i3 = ((eee + 7) / 8) * eee2;
            byte[] bArr2 = new byte[i3];
            fe.when.ad.f.n2.uk ukVar = new fe.when.ad.f.n2.uk();
            if (i2 == 0 || i2 > 0) {
                int i4 = (z ? 4 : 0) | (i2 > 0 ? 1 : 0);
                ukVar.qw(1, 3, i4, 0);
                ukVar.rg(bArr2, bArr, eee, eee2);
                int i5 = ukVar.f9652fe;
                if (i5 > 0) {
                    byte[] bArr3 = new byte[i3];
                    ukVar.qw(1, 2, i4, 0);
                    ukVar.rg(bArr3, bArr, eee, eee2);
                    if (ukVar.f9652fe < i5) {
                        bArr2 = bArr3;
                    }
                }
            } else {
                new fe.when.ad.f.n2.yj(1, eee, eee2).th(bArr2, bArr, 0, eee2, 0);
            }
            if (!z2) {
                int length = bArr2.length;
                for (int i6 = 0; i6 < length; i6++) {
                    bArr2[i6] = (byte) (bArr2[i6] ^ 255);
                }
            }
            return bArr2;
        }
    }

    public static class rg implements FilterHandler {
        public rg() {
        }

        public byte[] qw(byte[] bArr, s0 s0Var, y0 y0Var, x xVar) throws IOException {
            return bArr;
        }
    }

    public static class th implements FilterHandler {
        public th() {
        }

        public byte[] qw(byte[] bArr, s0 s0Var, y0 y0Var, x xVar) throws IOException {
            return m1.i(m1.de(bArr), y0Var);
        }
    }

    public static class uk implements FilterHandler {
        public uk() {
        }

        public byte[] qw(byte[] bArr, s0 s0Var, y0 y0Var, x xVar) throws IOException {
            byte b;
            int i2;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            int i3 = 0;
            while (i3 < bArr.length && (b = bArr[i3]) != Byte.MIN_VALUE) {
                if (b < 0 || b > Byte.MAX_VALUE) {
                    i2 = i3 + 1;
                    for (int i4 = 0; i4 < 1 - b; i4++) {
                        byteArrayOutputStream.write(bArr[i2]);
                    }
                } else {
                    int i5 = b + 1;
                    byteArrayOutputStream.write(bArr, i3, i5);
                    i2 = i3 + i5;
                }
                i3 = i2 + 1;
            }
            return byteArrayOutputStream.toByteArray();
        }
    }

    public static class yj implements FilterHandler {
        public yj() {
        }

        public byte[] qw(byte[] bArr, s0 s0Var, y0 y0Var, x xVar) throws IOException {
            return m1.i(m1.rg(bArr), y0Var);
        }
    }

    static {
        HashMap hashMap = new HashMap();
        hashMap.put(s0.p1, new th());
        hashMap.put(s0.n1, new th());
        hashMap.put(s0.g, new de());
        hashMap.put(s0.ppp, new de());
        hashMap.put(s0.f, new ad());
        hashMap.put(s0.f9758o, new ad());
        hashMap.put(s0.Q2, new yj());
        hashMap.put(s0.G, new fe());
        hashMap.put(s0.i0, new rg());
        hashMap.put(s0.C4, new uk());
        qw = Collections.unmodifiableMap(hashMap);
    }

    public static Map<s0, FilterHandler> qw() {
        return qw;
    }
}
