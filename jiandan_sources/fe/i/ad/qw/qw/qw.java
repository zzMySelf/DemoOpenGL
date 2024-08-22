package fe.i.ad.qw.qw;

import android.content.Context;
import com.dxmpay.apollon.armor.SecurePay;
import com.dxmpay.wallet.base.nopassauth.b;

public class qw implements b {

    /* renamed from: fe  reason: collision with root package name */
    public static final int[] f4452fe = {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000};

    /* renamed from: ad  reason: collision with root package name */
    public long f4453ad;

    /* renamed from: de  reason: collision with root package name */
    public int f4454de;
    public String qw;

    public qw(String str, long j, int i2) {
        this.qw = str;
        this.f4453ad = j;
        this.f4454de = i2;
    }

    public static byte[] ad(String str) {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i2 * 2;
            bArr[i2] = (byte) Integer.parseInt(str.substring(i3, i3 + 2), 16);
        }
        return bArr;
    }

    public String a(Context context) {
        byte[] bArr = new byte[8];
        long j = this.f4453ad;
        for (int i2 = 7; i2 >= 0; i2--) {
            bArr[i2] = (byte) ((int) (255 & j));
            j >>= 8;
        }
        SecurePay instance = SecurePay.getInstance();
        byte[] ad2 = ad(this.qw);
        int[] iArr = f4452fe;
        int i3 = this.f4454de;
        return instance.getDyKey(ad2, bArr, iArr[i3], i3);
    }

    public void qw(long j) {
        this.f4453ad = j;
        "+++++++++HotpToken movingFactor is " + this.f4453ad;
    }
}
