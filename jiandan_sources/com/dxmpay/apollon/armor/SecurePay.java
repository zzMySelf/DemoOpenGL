package com.dxmpay.apollon.armor;

import android.content.Context;
import com.dxmpay.wallet.base.statistics.StatServiceEvent;
import com.dxmpay.wallet.core.utils.LogUtil;
import com.dxmpay.wallet.statistics.api.StatisticManager;

public final class SecurePay {
    public static final int INPUT_ID_CVV = 2;
    public static final int INPUT_ID_CVV_MAX_LEN = 3;
    public static final int INPUT_ID_PW = 1;
    public static final String KEY = "key";
    public static final int SIG_RSA_MD2 = 2;
    public static final int SIG_RSA_MD4 = 3;
    public static final int SIG_RSA_MD5 = 4;
    public static final int SIG_RSA_RAW = 0;
    public static final int SIG_RSA_SHA1 = 5;
    public static final int SIG_RSA_SHA224 = 14;
    public static final int SIG_RSA_SHA256 = 11;
    public static final int SIG_RSA_SHA384 = 12;
    public static final int SIG_RSA_SHA512 = 13;

    /* renamed from: ad  reason: collision with root package name */
    public static boolean f3954ad = false;
    public static SecurePay qw;

    static {
        try {
            System.loadLibrary("dxm_wsp_v1_1");
        } catch (UnsatisfiedLinkError e) {
            LogUtil.e("SecurePay", "load library failed, " + e.getMessage(), (Throwable) null);
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:2|3|(3:5|6|7)|8|9|10) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0011 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized com.dxmpay.apollon.armor.SecurePay getInstance() {
        /*
            java.lang.Class<com.dxmpay.apollon.armor.SecurePay> r0 = com.dxmpay.apollon.armor.SecurePay.class
            monitor-enter(r0)
            com.dxmpay.apollon.armor.SecurePay r1 = qw     // Catch:{ all -> 0x0015 }
            if (r1 != 0) goto L_0x0011
            com.dxmpay.apollon.armor.SecurePay r1 = new com.dxmpay.apollon.armor.SecurePay     // Catch:{ all -> 0x0015 }
            r1.<init>()     // Catch:{ all -> 0x0015 }
            qw = r1     // Catch:{ all -> 0x0015 }
            r1.init()     // Catch:{ all -> 0x0011 }
        L_0x0011:
            com.dxmpay.apollon.armor.SecurePay r1 = qw     // Catch:{ all -> 0x0015 }
            monitor-exit(r0)
            return r1
        L_0x0015:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dxmpay.apollon.armor.SecurePay.getInstance():com.dxmpay.apollon.armor.SecurePay");
    }

    public static String unicodeDecode(String str) {
        int i2;
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        int i3 = 0;
        while (i3 < length) {
            char charAt = str.charAt(i3);
            if (charAt == '\\' && (i2 = i3 + 1) != length && str.charAt(i2) == 'u') {
                int i4 = i3 + 2;
                i3 += 6;
                sb.append((char) Integer.parseInt(str.substring(i4, i3), 16));
            } else {
                sb.append(charAt);
                i3++;
            }
        }
        return sb.toString();
    }

    public boolean checkLicense(Context context) {
        StatisticManager.onEvent(StatServiceEvent.START_CHECK_SIGN);
        try {
            if (checkSign(context) == 0) {
                return true;
            }
            StatisticManager.onEvent(StatServiceEvent.CHECK_SIGN_FAIL);
            return false;
        } catch (Throwable th2) {
            StatisticManager.onEventWithValue(StatServiceEvent.CHECK_SIGN_ERROR, th2.getMessage());
            return false;
        }
    }

    public native int checkSign(Context context);

    public native void clearKeyboard(int i2);

    public native String decrypt(String str);

    public String decryptProxy(String str) {
        try {
            return decrypt(str);
        } catch (Throwable th2) {
            LogUtil.e("SecurePay", th2.getMessage(), th2);
            return "";
        }
    }

    public native String encrypt(String str);

    public String encryptProxy(String str) {
        try {
            return encrypt(str);
        } catch (Throwable unused) {
            return "";
        }
    }

    public native String getA(long j);

    public native String getB(int i2);

    public native String getC(int i2);

    public native String getDyKey(byte[] bArr, byte[] bArr2, int i2, int i3);

    public native String getSafeStr(int i2);

    public native String getToken();

    public String getTokenProxy() {
        try {
            return getToken();
        } catch (Throwable th2) {
            StatisticManager.onEventWithValue(StatServiceEvent.GET_TOKEN_ERROR, th2.getMessage());
            return "";
        }
    }

    public native String getak();

    public native String getpw();

    public String getpwProxy() {
        try {
            return getpw();
        } catch (Throwable unused) {
            return "";
        }
    }

    public native void init();

    public native int inputKeyboardChar(int i2, char c, int i3);

    public native String localDecrypt(String str);

    public native String localDecrypt1(String str);

    public String localDecryptProxy(String str) {
        try {
            return localDecrypt(str);
        } catch (Throwable unused) {
            return "";
        }
    }

    public native String localEncrypt(String str);

    public native String localEncrypt1(String str);

    public String localEncryptProxy(String str) {
        try {
            return localEncrypt(str);
        } catch (Throwable unused) {
            return "";
        }
    }

    public native String mapScancode(String str);

    public boolean prepareCompleted() {
        return f3954ad;
    }

    public native String rsaDecrypt(String str);

    public native int rsaVerify(int i2, int i3, int i4, byte[] bArr, byte[] bArr2);

    public native String tokenDecrypt(String str);

    public native String tokenEncrypt(String str);
}
