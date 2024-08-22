package fe.fe.uk;

public class qw {

    /* renamed from: ad  reason: collision with root package name */
    public int f3156ad;

    /* renamed from: de  reason: collision with root package name */
    public int f3157de;

    /* renamed from: fe  reason: collision with root package name */
    public byte[] f3158fe;
    public byte[] qw;

    public qw(String str) {
        this.f3158fe = str.getBytes();
    }

    public byte[] ad(byte[] bArr) {
        fe();
        byte[] bArr2 = new byte[bArr.length];
        de(bArr, 0, bArr.length, bArr2, 0);
        return bArr2;
    }

    public final void de(byte[] bArr, int i2, int i3, byte[] bArr2, int i4) {
        int i5 = i2 + i3;
        if (i5 > bArr.length) {
            "input buffer too short, buffer length=" + bArr.length + ", input length=" + i5;
        } else if (i4 + i3 > bArr2.length) {
            "output buffer too short, buffer length=" + bArr.length + ", output length=" + i5;
        } else {
            for (int i6 = 0; i6 < i3; i6++) {
                int i7 = (this.f3156ad + 1) & 255;
                this.f3156ad = i7;
                byte[] bArr3 = this.qw;
                int i8 = (bArr3[i7] + this.f3157de) & 255;
                this.f3157de = i8;
                byte b = bArr3[i7];
                bArr3[i7] = bArr3[i8];
                bArr3[i8] = b;
                bArr2[i6 + i4] = (byte) (bArr3[(bArr3[i7] + bArr3[i8]) & 255] ^ bArr[i6 + i2]);
            }
        }
    }

    public final void fe() {
        rg(this.f3158fe);
    }

    public byte[] qw(byte[] bArr) {
        fe();
        byte[] bArr2 = new byte[bArr.length];
        de(bArr, 0, bArr.length, bArr2, 0);
        return bArr2;
    }

    public final void rg(byte[] bArr) {
        this.f3156ad = 0;
        this.f3157de = 0;
        if (this.qw == null) {
            this.qw = new byte[256];
        }
        for (int i2 = 0; i2 < 256; i2++) {
            this.qw[i2] = (byte) i2;
        }
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < 256; i5++) {
            byte[] bArr2 = this.qw;
            i4 = ((bArr[i3] & 255) + bArr2[i5] + i4) & 255;
            byte b = bArr2[i5];
            bArr2[i5] = bArr2[i4];
            bArr2[i4] = b;
            i3 = (i3 + 1) % bArr.length;
        }
    }
}
