package fe.when.ad.f;

import java.util.Arrays;

public class aaa implements Cloneable {

    /* renamed from: ad  reason: collision with root package name */
    public transient qw[] f9352ad;

    /* renamed from: th  reason: collision with root package name */
    public transient int f9353th;

    /* renamed from: uk  reason: collision with root package name */
    public float f9354uk;

    /* renamed from: yj  reason: collision with root package name */
    public int f9355yj;

    public static class qw {

        /* renamed from: ad  reason: collision with root package name */
        public int f9356ad;

        /* renamed from: de  reason: collision with root package name */
        public int f9357de;

        /* renamed from: fe  reason: collision with root package name */
        public qw f9358fe;
        public int qw;

        public qw(int i2, int i3, int i4, qw qwVar) {
            this.qw = i2;
            this.f9356ad = i3;
            this.f9357de = i4;
            this.f9358fe = qwVar;
        }

        public Object clone() {
            int i2 = this.qw;
            int i3 = this.f9356ad;
            int i4 = this.f9357de;
            qw qwVar = this.f9358fe;
            return new qw(i2, i3, i4, qwVar != null ? (qw) qwVar.clone() : null);
        }
    }

    public aaa() {
        this(150, 0.75f);
    }

    public boolean ad(int i2) {
        qw[] qwVarArr = this.f9352ad;
        for (qw qwVar = qwVarArr[(Integer.MAX_VALUE & i2) % qwVarArr.length]; qwVar != null; qwVar = qwVar.f9358fe) {
            if (qwVar.qw == i2 && qwVar.f9356ad == i2) {
                return true;
            }
        }
        return false;
    }

    public Object clone() {
        try {
            aaa aaa = (aaa) super.clone();
            aaa.f9352ad = new qw[this.f9352ad.length];
            int length = this.f9352ad.length;
            while (true) {
                int i2 = length - 1;
                if (length <= 0) {
                    return aaa;
                }
                aaa.f9352ad[i2] = this.f9352ad[i2] != null ? (qw) this.f9352ad[i2].clone() : null;
                length = i2;
            }
        } catch (CloneNotSupportedException unused) {
            throw new InternalError();
        }
    }

    public int de(int i2) {
        qw[] qwVarArr = this.f9352ad;
        for (qw qwVar = qwVarArr[(Integer.MAX_VALUE & i2) % qwVarArr.length]; qwVar != null; qwVar = qwVar.f9358fe) {
            if (qwVar.qw == i2 && qwVar.f9356ad == i2) {
                return qwVar.f9357de;
            }
        }
        return 0;
    }

    public int[] fe() {
        int i2;
        int[] iArr = new int[this.f9353th];
        int length = this.f9352ad.length;
        int i3 = 0;
        qw qwVar = null;
        while (true) {
            if (qwVar == null) {
                while (true) {
                    i2 = length - 1;
                    if (length <= 0 || (qwVar = this.f9352ad[i2]) != null) {
                        length = i2;
                    } else {
                        length = i2;
                    }
                }
                length = i2;
            }
            if (qwVar == null) {
                return iArr;
            }
            qw qwVar2 = qwVar.f9358fe;
            iArr[i3] = qwVar.f9356ad;
            qwVar = qwVar2;
            i3++;
        }
    }

    public int rg(int i2, int i3) {
        qw[] qwVarArr = this.f9352ad;
        int i4 = Integer.MAX_VALUE & i2;
        int length = i4 % qwVarArr.length;
        for (qw qwVar = qwVarArr[length]; qwVar != null; qwVar = qwVar.f9358fe) {
            if (qwVar.qw == i2 && qwVar.f9356ad == i2) {
                int i5 = qwVar.f9357de;
                qwVar.f9357de = i3;
                return i5;
            }
        }
        if (this.f9353th >= this.f9355yj) {
            th();
            qwVarArr = this.f9352ad;
            length = i4 % qwVarArr.length;
        }
        qwVarArr[length] = new qw(i2, i2, i3, qwVarArr[length]);
        this.f9353th++;
        return 0;
    }

    public void th() {
        qw[] qwVarArr = this.f9352ad;
        int length = qwVarArr.length;
        int i2 = (length * 2) + 1;
        qw[] qwVarArr2 = new qw[i2];
        this.f9355yj = (int) (((float) i2) * this.f9354uk);
        this.f9352ad = qwVarArr2;
        while (true) {
            int i3 = length - 1;
            if (length > 0) {
                qw qwVar = qwVarArr[i3];
                while (qwVar != null) {
                    qw qwVar2 = qwVar.f9358fe;
                    int i4 = (qwVar.qw & Integer.MAX_VALUE) % i2;
                    qwVar.f9358fe = qwVarArr2[i4];
                    qwVarArr2[i4] = qwVar;
                    qwVar = qwVar2;
                }
                length = i3;
            } else {
                return;
            }
        }
    }

    public int[] uk() {
        int[] fe2 = fe();
        Arrays.sort(fe2);
        return fe2;
    }

    public int yj() {
        return this.f9353th;
    }

    public aaa(int i2) {
        this(i2, 0.75f);
    }

    public aaa(int i2, float f) {
        if (i2 < 0) {
            throw new IllegalArgumentException(fe.when.ad.c.qw.qw("illegal.capacity.1", i2));
        } else if (f > 0.0f) {
            i2 = i2 == 0 ? 1 : i2;
            this.f9354uk = f;
            this.f9352ad = new qw[i2];
            this.f9355yj = (int) (((float) i2) * f);
        } else {
            throw new IllegalArgumentException(fe.when.ad.c.qw.ad("illegal.load.1", String.valueOf(f)));
        }
    }
}
