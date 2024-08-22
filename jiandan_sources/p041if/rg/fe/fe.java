package p041if.rg.fe;

import kotlin.collections.builders.MapBuilder;
import p041if.rg.fe.i.uk;

/* renamed from: if.rg.fe.fe  reason: invalid package */
public final class fe<T> {

    /* renamed from: ad  reason: collision with root package name */
    public int f11204ad;

    /* renamed from: de  reason: collision with root package name */
    public int f11205de;

    /* renamed from: fe  reason: collision with root package name */
    public int f11206fe;
    public final float qw;

    /* renamed from: rg  reason: collision with root package name */
    public T[] f11207rg;

    public fe() {
        this(16, 0.75f);
    }

    public static int de(int i2) {
        int i3 = i2 * MapBuilder.MAGIC;
        return i3 ^ (i3 >>> 16);
    }

    public boolean ad() {
        return this.f11205de == 0;
    }

    public void fe() {
        T[] tArr = this.f11207rg;
        int length = tArr.length;
        int i2 = length << 1;
        int i3 = i2 - 1;
        T[] tArr2 = new Object[i2];
        int i4 = this.f11205de;
        while (true) {
            int i5 = i4 - 1;
            if (i4 != 0) {
                do {
                    length--;
                } while (tArr[length] == null);
                int de2 = de(tArr[length].hashCode()) & i3;
                if (tArr2[de2] != null) {
                    do {
                        de2 = (de2 + 1) & i3;
                    } while (tArr2[de2] != null);
                }
                tArr2[de2] = tArr[length];
                i4 = i5;
            } else {
                this.f11204ad = i3;
                this.f11206fe = (int) (((float) i2) * this.qw);
                this.f11207rg = tArr2;
                return;
            }
        }
    }

    public boolean qw(T t) {
        T t2;
        T[] tArr = this.f11207rg;
        int i2 = this.f11204ad;
        int de2 = de(t.hashCode()) & i2;
        T t3 = tArr[de2];
        if (t3 != null) {
            if (t3.equals(t)) {
                return false;
            }
            do {
                de2 = (de2 + 1) & i2;
                t2 = tArr[de2];
                if (t2 == null) {
                }
            } while (!t2.equals(t));
            return false;
        }
        tArr[de2] = t;
        int i3 = this.f11205de + 1;
        this.f11205de = i3;
        if (i3 >= this.f11206fe) {
            fe();
        }
        return true;
    }

    public boolean rg(T t) {
        T t2;
        T[] tArr = this.f11207rg;
        int i2 = this.f11204ad;
        int de2 = de(t.hashCode()) & i2;
        T t3 = tArr[de2];
        if (t3 == null) {
            return false;
        }
        if (t3.equals(t)) {
            return th(de2, tArr, i2);
        }
        do {
            de2 = (de2 + 1) & i2;
            t2 = tArr[de2];
            if (t2 == null) {
                return false;
            }
        } while (!t2.equals(t));
        return th(de2, tArr, i2);
    }

    public boolean th(int i2, T[] tArr, int i3) {
        int i4;
        T t;
        this.f11205de--;
        while (true) {
            int i5 = i2 + 1;
            while (true) {
                i4 = i5 & i3;
                t = tArr[i4];
                if (t == null) {
                    tArr[i2] = null;
                    return true;
                }
                int de2 = de(t.hashCode()) & i3;
                if (i2 <= i4) {
                    if (i2 >= de2 || de2 > i4) {
                        break;
                    }
                    i5 = i4 + 1;
                } else {
                    if (i2 >= de2 && de2 > i4) {
                        break;
                    }
                    i5 = i4 + 1;
                }
            }
            tArr[i2] = t;
            i2 = i4;
        }
    }

    public T[] uk() {
        return this.f11207rg;
    }

    public void yj() {
        this.f11205de = 0;
        this.f11207rg = new Object[0];
    }

    public fe(int i2, float f) {
        this.qw = f;
        int qw2 = uk.qw(i2);
        this.f11204ad = qw2 - 1;
        this.f11206fe = (int) (f * ((float) qw2));
        this.f11207rg = new Object[qw2];
    }
}
