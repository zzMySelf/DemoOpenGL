package com.alipay.sdk.m.l0;

public class e {

    public static class b {
        public int[] a;
        public int b;
        public int c;

        public b() {
            this.a = new int[256];
        }
    }

    public static byte[] a(byte[] bArr) {
        b a2;
        if (bArr == null || (a2 = a("QrMgt8GGYI6T52ZY5AnhtxkLzb8egpFn3j5JELI8H6wtACbUnZ5cc3aYTsTRbmkAkRJeYbtx92LPBWm7nBO9UIl7y5i5MQNmUZNf5QENurR5tGyo7yJ2G0MBjWvy6iAtlAbacKP0SwOUeUWx5dsBdyhxa7Id1APtybSdDgicBDuNjI0mlZFUzZSS9dmN8lBD0WTVOMz0pRZbR3cysomRXOO1ghqjJdTcyDIxzpNAEszN8RMGjrzyU7Hjbmwi6YNK")) == null) {
            return null;
        }
        return a(bArr, a2);
    }

    public static b a(String str) {
        if (str == null) {
            return null;
        }
        b bVar = new b();
        int i2 = 0;
        for (int i3 = 0; i3 < 256; i3++) {
            bVar.a[i3] = i3;
        }
        bVar.b = 0;
        bVar.c = 0;
        int i4 = 0;
        int i5 = 0;
        while (i2 < 256) {
            try {
                i5 = ((str.charAt(i4) + bVar.a[i2]) + i5) % 256;
                int i6 = bVar.a[i2];
                bVar.a[i2] = bVar.a[i5];
                bVar.a[i5] = i6;
                i4 = (i4 + 1) % str.length();
                i2++;
            } catch (Exception unused) {
                return null;
            }
        }
        return bVar;
    }

    public static byte[] a(byte[] bArr, b bVar) {
        if (bArr == null || bVar == null) {
            return null;
        }
        int i2 = bVar.b;
        int i3 = bVar.c;
        for (int i4 = 0; i4 < bArr.length; i4++) {
            i2 = (i2 + 1) % 256;
            int[] iArr = bVar.a;
            i3 = (iArr[i2] + i3) % 256;
            int i5 = iArr[i2];
            iArr[i2] = iArr[i3];
            iArr[i3] = i5;
            bArr[i4] = (byte) (iArr[(iArr[i2] + iArr[i3]) % 256] ^ bArr[i4]);
        }
        bVar.b = i2;
        bVar.c = i3;
        return bArr;
    }
}
