package com.baidu.apollon.armor;

public final class SafePay {
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
    public static final boolean a = false;
    public static final String b = "SafePay";
    public static SafePay c = null;
    public static boolean d = false;

    static {
        try {
            System.loadLibrary("bd_wsp_v1_1");
        } catch (UnsatisfiedLinkError e) {
            "load library failed, " + e.getMessage();
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:2|3|(3:5|6|7)|8|9|10) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0011 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized com.baidu.apollon.armor.SafePay getInstance() {
        /*
            java.lang.Class<com.baidu.apollon.armor.SafePay> r0 = com.baidu.apollon.armor.SafePay.class
            monitor-enter(r0)
            com.baidu.apollon.armor.SafePay r1 = c     // Catch:{ all -> 0x0015 }
            if (r1 != 0) goto L_0x0011
            com.baidu.apollon.armor.SafePay r1 = new com.baidu.apollon.armor.SafePay     // Catch:{ all -> 0x0015 }
            r1.<init>()     // Catch:{ all -> 0x0015 }
            c = r1     // Catch:{ all -> 0x0015 }
            r1.init()     // Catch:{ all -> 0x0011 }
        L_0x0011:
            com.baidu.apollon.armor.SafePay r1 = c     // Catch:{ all -> 0x0015 }
            monitor-exit(r0)
            return r1
        L_0x0015:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.apollon.armor.SafePay.getInstance():com.baidu.apollon.armor.SafePay");
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

    public native void clearKeyboard(int i2);

    public native String decrypt(String str);

    public String decryptProxy(String str) {
        try {
            return decrypt(str);
        } catch (Throwable th2) {
            th2.printStackTrace();
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

    public native int inputKeyboardChar(int i2, char c2, int i3);

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
        return d;
    }

    public native String rsaDecrypt(String str);

    public native int rsaVerify(int i2, int i3, int i4, byte[] bArr, byte[] bArr2);

    public native String tokenDecrypt(String str);

    public native String tokenEncrypt(String str);
}
