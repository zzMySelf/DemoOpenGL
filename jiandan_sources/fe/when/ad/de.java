package fe.when.ad;

import fe.when.ad.c.qw;

public class de {

    /* renamed from: ad  reason: collision with root package name */
    public static final de f9335ad = new de(255, 255, 255);

    /* renamed from: de  reason: collision with root package name */
    public static final de f9336de = new de(0, 0, 0);
    public int qw;

    static {
        new de(192, 192, 192);
        new de(128, 128, 128);
        new de(64, 64, 64);
        new de(255, 0, 0);
        new de(255, 175, 175);
        new de(255, 200, 0);
        new de(255, 255, 0);
        new de(0, 255, 0);
        new de(255, 0, 255);
        new de(0, 255, 255);
        new de(0, 0, 255);
    }

    public de(int i2, int i3, int i4, int i5) {
        rg(i2, i3, i4, i5);
    }

    public static void th(int i2) {
        if (i2 < 0 || i2 > 255) {
            throw new IllegalArgumentException(qw.ad("color.value.outside.range.0.255", new Object[0]));
        }
    }

    public int ad() {
        return (de() >> 8) & 255;
    }

    public int de() {
        return this.qw;
    }

    public boolean equals(Object obj) {
        return (obj instanceof de) && ((de) obj).qw == this.qw;
    }

    public int fe() {
        return (de() >> 16) & 255;
    }

    public int hashCode() {
        return this.qw;
    }

    public int qw() {
        return (de() >> 0) & 255;
    }

    public void rg(int i2, int i3, int i4, int i5) {
        th(i2);
        th(i3);
        th(i4);
        th(i5);
        this.qw = ((i2 & 255) << 16) | ((i5 & 255) << 24) | ((i3 & 255) << 8) | ((i4 & 255) << 0);
    }

    public String toString() {
        return "Color value[" + Integer.toString(this.qw, 16) + "]";
    }

    public de(int i2, int i3, int i4) {
        this(i2, i3, i4, 255);
    }

    public de(float f, float f2, float f3, float f4) {
        this((int) (((double) (f * 255.0f)) + 0.5d), (int) (((double) (f2 * 255.0f)) + 0.5d), (int) (((double) (f3 * 255.0f)) + 0.5d), (int) (((double) (f4 * 255.0f)) + 0.5d));
    }

    public de(float f, float f2, float f3) {
        this(f, f2, f3, 1.0f);
    }
}
