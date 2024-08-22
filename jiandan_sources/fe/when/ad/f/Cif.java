package fe.when.ad.f;

import com.itextpdf.text.SplitCharacter;

/* renamed from: fe.when.ad.f.if  reason: invalid class name */
public class Cif implements SplitCharacter {

    /* renamed from: ad  reason: collision with root package name */
    public static final SplitCharacter f9498ad = new Cif();
    public char[] qw;

    public char ad(int i2, char[] cArr, n[] nVarArr) {
        if (nVarArr == null) {
            return cArr[i2];
        }
        return (char) nVarArr[Math.min(i2, nVarArr.length - 1)].vvv(cArr[i2]);
    }

    public boolean qw(int i2, int i3, int i4, char[] cArr, n[] nVarArr) {
        char ad2 = ad(i3, cArr, nVarArr);
        if (this.qw != null) {
            int i5 = 0;
            while (true) {
                char[] cArr2 = this.qw;
                if (i5 >= cArr2.length) {
                    return false;
                }
                if (ad2 == cArr2[i5]) {
                    return true;
                }
                i5++;
            }
        } else if (ad2 <= ' ' || ad2 == '-' || ad2 == 8208) {
            return true;
        } else {
            if (ad2 < 8194) {
                return false;
            }
            if (ad2 >= 8194 && ad2 <= 8203) {
                return true;
            }
            if (ad2 >= 11904 && ad2 < 55200) {
                return true;
            }
            if (ad2 >= 63744 && ad2 < 64256) {
                return true;
            }
            if (ad2 >= 65072 && ad2 < 65104) {
                return true;
            }
            if (ad2 < 65377 || ad2 >= 65440) {
                return false;
            }
            return true;
        }
    }
}
